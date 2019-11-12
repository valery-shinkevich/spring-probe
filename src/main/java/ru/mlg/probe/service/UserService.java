package ru.mlg.probe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mlg.probe.entity.User;
import ru.mlg.probe.repository.UsersRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private final UsersRepository usersRepository;

    public UserService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    public User createUser(User user) {
        return usersRepository.save(user);
    }

    public List<User> findAll(){
        return usersRepository.findAll();
    }

    public User findById(Long userId){
        return usersRepository.findById(userId).orElse(null);
    }

    public List<User> findAllByName(String name){
        return usersRepository.findAllByName(name);
    }

    public List<User> findWhereEmailIsGmail(){
        return usersRepository.findWhereEmailIsGmail();
    }

    public List<User> findWhereNameStartsFromSmith(){
        return usersRepository.findWhereNameStartsFromSmith();
    }
}
