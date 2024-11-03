package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class PecaTO {

    private Long idPeca;
    @NotBlank private String nome;
    @NotNull @PositiveOrZero private Double numeroDeSerie;
    @NotNull @PositiveOrZero private Double preco;

    public PecaTO() {
    }

    public PecaTO(Long idPeca, @NotBlank String nome, @NotNull @PositiveOrZero Double numeroDeSerie, @NotNull @PositiveOrZero Double preco) {
        this.idPeca = idPeca;
        this.nome = nome;
        this.numeroDeSerie = numeroDeSerie;
        this.preco = preco;
    }

    public Long getIdPeca() {
        return idPeca;
    }

    public void setIdPeca(Long idPeca) {
        this.idPeca = idPeca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getNumeroDeSerie() {
        return numeroDeSerie;
    }

    public void setNumeroDeSerie(Double numeroDeSerie) {
        this.numeroDeSerie = numeroDeSerie;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
