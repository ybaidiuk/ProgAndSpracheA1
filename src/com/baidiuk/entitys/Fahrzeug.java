package com.baidiuk.entitys;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Calendar;

/**
 * @author Baidiuk Yevhen
 * Matrikelnummer: 1368277
 */

public abstract class Fahrzeug implements Serializable {

  private static final long serialVersionUID = 1L;
  public static DecimalFormat df = getDecimalFormat();
  static int currentYear = Calendar.getInstance().get(Calendar.YEAR);
  private int id;
  private String marke;
  private String modell;
  private int baujahr;
  private double grundpreis;

  public Fahrzeug(int id, String marke, String modell, int baujahr, double grundpreis) throws Exception {
    setId(id);
    setMarke(marke);
    setModell(modell);
    setBaujahr(baujahr);
    setGrundpreis(grundpreis);
  }

  abstract double getRabatt();

  abstract public String toString();

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getMarke() {
    return marke;
  }

  public void setMarke(String marke) {
    this.marke = marke;
  }

  public String getModell() {
    return modell;
  }

  public void setModell(String modell) {
    this.modell = modell;
  }

  public int getBaujahr() {
    return baujahr;
  }

  public void setBaujahr(int baujahr) throws Exception {
    if (baujahr > currentYear) throw new Exception("Error: Baujahr ungueltig.");
    this.baujahr = baujahr;
  }

  public double getGrundpreis() {
    return grundpreis;
  }

  public void setGrundpreis(double grundpreis) throws Exception {
    if (grundpreis <= 0) throw new Exception("Error: Grundpreis ungueltig.");
    this.grundpreis = grundpreis;
  }

  public int getAlter() {
    return currentYear - baujahr;
  }

  public double getPreis() {
    return getGrundpreis() - getRabatt();
  }


  public static DecimalFormat getDecimalFormat() {
    DecimalFormatSymbols dfs = DecimalFormatSymbols.getInstance();
    dfs.setDecimalSeparator('.');
    return new DecimalFormat("0.00", dfs);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Fahrzeug)) return false;

    Fahrzeug fahrzeug = (Fahrzeug) o;

    return id == fahrzeug.id;
  }

  @Override
  public int hashCode() {
    return id;
  }

}
