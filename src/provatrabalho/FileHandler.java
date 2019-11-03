/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provatrabalho;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author leonardoamurca
 */
public class FileHandler {

    AllBurns allBurnsSingleton = AllBurns.getInstance();
    final String basePath = System.getProperty("user.dir") + "/src";

    public FileHandler() {
    }

    public void getDataAndSave() throws Exception {
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(basePath + "/provatrabalho/forestfires.csv"));
            String row;

            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                boolean isHeader = data[0].equalsIgnoreCase("x");

                if (isHeader) {
                    allBurnsSingleton.setHeaders(Arrays.asList(data));
                } else {
                    insertBurn(data);
                }

            }

            csvReader.close();

        } catch (IOException e) {
            LogWriter.writeFileTXT(Arrays.toString(e.getStackTrace()));
        }

    }

    public void insertBurn(String[] data) throws Exception {
        Integer x = Integer.parseInt(data[0]);

        if (x >= 1 && x <= 3) {
            allBurnsSingleton.insertMonthlyBurns(new BurnX1to3(Integer.parseInt(data[0]), Integer.parseInt(data[1]), data[2], data[3], Double.parseDouble(data[4]), Double.parseDouble(data[5]), Double.parseDouble(data[6]), Double.parseDouble(data[7]), Double.parseDouble(data[8]), Integer.parseInt(data[9]), Double.parseDouble(data[10]), Double.parseDouble(data[11]), Double.parseDouble(data[11])));
        } else if (x >= 4 && x <= 6) {
            allBurnsSingleton.insertMonthlyBurns(new BurnX4to6(Integer.parseInt(data[0]), Integer.parseInt(data[1]), data[2], data[3], Double.parseDouble(data[4]), Double.parseDouble(data[5]), Double.parseDouble(data[6]), Double.parseDouble(data[7]), Double.parseDouble(data[8]), Integer.parseInt(data[9]), Double.parseDouble(data[10]), Double.parseDouble(data[11]), Double.parseDouble(data[11])));
        } else if (x >= 7 && x <= 9) {
            allBurnsSingleton.insertMonthlyBurns(new BurnX7to9(Integer.parseInt(data[0]), Integer.parseInt(data[1]), data[2], data[3], Double.parseDouble(data[4]), Double.parseDouble(data[5]), Double.parseDouble(data[6]), Double.parseDouble(data[7]), Double.parseDouble(data[8]), Integer.parseInt(data[9]), Double.parseDouble(data[10]), Double.parseDouble(data[11]), Double.parseDouble(data[11])));
        }
    }

    public void generateReport(String type) throws Exception {
        switch (type) {
            case "monthly-burns":
                getMonthlyBurns();
                break;
            case "get-burns-qtd-by-day-of-the-week":
                getBurnsQtdByDayOfTheWeek();
                break;
            default:

        }
    }

    public void getBurnsQtdByDayOfTheWeek() throws Exception {
        getDataAndSave();

        try {
            FileWriter csvWriter = null;

            int i = 0;
            int sun = 0, mon = 0, tue = 0, wed = 0, thu = 0, fri = 0, sat = 0;

            csvWriter = new FileWriter(basePath + "/reports/" + "BurnsQtdByDayOfTheWeek" + ".csv");
            csvWriter.append(String.join(",", "day", "Quantity"));
            csvWriter.append("\n");
            for (Stack<Burn> monthlyBurn : allBurnsSingleton.getMonthlyBurns()) {

                while (!monthlyBurn.isEmpty()) {
                    String day = monthlyBurn.getTop().getDay();
                    if (day.equalsIgnoreCase("sun")) {
                        sun = sun + 1;
                    } else if (day.equalsIgnoreCase("mon")) {
                        mon = mon + 1;
                    } else if (day.equalsIgnoreCase("tue")) {
                        tue = tue + 1;
                    } else if (day.equalsIgnoreCase("wed")) {
                        wed = wed + 1;
                    } else if (day.equalsIgnoreCase("thu")) {
                        thu = thu + 1;
                    } else if (day.equalsIgnoreCase("fri")) {
                        fri = fri + 1;
                    } else if (day.equalsIgnoreCase("sat")) {
                        sat = sat + 1;
                    } else {
                        System.out.println("Erro");
                    }
                    monthlyBurn.pop();
                }
            }

            csvWriter.append(String.join(",", "sun", String.valueOf(sun)));
            csvWriter.append("\n");
            csvWriter.append(String.join(",", "mon", String.valueOf(mon)));
            csvWriter.append("\n");
            csvWriter.append(String.join(",", "tue", String.valueOf(tue)));
            csvWriter.append("\n");
            csvWriter.append(String.join(",", "wed", String.valueOf(wed)));
            csvWriter.append("\n");
            csvWriter.append(String.join(",", "thu", String.valueOf(thu)));
            csvWriter.append("\n");
            csvWriter.append(String.join(",", "fri", String.valueOf(fri)));
            csvWriter.append("\n");
            csvWriter.append(String.join(",", "sat", String.valueOf(sat)));
            csvWriter.append("\n");

            csvWriter.close();
            System.out.println(sun);
        } catch (IOException e) {
            LogWriter.writeFileTXT(Arrays.toString(e.getStackTrace()));
        }

    }

    public void getMonthlyBurns() throws Exception {
        try {
            FileWriter csvWriter = null;
            int i = 0;

            for (Stack<Burn> monthlyBurn : allBurnsSingleton.getMonthlyBurns()) {
                csvWriter = new FileWriter(basePath + "/reports/" + Month.values()[i] + ".csv");

                appendHeader(csvWriter);
                appendData(csvWriter, monthlyBurn);
                csvWriter.flush();

                i++;
            }

            csvWriter.close();

        } catch (IOException e) {
            LogWriter.writeFileTXT(Arrays.toString(e.getStackTrace()));
        }
    }

    public void appendHeader(FileWriter csvWriter) throws Exception {
        try {

            for (String header : allBurnsSingleton.getHeaders()) {
                csvWriter.append(header);
                csvWriter.append(",");
            }

            csvWriter.append("\n");

        } catch (IOException ex) {
            LogWriter.writeFileTXT(Arrays.toString(ex.getStackTrace()));
        }
    }

    public void appendData(FileWriter csvWriter, Stack<Burn> monthlyBurn) throws Exception {

        while (!monthlyBurn.isEmpty()) {
            Burn currentBurn = monthlyBurn.getTop();
            try {
                csvWriter.append(String.join(",",
                        String.valueOf(currentBurn.getX()),
                        String.valueOf(currentBurn.getX()),
                        currentBurn.getMonth(),
                        currentBurn.getDay(),
                        String.valueOf(currentBurn.getFfmc()),
                        String.valueOf(currentBurn.getDmc()),
                        String.valueOf(currentBurn.getDc()),
                        String.valueOf(currentBurn.getIsi()),
                        String.valueOf(currentBurn.getTemp()),
                        String.valueOf(currentBurn.getRh()),
                        String.valueOf(currentBurn.getWind()),
                        String.valueOf(currentBurn.getRain()),
                        String.valueOf(currentBurn.getArea())
                ));

                csvWriter.append("\n");
                monthlyBurn.pop();
            } catch (IOException ex) {
                LogWriter.writeFileTXT(Arrays.toString(ex.getStackTrace()));
            }

        }

    }

}
