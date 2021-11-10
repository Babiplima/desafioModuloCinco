package zup.com.br.gerenciadorConta.exceptions;

import org.springframework.beans.factory.annotation.Autowired;

public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public Conta salvarConta(Conta conta){
        if(contaRepository.existsById(conta.getNome())){
          throw new ContaDublicadaException();
        }

    }

}
