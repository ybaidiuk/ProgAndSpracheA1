package com.baidiuk.entitys;

/**
 * @author Baidiuk Yevhen
 * Matrikelnummer: 1368277
 */

public class Lkw extends Fahrzeug {

    private static final long serialVersionUID = 1L;

    public Lkw(int id, String marke, String modell, int baujahr, double grundpreis) throws Exception {
        super(id, marke, modell, baujahr, grundpreis);
    }

    @Override
    public double getRabatt() {
        double rabbatProzent = getAlter() * 0.05;
        double price = getGrundpreis() * (1 - rabbatProzent);
        double minPrice = getGrundpreis() * 0.80;
        return price < minPrice ? minPrice : price;

    }

    @Override
    public String toString() {
        return "Lkw{" +
                "id=" + getId() +
                ", marke='" + getMarke() + '\'' +
                ", modell='" + getModell() + '\'' +
                ", baujahr=" + getBaujahr() +
                ", grundpreis=" + df.format(getGrundpreis()) +
                ", price=" + getPreis() +
                '}';
    }
}
