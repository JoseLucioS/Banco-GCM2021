package Banco;

import Contas.Conta;

import java.util.ArrayList;
import java.util.List;

//Classe para gerenciar as contas
public class Banco {
    public List<Conta> contas = new ArrayList<Conta>();

    //Cadastra uma conta que ainda não existe no sistema
    public boolean cadastrarConta(String numeroDaConta){
        for (Conta aux: contas) {
            if(aux.getNumero().equals(numeroDaConta)){
                System.out.println("ERROR: Número de conta já existe!");
                return false;
            }
        }
        Conta c = new Conta(numeroDaConta);
        contas.add(c);
        System.out.println("Conta cadastrada com sucesso!");
        return true;
    }

    public double consultarSaldo(String numeroDaConta){
        for (Conta c: contas) {
            if(c.getNumero().equals(numeroDaConta)){
                return c.getSaldo();
            }
        }
        System.out.println("Conta de número " + numeroDaConta + " não existe!");
        return -1;
    }

    public boolean creditar(String numeroDaConta, double valor){
        for (Conta c: contas) {
            if(c.getNumero().equals(numeroDaConta)){
                c.setSaldo(c.getSaldo() + valor);
                return true;
            }
        }
        return false;
    }

    public boolean debitar(String numeroDaConta, double valor){
        for (Conta c: contas) {
            if(c.getNumero().equals(numeroDaConta)){
                c.setSaldo(c.getSaldo() - valor);
                return true;
            }
        }
        return false;
    }

    public boolean transferir(String numeroContaOrigem, String numeroContaDestino, double valor){
        boolean flag1 = false;
        boolean flag2 = false;

        for (Conta c: contas) {
            if(c.getNumero().equals(numeroContaOrigem)){
                flag1 = true;
            }
        }

        for (Conta c: contas) {
            if(c.getNumero().equals(numeroContaDestino)){
                flag2 = true;
            }
        }

        if(flag1 && flag2){
            debitar(numeroContaOrigem, valor);
            creditar(numeroContaDestino, valor);
            return true;
        }
        return false;
    }
}
