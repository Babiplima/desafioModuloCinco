package zup.com.br.gerenciadorConta.exceptions;

import zup.com.br.gerenciadorConta.Enum.Status;
import zup.com.br.gerenciadorConta.Enum.Tipo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Conta {

    private String nome;
    private double valor;
    private Tipo tipo;
    private LocalDate dataDeVencimento;
    private LocalDateTime dataDePagamento;
    private Status status;

    public Conta() {
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

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
