package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

import java.util.HashMap;

public class WriteToJsonFile {
    public void createJSONFile(String fileName, JSONArray arr) {
        try (FileWriter file = new FileWriter(fileName)) {
            file.write(arr.toString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void insertToJsonFile(Building b, JSONArray arr) {
        HashMap<String, String> m1 = new HashMap<>();
        m1.put("BlName", b.getBlName());
        m1.put("City", b.getCity());
        m1.put("FoundationYear", b.getFoundationYear());
        JSONObject op1 = new JSONObject(m1);
        arr.put(op1);
    }
}

