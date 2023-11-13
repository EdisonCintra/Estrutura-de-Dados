/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lista2;

import java.util.Scanner;

/**
 *
 * @author Davi
 */
public class ListaSimples {

    No primeiro=null,ultimo=null;

    //metodo utilizando o scanner para pedir numero e adicionar na lista
    public void add(int valor) {
        No novo = new No(valor);
        if (primeiro == null) {
            primeiro = novo;
            ultimo = novo;
        } else {
            ultimo.prox = novo;
            ultimo = novo;
        }
    }


    public void imprimir(){
        No aux = primeiro;
        if (aux == null) {
            System.out.println("Lista vazia");
            return;
        }
        System.out.println("Lista apresenta os seguintes valores: ");
        while(aux!=null){
            System.out.println(aux.valor);
            aux = aux.prox;
        }
    }


    public void calcularMedia(){
        No aux = primeiro;
        int soma = 0;
        int cont = 0;
        if (aux == null) {
            System.out.println("Não é possível pois a lista está vazia");
            return;
        }
        while(aux!=null){
            soma += aux.valor;
            cont++;
            aux = aux.prox;
        }
        System.out.println("A média dos valores é: "+(soma/cont));
    }


    public void antecessorSucessor(){
        No aux = primeiro;
        if (aux == null){
            System.out.println("Lista vazia");

        }
        else{
            System.out.println("O antecessor do primeiro valor é: "+primeiro.valor);
            System.out.println("O sucessor do último valor é: "+ultimo.valor);

        }

    }


    public static void main(String[] args) {

        ListaSimples lista = new ListaSimples();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número (ou -1 para sair): ");
        int valor = scanner.nextInt();


        while (valor != -1) {
            lista.add(valor);
            System.out.print("Digite outro número (ou -1 para sair): ");
            valor = scanner.nextInt();

        }



        lista.imprimir();
        lista.calcularMedia();
        lista.antecessorSucessor();




        scanner.close();

    }



}
