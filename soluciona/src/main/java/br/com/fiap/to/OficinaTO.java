package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class OficinaTO {

    private Long idOficina;
    @NotBlank private String nome;
    @NotBlank private String endereco;
    @NotBlank private String email;
    @NotNull @PositiveOrZero private String cnpj;
    @NotNull @PositiveOrZero private String telefone;

    public OficinaTO() {
    }

    public OficinaTO(Long idOficina, @NotNull String nome, @NotBlank String endereco, @NotBlank String email, @NotNull @PositiveOrZero String cnpj, @NotNull @PositiveOrZero String telefone) {
        this.idOficina = idOficina;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.cnpj = cnpj;
        this.telefone = telefone;
    }

    public Long getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(Long idOficina) {
        this.idOficina = idOficina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
