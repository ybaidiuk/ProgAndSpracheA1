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
  public static void main(String[] args) {

    try {
      FahrzeugManagement fm = new FahrzeugManagement(args[0]);
      Fahrzeug f;
      switch (args[1]) {
//----------------------------------------------------------------------
        case "show":
          if (args.length == 3) {
            fm.print(Integer.parseInt(args[2]));
            break;
          }
          fm.show();
          break;


//----------------------------------------------------------------------
        case "add":
          switch (args[2]) { // add x 7 VW Golf 2005 10000 2015
            case "pkw":
              if (args.length < 9) throw new Exception("Error: Parameter ungueltig.");
              f = new Pkw(Integer.parseInt(args[3]), args[4], args[5], Integer.parseInt(args[6]), Double.parseDouble(args[7]), Integer.parseInt(args[8]));
              fm.add(f);
              break;
            case "lkw":
              if (args.length < 8) throw new Exception("Error: Parameter ungueltig.");
              f = new Lkw(Integer.parseInt(args[3]), args[4], args[5], Integer.parseInt(args[6]), Double.parseDouble(args[7]));
              fm.add(f);
              break;
            default:
              throw new Exception("Error: Parameter ungueltig.");
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
      System.out.println(e.getMessage());
    }
  }
}