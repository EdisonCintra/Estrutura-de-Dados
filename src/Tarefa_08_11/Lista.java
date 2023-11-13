package Tarefa_08_11;

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

    public static void main(String[] args) {
        Lista lista = new Lista();

        System.out.println("Adicionando por posição");

        lista.inserirPorPosicao(1, 0);
        lista.inserirPorPosicao(10, 1);

        lista.imprimir();

        lista.inserirPorPosicao(100, 1);
        lista.imprimir();




    }
}