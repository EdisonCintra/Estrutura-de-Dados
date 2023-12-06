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
    }


    public Pessoa dequeue() {
        if (isEmpty()) {
            return null;
        }

        Pessoa pessoaAtendida = frente.pessoa;
        frente = frente.next;
        tamanho--;

        if (pessoaAtendida.necessidadeEspecial) {
            atendimentosNormais = 0;
            return pessoaAtendida;
        }

        atendimentosNormais++;

        if (atendimentosNormais >= 4) {


            Pessoa pessoaPNE = buscarProximaPNE();

            if (pessoaPNE != null) {
                System.out.println("Atendendo: " + pessoaPNE.nome + " (PNE)");
                removerPNE(frente, pessoaPNE);

            }
            atendimentosNormais = 0;

        }


        return pessoaAtendida;
    }

    private void removerPNE(No inicio, Pessoa pessoa) {
        No atual = inicio;
        No anterior = null;

        while (atual != null && atual.pessoa != pessoa) {
            anterior = atual;
            atual = atual.next;
        }

        if (atual != null) {
            if (anterior == null) {
                frente = atual.next;
            } else {
                anterior.next = atual.next;
            }
            tamanho--;
        }
    }

    private Pessoa buscarProximaPNE() {
        No atual = frente;

        while (atual != null) {
            if (atual.pessoa.necessidadeEspecial) {
                return atual.pessoa;
            }
            atual = atual.next;
        }
        return null;
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
        fila.enqueue(new Pessoa("Pessoa5", true));
        fila.enqueue(new Pessoa("Pessoa6", true));
        fila.enqueue(new Pessoa("Pessoa7", false));





        while (!fila.isEmpty()) {
            Pessoa pessoaAtendida = fila.dequeue();
            System.out.println("Atendendo: " + pessoaAtendida.nome +
                    (pessoaAtendida.necessidadeEspecial ? " (PNE)" : ""));
        }
    }
}
