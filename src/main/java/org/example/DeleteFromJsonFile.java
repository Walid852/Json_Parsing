package org.example;

import org.json.JSONArray;



public class DeleteFromJsonFile extends JSONArray {

    public JSONArray removeFromJsonFile(int index, JSONArray arrd) {

        JSONArray output = arrd;
        for (int i = 0; i < arrd.length(); i++) {
            if (i == index) {
                output.remove(i);
            }
        }
        return output;

    }
}

