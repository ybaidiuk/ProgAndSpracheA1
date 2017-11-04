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
  private List<Fahrzeug> fList;

  public SerializedFahrzeugDAO(String filePath) {
    this.filePath = filePath;
    restore();
  }

  private void restore() {
    File file = new File(filePath);
    if (file.exists())
      try (FileInputStream fileInputStream = new FileInputStream(filePath);
           ObjectInputStream os = new ObjectInputStream(fileInputStream)) {

        fList = (ArrayList<Fahrzeug>) os.readObject();
      } catch (Exception e) {
        System.err.println("Fehler bei Deserialisierung");
        e.printStackTrace();
        System.exit(1);
      }
    else {
      fList = new ArrayList<>();
    }
  }

  private void save() {
    try (FileOutputStream fileOutputStream = new FileOutputStream(filePath);
         ObjectOutputStream os = new ObjectOutputStream(fileOutputStream)) {

      os.writeObject(fList);
    } catch (Exception e) {
      System.err.println("Fehler bei Serialisierung");
      e.printStackTrace();
      System.exit(1);
    }
  }

  @Override
  public List<Fahrzeug> getList() {
    return fList;
  }

  @Override
  public Fahrzeug get(int id) {
    for (Fahrzeug fahrzeug : fList)
      if (fahrzeug.getId() == id)
        return fahrzeug;
    return null;
  }

  @Override
  public void save(Fahrzeug fahrzeug) throws Exception {
    if (fList.contains(fahrzeug))
      throw new Exception("Error: Fahrzeug bereits vorhanden. (id=<" + fahrzeug.getId() + ">)");
    fList.add(fahrzeug);
    save();
  }

  @Override
  public void remove(int id) throws Exception {
    Fahrzeug fahrzeug = null;
    for (Fahrzeug f : fList)
      if (f.getId() == id)
        fahrzeug = f;
    if (fahrzeug == null) {
      throw new Exception("Error: Fahrzeug nicht vorhanden. (id=" + id + ")");
    }
    fList.remove(fahrzeug);
    save();
  }

  @Override
  public void clear() {
    fList.clear();
    save();
  }
}
