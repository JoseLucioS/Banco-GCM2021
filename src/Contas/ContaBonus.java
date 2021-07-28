package Contas;

public class ContaBonus extends Conta{
    private int pontuacao;

    public ContaBonus(String numero) {
        super(numero);
        this.pontuacao = 10;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
}
