package com.invest.ZGInvest.services;

import com.invest.ZGInvest.entities.User;
import com.invest.ZGInvest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    public List<User> findAll(){
        return repository.findAll();
    }
}
