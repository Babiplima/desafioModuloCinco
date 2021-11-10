package zup.com.br.gerenciadorConta.exceptions;

import org.springframework.data.repository.CrudRepository;

public interface ContaRepository extends CrudRepository<Conta, String> {
    Conta save(Conta conta);
}
