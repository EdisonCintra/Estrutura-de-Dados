package Tarefa_08_11;

import TarefaListaSimples.NoString;

public class Lista {
    No primeiro = null;
    No ultimo = null;

    public int tamanho() {

        No aux = primeiro;
        int cont = 0;

        while (aux != null) {
            aux = aux.prox;
            cont++;
        }

        return cont;

    }

    public void inserirPorPosicao(int valor, int posicao) {
        No novo = new No(valor);

        if (posicao == 0) {
            if (primeiro == null) {
                primeiro = novo;
                ultimo = novo;
            } else {
                novo.prox = primeiro;
                primeiro = novo;
            }

        } else if (posicao == tamanho()) {
            ultimo.prox = novo;
            ultimo = novo;

        } else if (posicao > 0 && posicao < tamanho()) {
            No aux = primeiro;
            for (int i = 0; i < posicao - 1; i++) {
                aux = aux.prox;
            }
            novo.prox = aux.prox;
            aux.prox = novo;

        } else {
            System.out.println("Posição fora dos limites da lista");
        }
    }

    public void imprimir() {
        No aux = primeiro;
        if (aux == null || ultimo == null) {
            System.out.println("Lista vazia");
            return;
        }
        System.out.println("Lista apresenta os seguintes valores: ");
        while (aux != null) {
            System.out.println(aux.valor);
            aux = aux.prox;
        }
    }


    public void excluirPorPosicao(int posicao) {

        No aux = primeiro;

        //nada dentro da lista
        if (primeiro == null || ultimo == null) {
            System.out.println("Não é possível excluir pois a lista  está vazia");
            return;
        }

        //apenas um elemento
        if (tamanho() == 1) {
            primeiro = null;
            ultimo = null; //null
        }

        //saiu dos limites
        if (posicao > tamanho() || posicao < 0) {
            System.out.println("Posição fora dos limites da lista");
            return;
        }


        //primeiro
        if (posicao == 0) {
            primeiro = primeiro.prox;
        }


        //meio
        else{
                No previous = primeiro; // 1
                for (int i = 0; i < posicao - 1; i++) { //1 //2
                    previous = previous.prox; //2 //3
                }

                previous.prox = previous.prox.prox; // 4 = null

                if (posicao == tamanho() - 1) {
                    ultimo = previous;
                }
            }


        }


        public static void main (String[]args){
            Lista lista = new Lista();

            System.out.println("Adicionando por posição");

            lista.inserirPorPosicao(1, 0); //1
            lista.inserirPorPosicao(2, 1);
            lista.inserirPorPosicao(3, 2);

            lista.imprimir();

            lista.excluirPorPosicao(1);
            lista.imprimir();


        }
    }