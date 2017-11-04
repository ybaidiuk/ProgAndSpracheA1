package com.baidiuk.daos;

import com.baidiuk.entitys.Fahrzeug;

import java.util.List;

/**
 * @author Baidiuk Yevhen
 * Matrikelnummer: 1368277
 */

public interface FahrzeugDAO {

  List<Fahrzeug> getList();

  Fahrzeug get(int id);

  void save(Fahrzeug fahrzeug) throws Exception;

  void remove(int id) throws Exception;

  @Deprecated
  void clear();
}
