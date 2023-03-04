package dev.marios.scrumpoker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<List<User>>(userService.allUsers(), HttpStatus.OK);
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable String userId){
        return new ResponseEntity<Optional<User>>(userService.userById(userId), HttpStatus.OK);
    }

    @GetMapping("/names")
    public ResponseEntity<List<String>> getAllUserNames(){
        return new ResponseEntity<List<String>>(userService.allUserNames(), HttpStatus.OK);
    }
}
