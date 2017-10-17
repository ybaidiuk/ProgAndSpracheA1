package com.entitys;

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
        return "Pkw{" +
                "id=" + getId() +
                ", marke='" + getMarke() + '\'' +
                ", modell='" + getModell() + '\'' +
                ", baujahr=" + getBaujahr() +
                ", grundpreis=" + getGrundpreis() +
                ", servicejahr=" + getServicejahr() +
                ", price=" + getPreis() +
                '}';
    }
}
