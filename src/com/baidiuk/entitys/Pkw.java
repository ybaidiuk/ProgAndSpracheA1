package com.baidiuk.entitys;

/**
 * @author Baidiuk Yevhen
 * Matrikelnummer: 1368277
 */

public class Pkw extends Fahrzeug {

  private static final long serialVersionUID = 1L;
  private int serviceYear;

  public Pkw(int id, String marke, String modell, int baujahr, double grundpreis, int serviceYear) throws Exception {
    super(id, marke, modell, baujahr, grundpreis);
    setServiceYear(serviceYear);
  }

  public int getServiceYear() {
    return serviceYear;
  }

  public void setServiceYear(int serviceYear) throws Exception {
    if (serviceYear < getBaujahr() || serviceYear > currentYear)
      throw new Exception("Error: ServiceJahr ungueltig.");
    this.serviceYear = serviceYear;
  }

  @Override
  public double getRabatt() {
    double rabbatProzent = getAlter() * 0.05 + (currentYear - serviceYear) * 0.02;
    double rabatt = getGrundpreis() * rabbatProzent;
    double maxRabatt = getGrundpreis() * 0.15;
    return rabatt > maxRabatt ? maxRabatt : rabatt;
  }

  @Override
  public String toString() {
    return "Typ:         PKW\n" +
        "Id:          " + getId() + "\n" +
        "Marke:       " + getMarke() + '\n' +
        "Modell:      " + getModell() + '\n' +
        "Baujahr:     " + getBaujahr() + "\n" +
        "Grundpreis:  " + df.format(getGrundpreis()) + "\n" +
        "Servicejahr: " + getServiceYear() + "\n" +
        "Preis:       " + df.format(getPreis()) + "\n";
  }
}
