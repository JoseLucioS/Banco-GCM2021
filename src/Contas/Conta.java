package Contas;

public class Conta {
    private String numero;
    private double saldo;

    public Conta(String numero){
        this.setNumero(numero);
        this.setSaldo(0.0);
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
