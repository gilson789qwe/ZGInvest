package com.invest.ZGInvest.services;

import com.invest.ZGInvest.dto.UserDTO;
import com.invest.ZGInvest.entities.User;
import com.invest.ZGInvest.repositories.UserRepository;
import com.invest.ZGInvest.services.exceptions.DatabaseException;
import com.invest.ZGInvest.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

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
        User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));
        return new UserDTO(entity);
    }

    @Transactional
    public UserDTO update(Long id, UserDTO dto) {
        try {
            User entity = repository.getOne(id);

            entity.setTipoOperacao(dto.getTipoOperacao());
            entity.setMercado(dto.getMercado());
            entity.setPrazo(dto.getPrazo());
            entity.setInstrument(dto.getInstrument());
            entity.setEspecificacao(dto.getEspecificacao());
            entity.setQuantidade(dto.getQuantidade());
            entity.setPreco(dto.getPreco());
            entity.setValorTotal(dto.getValorTotal());

            entity = repository.save(entity);
            return new UserDTO((entity));
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Id não encontrado" +id);
        }
    }

    @Transactional
    public UserDTO insert(UserDTO dto) {
        User entity = new User();

        entity.setTipoOperacao(dto.getTipoOperacao());
        entity.setMercado(dto.getMercado());
        entity.setPrazo(dto.getPrazo());
        entity.setInstrument(dto.getInstrument());
        entity.setEspecificacao(dto.getEspecificacao());
        entity.setQuantidade(dto.getQuantidade());
        entity.setPreco(dto.getPreco());
        entity.setValorTotal(dto.getValorTotal());

        entity = repository.save(entity);

        return new UserDTO(entity);
    }

    @Transactional
    public void  delete(Long id) {
        try {
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Id não encontrado" + id);
        }
        catch (DataIntegrityViolationException e){
            throw new DatabaseException("Violação de integridade");
        }
    }
}
