package ArvoreBinaria;

public class ArvoreBinaria {

    No raiz;

    public ArvoreBinaria() {
        raiz = null;
    }


    public void inserir(int valor) {

        raiz = inserirRec(raiz, valor);
    }


    private No inserirRec(No raiz, int valor) {  //30
        if (raiz == null) {                         //40
            raiz = new No(valor);                        // 50
            return raiz;
        }


        if (valor < raiz.valor) {
            raiz.esquerda = inserirRec(raiz.esquerda, valor);
        } else if (valor > raiz.valor) {
            raiz.direita = inserirRec(raiz.direita, valor);
        }


        return raiz;
    }

    public void imprimirArvore() {
        imprimirArvoreRec(raiz, 0);
    }

    private void imprimirArvoreRec(No raiz, int nivel) {
        if (raiz != null) {
            imprimirArvoreRec(raiz.direita, nivel + 1);
            for (int i = 0; i < nivel; i++) {
                System.out.print("  ");
            }
            System.out.println(raiz.valor);
            imprimirArvoreRec(raiz.esquerda, nivel + 1);
        }
    }


    public void percursoPreOrdem() {
        percursoPreOrdemRec(raiz);
    }

    private void percursoPreOrdemRec(No raiz) {
        if (raiz != null) {
            System.out.print(raiz.valor + " ");
            percursoPreOrdemRec(raiz.esquerda);
            percursoPreOrdemRec(raiz.direita);
        }
    }


    public void percursoEmOrdem() {
        percursoEmOrdemRec(raiz);
    }

    private void percursoEmOrdemRec(No raiz) {
        if (raiz != null) {
            percursoEmOrdemRec(raiz.esquerda);
            System.out.print(raiz.valor + " ");
            percursoEmOrdemRec(raiz.direita);
        }
    }

    public void percursoPosOrdem() {
        percursoPosOrdemRec(raiz);
    }

    private void percursoPosOrdemRec(No raiz) {
        if (raiz != null) {
            percursoPosOrdemRec(raiz.esquerda);
            percursoPosOrdemRec(raiz.direita);
            System.out.print(raiz.valor + " ");
        }
    }


    public static void main(String[] args) {

        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.inserir(30);
        arvore.inserir(40);
        arvore.inserir(50);
        arvore.inserir(3);

        arvore.imprimirArvore();

        System.out.println("   ");

        arvore.percursoPreOrdem();

        System.out.println("   ");
        System.out.println("   ");


        arvore.percursoEmOrdem();

        System.out.println("   ");
        System.out.println("   ");


        arvore.percursoPosOrdem();


    }
}

