package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class AvaliacaoTO {

    private Long idAvaliacao;
    private Double nota;
    private String experiencia;
    private Long idCliente;

    public AvaliacaoTO() {
    }

    public AvaliacaoTO(Long idAvaliacao, Double nota, String experiencia, Long idCliente) {
        this.idAvaliacao = idAvaliacao;
        this.nota = nota;
        this.experiencia = experiencia;
        this.idCliente = idCliente;
    }

    public Long getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(Long idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
}
