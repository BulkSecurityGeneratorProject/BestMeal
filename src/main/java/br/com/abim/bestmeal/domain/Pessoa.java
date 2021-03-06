package br.com.abim.bestmeal.domain;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Pessoa.
 */
@Entity
@Table(name = "pessoa")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "cnpj")
    private String cnpj;

    @NotNull
    @Size(min = 2, max = 20)
    @Column(name = "primeiro_nome", length = 20, nullable = false)
    private String primeiroNome;

    @NotNull
    @Size(min = 2, max = 30)
    @Column(name = "nome_meio", length = 30, nullable = false)
    private String nomeMeio;

    @NotNull
    @Size(min = 2, max = 30)
    @Column(name = "sobre_nome", length = 30, nullable = false)
    private String sobreNome;

    @Column(name = "saudacao")
    private String saudacao;

    @NotNull
    @Size(min = 3, max = 15)
    @Column(name = "titulo", length = 15, nullable = false)
    private String titulo;

    @Column(name = "cep")
    private String cep;

    @Column(name = "tipo_logradouro")
    private String tipoLogradouro;

    @Column(name = "nome_logradouro")
    private String nomeLogradouro;

    @NotNull
    @Size(min = 0, max = 30)
    @Column(name = "complemento", length = 30, nullable = false)
    private String complemento;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public Pessoa tipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCpf() {
        return cpf;
    }

    public Pessoa cpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Pessoa cnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public Pessoa primeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
        return this;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getNomeMeio() {
        return nomeMeio;
    }

    public Pessoa nomeMeio(String nomeMeio) {
        this.nomeMeio = nomeMeio;
        return this;
    }

    public void setNomeMeio(String nomeMeio) {
        this.nomeMeio = nomeMeio;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public Pessoa sobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
        return this;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getSaudacao() {
        return saudacao;
    }

    public Pessoa saudacao(String saudacao) {
        this.saudacao = saudacao;
        return this;
    }

    public void setSaudacao(String saudacao) {
        this.saudacao = saudacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public Pessoa titulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCep() {
        return cep;
    }

    public Pessoa cep(String cep) {
        this.cep = cep;
        return this;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    public Pessoa tipoLogradouro(String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
        return this;
    }

    public void setTipoLogradouro(String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getNomeLogradouro() {
        return nomeLogradouro;
    }

    public Pessoa nomeLogradouro(String nomeLogradouro) {
        this.nomeLogradouro = nomeLogradouro;
        return this;
    }

    public void setNomeLogradouro(String nomeLogradouro) {
        this.nomeLogradouro = nomeLogradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public Pessoa complemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Pessoa)) {
            return false;
        }
        return id != null && id.equals(((Pessoa) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
            "id=" + getId() +
            ", tipo='" + getTipo() + "'" +
            ", cpf='" + getCpf() + "'" +
            ", cnpj='" + getCnpj() + "'" +
            ", primeiroNome='" + getPrimeiroNome() + "'" +
            ", nomeMeio='" + getNomeMeio() + "'" +
            ", sobreNome='" + getSobreNome() + "'" +
            ", saudacao='" + getSaudacao() + "'" +
            ", titulo='" + getTitulo() + "'" +
            ", cep='" + getCep() + "'" +
            ", tipoLogradouro='" + getTipoLogradouro() + "'" +
            ", nomeLogradouro='" + getNomeLogradouro() + "'" +
            ", complemento='" + getComplemento() + "'" +
            "}";
    }
}
