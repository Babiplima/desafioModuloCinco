package zup.com.br.gerenciadorConta.exceptions;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ConversorModel {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
