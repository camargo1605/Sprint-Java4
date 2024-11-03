package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class ServicoAgendadoTO{

    private Long idServicoAgendado;
    @NotBlank private String tipoDeVeiculo;
    @NotBlank private String tipoDeServico;
    private LocalDate data;
    private Long idOrcamento;

    public ServicoAgendadoTO() {
    }

    public ServicoAgendadoTO(Long idServicoAgendado, @NotBlank String tipoDeVeiculo, @NotBlank String tipoDeServico, LocalDate data, Long idOrcamento) {
        this.idServicoAgendado = idServicoAgendado;
        this.tipoDeVeiculo = tipoDeVeiculo;
        this.tipoDeServico = tipoDeServico;
        this.data = data;
        this.idOrcamento = idOrcamento;
    }

    public Long getIdServicoAgendado() {
        return idServicoAgendado;
    }

    public void setIdServicoAgendado(Long idServicoAgendado) {
        this.idServicoAgendado = idServicoAgendado;
    }

    public String getTipoDeVeiculo() {
        return tipoDeVeiculo;
    }

    public void setTipoDeVeiculo(String tipoDeVeiculo) {
        this.tipoDeVeiculo = tipoDeVeiculo;
    }

    public String getTipoDeServico() {
        return tipoDeServico;
    }

    public void setTipoDeServico(String tipoDeServico) {
        this.tipoDeServico = tipoDeServico;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Long getIdOrcamento() {
        return idOrcamento;
    }

    public void setIdOrcamento(Long idOrcamento) {
        this.idOrcamento = idOrcamento;
    }
}
