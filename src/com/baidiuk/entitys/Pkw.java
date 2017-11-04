package com.baidiuk.entitys;

/**
 * @author Baidiuk Yevhen
 * Matrikelnummer: 1368277
 */

public class Pkw extends Fahrzeug {

  private static final long serialVersionUID = 1L;
  private int servicejahr;

  public Pkw(String id, String marke, String modell, String baujahr, String grundpreis, String servicejahr) throws Exception {
    super(id, marke, modell, baujahr, grundpreis);
    setServicejahr(Integer.parseInt(servicejahr));
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
    return "Typ:           PKW \n" +
        "Id:            " + getId() + "\n" +
        "Marke:         " + getMarke() + '\n' +
        "Modell:        " + getModell() + '\n' +
        "Baujahr:       " + getBaujahr() + "\n" +
        "Grundpreis:    " + df.format(getGrundpreis()) + "\n" +
        "Servicejahr:   " + getServicejahr() + "\n" +
        "Price:         " + getPreis() + "\n";
  }
}
