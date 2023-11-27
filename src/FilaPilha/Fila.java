package FilaPilha;

class Fila {
    private No front;
    private No rear;

    public Fila() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(String letra) {
        No newNode = new No(letra);

        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public String dequeue() {
        if (isEmpty()) {
            return null;
        }

        String letra = front.letra;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        return letra;
    }

    public boolean isEmpty() {
        return front == null;
    }
}