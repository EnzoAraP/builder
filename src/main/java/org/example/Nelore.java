package org.example;

public class Nelore implements Vaca {
    private String rgn;
    private String dono;
    private double preco;
    private int peso;

    @Override public String getRGN() { return rgn; }
    @Override public void setRGN(String rgn) { this.rgn = rgn; }
    @Override public double getPreco() { return preco; }
    @Override public void setPreco(double preco) {
        if (preco < 0) throw new IllegalArgumentException("Preço não pode ser negativo");
        this.preco = preco;
    }
    @Override public void venderConsumo() { setPreco(peso * 148.0); }
    @Override public String getDono() { return dono; }
    @Override public void setDono(String dono) { this.dono = dono; }
    public int getPeso() { return peso; }
    public void setPeso(int peso) {
        if (peso < 0) throw new IllegalArgumentException("Peso não pode ser negativo");
        this.peso = peso;
    }
}
