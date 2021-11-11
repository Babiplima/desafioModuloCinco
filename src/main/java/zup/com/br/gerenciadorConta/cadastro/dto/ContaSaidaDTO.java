package zup.com.br.gerenciadorConta.cadastro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import zup.com.br.gerenciadorConta.Enum.Status;
import zup.com.br.gerenciadorConta.Enum.Tipo;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContaSaidaDTO {
    private int id;
    private String nome;
    private double valor;
    private Tipo tipo;
    private LocalDate dataDeVencimento;
    private LocalDateTime dataDePagamento;
    private Status status;

}
