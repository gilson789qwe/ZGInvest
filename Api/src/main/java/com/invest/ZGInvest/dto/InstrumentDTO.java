package com.invest.ZGInvest.dto;

import com.invest.ZGInvest.entities.Instrument;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.Instant;

public class InstrumentDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private  Long id;

    private String simbol;

    private Integer price;

    private Instant date;

    public InstrumentDTO(){}

    public InstrumentDTO(Long id, String simbol, Integer price, Instant date) {
        this.id = id;
        this.simbol = simbol;
        this.price = price;
        this.date = date;
    }

    public InstrumentDTO(Instrument entity){
        this.id = entity.getId();
        this.simbol = entity.getSimbol();
        this.price = entity.getPrice();
        this.date = entity.getDate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSimbol() {
        return simbol;
    }

    public void setSimbol(String simbol) {
        this.simbol = simbol;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }


}
