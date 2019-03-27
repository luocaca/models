package me.luocaca.model.service.impl;

import me.luocaca.model.entity.Company;
import me.luocaca.model.entity.User;
import me.luocaca.model.service.UserRepository;
import me.luocaca.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User save(User user) {
       return userRepository.save(user);
    }

    @Override
    public Company save(Company company) {
        return null;
    }
}
