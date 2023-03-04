package dev.marios.scrumpoker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> allUsers(){
        return userRepository.findAll();
    }
    public List<String> allUserNames(){
        List<User> users = allUsers();
        List<String> userNames = new ArrayList<String>();
        for(User user : users){
            userNames.add(user.getUserName());
        }
        return userNames;
    }

    public Optional<User> userById(String userId){
        return userRepository.findUserByUserId(userId);
    }
}
