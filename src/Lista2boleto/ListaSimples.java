package Lista2boleto;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;


public class ListaSimples {

    No primeiro=null,ultimo=null;

    public void adicionarBoleto(Boleto boleto) {
        No novo = new No(boleto);
        if (primeiro == null) {
            primeiro = novo;
            ultimo = novo;
        } else {
            ultimo.prox = novo;
            ultimo = novo;
        }
    }

    public int totalDespesasCadastradas() {
        int total = 0;
        No atual = primeiro;

        while (atual != null) {
            total++;
            atual = atual.prox;
        }

        return total;
    }

    public void despesasAteData(Date data) {
        No atual = primeiro;

        System.out.println("Despesas cadastradas até " + data + ":");
        while (atual != null) {
            if (atual.boleto.prazo_encerramento.before(data)) {
                System.out.println(atual.boleto.nome_despesa);
            }
            atual = atual.prox;
        }
    }

    public void despesasPagasAteData(Date data) {
        No atual = primeiro;

        System.out.println("Despesas pagas até " + data + ":");
        while (atual != null) {
            if (atual.boleto.situacao_boleto == 0 && atual.boleto.prazo_encerramento.before(data)) {
                System.out.println(atual.boleto.nome_despesa);
            }
            atual = atual.prox;
        }
    }

    public Boleto despesaNaoPagaProxima(Date data) {
        No atual = primeiro;
        Boleto despesaProxima = null;
        long menorDiferenca = Long.MAX_VALUE;

        while (atual != null) {
            if (atual.boleto.situacao_boleto == 1) {
                long diferenca = atual.boleto.prazo_encerramento.getTime() - data.getTime();
                if (diferenca < menorDiferenca && diferenca >= 0) {
                    menorDiferenca = diferenca;
                    despesaProxima = atual.boleto;
                }
            }
            atual = atual.prox;
        }

        return despesaProxima;
    }


    public static void main(String[] args) throws ParseException {


        ListaSimples lista = new ListaSimples();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataAtual = new Date();

        Boleto boleto1 = new Boleto("Conta de Luz", 100.0, sdf.parse("10/10/2023"), 1);
        Boleto boleto2 = new Boleto("Aluguel", 1500.0, sdf.parse("01/11/2023"), 0);
        Boleto boleto3 = new Boleto("Conta de Água", 50.0, sdf.parse("05/10/2023"), 0);
        Boleto boleto4 = new Boleto("Telefone", 80.0, sdf.parse("20/10/2023"), 1);


        lista.adicionarBoleto(boleto1);
        lista.adicionarBoleto(boleto2);
        lista.adicionarBoleto(boleto3);
        lista.adicionarBoleto(boleto4);

        Date dataLimite = sdf.parse("16/10/2023");

        int totalDespesas = lista.totalDespesasCadastradas();
        System.out.println("Total de despesas cadastradas: " + totalDespesas);

        lista.despesasAteData(dataLimite);

        lista.despesasPagasAteData(dataLimite);

        Boleto despesaProxima = lista.despesaNaoPagaProxima(dataAtual);
        if (despesaProxima != null) {
            System.out.println("A próxima despesa não paga é: " + despesaProxima.nome_despesa);
        } else {
            System.out.println("Não há despesas não pagas próximas.");
        }


    }
}
