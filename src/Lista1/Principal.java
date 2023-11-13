package Lista1;

import Lista1.Contato;
import Lista1.controlaAgenda;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        boolean sair = true;
        Scanner opt = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        controlaAgenda agenda = new controlaAgenda(100);

        while (sair){
            System.out.print("""
                    \nSelecione:
                    1 -> Adicionar contato no final
                    2 -> Adicionar contato por posição 
                    3 -> Remover contato 
                    4 -> Informar a quantidade de contatos 
                    5 -> Verificar se um determinado contato existe na agenda
                    6 -> Imprimir contatos
                    7 -> Imprimir todos os contatos por letra
                    0 -> Finalizar 
                    Digite alguma opção! -> """);

            int option = opt.nextInt();
            switch (option) {
                case 1 -> {
                    System.out.println("\nNome:");
                    System.out.println("Telefone:");
                    String nome = input.nextLine();
                    String tel = input.nextLine();
                    Contato contato = new Contato(nome, tel);
                    agenda.inserirFinalVetor(contato);
                }
                case 2 -> {
                    System.out.println("\nNome:");
                    System.out.println("Telefone:");
                    System.out.println("Posição:");
                    String nome = input.nextLine();
                    String tel = input.nextLine();
                    Contato contato2 = new Contato(nome, tel);
                    int posit = Integer.parseInt(input.nextLine());
                    agenda.adicionarPorPosicao(posit, contato2);
                }
                case 3 -> {
                    System.out.println("Nome:");
                    agenda.removerPorNome(input.nextLine());
                }
                case 4 -> agenda.quantidade();
                case 5 -> {
                    System.out.println("Nome:");
                    agenda.buscarAlunoPorPosicao(input.nextLine());
                }
                case 6 -> agenda.imprimir();
                case 7 -> {
                    System.out.print("Letra: ");
                    char letra = input.nextLine().charAt(0);
                    agenda.imprimirContatosPorLetra(letra);
                }
                case 0 -> sair = false;
            }
}
}
}