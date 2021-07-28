package HUD;

import jdk.swing.interop.SwingInterOpUtils;

public class Display {
    public void mostrarOpcoes(){
        System.out.println("-------BANCO DO PROGRESSO-------");
        System.out.println("PORQUE OS TEMPOS MUDAM MUITO...");
        System.out.println("Digite 1 - para cadastrar uma conta");
        System.out.println("Digite 2 - para consultar um saldo");
        System.out.println("Digite 3 - para creditar");
        System.out.println("Digite 4 - para debitar");
        System.out.println("Digite 5 - para transferencia");
        System.out.println("Digite 0 - para encerrar operacoes");
    }

    public void mostrarTiposCadastro(){
        System.out.println("---------------------------------");
        System.out.println("Digite 11 para criar conta comum");
        System.out.println("Digite 12 para criar conta bonus");
    }
}
