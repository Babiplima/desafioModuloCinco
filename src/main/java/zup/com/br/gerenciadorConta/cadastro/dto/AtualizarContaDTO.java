package zup.com.br.gerenciadorConta.cadastro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import zup.com.br.gerenciadorConta.Enum.Status;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AtualizarContaDTO {
    private Status status;
}
