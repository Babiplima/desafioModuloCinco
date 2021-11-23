package zup.com.br.gerenciadorConta.exceptions;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import zup.com.br.gerenciadorConta.Enum.Status;
import zup.com.br.gerenciadorConta.Enum.Tipo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ContaRepository extends CrudRepository<Conta, Integer> {

    Optional<Conta> findById(int id);

    List<Conta> findAllByStatus(Status status);

    List<Conta>findAllByTipo(Tipo tipo);

    @Query(value = "SELECT * FROM gerencia_conta WHERE VALOR BETWEEN :valor*0.5 AND :valor*1.5", nativeQuery = true)
    List<Conta>findAllByValorAproximado(double valor);
}
