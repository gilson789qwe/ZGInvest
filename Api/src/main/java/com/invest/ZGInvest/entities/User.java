package com.invest.ZGInvest.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user_trade")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant data;
    @Column(columnDefinition = "TEXT", name = "tipo_operacao", nullable = true)
    private String tipoOperacao;
    @Column(columnDefinition = "TEXT", nullable = true)
    private String mercado;
    @Column(columnDefinition = "TEXT", nullable = true)
    private String prazo;
    @Column(columnDefinition = "TEXT", nullable = true)
    private String instrument;
    @Column(columnDefinition = "TEXT", nullable = true)
    private String especificacao;

    private Integer quantidade;
    private Integer preco;
    @Column(name = "valor_total")
    private Integer valorTotal;

    /*@OneToMany
    @JoinTable(
            name = "user_trade",
            joinColumns = { @JoinColumn(name = "user_trade_instrument") },
            inverseJoinColumns = { @JoinColumn(name = "instrument_quote_simbol") })*/

    @OneToMany
    @JoinColumns(
            @JoinColumn(name="simbol", referencedColumnName="instrument" )
    )
    Set<Instrument> instruments = new HashSet<>();


    public User(){

    }

    public User(Long id, Instant data, String tipoOperacao, String mercado, String prazo, String instrument, String especificacao, Integer quantidade, Integer preco, Integer valorTotal) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getData() {
        return data;
    }

    public void setData(Instant data) {
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

    public Set<Instrument> getInstruments() {
        return instruments;
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
