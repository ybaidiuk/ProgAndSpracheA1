package com.managers;

import com.daos.FahrzeugDAO;
import com.daos.SerializedFahrzeugDAO;
import com.entitys.Fahrzeug;
import com.entitys.Lkw;
import com.entitys.Pkw;

import java.util.Collections;
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
     * Alle Daten eines Fahrzeugs bereitstellen
     */
    public void print(Fahrzeug f) {
        System.out.println(f);
    }

    /**
     * Neues Fahrzeug hinzufügen
     */
    public void add(Fahrzeug f) {
        dao.saveFahzeug(f);
    }

    /**
     * Bestehendes Fahrzeug löschen
     */
    public void delete(Fahrzeug f) {
        dao.deleteFahrzeug(f.getId());
    }
    public void delete(int id) {
        dao.deleteFahrzeug(id);
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
     * Gesamtzahl aller LKWs ermitteln
     */
    public int priceAvg() {
        int counter = 0;
        for (Fahrzeug f : dao.getFahrzeugList())
            counter += f.getGrundpreis();
        return counter / dao.getFahrzeugList().size();
    }

    /**
     * Id(s) des(r) ältesten Fahrzeugs(e) ermitteln
     */
    public int getOldestFahrzeugId() {
        if (dao.getFahrzeugList().isEmpty()) {
            System.err.println("You have no Fahrzeug!");
            System.exit(1);
        }
        Fahrzeug smalerste = dao.getFahrzeugList().stream().sorted(Comparator.comparingInt(Fahrzeug::getAlter)).findFirst().get();
        return smalerste.getId();
    }

    @Deprecated
    public void clear(){// only for JunitTest
        dao.getFahrzeugList().clear();
    }
    @Deprecated
    public Set<Fahrzeug> getAll(){// only for JunitTest
        return dao.getFahrzeugList();
    }
}
