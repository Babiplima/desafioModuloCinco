package zup.com.br.gerenciadorConta.exceptions;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import zup.com.br.gerenciadorConta.Enum.Tipo;
import zup.com.br.gerenciadorConta.cadastro.dto.ContaDTO;
import zup.com.br.gerenciadorConta.cadastro.dto.ResumoDTO;

import java.time.LocalDate;
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
    public void cadastrarConta(@RequestBody ContaDTO contaDTO) {
        Conta conta = modelMapper.map(contaDTO, Conta.class);
        contaService.salvarConta(conta);
    }

    @GetMapping
    public List<ResumoDTO> exibirResumoDeContas(@RequestParam(required = false) String nome,
                                                @RequestParam(required = false) double valor,
                                                @RequestParam(required = false) Tipo tipo,
                                                @RequestParam(required = false) LocalDate dataDeVencimento) {

        List<ResumoDTO> resumoDTOS = new ArrayList<>();
        for (Conta conta : contaService.exibirTodasAsContas(nome, valor, tipo, dataDeVencimento)) {
            ResumoDTO resumoDTO = modelMapper.map(conta, ResumoDTO.class);
            resumoDTOS.add(resumoDTO);
        }

        return resumoDTOS;

    }
}
