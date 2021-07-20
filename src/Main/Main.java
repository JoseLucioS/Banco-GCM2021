package Main;

import Banco.Banco;
import Contas.Conta;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Conta c = new Conta("123456-1");

        banco.cadastrarConta(c.getNumero());
        banco.cadastrarConta("123456-2");
        banco.creditar(c.getNumero(), 345.57);
        banco.debitar("123456-2", 200.10);

        System.out.println("antes da transferencia:");
        System.out.println("saldo: " + banco.consultarSaldo(c.getNumero()));
        System.out.println("saldo: " + banco.consultarSaldo("123456-2"));

        banco.transferir(c.getNumero(), "123456-2", 300);

        System.out.println("depois da transferencia:");
        System.out.println("saldo: " + banco.consultarSaldo(c.getNumero()));
        System.out.println("saldo: " + banco.consultarSaldo("123456-2"));

        System.out.println(banco.contas.size());

    }
}
