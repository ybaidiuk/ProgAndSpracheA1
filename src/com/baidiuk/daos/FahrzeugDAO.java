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

    void saveFahzeug(Fahrzeug fahrzeug) throws Exception;

    void deleteFahrzeug(int id) throws Exception;

    @Deprecated
    void clear();
}
