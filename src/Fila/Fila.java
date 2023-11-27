package Fila;

public class Fila {

    No inicio = null;
    No fim = null;

    //inserir no final e remover no inicio
    //pilha é inserir e remover no inicio

    //pilha - inserir no inicio push / remover no inicio pop  / top == null vazio
    //fila - inserir no final enqueue / remover no inicio dequeue / front == null vazio

    public void enqueue(int valor){
        //inserir no final

       No novo = new No(valor);

        //nenhum item
        if (inicio == null || fim == null){
            inicio = novo;
            fim = inicio;
        }else{
            novo.prox = inicio;
            inicio = novo;
        }


    }


    public void dequeue (int valor){
        //retirar no inicio

        No novo = new No(valor);

        if (inicio == null){
            System.out.println("Lista vazia!");
        }






    }


    public void imprimir(){
        No aux = inicio;
        if ( aux == null || fim == null){
            System.out.println("Lista vazia");
            return;
        }
        System.out.println("Lista apresenta os seguintes valores: ");
        while (aux != null) { //apresenta valor
            System.out.println(aux.valor); //1
            aux = aux.prox;
        }

    }

    public static void main(String[] args) {

        Fila fila = new Fila();

        fila.imprimir();

        fila.enqueue(1);
        fila.enqueue(2);
        fila.enqueue(3);


        fila.imprimir();
    }
}
