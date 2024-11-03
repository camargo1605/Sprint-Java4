package br.com.fiap.to;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

public class OrcamentoTO {

    private Long idOrcamento;
    private LocalDate data;
    @NotNull@PositiveOrZero private Double maoDeObra;
    private Long idOficina;
    private Long idScanner;
    private Long idPeca;

    public OrcamentoTO() {
    }

    public OrcamentoTO(Long idOrcamento, LocalDate data, Double maoDeObra, Long idOficina, Long idScanner, Long idPeca) {
        this.idOrcamento = idOrcamento;
        this.data = data;
        this.maoDeObra = maoDeObra;
        this.idOficina = idOficina;
        this.idScanner = idScanner;
        this.idPeca = idPeca;
    }

    public Long getIdOrcamento() {
        return idOrcamento;
    }

    public void setIdOrcamento(Long idOrcamento) {
        this.idOrcamento = idOrcamento;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public @NotNull @PositiveOrZero Double getMaoDeObra() {
        return maoDeObra;
    }

    public void setMaoDeObra(@NotNull @PositiveOrZero Double maoDeObra) {
        this.maoDeObra = maoDeObra;
    }

    public Long getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(Long idOficina) {
        this.idOficina = idOficina;
    }

    public Long getIdScanner() {
        return idScanner;
    }

    public void setIdScanner(Long idScanner) {
        this.idScanner = idScanner;
    }

    public Long getIdPeca() {
        return idPeca;
    }

    public void setIdPeca(Long idPeca) {
        this.idPeca = idPeca;
    }
}
