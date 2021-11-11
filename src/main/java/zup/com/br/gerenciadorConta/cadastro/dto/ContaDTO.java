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


    public LocalDate getDataDeVencimento() {
        return dataDeVencimento;
    }

    public void setDataDeVencimento(LocalDate dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }



    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }


    }
