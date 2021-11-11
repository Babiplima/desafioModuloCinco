package zup.com.br.gerenciadorConta.exceptions;

import org.springframework.data.repository.CrudRepository;
import zup.com.br.gerenciadorConta.Enum.Tipo;

import java.time.LocalDate;
import java.util.List;

public interface ContaRepository extends CrudRepository<Conta, Integer> {

    List<Conta> findAllByNome(String nome);
    List<Conta> findAllByValor(double valor);
    List<Conta> findAllByTipo(Tipo tipo);
    List<Conta> findAllByDataDeVencimento(LocalDate dataDeVencimento);
}
