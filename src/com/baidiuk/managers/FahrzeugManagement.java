package com.baidiuk.managers;

import com.baidiuk.daos.FahrzeugDAO;
import com.baidiuk.daos.SerializedFahrzeugDAO;
import com.baidiuk.entitys.Fahrzeug;
import com.baidiuk.entitys.Lkw;
import com.baidiuk.entitys.Pkw;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 * @author Baidiuk Yevhen
 * Matrikelnummer: 1368277
 */


public class FahrzeugManagement {
  private FahrzeugDAO dao;

  public FahrzeugManagement(String filePath) {
    dao = new SerializedFahrzeugDAO(filePath);
  }


  /**
   * Alle Daten aller Fahrzeuge bereitstellen
   */
  public void show() {
    Set<Fahrzeug> fahrzeugSet = dao.getFahrzeugList();
    for (Fahrzeug f : fahrzeugSet) System.out.println(f);

  }

  /**
   * Alle Daten eines Fahrzeugs bereitstellen
   */
  public void print(int i) throws Exception {
    System.out.println(dao.getFahrzeugbyId(i));
  }

  /**
   * Neues Fahrzeug hinzufügen
   */
  public void add(Fahrzeug f) {
    try {
      dao.speichereFahrzeug(f);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Bestehendes Fahrzeug löschen
   */
  public void delete(int i) {
    try {
      dao.loescheFahrzeug(i);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Gesamtzahl aller Fahrzeuge ermitteln
   */
  public int count() {
    return dao.getFahrzeugList().size();
  }

  /**
   * Gesamtzahl aller PKWs ermitteln
   */
  public int countPkw() {
    int counter = 0;
    for (Fahrzeug f : dao.getFahrzeugList())
      if (f instanceof Pkw) counter++;
    return counter;
  }

  /**
   * Gesamtzahl aller LKWs ermitteln
   */
  public int countLkw() {
    int counter = 0;
    for (Fahrzeug f : dao.getFahrzeugList())
      if (f instanceof Lkw) counter++;
    return counter;
  }

  /**
   * Durchschnittspreis aller Fahrzeuge ermitteln
   */
  public String meanprice() {
    double meanprice;
    double counter = 0;
    for (Fahrzeug f : dao.getFahrzeugList())
      counter += f.getGrundpreis();
    meanprice = counter / dao.getFahrzeugList().size();
    return Fahrzeug.df.format(meanprice);
  }

  /**
   * Id(s) des(r) ältesten Fahrzeugs(e) ermitteln
   */
  public List<Integer> oldest() {
    if (dao.getFahrzeugList().isEmpty()) {
      System.err.println("You have no Fahrzeug!");
      System.exit(1);
    }
    List<Integer> retList = new ArrayList<>();
    int ageOfOldest = dao.getFahrzeugList().stream().sorted(Comparator.comparingInt(Fahrzeug::getAlter).reversed()).findFirst().get().getAlter();

    for (Fahrzeug f : dao.getFahrzeugList()) {
      if (f.getAlter() == ageOfOldest)
        retList.add(f.getId());
    }
    return retList;
  }

  @Deprecated
  public void clear() {// only for JunitTest
    dao.clear();
  }

  @Deprecated
  public Set<Fahrzeug> getAll() {// only for JunitTest
    return dao.getFahrzeugList();
  }

}
