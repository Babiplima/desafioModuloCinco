package zup.com.br.gerenciadorConta.exceptions;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public static Conta salvarConta(Conta conta){
        if(contaRepository.existsById(conta.getNome())){
          throw new ContaDublicadaException();
        }
        return contaRepository.save(conta);
    }
}
