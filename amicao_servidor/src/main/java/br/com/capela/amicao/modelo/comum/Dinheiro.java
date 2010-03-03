package br.com.capela.amicao.modelo.comum;

import br.com.capela.amicao.modelo.base.ObjetoValor;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

public class Dinheiro implements ObjetoValor<Dinheiro> {
    private Long quantia;
    private Currency moeda;
    private static final int[] CENTAVOS = {1, 10, 100, 1000};

    private Dinheiro() {

    }

    public Dinheiro(Long quantia, Currency moeda) {
        this.moeda = moeda;
        this.quantia = quantia * fatorCentavos();
    }

    public Dinheiro(Double quantia, Currency moeda) {
        this.moeda = moeda;
        this.quantia = Math.round(quantia * fatorCentavos());
    }

    public static Dinheiro REAIS(Long quantia) {
        return new Dinheiro(quantia, Currency.getInstance(new Locale("pt", "br")));
    }

    public static Dinheiro REAIS(Double quantia) {
        return new Dinheiro(quantia, Currency.getInstance(new Locale("pt", "br")));
    }

    @Override
    public Boolean isMesmoValorQue(Dinheiro outro) {
        return this.quantia.equals(outro.quantia);
    }

    private void assercaoMesmaMoedaQue(Dinheiro outro) {
        if (!this.moeda.equals(outro.moeda))
            throw new IllegalArgumentException("Erro de comparacao de moedas!");
    }

    private Dinheiro novoDinheiro(Long novaQuantia) {
        Dinheiro novoDinheiro = new Dinheiro();
        novoDinheiro.moeda = this.moeda;
        novoDinheiro.quantia = novaQuantia;
        return novoDinheiro;
    }

    private int fatorCentavos() {
        return CENTAVOS[moeda.getDefaultFractionDigits()];
    }

    @Override
    public int hashCode() {
        return (int) (quantia ^ (quantia >>> 32));
    }

    @Override
    public boolean equals(Object outro) {
        return (outro instanceof Dinheiro) && equals((Dinheiro) outro);
    }

    public Boolean equals(Dinheiro outro) {
        return moeda.equals(outro.moeda) && quantia.equals(outro.quantia);
    }

    public Currency getMoeda() {
        return this.moeda;
    }

    public BigDecimal getQuantia() {
        return BigDecimal.valueOf(quantia, moeda.getDefaultFractionDigits());
    }

    public int comparaCom(Dinheiro outro) {
        assercaoMesmaMoedaQue(outro);
        if (quantia < outro.quantia)
            return -1;
        else if (quantia == outro.quantia)
            return 0;
        else
            return 1;
    }

    public boolean maiorQue(Dinheiro outro) {
        return comparaCom(outro) > 0;
    }

    public Dinheiro adicionar(Dinheiro outro) {
        assercaoMesmaMoedaQue(outro);
        return novoDinheiro(quantia + outro.quantia);
    }

    public Dinheiro subtrair(Dinheiro outro) {
        assercaoMesmaMoedaQue(outro);
        return novoDinheiro(quantia - outro.quantia);
    }

    public Dinheiro[] alocar(int n) {
        Dinheiro resutadoBaixo = novoDinheiro(quantia / n);
        Dinheiro resutadoAlto = novoDinheiro(resutadoBaixo.quantia + 1);
        Dinheiro[] resultados = new Dinheiro[n];
        int resto = (int) (quantia % n);
        for (int i = 0; i <= resto; i++)
            resultados[i] = resutadoAlto;
        for (int i = resto; i < n; i++)
            resultados[i] = resutadoBaixo;
        return resultados;
    }
}
