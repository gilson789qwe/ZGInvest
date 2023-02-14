package com.invest.ZGInvest.services;

import com.invest.ZGInvest.dto.UserDTO;
import com.invest.ZGInvest.entities.User;
import com.invest.ZGInvest.services.exceptions.EntityNotFoundException;
import com.invest.ZGInvest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Transactional(readOnly = true)
    public Page<UserDTO> findAll(PageRequest pageRequest){
        Page<User> page = repository.findAll(pageRequest);
        return page.map(user -> new UserDTO(user));
    }

    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        Optional<User> obj = repository.findById(id);
        User entity = obj.orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada"));
        return new UserDTO(entity);
    }
}
