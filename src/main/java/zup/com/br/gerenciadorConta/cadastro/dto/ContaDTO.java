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


    @Min (value =2, message = "Nome com menos de dois caracteres não é permitido")
    @NotBlank(message = "O nome é obrigatório")
    private String nome;
    @Length(min = 2, message = "Este campo não pode ser preenchido por menos que dois caracteres")
    @Length(max =50,message = "O número de caracteres excedem o limite permitido")
    private double valor;
    @NotBlank(message = "O campo tipo é obrigatório")
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
