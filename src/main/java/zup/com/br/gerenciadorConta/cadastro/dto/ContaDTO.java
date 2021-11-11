package zup.com.br.gerenciadorConta.cadastro.dto;

import org.hibernate.validator.constraints.Length;
import zup.com.br.gerenciadorConta.Enum.Status;
import zup.com.br.gerenciadorConta.Enum.Tipo;

import javax.validation.GroupSequence;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@GroupSequence({FieldGroup.class, CustomGroup.class, ContaDTO.class})

public class ContaDTO {
    @NotBlank(message = “A categoria é obrigatória", groups = FieldGroup.class)
            @OneOf(types = {“LUZ", “AGUA”,"COMIDA","OUTROS" }, groups = CustomGroup.class)
            private String categoria;

    @Min (value =2, message = "Nome com menos de dois caracteres não é permitido")
    @Max(value = 50, message = "Nome com mais de 50 caracteres não é permitido")
    @NotBlank(message = "O nome é obrigatório")
    private String nome;
    @Length
    private double valor;
    @OneOf(types = {"LUZ","AGUA","COMIDA","OUTROS"})
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
