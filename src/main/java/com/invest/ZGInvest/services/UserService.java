package com.invest.ZGInvest.services;

import com.invest.ZGInvest.dto.UserDTO;
import com.invest.ZGInvest.entities.User;
import com.invest.ZGInvest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Transactional(readOnly = true)
    public List<UserDTO> findAll(){
        List<User> list = repository.findAll();
        return list.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
    }
}
