package com;

import com.baidiuk.entitys.Fahrzeug;
import com.baidiuk.entitys.Lkw;
import com.baidiuk.entitys.Pkw;
import com.baidiuk.managers.FahrzeugManagement;

/**
 * @author Baidiuk Yevhen
 * Matrikelnummer: 1368277
 * find ./src/com -name "*.java" > sources.txt
 * javac -d myOut/ @sources.txt
 * java -classpath myOut com.FahrzeugClient
 */

public class FahrzeugClient {
  public static void main(String[] args) throws Exception {
    try {
      FahrzeugManagement fm = new FahrzeugManagement(args[0]);
      Fahrzeug f;
      switch (args[1]) {

//----------------------------------------------------------------------
        case "show":
          fm.show();
          break;


//----------------------------------------------------------------------
        case "add":

          switch (args[2]) {
            case "pkw":
              f = new Pkw(args[3], args[4], args[5], args[6], args[7], args[8]);
              fm.add(f);
              break;
            case "lkw":
              f = new Lkw(args[3], args[4], args[5], args[6], args[7]);
              fm.add(f);
              break;
            default:
              System.err.println("Argument is missing or wrong");
          }
          break;

//----------------------------------------------------------------------
        case "del":
          fm.delete(Integer.parseInt(args[2]));
          break;

//----------------------------------------------------------------------
        case "count":
          if (args.length == 2) {
            System.out.println(fm.count());
            break;
          }
          switch (args[2]) {
            case "pkw":
              System.out.println(fm.countPkw());
              break;
            case "lkw":
              System.out.println(fm.countLkw());
              break;
          }
          break;


//----------------------------------------------------------------------
        case "meanprice":
          System.out.println(fm.meanprice());
          break;


//----------------------------------------------------------------------
        case "oldest":
          for (int i : fm.oldest())
            System.out.println("Id: " + i);
          break;
        default:
          throw new Exception();

      }
    } catch (Exception e) {
      System.err.println("Error: Parameter ungueltig.");
      e.printStackTrace();
    }

  }
}