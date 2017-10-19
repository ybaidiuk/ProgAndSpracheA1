package com.baidiuk.entitys;

/**
 * @author Baidiuk Yevhen
 * Matrikelnummer: 1368277
 */

public class Pkw extends Fahrzeug {

    private static final long serialVersionUID = 1L;
    private int servicejahr;

    public Pkw(int id, String marke, String modell, int baujahr, double grundpreis) {
        super(id, marke, modell, baujahr, grundpreis);
    }

    public int getServicejahr() {
        return servicejahr;
    }

    public void setServicejahr(int servicejahr) {
        // todo add to subClass "Error: Servicejahr ungueltig."  nicht in der Zukunft
        this.servicejahr = servicejahr;
    }

    @Override
    public double getRabatt() {
        double rabbatProzent = getAlter() * 0.05 + (currentYear - servicejahr) * 0.02;
        double price = getGrundpreis() * (1 - rabbatProzent);
        double minPrice = getGrundpreis() * 0.75;
        if (price < minPrice)
            return minPrice;
        else
            return price;
    }

    @Override
    public String toString() {
        return "Pkw{" +
                "id=" + getId() +
                ", marke='" + getMarke() + '\'' +
                ", modell='" + getModell() + '\'' +
                ", baujahr=" + getBaujahr() +
                ", grundpreis=" + df.format(getGrundpreis()) +
                ", servicejahr=" + getServicejahr() +
                ", price=" + getPreis() +
                '}';
    }
}
