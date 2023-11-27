package Fila_PNE;

class No {
    Pessoa pessoa;
    No next;

    public No(Pessoa pessoa) {
        this.pessoa = pessoa;
        this.next = null;
    }
}