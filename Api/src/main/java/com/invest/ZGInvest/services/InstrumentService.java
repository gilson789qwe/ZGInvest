package com.invest.ZGInvest.services;

import com.invest.ZGInvest.dto.InstrumentDTO;
import com.invest.ZGInvest.entities.Instrument;
import com.invest.ZGInvest.repositories.InstrumentRepository;
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
public class InstrumentService {

    @Autowired
    private InstrumentRepository repository;

    @Transactional(readOnly = true)
    public Page<InstrumentDTO> findAll(PageRequest pageRequest) {
        Page<Instrument> page = repository.findAll(pageRequest);
        return page.map(instrument -> new InstrumentDTO(instrument));
    }

    @Transactional(readOnly = true)
    public InstrumentDTO findById(Long id) {
        Optional<Instrument> obj = repository.findById(id);
        Instrument entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));
        return new InstrumentDTO(entity);
    }

    @Transactional
    public InstrumentDTO update(Long id, InstrumentDTO dto) {
        try {
            Instrument entity = repository.getOne(id);

            entity.setPrice(dto.getPrice());
            entity.setSimbol(dto.getSimbol());

            entity = repository.save(entity);
            return new InstrumentDTO((entity));
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Id não encontrado" +id);
        }
    }

    @Transactional
    public InstrumentDTO insert(InstrumentDTO dto) {
        Instrument entity = new Instrument();

        entity.setPrice(dto.getPrice());
        entity.setSimbol(dto.getSimbol());

        entity = repository.save(entity);

        return new InstrumentDTO(entity);
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
