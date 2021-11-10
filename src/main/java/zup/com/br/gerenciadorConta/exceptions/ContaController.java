package zup.com.br.gerenciadorConta.exceptions;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/gereciadorCadastro")
public class ContaController {
    @Autowired
    private ContaService cadastroService;
    @Autowired
    private ModelMapper modelMapper;
}
