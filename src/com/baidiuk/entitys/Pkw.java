package com.baidiuk.entitys;

/**
 * @author Baidiuk Yevhen
 * Matrikelnummer: 1368277
 */

public class Pkw extends Fahrzeug {

    private static final long serialVersionUID = 1L;
    private int servicejahr;
//<Datei> add pkw   5         Tesla      "Model S"         2016              65000             2016
    public Pkw(int id, String marke, String modell, int baujahr, double grundpreis, int servicejahr) throws Exception {
        super(id, marke, modell, baujahr, grundpreis);
        setServicejahr(servicejahr);
    }

    public int getServicejahr() {
        return servicejahr;
    }

    public void setServicejahr(int servicejahr) throws Exception {
        if (servicejahr < getBaujahr() || servicejahr > currentYear)
            throw new Exception("Error: ServiceJahr ungueltig.");
        this.servicejahr = servicejahr;
    }

    @Override
    public double getRabatt() {
        double rabbatProzent = getAlter() * 0.05 + (currentYear - servicejahr) * 0.02;
        double rabatt = getGrundpreis() * rabbatProzent;
        double maxRabatt = getGrundpreis() * 0.15;
        return rabatt > maxRabatt ? maxRabatt : rabatt;
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
