package zup.com.br.gerenciadorConta.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zup.com.br.gerenciadorConta.Enum.Status;
import zup.com.br.gerenciadorConta.cadastro.dto.ContaDTO;
import zup.com.br.gerenciadorConta.exceptions.ExceptionIdNaoEncontrado;
import zup.com.br.gerenciadorConta.exceptions.Conta;
import zup.com.br.gerenciadorConta.exceptions.ContaRepository;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


    public List<Conta> exibirTodasAsContas() {
        List<Conta> contas = (List<Conta>) contaRepository.findAll();
        return contas;
    }


    public Conta buscarPorId(int id) {
        Optional<Conta> contaId = contaRepository.findById(id);

        return contaId.get();
    }


    public Conta atualizarContaId(int id) throws ExceptionIdNaoEncontrado {
        Optional<Conta> atualizarContas = contaRepository.findById(id);
        if (atualizarContas.isEmpty()) {
            throw new ExceptionIdNaoEncontrado("Id inválido, não foi encontrado");

        }
        return atualizarContas.get();
    }

    public Conta atualizarConta(int id)  {
        Optional<Conta> atualizarContas = contaRepository.findById(id);
        if (atualizarContas.isEmpty()) {
            throw new ExceptionIdNaoEncontrado("Id inválido, não foi encontrado");
        }
            Conta contaAtualizada = buscarPorId(id);
            contaAtualizada.setStatus(Status.PAGO);
            contaAtualizada.setDataDePagamento(LocalDateTime.now());
            contaRepository.save(contaAtualizada);
            return contaAtualizada;
        }


    }



