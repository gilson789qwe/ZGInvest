package com.invest.ZGInvest.dto;

import com.invest.ZGInvest.entities.User;

import java.io.Serializable;
import java.util.Date;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private  Long id;
    private Date data;
    private String tipoOperacao;
    private String mercado;
    private String prazo;
    private String instrument;
    private String especificacao;
    private Integer quantidade;
    private Integer preco;
    private Integer valorTotal;

    public UserDTO(){}

    public UserDTO(Long id, Date data, String tipoOperacao, String mercado, String prazo, String instrument, String especificacao, Integer quantidade, Integer preco, Integer valorTotal) {
        this.id = id;
        this.data = data;
        this.tipoOperacao = tipoOperacao;
        this.mercado = mercado;
        this.prazo = prazo;
        this.instrument = instrument;
        this.especificacao = especificacao;
        this.quantidade = quantidade;
        this.preco = preco;
        this.valorTotal = valorTotal;
    }

    public UserDTO(User entity){
        this.id = entity.getId();
        this.data = entity.getData();
        this.tipoOperacao = entity.getTipoOperacao();
        this.mercado = entity.getMercado();
        this.prazo = entity.getPrazo();
        this.instrument = entity.getInstrument();
        this.especificacao = entity.getEspecificacao();
        this.quantidade = entity.getQuantidade();
        this.preco = entity.getPreco();
        this.valorTotal = entity.getValorTotal();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public String getMercado() {
        return mercado;
    }

    public void setMercado(String mercado) {
        this.mercado = mercado;
    }

    public String getPrazo() {
        return prazo;
    }

    public void setPrazo(String prazo) {
        this.prazo = prazo;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public String getEspecificacao() {
        return especificacao;
    }

    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getPreco() {
        return preco;
    }

    public void setPreco(Integer preco) {
        this.preco = preco;
    }

    public Integer getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Integer valorTotal) {
        this.valorTotal = valorTotal;
    }
}
