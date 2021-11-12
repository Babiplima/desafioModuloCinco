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
           ErroDaValidacao erroDeValidacao = new ErroDeValidacao(fieldError.getField());
            mensagens.add(new MensagemErro(fieldError.getDefaultMessage(), fieldError.getField()));
        }
        return mensagens;
    }

    @ExceptionHandler(ContaJaCadastradaException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public MensagemErro manipularExcecaoDeLeadEProdutoJaCadastrado(ContaJaCadastradoException exception) {
        return new MensagemErro(exception.getMessage(), "sem campo");
    }
}
