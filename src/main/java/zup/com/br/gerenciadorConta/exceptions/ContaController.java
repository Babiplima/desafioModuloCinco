package zup.com.br.gerenciadorConta.exceptions;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zup.com.br.gerenciadorConta.cadastro.dto.ContaDTO;

@RestController
@RequestMapping ("/gereciadorCadastro")
public class ContaController {

    @Autowired
    private ContaService contaService;
    @Autowired
    private ModelMapper modelMapper;

    public void cadastrarConta(@RequestBody ContaDTO contaDTO){
        Conta conta = modelMapper.map(contaDTO, Conta.class);
        contaService.salvarConta(conta);
    }

}
