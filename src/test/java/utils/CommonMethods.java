package utils;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class CommonMethods {
    private static final DecimalFormat df = new DecimalFormat("#.##");
    public static double area = 0;

    public static Map<String, List<Double>> putIntoAMap(List<String> list) {
        Map<String, List<Double>> mapOFList = new HashMap<>();

        for (String eachShape : list) {
            String[] eachLine = eachShape.split(" ");
            List<Double> aList;

            if (eachLine[0].equalsIgnoreCase("circle") && !(Double.parseDouble(eachLine[1]) <= 0)) {
                aList = mapOFList.get("circle");
                area = Math.PI * (Math.pow((Double.parseDouble(eachLine[1]) / 2), 2));
                if (aList != null) {
                    aList.add(area);
                    mapOFList.put(eachLine[0], aList);
                } else {
                    List<Double> bList = new ArrayList<>();
                    bList.add(area);
                    mapOFList.put(eachLine[0], bList);
                }
            } else if (eachLine[0].equalsIgnoreCase("square") && !(Double.parseDouble(eachLine[1]) <= 0)) {
                aList = mapOFList.get("square");
                area = Math.pow((Double.parseDouble(eachLine[1])), 2);
                if (aList != null) {
                    aList.add(area);
                    mapOFList.put(eachLine[0], aList);
                } else {
                    List<Double> bList = new ArrayList<>();
                    bList.add(area);
                    mapOFList.put(eachLine[0], bList);
                }
            } else if (eachLine[0].equalsIgnoreCase("rectangle") && !(Double.parseDouble(eachLine[1]) <= 0 || Double.parseDouble(eachLine[2]) <= 0)) {
                aList = mapOFList.get("rectangle");
                area = (Double.parseDouble(eachLine[1])) * (Double.parseDouble(eachLine[2]));
                if (aList != null) {
                    aList.add(area);
                    mapOFList.put(eachLine[0], aList);
                } else {
                    List<Double> bList = new ArrayList<>();
                    bList.add(area);
                    mapOFList.put(eachLine[0], bList);
                }
            } else if (eachLine[0].equalsIgnoreCase("triangle") && !(Double.parseDouble(eachLine[1]) <= 0 || Double.parseDouble(eachLine[2]) <= 0)) {
                aList = mapOFList.get("triangle");
                area = ((Double.parseDouble(eachLine[1])) * (Double.parseDouble(eachLine[2]))) / 2;
                if (aList != null) {
                    aList.add(area);
                    mapOFList.put(eachLine[0], aList);
                } else {
                    List<Double> bList = new ArrayList<>();
                    bList.add(area);
                    mapOFList.put(eachLine[0], bList);
                }
            }
        }
        return mapOFList;

    }

    public static Map<String, List<Double>> sortMap(Map<String, List<Double>> mapOFList) {
        for (List<Double> e : mapOFList.values()) {
            Collections.sort(e, Collections.reverseOrder());
        }

        Map<String, List<Double>> output = mapOFList.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(o -> o.getValue().get(0))))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
        return output;
    }

    public static void printMap(Map<String, List<Double>> output) {
        for (Map.Entry<String, List<Double>> entry : output.entrySet()) {
            for (Double dbl : entry.getValue()
            ) {
                System.out.println(entry.getKey() + " " + df.format(dbl));
            }
        }
    }
}

