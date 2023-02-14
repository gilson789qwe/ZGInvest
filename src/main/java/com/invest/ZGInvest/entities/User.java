package com.invest.ZGInvest.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "user_trade")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private Date data;
    private String tipoOperacao;
    private String mercado;
    private String prazo;
    private String instrument;
    private String especificacao;
    private Integer quantidade;
    private Integer preco;
    private Integer valor_total;

    public User(){

    }

    public User(Long id, Date data, String tipoOperacao, String mercado, String prazo, String instrument, String especificacao, Integer quantidade, Integer preco, Integer valor_total) {
        this.id = id;
        this.data = data;
        this.tipoOperacao = tipoOperacao;
        this.mercado = mercado;
        this.prazo = prazo;
        this.instrument = instrument;
        this.especificacao = especificacao;
        this.quantidade = quantidade;
        this.preco = preco;
        this.valor_total = valor_total;
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

    public Integer getValor_total() {
        return valor_total;
    }

    public void setValor_total(Integer valor_total) {
        this.valor_total = valor_total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
