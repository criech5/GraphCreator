package GraphCreator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GraphMaps {

    public static Map<String, Double> makeMap(String[][][] store) {
        Map<String, Double> data = new HashMap<>();
        for(String[][] item : store) {
            for(String[] pair : item) {
                if(!(pair[1] == null) && pair[1].length() > 0) {
                    data.put(pair[0], Double.parseDouble(pair[1]));
                }
            }
        }
        //for debugging
        for(Map.Entry<String, Double> entry : data.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
        return data;
    }

    public static Map<String, Double> pieBarData(File inFile) {
        //Pass in filename and return map of skill-to-%
        Map<String, Double> data = new HashMap<>();
        try {
            FileReader fr = new FileReader(inFile);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                if(arr[1].matches("-?\\d+(\\.\\d+)?")) {
                    data.put(arr[0], Double.parseDouble(arr[1]));
                }
                else {
                    System.out.println("Invalid CSV format for pie/bar graph!");
                    System.exit(-1);
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("IO Exception!");
        }
        return data;
    }

    //Functionality for line graphs is still a work in progress
//    public static Map<Double, Double> lineData(File inFile) {
//        //Pass in filename and return map of skill-to-%
//        Map<Double, Double> data = new HashMap<>();
//        try {
//            FileReader fr = new FileReader(inFile);
//            BufferedReader br = new BufferedReader(fr);
//            String line = "";
//            while ((line = br.readLine()) != null) {
//                String[] arr = line.split(",");
//                if(arr[0].matches("-?\\d+(\\.\\d+)?") && arr[1].matches("-?\\d+(\\.\\d+)?")) {
//                    data.put(Double.parseDouble(arr[0]), Double.parseDouble(arr[1]));
//                }
//                else {
//                    System.out.println("Invalid CSV format for line graph!");
//                    System.exit(-1);
//                }
//            }
//            br.close();
//        } catch (IOException e) {
//            System.out.println("IO Exception!");
//        }
//
//        return data;
//    }

}
