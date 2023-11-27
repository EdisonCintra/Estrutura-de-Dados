package FilaPilha;

public class Main {

    public static void main(String[] args) {
        Pilha pilha = new Pilha();
        Fila fila = new Fila();

        pilha.push("A");
        pilha.push("B");
        pilha.push("C");

        fila.enqueue(pilha.top());
        fila.enqueue(pilha.top());
        fila.enqueue("D"); //pilha -> cba   fila -> dcc

        pilha.push(fila.dequeue());
        fila.enqueue(fila.dequeue());
        fila.enqueue(pilha.pop());
        pilha.push("e");

        fila.enqueue("E");

        pilha.pop();

        System.out.println("Pilha: ");
        printPilha(pilha);

        System.out.println("\nFila: ");
        printFila(fila);
    }

    private static void printPilha(Pilha pilha) {
        while (!pilha.isEmpty()) {
            System.out.print(pilha.pop() + " ");
        }
    }

    private static void printFila(Fila fila) {
        while (!fila.isEmpty()) {
            System.out.print(fila.dequeue() + " ");
        }
    }
}
