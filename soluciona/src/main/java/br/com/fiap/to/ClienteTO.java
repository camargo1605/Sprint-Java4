package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;


public class ClienteTO {

    private Long idCliente;
    @NotBlank private String nome;
    @NotBlank private String cpf;
    @NotBlank private String email;
    @NotBlank private String telefone;
    @NotBlank private String endereco;
    @NotBlank private String senha;

    public ClienteTO() {
    }

    public ClienteTO(Long idCliente, @NotBlank String nome, @NotBlank String cpf, @NotBlank String email, @NotBlank String telefone, @NotBlank String endereco, @NotBlank String senha) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.senha = senha;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotBlank String nome) {
        this.nome = nome;
    }

    public @NotBlank String getCpf() {
        return cpf;
    }

    public void setCpf(@NotBlank String cpf) {
        this.cpf = cpf;
    }

    public @NotBlank String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank String email) {
        this.email = email;
    }

    public @NotBlank String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotBlank String telefone) {
        this.telefone = telefone;
    }

    public @NotBlank String getEndereco() {
        return endereco;
    }

    public void setEndereco(@NotBlank String endereco) {
        this.endereco = endereco;
    }

    public @NotBlank String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank String senha) {
        this.senha = senha;
    }
}



