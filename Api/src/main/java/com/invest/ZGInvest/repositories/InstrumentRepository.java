package com.invest.ZGInvest.repositories;


import com.invest.ZGInvest.entities.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrumentRepository extends JpaRepository<Instrument, Long> {

}
