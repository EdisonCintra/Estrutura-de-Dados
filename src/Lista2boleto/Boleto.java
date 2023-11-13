package Lista2boleto;

import java.util.Date;

public class Boleto {

    //- nome da despesa (tipo String),
    //- valor da despesa (tipo double),
    //- prazo de encerramento do boleto (tipo data dd/MM/YYYY),
    //- situação do boleto (tipo int, sendo 0 para pago e 1 para não pago)

    String nome_despesa;
    double valor_despesa;
    Date prazo_encerramento;
    int situacao_boleto; //0 para pago 1 para não pago

    public Boleto(String nome_despesa, double valor_despesa, Date prazo_encerramento, int situacao_boletos) {
        this.nome_despesa = nome_despesa;
        this.valor_despesa = valor_despesa;
        this.prazo_encerramento = prazo_encerramento;
        this.situacao_boleto = situacao_boletos;
    }
}

