package org.zouzias.xmltojson;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.apache.commons.io.FileUtils;

public class Main {

    public static int PRETTY_PRINT_INDENT_FACTOR = 4;

    public static void main(String[] args) {
        try {

            File file = new File("arxivMetadata.xml");

            // Convert file contents to string
            String contents = FileUtils.readFileToString(file);

            // Convert XML to JSON
            JSONObject xmlJSONObj = XML.toJSONObject(contents);

            // Print XML to papers.json
            String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
            PrintWriter writer = new PrintWriter("papers.json");
            writer.write(jsonPrettyPrintString);

            writer.close();

        } catch (JSONException | IOException je) {
            System.out.println(je.toString());
        }
    }
}
