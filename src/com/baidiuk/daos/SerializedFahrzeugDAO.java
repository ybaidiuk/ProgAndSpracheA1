package com.baidiuk.daos;

import com.baidiuk.entitys.Fahrzeug;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Baidiuk Yevhen
 * Matrikelnummer: 1368277
 */

public class SerializedFahrzeugDAO implements FahrzeugDAO {
  private String filePath;
  private List<Fahrzeug> fahrzeugSet;

  public SerializedFahrzeugDAO(String filePath) {
    this.filePath = filePath;
    restoreData();
  }

  private void restoreData() {
    File file = new File(filePath);
    if (file.exists())
      try (FileInputStream fileInputStream = new FileInputStream(filePath);
           ObjectInputStream os = new ObjectInputStream(fileInputStream)) {

        fahrzeugSet = (ArrayList<Fahrzeug>) os.readObject();
      } catch (Exception e) {
        System.err.println("Fehler bei Deserialisierung:");
        e.printStackTrace();
        System.exit(1);
      }
    else {
      fahrzeugSet = new ArrayList<>();
    }
  }

  private void saveData() {
    try (FileOutputStream fileOutputStream = new FileOutputStream(filePath);
         ObjectOutputStream os = new ObjectOutputStream(fileOutputStream)) {

      File outFile = new File(filePath);
      if (outFile.getParentFile() != null)
        outFile.getParentFile().mkdirs();
      os.writeObject(fahrzeugSet);
    } catch (Exception e) {
      System.err.println("Fehler bei Serialisierung:");
      e.printStackTrace();
      System.exit(1);
    }
  }

  @Override
  public List<Fahrzeug> getFahrzeugList() {
    return fahrzeugSet;
  }

  @Override
  public Fahrzeug getFahrzeugbyId(int id) {
    for (Fahrzeug fahrzeug : fahrzeugSet)
      if (fahrzeug.getId() == id)
        return fahrzeug;
    return null;
  }

  @Override
  public void speichereFahrzeug(Fahrzeug fahrzeug) throws Exception {
    if (fahrzeugSet.contains(fahrzeug))
      throw new Exception("Error: Fahrzeug bereits vorhanden. (id=<" + fahrzeug.getId() + ">)");
    fahrzeugSet.add(fahrzeug);
    saveData();
  }

  @Override
  public void loescheFahrzeug(int id) throws Exception {
    Fahrzeug fahrzeug = null;
    for (Fahrzeug f : fahrzeugSet)
      if (f.getId() == id)
        fahrzeug = f;
    if (fahrzeug == null) {
      throw new Exception("Error: Fahrzeug nicht vorhanden. (id=" + id + ")");
    }
    fahrzeugSet.remove(fahrzeug);
    saveData();
  }

  @Override
  public void clear() {
    fahrzeugSet.clear();
    saveData();
  }
}
