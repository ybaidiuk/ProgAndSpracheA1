package com.daos;

import com.entitys.Fahrzeug;

import java.util.Set;

/**
 * @author Baidiuk Yevhen
 * Matrikelnummer: 1368277
 */

public interface FahrzeugDAO {

    Set<Fahrzeug> getFahrzeugList();

    Fahrzeug getFahrzeugbyId(int id);

    void saveFahzeug(Fahrzeug fahrzeug);

    void deleteFahrzeug(int id);
}
