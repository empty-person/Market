package com.example.Market.Controller;


import com.example.Market.Entity.ItemEntity;
import com.example.Market.Entity.UserEntity;
import com.example.Market.Exception.ItemAlreadyExistException;
import com.example.Market.Exception.ItemNotFoundException;
import com.example.Market.Exception.UserAlreadyExistException;
import com.example.Market.Exception.UserNotFoundException;
import com.example.Market.Service.ItemService;
import com.example.Market.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemRESTController {




    @Autowired
    ItemService itemService;

    /**
     * Retrieves item from database by Query Param 'id'
     */
    @GetMapping
    public ResponseEntity getItem(@RequestParam(value = "name", required = true) String name) {
        try {
            return ResponseEntity.ok(itemService.getItemById(name));
        } catch (ItemNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Неправильный аргумент, попробуйте 'id'");
        }
    }

    @PostMapping
    public ResponseEntity addItem(@RequestBody ItemEntity item) {
        try {
            itemService.createItem(item);
            return ResponseEntity.ok("Новый предмет был добавлен успешно");
        } catch (ItemAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage() + "\n " + item.getName() + " " + item.getPrice());
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * Retrieves all items from database
     */
    @GetMapping
    @RequestMapping("/all")
    public ResponseEntity getAllUser() {
        try {
            return ResponseEntity.ok(itemService.getAllItems());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
