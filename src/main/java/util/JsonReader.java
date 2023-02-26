package util;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader {

    public static Object[][] getJsonData(String jsonPath, String jsonData, int jsonAttrs)
            throws IOException, ParseException {
        var object = new JSONParser().parse(new FileReader((jsonPath)));
        var jsonObject = (JSONObject) object;
        var jsonArray = (JSONArray) jsonObject.get(jsonData);
        Object[][] arr = new String[jsonArray.size()][jsonAttrs];
        for (int i = 0; i < jsonArray.size(); i++) {
            var obj = (JSONObject) jsonArray.get(i);
            arr[i][0] = String.valueOf(obj.get("TaskTitle"));
            arr[i][1] = String.valueOf(obj.get("TaskText"));
        }
        return arr;
    }
}