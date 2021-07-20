package Contas;

public class Conta {
    private String numero;
    private double saldo;

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

    //TODO retornar true caso o cadastro funcione; false caso contrario
    public boolean cadastrarConta(String conta){
        return true;
    }

    //TODO retornar saldo da conta informada
    public double consultarSaldo(String conta){
        return 1.1;
    }

    //TODO retornar true caso o credito funcione; false caso contrario
    public boolean creditar(String conta, double valor){
        return true;
    }

    //TODO retornar true caso o debito funcione; false caso contrario
    public boolean debitar(String conta, double valor){
        return true;
    }

    //TODO retornar true caso a tranferencia funcione; false caso contrario
    public boolean transferir(String contaOrigem, String contaDestino, double valor){
        return true;
    }
}
