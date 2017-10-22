package com.baidiuk.daos;

import com.baidiuk.entitys.Fahrzeug;

import java.util.Set;

/**
 * @author Baidiuk Yevhen
 * Matrikelnummer: 1368277
 */

public interface FahrzeugDAO {

    Set<Fahrzeug> getFahrzeugList();

    Fahrzeug getFahrzeugbyId(int id);

    void speichereFahrzeug(Fahrzeug fahrzeug) throws Exception;

    void loescheFahrzeug(int id) throws Exception;

    @Deprecated
    void clear();
}
