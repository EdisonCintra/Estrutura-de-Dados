/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Listacompras2;

import java.util.Scanner;

/**
 *
 * @author Davi
 */
public class ListaSimples {
    No primeiro = null;
    No ultimo = null;

    //metodo para adicionar nome,categoria e valor na lista do
    //tipo lista simples
    public void add(int valor, String categoria, String nome) {
        No novo = new No(valor, categoria, nome);
        if (primeiro == null) {
            primeiro = novo;
            ultimo = novo;
        } else {
            ultimo.prox = novo;
            ultimo = novo;
        }
    }

    //metodo imprimir a lista simples
    public void imprimir(){
        No aux = primeiro;
        if (aux == null) {
            System.out.println("Lista vazia");
            return;
        }
        System.out.println("Lista apresenta os seguintes valores: ");
        while(aux!=null){
            System.out.println(aux.valor+" "+aux.categoria+" "+aux.nome);
            aux = aux.prox;
        }
    }

    //metodo para criar a soma do valor das listas
    public void valorFinalCompra(){
        No aux = primeiro;
        int soma = 0;
        if (aux == null) {
            System.out.println("Não é possível pois a lista está vazia");
            return;
        }
        while(aux!=null){
            soma += aux.valor;
            aux = aux.prox;
        }
        System.out.println("A soma dos valores é: "+soma);
    }

    public void buscaItemLista(){
        No aux = primeiro;
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do item que deseja buscar: ");
        String nome = sc.nextLine();
        if (aux == null) {
            System.out.println("Não é possível pois a lista está vazia");
            return;
        }
        while(aux!=null){
            if (aux.nome.equals(nome)) {
                System.out.println("O item "+nome+" foi encontrado");
                return;
            }
            aux = aux.prox;
        }
        System.out.println("O item "+nome+" não foi encontrado!");
    }


    public void maiorValorItemLista(){
        No aux = primeiro;
        int maior = -1000000;
        if (aux == null){
            System.out.println("Lista vazia");
            return;
        }
        else {
            while (aux != null) {
                if (aux.valor > maior) {
                    maior = aux.valor;
                }
                aux = aux.prox;
            }
            System.out.println("O maior valor é: " + maior);
        }
    }

    public void listaItensCategoria(){
        No aux = primeiro;
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a categoria que deseja buscar: ");
        String categoria = sc.nextLine();
        if (aux == null) {
            System.out.println("Não é possível pois a lista está vazia");
            return;
        }
        while(aux!=null){
            if (aux.categoria.equals(categoria)) {
                System.out.println("O item da categoria "+categoria+" foi encontrado na lista!");
                System.out.println(aux.valor+" "+aux.categoria+" "+aux.nome);
                return;
            }
            aux = aux.prox;
        }
        System.out.println("O item "+categoria+" não foi encontrado!");
    }

    public static void main(String[] args) {

        ListaSimples lista = new ListaSimples();

        lista.add(30, "Frutas", "Banana");
        lista.add(5, "Frutas", "Maça");
        lista.add(5, "Frutas", "Uva");

        lista.imprimir();
        System.out.println("////");
        lista.valorFinalCompra();
        System.out.println("////");
        lista.buscaItemLista();
        System.out.println("////");
        lista.maiorValorItemLista();
        System.out.println("////");
        lista.listaItensCategoria();








    }
}