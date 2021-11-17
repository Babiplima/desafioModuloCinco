package zup.com.br.gerenciadorConta.cadastro.dto;

import org.hibernate.validator.constraints.Length;
import zup.com.br.gerenciadorConta.Enum.Status;
import zup.com.br.gerenciadorConta.Enum.Tipo;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MapKeyEnumerated;
import javax.validation.GroupSequence;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class ContaDTO {

    @Size (max = 50, min = 2,message = "Tamanho de nome inválido")
    @NotBlank(message = "O nome é obrigatório")
    private String nome;
    @Min(value = 2, message = "No mínimo deve conter pelo menos 2 caracteres")
    @Max(value = 50,message = "A quantidade de caracteres excede a que é permitida")
    private double valor;
    @NotNull
    private Tipo tipo;
    @NotNull
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
