package zup.com.br.gerenciadorConta.cadastro.dto;

import zup.com.br.gerenciadorConta.Enum.Status;
import zup.com.br.gerenciadorConta.Enum.Tipo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ContaDTO {

    private String nome;
    private double valor;
    private Tipo tipo;
    private LocalDate dataDeVencimento;
    private LocalDateTime dataDePagamento;
    private Status status;

    public ContaDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public zup.com.br.gerenciadorConta.cadastro.dto.Tipo getTipo() {
        return tipo;
    }

    public void setTipo(zup.com.br.gerenciadorConta.cadastro.dto.Tipo tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataDeVencimento() {
        return dataDeVencimento;
    }

    public void setDataDeVencimento(LocalDate dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }

    public LocalDateTime getDataDePagamento() {
        return dataDePagamento;
    }

    public void setDataDePagamento(LocalDateTime dataDePagamento) {
        this.dataDePagamento = dataDePagamento;
    }

    public zup.com.br.gerenciadorConta.cadastro.dto.Status getStatus() {
        return status;
    }

    public void setStatus(zup.com.br.gerenciadorConta.cadastro.dto.Status status) {
        this.status = status;
    }
}
