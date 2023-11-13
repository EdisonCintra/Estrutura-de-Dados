package TarefaListaSimples;
import ListaSimples.No;

public class ListaSimplesString {


    NoString primeiro = null, ultimo = null;


    public void inserirNoFinal(NoString novoNo) {

        if (primeiro == null) {
            //Lista vazia
            //inserir nó na lista
            //nó será o primeiro e o último elemento
            primeiro = novoNo;
        } else {
            //existe elementos na lista
            //inserir na ultima posição
            ultimo.prox = novoNo;
        }
        ultimo = novoNo;

    }


    public void inserirNoInicio(NoString novoNo){
        if (primeiro==null){
            primeiro = novoNo;
            ultimo = novoNo;
        }
        else {
            ultimo.prox = novoNo;

        }
        ultimo = novoNo;
    }


    public void imprimir(){

        NoString aux=primeiro;
        int i=0;
        while(aux!=null){
            System.out.println("Pos: "+i+" Valor: "+aux.nome);
            i++;
            aux=aux.prox;
        }


    }

    public void tamanhoLista(){
        NoString aux=primeiro;
        int i=0;
        while(aux!=null) {
            i++;
            aux = aux.prox;

        }
        System.out.println("Tamanho do vetor:" + i);

    }


    public void excluirPrimeiro(){
        NoString aux = primeiro; //10
        primeiro = primeiro.prox; //null
        aux.prox = null;
    }


    //excluir o ultimo
    public void excluirUltimo(){
        NoString aux = primeiro;
        while (aux.prox != ultimo){
            aux = aux.prox;
        }
        aux.prox = null;
        ultimo = aux;
    }



    public void imprimirAlessandro() {
        NoString aux = primeiro;
        int i = 0;
        while (aux != null) {
            if (aux.nome.equals("Alessandro")) {
                System.out.println("Pos: " + i + " Valor: " + aux.nome);
            }
            i++;
            aux = aux.prox;
        }
    }



    public void alterarNomeDavi(){
        NoString aux = primeiro;
        int i = 0;
        while (aux != null) {
            if (aux.nome.equals("Davi")) {
                aux.nome = "Davi Taveira";
            }
            i++;
            aux = aux.prox;
        }
    }

    public void imprimirAlexandre(){
        NoString aux = primeiro;
        int i = 0;
        int c = 0;
        while (aux != null) {
            if (aux.nome.equals("Alexandre")) {
                System.out.println("Pos: " + i + " Valor: " + aux.nome);
                c = 1;
            }
            i++;
            aux = aux.prox;
        }
        if (c == 0){
            System.out.println("Não existe Alexandre na lista");
        }
    }


    public void imprimirPosicao(int posicao){
        NoString aux = primeiro;
        int i = 0;
        while (aux != null) {
            if (i == posicao) {
                System.out.println("Pos: " + i + " Valor: " + aux.nome);
            }
            i++;
            aux = aux.prox;
        }
    }


    public void imprimirLetra(char letra){
        NoString aux = primeiro;
        int i = 0;
        int c = 0;
        while (aux != null) {
            if (aux.nome.charAt(0) == letra) {
                System.out.println("Pos: " + i + " Valor: " + aux.nome);
                c = 1;
            }
            i++;
            aux = aux.prox;



        }
        if (c == 0){
            System.out.println("Não existe letra na lista");
        }
    }





    //criação de objetos, chamar métodos e imprimir

    public static void main(String[] args) {

        ListaSimplesString listaSimples = new ListaSimplesString();



        NoString no1 = new NoString("Lynwood");
        NoString no2 = new NoString("Thiane");
        NoString no3 = new NoString("Maurilio");
        NoString no4 = new NoString("Davi");
        NoString no5 = new NoString("Ricardo");
        NoString no6 = new NoString("Alessandro");
        NoString no7 = new NoString("Viviane");
        NoString no8 = new NoString("Alexandre");


        listaSimples.inserirNoInicio(no1);
        listaSimples.imprimir();
        System.out.println("/////////////////////////");
        listaSimples.inserirNoInicio(no2);
        listaSimples.imprimir();
        System.out.println("////////////////////////");
        listaSimples.inserirNoInicio(no3);
        listaSimples.imprimir();
        System.out.println("////////////////////////");
        listaSimples.inserirNoFinal(no4);
        listaSimples.imprimir();
        System.out.println("////////////////////////");
        listaSimples.inserirNoFinal(no5);
        listaSimples.imprimir();
        System.out.println("////////////////////////");
        listaSimples.inserirNoFinal(no6);
        listaSimples.imprimir();
        System.out.println("////////////////////////");
        listaSimples.inserirNoFinal(no7);
        listaSimples.imprimir();
        System.out.println("////////////////////////");
        listaSimples.inserirNoFinal(no8);
        listaSimples.imprimir();
        System.out.println("////////////////////////");


        listaSimples.tamanhoLista();
        System.out.println("////////////////////////");


        listaSimples.excluirPrimeiro();
        listaSimples.imprimir();

        System.out.println("////////////////////////");

        listaSimples.excluirUltimo();
        listaSimples.imprimir();

        System.out.println("////////////////////////");
        listaSimples.imprimirAlessandro();
        listaSimples.alterarNomeDavi();

        System.out.println("////////////////////////");
        listaSimples.imprimir();

        System.out.println("////////////////////////");
        listaSimples.imprimirAlexandre();


        System.out.println("////////////////////////");
        listaSimples.imprimirPosicao(3);

        System.out.println("////////////////////////");
        listaSimples.imprimirLetra('A');
        listaSimples.imprimirLetra('B');
        System.out.println("////////////////////////");


        listaSimples.imprimir();






    }

}
