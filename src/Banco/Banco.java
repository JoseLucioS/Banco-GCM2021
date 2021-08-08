package Banco;

import Contas.Conta;
import Contas.ContaBonus;
import Contas.ContaPoupanca;

import java.util.ArrayList;
import java.util.List;

//Classe para gerenciar as contas
public class Banco {
    public List<Conta> contas = new ArrayList<Conta>();
    public List<ContaBonus> contasBonus = new ArrayList<ContaBonus>();
    public List<ContaPoupanca> contasPoupanca = new ArrayList<ContaPoupanca>();

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

    public boolean cadastrarContaBonus(String numeroDaConta){
        for (ContaBonus aux: contasBonus) {
            if(aux.getNumero().equals(numeroDaConta)){
                System.out.println("ERROR: Número de conta já existe!");
                return false;
            }
        }
        ContaBonus c = new ContaBonus(numeroDaConta);
        contasBonus.add(c);

        System.out.println("Conta cadastrada com sucesso!");
        return true;
    }

    public boolean cadastrarContaPoupanca(String numeroDaConta, double saldoInicial){
        for (ContaPoupanca aux: contasPoupanca) {
            if(aux.getNumero().equals(numeroDaConta)){
                System.out.println("ERROR: Número de conta já existe!");
                return false;
            }
        }
        ContaPoupanca cp = new ContaPoupanca(numeroDaConta);
        cp.setSaldo(saldoInicial);

        contasPoupanca.add(cp);
        System.out.println("Conta cadastrada com sucesso!");
        return true;
    }

    public double consultarSaldo(String numeroDaConta){
        for (Conta c: contas) {
            if(c.getNumero().equals(numeroDaConta)){
                return c.getSaldo();
            }
        }

        for (ContaBonus cb: contasBonus) {
            if(cb.getNumero().equals(numeroDaConta)){
                return cb.getSaldo();
            }
        }

        for (ContaPoupanca cp: contasPoupanca) {
            if(cp.getNumero().equals(numeroDaConta)){
                return cp.getSaldo();
            }
        }

        System.out.println("Conta de número " + numeroDaConta + " não existe!");
        return -1;
    }

    public int mostrarPontuacao(String numeroDaConta){
        for (ContaBonus c: contasBonus) {
            if(c.getNumero().equals(numeroDaConta)){
                return c.getPontuacao();
            }
        }
        return -1;
    }

    public boolean creditar(String numeroDaConta, double valor){
        for (Conta c: contas) {
            if(c.getNumero().equals(numeroDaConta)){
                c.setSaldo(c.getSaldo() + valor);
                return true;
            }
        }

        for (ContaBonus cb: contasBonus) {
            if(cb.getNumero().equals(numeroDaConta)){

                cb.setSaldo(cb.getSaldo() + valor);

                int pontos;
                int divisor = 100;
                int novoValor = (int) valor;

                pontos = (novoValor - (novoValor % divisor))/divisor;
                cb.setPontuacao(cb.getPontuacao() + pontos);
                return true;
            }
        }

        for (ContaPoupanca cp: contasPoupanca) {
            if(cp.getNumero().equals(numeroDaConta)){
                cp.setSaldo(cp.getSaldo() + valor);
                return true;
            }
        }

        return false;
    }

    public boolean debitar(String numeroDaConta, double valor){
        double limiteInferiorContaSimples = -1000;
        double limiteInferiorContaBonus = -1000;
        double limiteInferiorContaPoupanca = 0;

        for (Conta c: contas) {
            if(c.getNumero().equals(numeroDaConta)){
                if((c.getSaldo() - valor) < limiteInferiorContaSimples){
                    System.out.println("ERROR! Saldo insuficiente!");
                    return false;
                } else {
                    c.setSaldo(c.getSaldo() - valor);
                    return true;
                }
            }
        }

        for (ContaBonus cb: contasBonus) {
            if(cb.getNumero().equals(numeroDaConta)){
                if((cb.getSaldo() - valor) < limiteInferiorContaBonus){
                    System.out.println("ERROR! Saldo insuficiente!");
                    return false;
                } else {
                    cb.setSaldo(cb.getSaldo() - valor);
                    return true;
                }
            }
        }

        for (ContaPoupanca cp: contasPoupanca) {
            if(cp.getNumero().equals(numeroDaConta)){
                if((cp.getSaldo() - valor) < limiteInferiorContaPoupanca){
                    System.out.println("ERROR! Saldo insuficiente!");
                    return false;
                } else {
                    cp.setSaldo(cp.getSaldo() - valor);
                    return true;
                }
            }
        }

        return false;
    }

    public boolean transferir(String numeroContaOrigem, String numeroContaDestino, double valor){
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flagContaDestino = false; //true se for uma conta bonus, false se for uma conta comum
        ContaBonus cBonus = null;

        for (Conta c: contas) {
            if(c.getNumero().equals(numeroContaOrigem)){
                flag1 = true;
            }
        }

        for (ContaBonus cb: contasBonus) {
            if(cb.getNumero().equals(numeroContaOrigem)){
                flag1 = true;
            }
        }

        for (ContaPoupanca cp: contasPoupanca) {
            if(cp.getNumero().equals(numeroContaOrigem)){
                flag1 = true;
            }
        }

        for (Conta c: contas) {
            if(c.getNumero().equals(numeroContaDestino)){
                flag2 = true;
            }
        }

        for (ContaBonus cb: contasBonus) {
            if(cb.getNumero().equals(numeroContaDestino)){
                flag2 = true;
                flagContaDestino = true;
                cBonus = cb;
            }
        }

        for (ContaPoupanca cp: contasPoupanca) {
            if(cp.getNumero().equals(numeroContaDestino)){
                flag2 = true;
            }
        }

        if(flag1 && flag2){
            debitar(numeroContaOrigem, valor);
            //TODO consertar um pequeno erro de cálculo na pontuação ao transferir dinheiro
            if(flagContaDestino){
                creditar(numeroContaDestino, valor);

                int pontos;
                int divisor = 150;
                int novoValor = (int) valor;

                pontos = (novoValor - (novoValor % divisor))/divisor;

                cBonus.setPontuacao(cBonus.getPontuacao() - pontos);

            } else {
                creditar(numeroContaDestino, valor);
            }

            return true;
        }
        return false;
    }

    public boolean renderJuros(String numeroDaConta, double valorDosJuros){
        for (ContaPoupanca cp: contasPoupanca) {
            if(cp.getNumero().equals(numeroDaConta)){
                cp.setSaldo(cp.getSaldo()*(1+valorDosJuros));
                return true;
            }
        }
        return false;
    }
}
