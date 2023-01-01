package org.example;

import org.json.JSONArray;


public class SearchInFile {
    public JSONArray searchByCity(String cityName, JSONArray array) {
        JSONArray arr = new JSONArray();
        for (int i = 0; i < array.length(); i++) {
            if (array.getJSONObject(i).get("City").equals(cityName)) {
                arr.put(array.getJSONObject(i));
            }
        }
        return arr;
    }

    public JSONArray searchByYear(String foundationYear, JSONArray array) {
        JSONArray arr = new JSONArray();
        for (int i = 0; i < array.length(); i++) {
            if (array.getJSONObject(i).get("FoundationYear").equals(foundationYear)) {
                arr.put(array.getJSONObject(i));
            }
        }
        return arr;
    }

    public int searchByName(String Name, JSONArray array) {
        JSONArray arr = new JSONArray();
        for (int i = 0; i < array.length(); i++) {
            if (array.getJSONObject(i).get("BlName").equals(Name)) {
                return i;
            }
        }
        return -1;
    }
}
