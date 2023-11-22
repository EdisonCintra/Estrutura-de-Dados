package Lista_prioridade_cores;

public class Lista {

    No primeiro = null;
    No ultimo = null;

    public void inserirNoFinal(No novoNo){
        if (primeiro == null){
            primeiro = novoNo;
        }
        else{
            ultimo.prox = novoNo;
        }
        ultimo = novoNo;
    }



    public void inserir(No novoNo){
        if (primeiro ==null){
            primeiro = novoNo;
            ultimo = novoNo;
        }
        else{
            if (novoNo.cor == 'V'){
                inserirNoFinal(novoNo);
            }
            else{
                inserirComPrioridade(novoNo);
            }
        }
    }

    public void inserirComPrioridade(No novo) {
        No aux = primeiro; //1

        if (aux.cor == 'V') {
            novo.prox = aux; // 3 1 2
            primeiro = novo;
            return;
        }

        while (aux.prox.cor != 'V') {
            aux = aux.prox; //4
        }

        novo.prox = aux.prox;
        aux.prox = novo;
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



    public static void main(String[] args) {



        Lista listaDePacientes = new Lista();

        listaDePacientes.inserir(new No(1,'V'));//1 2
        listaDePacientes.inserir(new No(3,'A'));
        listaDePacientes.inserir(new No(4,'V'));
        listaDePacientes.inserir(new No(5,'A'));

        listaDePacientes.imprimir();
    }
}
