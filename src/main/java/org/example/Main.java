package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class Main {
    static void menu() {
        System.out.println("Choose which option do you want \n 1- Add building \n 2- Search by sepcific city \n 3- Search by sepcific year \n 4- Delete Building by blname");
    }
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in).useDelimiter("\n");
        while (true) {
            menu();
            int Uinput = s.nextInt();
            if (Uinput == 1) {
                System.out.println("How many buildings do you want to add");
                int n = s.nextInt();
                JSONArray arr3 = null;
                File f = new File("Ass3.json");
                if (f.exists()) {
                    ReadFromJsonFile read = new ReadFromJsonFile();
                    arr3 = new JSONArray(read.Read());
                } else {
                    arr3 = new JSONArray();
                }

                WriteToJsonFile w1 = new WriteToJsonFile();
                for (int i = 0; i < n; i++) {
                    String blName, city, foundationYear;
                    System.out.println("insert building name");
                    blName = s.next();
                    System.out.println("insert city name");
                    city = s.next();
                    System.out.println("insert foundation year");
                    foundationYear = s.next();
                    Building b1 = new Building(blName, city, foundationYear);
                    w1.insertToJsonFile(b1, arr3);
                }
                w1.createJSONFile("Ass3.json", arr3);

            } else if (Uinput == 2) {
                System.out.println("What is name of the City");
                String city = s.next();
                JSONArray arr2 = new JSONArray();
                ReadFromJsonFile r1 = new ReadFromJsonFile();
                r1.Read();
                SearchInFile ss = new SearchInFile();
                arr2 = ss.searchByCity(city, r1.Read());
                if (arr2.length() == 0) {
                    System.out.println("There's no cite's that matching with this name");
                } else {
                    System.out.println(arr2);
                }

            } else if (Uinput == 3) {
                System.out.println("What is Foundation Year of the Building");
                String year = s.next();
                JSONArray arr2 = new JSONArray();
                ReadFromJsonFile r1 = new ReadFromJsonFile();
                r1.Read();
                SearchInFile ss = new SearchInFile();
                arr2 = ss.searchByYear(year, r1.Read());
                if (arr2.length() == 0) {
                    System.out.println("There's no years that matching with this year");
                } else {
                    System.out.println(arr2);
                }
            } else if (Uinput == 4) {
                System.out.println("Which Item do you want do delete?");
                String blNameDel = s.next();
                ReadFromJsonFile r1 = new ReadFromJsonFile();
                JSONArray arr2 = r1.Read();
                SearchInFile ss = new SearchInFile();
                int i = ss.searchByName(blNameDel, arr2);
                if (i != -1) {
                    DeleteFromJsonFile dell = new DeleteFromJsonFile();
                    dell.removeFromJsonFile(i, arr2);
                    WriteToJsonFile w2 = new WriteToJsonFile();
                    w2.createJSONFile("Ass3.json", arr2);
                    System.out.println("Deleted successfully");
                } else System.out.println("There's no buildings matching with this name");
            } else {
                System.out.println("This Option is not available");
            }
        }
    }
}




