package zup.com.br.gerenciadorConta.cadastro.dto;

import jdk.jfr.SettingDefinition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import zup.com.br.gerenciadorConta.Enum.Status;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class ExibirContaDTO {

    private int id;
    private String nome;
    private double valor;
    private Status status;
}
