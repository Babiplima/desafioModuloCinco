package zup.com.br.gerenciadorConta.exceptions;

public class MensagemErro {
    public String mensagem;
    public String campo;

    public MensagemErro(String mensagem, String campo) {
        this.mensagem = mensagem;
        this.campo = campo;
    }

    public MensagemErro(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }
}
