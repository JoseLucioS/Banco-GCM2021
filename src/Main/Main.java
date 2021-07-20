package Main;

import Banco.Banco;
import Contas.Conta;
import HUD.Display;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Conta c = new Conta("123456-1");
        String numeroDaConta, numeroContaOrigem, numeroContaDestino;
        double valor;

        Scanner leitor = new Scanner(System.in);

        int opcao = -1;

        Display display = new Display();

        //TODO colocar um "if" para verificar o êxito das funções booleanas (creditar, debitar, transferir)
        while(opcao != 0){
            display.mostrarOpcoes();
            opcao = leitor.nextInt();

            switch (opcao){
                case 1:

                    System.out.println("Por favor, informe um numero para a conta:");
                    numeroDaConta = leitor.next();

                    banco.cadastrarConta(numeroDaConta);

                    break;

                case 2:

                    System.out.println("Por favor, informe o numero da conta:");
                    numeroDaConta = leitor.next();

                    double resultado = banco.consultarSaldo(numeroDaConta);

                    System.out.println("Seu saldo é: " + resultado);

                    break;

                case 3:

                    System.out.println("Por favor, informe o numero da conta:");
                    numeroDaConta = leitor.next();
                    System.out.println("Informe o valor para creditar:");
                    valor = leitor.nextDouble();

                    banco.creditar(numeroDaConta, valor);

                    break;

                case 4:

                    System.out.println("Por favor, informe o numero da conta:");
                    numeroDaConta = leitor.next();
                    System.out.println("Informe o valor para debitar:");
                    valor = leitor.nextDouble();

                    banco.debitar(numeroDaConta, valor);

                    break;

                case 5:

                    System.out.println("Por favor, informe o numero da conta de origem:");
                    numeroContaOrigem = leitor.next();
                    System.out.println("Por favor, informe o numero da conta de destino:");
                    numeroContaDestino = leitor.next();
                    System.out.println("valor a ser transferido:");
                    valor = leitor.nextDouble();

                    banco.transferir(numeroContaOrigem, numeroContaDestino, valor);

                    break;
                case 0:

                    System.out.println("Encerrando o sistema...");

                    break;

                default:
                    System.out.println("Operação inválida!");
            }
        }

    }
}
