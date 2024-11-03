package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class ScannerTO {

    private Long idScanner;
    @NotNull @PositiveOrZero private Double temperaturaMotor;
    @NotBlank private String pressaoDoOleo;
    @PositiveOrZero private Double velocidadeDoVeiculo;
    private Long idVeiculo;
    private Long idCliente;

    public ScannerTO() {
    }

    public ScannerTO(Long idScanner, @NotNull @PositiveOrZero Double temperaturaMotor, @NotBlank String pressaoDoOleo, @PositiveOrZero Double velocidadeDoVeiculo, Long idVeiculo, Long idCliente) {
        this.idScanner = idScanner;
        this.temperaturaMotor = temperaturaMotor;
        this.pressaoDoOleo = pressaoDoOleo;
        this.velocidadeDoVeiculo = velocidadeDoVeiculo;
        this.idVeiculo = idVeiculo;
        this.idCliente = idCliente;
    }

    public Long getIdScanner() {
        return idScanner;
    }

    public void setIdScanner(Long idScanner) {
        this.idScanner = idScanner;
    }

    public Double getTemperaturaMotor() {
        return temperaturaMotor;
    }

    public void setTemperaturaMotor(Double temperaturaMotor) {
        this.temperaturaMotor = temperaturaMotor;
    }

    public String getPressaoDoOleo() {
        return pressaoDoOleo;
    }

    public void setPressaoDoOleo(String pressaoDoOleo) {
        this.pressaoDoOleo = pressaoDoOleo;
    }

    public Double getVelocidadeDoVeiculo() {
        return velocidadeDoVeiculo;
    }

    public void setVelocidadeDoVeiculo(Double velocidadeDoVeiculo) {
        this.velocidadeDoVeiculo = velocidadeDoVeiculo;
    }

    public Long getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Long idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
}
