package zup.com.br.gerenciadorConta.exceptions;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zup.com.br.gerenciadorConta.Enum.Status;
import zup.com.br.gerenciadorConta.Enum.Tipo;
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

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarConta(@PathVariable int id){
        contaService.excluirConta(id);
    }


    @GetMapping("/status")
    @ResponseBody
    public List<ContaSaidaDTO> buscarFiltroStatus(@RequestParam Status status) {
        List<ContaSaidaDTO> contaSaidaDTO = new ArrayList<>();
        for (Conta conta : contaService.buscarFiltroStatus(status)) {
            ContaSaidaDTO contaSaidaDTO1 = modelMapper.map(conta, ContaSaidaDTO.class);
            contaSaidaDTO.add(contaSaidaDTO1);
        }
        return contaSaidaDTO;
    }

    @GetMapping("/tipo")
    @ResponseBody
    public List<ContaSaidaDTO> buscarFiltroTipo(@RequestParam Tipo tipo) {
        List<ContaSaidaDTO> contaSaidaDTO = new ArrayList<>();
        for (Conta conta : contaService.buscarFiltroTipo(tipo)) {
            ContaSaidaDTO contaSaidaDTO1 = modelMapper.map(conta, ContaSaidaDTO.class);
            contaSaidaDTO.add(contaSaidaDTO1);
        }
        return contaSaidaDTO;
    }


    @GetMapping("/valor")
    @ResponseBody
    public List<ContaSaidaDTO> buscarFiltroValorAproximado(@RequestParam double valor) {
        List<ContaSaidaDTO> contaSaidaDTO = new ArrayList<>();
        for (Conta conta : contaService.buscarFiltroValorAproximado(valor)) {
            ContaSaidaDTO contaSaidaDTO1 = modelMapper.map(conta, ContaSaidaDTO.class);
            contaSaidaDTO.add(contaSaidaDTO1);
        }
        return contaSaidaDTO;
    }
}







