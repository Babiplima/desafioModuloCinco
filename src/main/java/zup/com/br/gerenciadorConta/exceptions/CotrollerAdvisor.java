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

    @ExceptionHandler(ContaJaCadastrada.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public MensagemErro manipularExcecaoDeContaJaCadastrada(ContaJaCadastrada exception) {
        return new MensagemErro(exception.getMessage());
    }

    @ExceptionHandler(ContaNaoEncontrada.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MensagemErro manipularContaNaoEncontrada(ContaNaoEncontrada exception) {
        return new MensagemErro(exception.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public MensagemErro statusInvalidoException(StatusInvalidoException exception) {
        return new MensagemErro(exception.getMessage());
    }

    @ExceptionHandler(ExceptionIdNaoEncontrado.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MensagemErro exceptionIdNaoEncontrado(ExceptionIdNaoEncontrado exception) {
        return new MensagemErro(exception.getMessage());
    }
}