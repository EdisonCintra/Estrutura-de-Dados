package Fila_PNE;
class FilaAtendimento {


    No frente;
    No fim;
    int tamanho;
    int atendimentosNormais;

    public FilaAtendimento() {
        this.frente = null;
        this.fim = null;
        this.tamanho = 0;
        this.atendimentosNormais = 0;
    }

    public void enqueue(Pessoa pessoa) {
        No novoNo = new No(pessoa);

        if (isEmpty()) {
            frente = novoNo;
        } else {
            fim.next = novoNo;
        }

        fim = novoNo;
        tamanho++;

        if (!pessoa.necessidadeEspecial) {
            atendimentosNormais++;
            if (atendimentosNormais == 3) {
                Pessoa pne = new Pessoa("PNE", true);
                enqueue(pne);
            }
        }
    }

    public Pessoa dequeue() {
        if (isEmpty()) {
            return null;
        }

        Pessoa pessoaAtendida = frente.pessoa;
        frente = frente.next;
        tamanho--;

        return pessoaAtendida;
    }

    public boolean isEmpty() {
        return frente == null;
    }

    public int tamanho() {
        return tamanho;
    }



    public static void main(String[] args) {
        FilaAtendimento fila = new FilaAtendimento();

        fila.enqueue(new Pessoa("Pessoa1", false));
        fila.enqueue(new Pessoa("Pessoa2", false));
        fila.enqueue(new Pessoa("Pessoa3", false));
        fila.enqueue(new Pessoa("Pessoa4", false));

        while (!fila.isEmpty()) {
            Pessoa pessoaAtendida = fila.dequeue();
            System.out.println("Atendendo: " + pessoaAtendida.nome +
                    (pessoaAtendida.necessidadeEspecial ? " (PNE)" : ""));
        }
    }
}