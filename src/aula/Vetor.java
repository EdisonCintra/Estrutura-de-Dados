package aula;

/**
 *
 * @author Davi
 */
public class Vetor {

    Aluno[] alunos = new Aluno[100];

    //Inserção em vetor descompactado
    public void inserirFinalVetorV1(Aluno a){
        for(int i=0;i<alunos.length;i++){
            if(alunos[i]==null){
                alunos[i]=a;
                break;
            }
        }
    }

    public void imprimirV1(){
        for(int i=0;i<alunos.length;i++){
            if(alunos[i]!=null){
                System.out.println("Pos: "+i+" Nome: "+alunos[i].nome);
            }
        }
    }

    //Inserção em vetor compactado e posição igual a null
    public void inserirFinalVetorV2(Aluno a){
        for(int i=0;i < alunos.length; i++){
            if(alunos[i]==null){
                alunos[i]=a;
                break;
            }
        }
    }

    public static void main(String[] args) {

        Vetor v = new Vetor();

        Aluno a1 = new Aluno("Davi");
        Aluno a2 = new Aluno("Daniel");

        v.inserirFinalVetorV1(a1);
        v.inserirFinalVetorV1(a2);
        v.imprimirV1();

    }


}