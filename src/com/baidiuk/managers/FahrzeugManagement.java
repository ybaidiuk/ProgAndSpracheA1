package com.baidiuk.managers;

import com.baidiuk.daos.FahrzeugDAO;
import com.baidiuk.daos.SerializedFahrzeugDAO;
import com.baidiuk.entitys.Fahrzeug;
import com.baidiuk.entitys.Lkw;
import com.baidiuk.entitys.Pkw;

import java.util.Comparator;
import java.util.Set;

/**
 * @author <your-name-here>
 * Matrikelnummer:
 */


public class FahrzeugManagement {
    private FahrzeugDAO dao;

    public FahrzeugManagement(String filePath) {
        dao = new SerializedFahrzeugDAO(filePath);
    }


    /**
     * Alle Daten aller Fahrzeuge bereitstellen
     */
    public void printAll() {
        Set<Fahrzeug> fahrzeugSet = dao.getFahrzeugList();
        for (Fahrzeug f : fahrzeugSet) System.out.println(f);

    }

    /**
     * Alle Daten eines Fahrzeugs bereitstellen
     */
    public void print(Fahrzeug f) {
        System.out.println(f);
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
    public void delete(Fahrzeug f) {
        try {
            dao.loescheFahrzeug(f.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Gesamtzahl aller Fahrzeuge ermitteln
     */
    public int size() {
        return dao.getFahrzeugList().size();
    }

    /**
     * Gesamtzahl aller PKWs ermitteln
     */
    public int sizeOfPkw() {
        int counter = 0;
        for (Fahrzeug f : dao.getFahrzeugList())
            if (f instanceof Pkw) counter++;
        return counter;
    }

    /**
     * Gesamtzahl aller LKWs ermitteln
     */
    public int sizeOfLkw() {
        int counter = 0;
        for (Fahrzeug f : dao.getFahrzeugList())
            if (f instanceof Lkw) counter++;
        return counter;
    }

    /**
     * Durchschnittspreis aller Fahrzeuge ermitteln
     */
    public String priceAvg() {
        double counter = 0;
        for (Fahrzeug f : dao.getFahrzeugList())
            counter += f.getGrundpreis();
        return Fahrzeug.df.format(counter / dao.getFahrzeugList().size());
    }

    /**
     * Id(s) des(r) ältesten Fahrzeugs(e) ermitteln
     */
    public int getOldestFahrzeugId() {
        if (dao.getFahrzeugList().isEmpty()) {
            System.err.println("You have no Fahrzeug!");
            System.exit(1);
        }
        Fahrzeug smalerste = dao.getFahrzeugList().stream().sorted(Comparator.comparingInt(Fahrzeug::getAlter).reversed()).findFirst().get();
        return smalerste.getId();
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
