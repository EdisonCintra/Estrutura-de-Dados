package Fila_PNE_2;


class FilaAtendimentoMudancas {

    No frente;
    No fim;
    int tamanho;
    int atendimentosNormais;

    int atendimentosPNE;

    public FilaAtendimentoMudancas() {
        this.frente = null;
        this.fim = null;
        this.tamanho = 0;
        this.atendimentosNormais = 0;
        this.atendimentosPNE = 0;

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

        if (atendimentosNormais >= 4 && frente != null) {
            Pessoa pessoaPNE = buscarProximaPNE();

            if (pessoaPNE != null) {
                System.out.println("Atendendo PNE após 3 atendimentos normais: " + pessoaPNE.nome + " (PNE)");
                removerPNE(frente, pessoaPNE);
                atendimentosNormais = 0;
            }
        } else if (frente != null && frente.pessoa.necessidadeEspecial) {
            Pessoa pessoaPNE = frente.pessoa;
            frente = frente.next;
            tamanho--;

            //System.out.println("Atendendo: " + pessoaPNE.nome + " (PNE)");
            atendimentosNormais = 0;

            return pessoaPNE;
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
        FilaAtendimentoMudancas fila = new FilaAtendimentoMudancas();

        fila.enqueue(new Pessoa("Pessoa1", true));
        fila.enqueue(new Pessoa("Pessoa2", false));
        fila.enqueue(new Pessoa("Pessoa3", false));
        fila.enqueue(new Pessoa("Pessoa4", false));
        fila.enqueue(new Pessoa("Pessoa5", false));
        fila.enqueue(new Pessoa("Pessoa6", true));
        fila.enqueue(new Pessoa("Pessoa7", false));



        while (!fila.isEmpty()) {
            Pessoa pessoaAtendida = fila.dequeue();
            System.out.println("Atendendo: " + pessoaAtendida.nome +
                    (pessoaAtendida.necessidadeEspecial ? " (PNE)" : ""));
        }
    }
}
