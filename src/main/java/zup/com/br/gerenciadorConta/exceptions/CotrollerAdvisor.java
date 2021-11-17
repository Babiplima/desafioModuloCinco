package zup.com.br.gerenciadorConta.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class CotrollerAdvisor {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public List<MensagemErro> manipularExcecoesDeValidacao(MethodArgumentNotValidException exception) {

        List<MensagemErro> mensagens = new ArrayList<>();

        for (FieldError fieldError : exception.getFieldErrors()) {
            mensagens.add(new MensagemErro(fieldError.getDefaultMessage(), fieldError.getField()));
        }
        return mensagens;
    }

    @ExceptionHandler(ContaJaCadastradaException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public MensagemDeErro manipularExcecaoDeContaJaCadastrada(ContaJaCadastradaException exception){
        return new MensagemDeErro(exception.getMessage(), "sem campo");
    }

    @ExceptionHandler(ContaNaoEncontradaException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MensagemDeErro manipularExcecaoDeContaJaCadastrada(LeadNaoEncontradoException exception){
        return new MensagemDeErro(exception.getMessage(), "sem campo");
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MensagemDeErro mensagemGenerica(RuntimeException exception){
        System.out.println(exception);
        return new MensagemDeErro("Algo deu errado. Volte mais tarde");
    }
}