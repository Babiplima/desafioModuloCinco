package zup.com.br.gerenciadorConta.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zup.com.br.gerenciadorConta.Enum.Status;
import zup.com.br.gerenciadorConta.Enum.Tipo;
import zup.com.br.gerenciadorConta.cadastro.dto.ContaDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContaService {

    private List<ContaDTO> contaDTO = new ArrayList<>();

    @Autowired
    private ContaRepository contaRepository;

    public Conta salvarConta(Conta conta) {
        if (conta.getDataDeVencimento().isBefore(LocalDate.now())) {
            conta.setStatus(Status.VENCIDA);
        } else {
            conta.setStatus(Status.AGUARDANDO);
        }
        return contaRepository.save(conta);
    }


    public List<Conta> exibirTodasAsContas(String nome, Double valor, Tipo tipo, LocalDate dataDeVencimento) {
        if (nome != null) {
            return contaRepository.findAllByNome(nome);
        } else if (valor != null) {
            return contaRepository.findAllByValor(valor);
        } else if (tipo != null) {
            return contaRepository.findAllByTipo(tipo);
        } else if (dataDeVencimento != null) {
            return contaRepository.findAllByDataDeVencimento(dataDeVencimento);
        }
        List<Conta> contas = (List<Conta>) contaRepository.findAll();
        return contas;
    }
}




  /*  @PutMapping(value="/{id}")
    public ResponseEntity update (@PathVariable("id") int id, @RequestBody Conta conta){
        return contaRepository.findById(id)
                .map(record -> {
                    record.setId(conta.getId());
                    record.setNome(conta.getNome());
                    record.setValor(conta.getValor());
                    record.setTipo(conta.getTipo());
                    record.setDataDeVencimento(conta.getDataDeVencimento());
                    record.setTipo(conta.getTipo());
                    record.setStatus(conta.getStatus());
                    return ResponseEntity.ok().body(update);
                }).orElse(ResponseEntity.notFound().build());
    }
}*/
/*
    public ContaSaidaDTO(ContaDTO contaDTO) {
        adicionarContaNaLista(contaDTO);
        return calcularInvestimento(investidorDTO);
    }
}
}
*/