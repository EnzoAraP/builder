package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VacaBuilderTest {

    @Test
    void constroiGirComDadosConfigurados() {
        Vaca vaca = new VacaBuilder("Gir")
                .setRGN("GIR-001")
                .setDono("Ana")
                .setPreco(2500)
                .setProducaoLeiteMes(120)
                .build();

        Gir gir = assertInstanceOf(Gir.class, vaca);
        assertEquals("GIR-001", gir.getRGN());
        assertEquals("Ana", gir.getDono());
        assertEquals(2500, gir.getPreco());
        assertEquals(120, gir.getProducaoLeiteMes());
    }

    @Test
    void constroiNeloreComDadosConfigurados() {
        Vaca vaca = new VacaBuilder("Nelore")
                .setRGN("NEL-001")
                .setDono("Bruno")
                .setPreco(3000)
                .setPeso(450)
                .build();

        Nelore nelore = assertInstanceOf(Nelore.class, vaca);
        assertEquals("NEL-001", nelore.getRGN());
        assertEquals("Bruno", nelore.getDono());
        assertEquals(3000, nelore.getPreco());
        assertEquals(450, nelore.getPeso());
    }

    @Test
    void rejeitaTipoDeVacaDesconhecido() {
        assertThrows(IllegalArgumentException.class, () -> new VacaBuilder("Campolina"));
    }

    @Test
    void exigeRgnEDono() {
        assertThrows(IllegalArgumentException.class, () -> new VacaBuilder("Gir")
                .setDono("Ana")
                .setProducaoLeiteMes(100)
                .build());

        assertThrows(IllegalArgumentException.class, () -> new VacaBuilder("Gir")
                .setRGN("GIR-001")
                .setProducaoLeiteMes(100)
                .build());
    }

    @Test
    void exigeProducaoParaGirEPesoParaNelore() {
        assertThrows(IllegalArgumentException.class, () -> new VacaBuilder("Gir")
                .setRGN("GIR-001").setDono("Ana").build());

        assertThrows(IllegalArgumentException.class, () -> new VacaBuilder("Nelore")
                .setRGN("NEL-001").setDono("Bruno").build());
    }

    @Test
    void rejeitaAtributoEspecificoDoTipoErrado() {
        assertThrows(IllegalStateException.class,
                () -> new VacaBuilder("Gir").setPeso(400));
        assertThrows(IllegalStateException.class,
                () -> new VacaBuilder("Nelore").setProducaoLeiteMes(100));
    }
}
