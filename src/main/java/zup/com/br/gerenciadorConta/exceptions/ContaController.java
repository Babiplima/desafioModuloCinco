package zup.com.br.gerenciadorConta.exceptions;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zup.com.br.gerenciadorConta.Enum.Status;
import zup.com.br.gerenciadorConta.cadastro.dto.AtualizarContaDTO;
import zup.com.br.gerenciadorConta.cadastro.dto.ContaDTO;
import zup.com.br.gerenciadorConta.cadastro.dto.ContaSaidaDTO;
import zup.com.br.gerenciadorConta.cadastro.dto.ExibirContaDTO;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContaSaidaDTO cadastrarConta(@Valid @RequestBody ContaDTO contaDTO) {
        Conta conta = modelMapper.map(contaDTO, Conta.class);

        return modelMapper.map(contaService.salvarConta(conta), ContaSaidaDTO.class);
    }

    @GetMapping
    public List<ExibirContaDTO> exibirResumoDeContas() {
        List<ExibirContaDTO> exibirContaDTOS = new ArrayList<>();

        for (Conta conta : contaService.exibirTodasAsContas()) {
            ExibirContaDTO exibirContaDTO = modelMapper.map(conta, ExibirContaDTO.class);
            exibirContaDTOS.add(exibirContaDTO);
        }

        return exibirContaDTOS;

    }

    @PutMapping("/{id}")
    public ContaSaidaDTO atualizarConta(@PathVariable int id, @RequestBody AtualizarContaDTO atualizarConta) {
        if (atualizarConta.getStatus() == Status.PAGO) {
            return modelMapper.map(contaService.atualizarConta(id), ContaSaidaDTO.class);
        }
        throw new StatusInvalidoException("Inválido");
    }
}







