package Aula1;

import aula.Aluno;

public class Vetor {

    Aluno[] alunos = new Aluno[100];
    int qtdAlunosVetor = 0;


    //inserção em vetor compactado
    public void inserirFinalVetorV2(Aluno a){
        for (int i = 0; i< alunos.length; i++){
            if (alunos[i] == null){
                alunos[i] =a;
                break;
            }
        }
    }

    public void inserirFinalVetor3 (Aluno a){
        if (qtdAlunosVetor < 100){
            alunos[qtdAlunosVetor] = a;
            qtdAlunosVetor++;
        }
        else {
            System.out.println("Vetor cheio!");
        }
    }

    public boolean tamanhoLista(String nome){
        for (int i =0; i < qtdAlunosVetor; i++){
            if(alunos[i].nome.equals(nome)){
                return true;
            }
        }
        return false;
    }

    public String buscarAlunoPorPosicao(int pos){
        if (pos >= 0 && pos < (qtdAlunosVetor - 1)){
            return alunos[pos].nome;
        }
        else{
            return "Posição Inválida!";
        }
    }


    public void adicionarPorPosicao(int pos, Aluno a){

        if (qtdAlunosVetor == alunos.length){
            System.out.println("Vetor cheio!");
        }
        else {
            for(int i = qtdAlunosVetor; i > pos; i--){
                alunos[i] = alunos[i-1];
            }
            alunos[pos] = a;
            qtdAlunosVetor++;
        }
    }


    public void remover(int pos){
        if (pos == qtdAlunosVetor-1){
            alunos[pos] = null;
        }
        for (int i = pos; i < qtdAlunosVetor; i++ ){
            alunos[i] = alunos[i+1];
        }
        qtdAlunosVetor--;
    }

    public static void main(String[] args) {
        Vetor v = new Vetor();

        int a = v.alunos.length;
        System.out.println(a);
    }
}
