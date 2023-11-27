package FilaPilha;

class Pilha {
    private No top;

    public Pilha() {
        this.top = null;
    }

    public void push(String letra) {
        No newNode = new No(letra);
        newNode.next = top;
        top = newNode;
    }

    public String pop() {
        if (isEmpty()) {
            return null;
        }

        String letra = top.letra;
        top = top.next;
        return letra;
    }

    public String top() {
        if (isEmpty()) {
            return null;
        }

        return top.letra;
    }

    public boolean isEmpty() {
        return top == null;
    }
}