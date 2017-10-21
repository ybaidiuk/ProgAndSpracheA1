package com;

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
        switch (args.length) {
            case 0:
                throw new Exception("Something wrong with Datai");
            case 1:
                FahrzeugManagement fm = new FahrzeugManagement(args[0]);
            case 2:

            case 3:
        }

    }
}