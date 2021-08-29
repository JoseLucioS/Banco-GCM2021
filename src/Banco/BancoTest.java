package Banco;

import Contas.Conta;
import Contas.ContaBonus;
import Contas.ContaPoupanca;

import static org.junit.Assert.*;

public class BancoTest {

    @org.junit.Test
    public void bancoNaoVazioAposCadastrarContaSimples() {
        Banco banco = new Banco();
        Conta conta = new Conta("123");

        banco.cadastrarConta(conta.getNumero());

        assertFalse(banco.contas.isEmpty());
    }

    @org.junit.Test
    public void bancoNaoVazioAposCadastrarContaBonus() {
        Banco banco = new Banco();
        ContaBonus contaBonus = new ContaBonus("456");

        banco.cadastrarContaBonus(contaBonus.getNumero());

        assertFalse(banco.contasBonus.isEmpty());
    }

    @org.junit.Test
    public void bancoNaoVazioAposCadastrarContaPoupanca() {
        Banco banco = new Banco();
        ContaPoupanca contaPoupanca = new ContaPoupanca("789");
        contaPoupanca.setSaldo(1500);

        banco.cadastrarContaPoupanca(contaPoupanca.getNumero(), contaPoupanca.getSaldo());

        assertFalse(banco.contasPoupanca.isEmpty());
    }

    @org.junit.Test
    public void saldoDeveSerIgualAoQueFoiDefinido() {
        Banco banco = new Banco();

        banco.cadastrarConta("123");
        banco.creditar("123", 300);

        banco.cadastrarContaBonus("456");
        banco.creditar("456", 600);

        banco.cadastrarContaPoupanca("789", 1000);

        assertEquals(300.0, banco.consultarSaldo("123"), 0.0);
        assertEquals(600.0, banco.consultarSaldo("456"), 0.0);
        assertEquals(1000.0, banco.consultarSaldo("789"), 0.0);
    }

    @org.junit.Test
    public void mostrarPontuacaoAdequada() {
        Banco banco = new Banco();
        banco.cadastrarContaBonus("456");
        banco.creditar("456", 1000);

        assertEquals(20, banco.mostrarPontuacao("456"), 0.0);
    }

    @org.junit.Test
    public void operacaoCreditarDeveFuncionar() {
        Banco banco = new Banco();

        banco.cadastrarConta("123");
        banco.cadastrarContaBonus("456");
        banco.cadastrarContaPoupanca("789", 1000);

        assertTrue(banco.creditar("123", 400));
        assertTrue(banco.creditar("456", 200));
        assertTrue(banco.creditar("789", 800));
    }

    @org.junit.Test
    public void operacaoDebitarDeveFuncionar() {
        Banco banco = new Banco();

        banco.cadastrarConta("123");
        banco.cadastrarContaBonus("456");
        banco.cadastrarContaPoupanca("789", 1000);

        assertTrue(banco.debitar("123", 400));
        assertTrue(banco.debitar("456", 200));
        assertTrue(banco.debitar("789", 800));
    }

    @org.junit.Test
    public void operacaoTranferirDeveFuncionar() {
        Banco banco = new Banco();

        banco.cadastrarConta("123");
        banco.cadastrarContaBonus("456");
        banco.cadastrarContaPoupanca("789", 1000);

        assertTrue(banco.transferir("123", "456", 200));
        assertTrue(banco.transferir("456", "789", 200));
        assertTrue(banco.transferir("789", "123", 200));
    }

    @org.junit.Test
    public void renderJurosDeveAlterarOValorDoSaldoCorretamente() {
        Banco banco = new Banco();

        banco.cadastrarContaPoupanca("789", 1000);

        assertTrue(banco.renderJuros("789", 0.40));
        assertEquals(1400.0, banco.consultarSaldo("789"), 0.0);

    }
}