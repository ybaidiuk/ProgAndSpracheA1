package com.baidiuk.entitys;

/**
 * @author Baidiuk Yevhen
 * Matrikelnummer: 1368277
 */

public class Lkw extends Fahrzeug {

    private static final long serialVersionUID = 1L;

    public Lkw(int id, String marke, String modell, int baujahr, double grundpreis) {
        super(id, marke, modell, baujahr, grundpreis);
    }


    @Override
    public int getPreis() {
        // todo
        return 0;
    }

    @Override
    public int getRabatt() {
        // todo
        return 0;
    }

    @Override
    public String toString() {
        return "Lkw{" +
                "id=" + getId() +
                ", marke='" + getMarke() + '\'' +
                ", modell='" + getModell() + '\'' +
                ", baujahr=" + getBaujahr() +
                ", grundpreis=" + getGrundpreis() +
                ", price=" + getPreis() +
                '}';
    }
}
