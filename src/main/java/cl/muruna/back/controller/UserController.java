package cl.muruna.back.controller;

import cl.muruna.back.exception.InvalidInputException;
import cl.muruna.back.model.User;
import cl.muruna.back.service.IUserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Slf4j
@RequestMapping(value = "/user")
@Api(value = "User controller", produces = "application/json")
public class UserController {

    @Autowired
    private IUserService userService;

    @DeleteMapping(value = "deleteUser")
    public ResponseEntity<String> deleteUser(@RequestParam("id") UUID userId) {
        try {
            return new ResponseEntity<>(userService.deleteUser(userId), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new InvalidInputException(User.class.getSimpleName());
        }
    }

    @GetMapping(value = "getAllUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new InvalidInputException(User.class.getSimpleName());
        }
    }

    @PutMapping(value = "updateUser")
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        try {
            return new ResponseEntity<>(userService.updateUser(user), HttpStatus.CREATED);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new InvalidInputException(User.class.getSimpleName());
        }
    }

    @PatchMapping(value = "updateIsActive")
    public ResponseEntity<String> updateIsActive(@RequestParam("userId") UUID userId, @RequestParam("isActive") Boolean isActive) {
        try {
            return new ResponseEntity<>(userService.updateIsActive(userId, isActive), HttpStatus.CREATED);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new InvalidInputException(User.class.getSimpleName());
        }
    }

}
