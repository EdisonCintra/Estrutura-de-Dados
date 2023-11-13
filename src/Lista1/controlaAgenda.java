package Lista1;


import aula.Aluno;

public class controlaAgenda {

    int qtdContatos = 100;
    Contato[] agenda = new Contato[qtdContatos];

    public controlaAgenda(int capacidadeMaxima) {

        agenda = new Contato[capacidadeMaxima];
        qtdContatos = 0;


    }

    public void inserirFinalVetor(Contato variavel_contato) {
        if (qtdContatos < 100) {
            agenda[qtdContatos] = variavel_contato;
            qtdContatos++;
        } else {
            System.out.println("Vetor cheio!");
        }
    }

    public void adicionarPorPosicao(int pos, Contato variavel_contato) {

        if (qtdContatos == agenda.length) {
            System.out.println("Vetor cheio!");
        } else {
            for (int i = qtdContatos; i > pos; i--) {
                agenda[i] = agenda[i - 1];
            }
            agenda[pos] = variavel_contato;
            qtdContatos++;
        }
    }


    public void removerPorNome(String nomeContato) {
        for (int i = 0; i < qtdContatos; i++) {
            if (agenda[i] != null && agenda[i].getNome().equals(nomeContato)) {
                if (i == qtdContatos - 1) {
                    agenda[i] = null;
                } else {
                    for (int j = i; j < qtdContatos - 1; j++) {
                        agenda[j] = agenda[j + 1];
                    }
                }
                qtdContatos--;
                break;
            }
        }
    }


    public String buscarAlunoPorPosicao(String nomeContato) {
        for (int i = 0; i < qtdContatos; i++) {
            if (agenda[i] != null && agenda[i].getNome().equals(nomeContato)) {
                System.out.println("Encontrado!");
                return agenda[i].getNome();

            }
        }
        return "Aluno não encontrado!";
    }


    public void quantidade(){
        System.out.println("Quantidade de contatos: "+qtdContatos);
    }

    public void imprimir(){
        for(int i=0;i<agenda.length;i++){
            if(agenda[i]!=null){
                System.out.println("Nome: "+agenda[i].nome+"Telefone: "+agenda[i].telefone);
            }
        }
    }

    public void imprimirContatosPorLetra(char letra) {
        boolean encontrou = false;

        for (int i = 0; i < qtdContatos; i++) {
            if (agenda[i] != null && agenda[i].getNome().charAt(0) == letra) {
                System.out.println(agenda[i].getNome());
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Agenda não possui contatos que iniciam com a letra informada!");
        }
    }



}
