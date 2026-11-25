package org.example;

/** Monta uma vaca configurando seus dados antes de chamar build(). */
public class VacaBuilder {
    private final Vaca vaca;

    public VacaBuilder(String tipo) {
        if (tipo == null) throw new IllegalArgumentException("Tipo da vaca é obrigatório");
        switch (tipo.trim().toLowerCase()) {
            case "gir" -> vaca = new Gir();
            case "nelore" -> vaca = new Nelore();
            default -> throw new IllegalArgumentException("Tipo de vaca inválido: " + tipo);
        }
    }

    public VacaBuilder setRGN(String rgn) { vaca.setRGN(rgn); return this; }
    public VacaBuilder setDono(String dono) { vaca.setDono(dono); return this; }
    public VacaBuilder setPreco(double preco) { vaca.setPreco(preco); return this; }

    public VacaBuilder setProducaoLeiteMes(int producaoLeiteMes) {
        if (!(vaca instanceof Gir)) throw new IllegalStateException("Produção de leite só se aplica à Gir");
        ((Gir) vaca).setProducaoLeiteMes(producaoLeiteMes);
        return this;
    }

    public VacaBuilder setPeso(int peso) {
        if (!(vaca instanceof Nelore)) throw new IllegalStateException("Peso só se aplica à Nelore");
        ((Nelore) vaca).setPeso(peso);
        return this;
    }

    public Vaca build() {
        if (vaca.getRGN() == null || vaca.getRGN().isBlank())
            throw new IllegalArgumentException("RGN da vaca é obrigatório");
        if (vaca.getDono() == null || vaca.getDono().isBlank())
            throw new IllegalArgumentException("Dono da vaca é obrigatório");
        if (vaca instanceof Gir && ((Gir) vaca).getProducaoLeiteMes() <= 0)
            throw new IllegalArgumentException("Produção mensal de leite deve ser maior que zero");
        if (vaca instanceof Nelore && ((Nelore) vaca).getPeso() <= 0)
            throw new IllegalArgumentException("Peso deve ser maior que zero");
        return vaca;
    }
}
