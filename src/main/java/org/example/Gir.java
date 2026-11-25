package org.example;

public class Gir implements Vaca {
    private String rgn;
    private String dono;
    private double preco;
    private int producaoLeiteMes;

    @Override public String getRGN() { return rgn; }
    @Override public void setRGN(String rgn) { this.rgn = rgn; }
    @Override public double getPreco() { return preco; }
    @Override public void setPreco(double preco) {
        if (preco < 0) throw new IllegalArgumentException("Preço não pode ser negativo");
        this.preco = preco;
    }
    @Override public void venderConsumo() { setPreco(preco + producaoLeiteMes * 20); }
    @Override public String getDono() { return dono; }
    @Override public void setDono(String dono) { this.dono = dono; }
    public int getProducaoLeiteMes() { return producaoLeiteMes; }
    public void setProducaoLeiteMes(int producaoLeiteMes) {
        if (producaoLeiteMes < 0) throw new IllegalArgumentException("Produção não pode ser negativa");
        this.producaoLeiteMes = producaoLeiteMes;
    }
}
