package com;

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
    FahrzeugManagement fm = new FahrzeugManagement(args[0]);

    try {
      switch (args[1]) {
        case "show":
          if (args.length > 3) throw new IllegalArgumentException("Arguments ist Falsh!");
          else if (args.length == 2) {
            fm.show();
          } else if (args.length == 3)
            fm.print(Integer.parseInt(args[2]));
          break;

        case "add":
          if (args.length != 9 && args[2].equals("pkw")) {
            throw new IllegalArgumentException("Error: Parameter ungueltig.");
          }
          if (args.length != 8 && args[2].equals("lkw"))
            throw new IllegalArgumentException("Error: Parameter ungueltig.");

          if (args[2].equals("pkw")) {
            Pkw pkw = new Pkw(Integer.parseInt(args[3]), args[4], args[5], Integer.parseInt(args[6]), Double.parseDouble(args[7]), Integer.parseInt(args[8]));
            fm.add(pkw);
          } else if (args[2].equals("lkw")) {
            Lkw lkw = new Lkw(Integer.parseInt(args[3]), args[4], args[5], Integer.parseInt(args[6]), Double.parseDouble(args[7]));
            fm.add(lkw);
          } else {
            throw new IllegalArgumentException("Error: Parameter ungueltig.");
          }
          break;
        case "del":
          if (args.length != 3) throw new IllegalArgumentException("Arguments ist Falsh!");
          fm.delete(Integer.parseInt(args[2]));
          break;
        case "count":
          if (args.length == 2) System.out.println(fm.count());
          else if (args[2].equals("pkw")) System.out.println(fm.countPkw());
          else if (args[2].equals("lkw")) System.out.println(fm.countLkw());
          break;
        case "meanprice":
          if (args.length != 2)
            throw new IllegalArgumentException("Arguments ist Falsh!");
          System.out.println(fm.meanprice());
          break;
        case "oldest":
          if (args.length != 2)
            throw new IllegalArgumentException("Arguments ist Falsh!");
          for (int i : fm.oldest())
            System.out.println("Id: " + i);
          break;
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
//
//public class FahrzeugClient {
//  public static void main(String[] args) throws Exception {
//    try {
//      FahrzeugManagement fm = new FahrzeugManagement(args[0]);
//      Fahrzeug f;
//      switch (args[1]) {
//
////----------------------------------------------------------------------
//        case "show":
//          fm.show();
//          break;
//
//
////----------------------------------------------------------------------
//        case "add":
//
//          switch (args[2]) {
//            case "pkw":
//              f = new Pkw(Integer.parseInt(args[3]), args[4], args[5], Integer.parseInt(args[6]), Double.parseDouble(args[7]), Integer.parseInt(args[8]));
//              fm.add(f);
//              break;
//            case "lkw":
//              f = new Lkw(Integer.parseInt(args[3]), args[4], args[5], Integer.parseInt(args[6]), Double.parseDouble(args[7]));
//              fm.add(f);
//              break;
//            default:
//              System.err.println("Argument is missing or wrong");
//          }
//          break;
//
////----------------------------------------------------------------------
//        case "del":
//          fm.delete(Integer.parseInt(args[2]));
//          break;
//
////----------------------------------------------------------------------
//        case "count":
//          if (args.length == 2) {
//            System.out.println(fm.count());
//            break;
//          }
//          switch (args[2]) {
//            case "pkw":
//              System.out.println(fm.countPkw());
//              break;
//            case "lkw":
//              System.out.println(fm.countLkw());
//              break;
//          }
//          break;
//
//
////----------------------------------------------------------------------
//        case "meanprice":
//          System.out.println(fm.meanprice());
//          break;
//
//
////----------------------------------------------------------------------
//        case "oldest":
//          for (int i : fm.oldest())
//            System.out.println("Id: " + i);
//          break;
//        default:
//          throw new Exception();
//
//      }
//    } catch (Exception e) {
//      System.err.println("Error: Parameter ungueltig.");
//      e.printStackTrace();
//    }
//
//  }
//}