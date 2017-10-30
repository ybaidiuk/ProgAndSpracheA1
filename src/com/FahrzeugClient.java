package com;

import com.baidiuk.daos.FahrzeugDAO;
import com.baidiuk.daos.SerializedFahrzeugDAO;
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
    // todo wenn nicht genug parameters"Error: Parameter ungueltig."
    public static void main(String[] args) throws Exception {
        FahrzeugManagement fm = new FahrzeugManagement(args[0]);


        switch (args[1]) {
            case "show":
                if (args.length == 2) {
                    fm.printAll();
                } else if (args.length == 3)
                    fm.print(Integer.parseInt(args[2]));
                else if (args.length > 3) throw new IllegalArgumentException("Arguments ist Falsh!");
                break;

            case "add":
                if (args[2] == "pkw"){
                    Pkw pkw = new Pkw(Integer.parseInt(args[3]),args[4],args[5],Integer.parseInt(args[6]),Double.parseDouble(args[7]),Integer.parseInt(args[8]));
                    fm.add(pkw);
                }else if(args[2] == "lkw"){
                    Lkw lkw = new Lkw(Integer.parseInt(args[3]),args[4],args[5],Integer.parseInt(args[6]),Double.parseDouble(args[7]));
                    fm.add(lkw);
                }
            case "del":
                if (args.length != 3) throw new IllegalArgumentException("Arguments ist Falsh!");
                fm.delete(Integer.parseInt(args[2]));
                break;
            case "count":
                if (args[2] == "pkw")fm.sizeOfPkw();
                else if(args[2] == "lkw") fm.sizeOfLkw();
        }
    }

}