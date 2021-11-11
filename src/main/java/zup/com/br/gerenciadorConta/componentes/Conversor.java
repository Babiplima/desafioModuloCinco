package zup.com.br.gerenciadorConta.componentes;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class Conversor {
    @Bean
    public ModelMapper criarModelMapper(){
        return new ModelMapper();
    }
}
