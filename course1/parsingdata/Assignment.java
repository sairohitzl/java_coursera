import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class Assignment
{
    private final static String TemperatureCol = "TemperatureF";
    private final static String DateCol = "DateUTC";
    private final static String HumidityCol = "Humidity";

    public CSVRecord coldestHourInFile(CSVParser parser)
    {
        CSVRecord coldestRecord = null;

        for (CSVRecord record : parser)
        {
            double temperature = Double.parseDouble(record.get(TemperatureCol));

            if (coldestRecord == null && temperature != -9999)
            {
                coldestRecord = record;
            }
            else
            {
                double coldestTemperature = Double.parseDouble(coldestRecord.get(TemperatureCol));

                if (temperature < coldestTemperature && temperature != -9999)
                {
                    coldestRecord = record;
                }
            }
        }

        return coldestRecord;
    }

    public void testColdestHourInFile()
    {
        FileResource fr = new FileResource();
        CSVRecord coldestRecord = coldestHourInFile(fr.getCSVParser());
        System.out.println("Coldest temperature was " + coldestRecord.get(TemperatureCol) + " at " + coldestRecord.get(DateCol));
    }

    public File fileWithColdestTemperature() {
        DirectoryResource dr = new DirectoryResource();
        File file = null;
        CSVRecord coldestRecord = null;

        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRecord = coldestHourInFile(fr.getCSVParser());

            if (coldestRecord == null) {
                coldestRecord = currentRecord;
                file = f;
            } else {
                double coldestTemperature = Double.parseDouble(coldestRecord.get(TemperatureCol));
                double currentTemperature = Double.parseDouble(currentRecord.get(TemperatureCol));

                if (currentTemperature < coldestTemperature) {
                    coldestRecord = currentRecord;
                    file = f;
                }
            }
        }

        return file;
    }

    public void printAllRecordsInFile(CSVParser parser) {
        for (CSVRecord record : parser) {
            System.out.println(record.get(DateCol) + " " + record.get(TemperatureCol));
        }
    }

    public void testFileWithColdestTemperature() {
        File file = fileWithColdestTemperature();
        System.out.println("Coldest day was in file " + file.getName());

        FileResource fr = new FileResource(file);
        String coldestTemperature = coldestHourInFile(fr.getCSVParser()).get(TemperatureCol);
        System.out.println("Coldest temperature on that day was " + coldestTemperature);

        System.out.println("All the Temperatures on the coldest day were:");
        printAllRecordsInFile(fr.getCSVParser());
    }

    public CSVRecord lowestHumidityInFile(CSVParser parser) {
        CSVRecord lowestHumidityRecord = null;

        for (CSVRecord record : parser) {
            String humidityStr = record.get(HumidityCol);

            if (!humidityStr.equals("N/A")) {
                int humidity = Integer.parseInt(humidityStr);

                if (lowestHumidityRecord == null) {
                    lowestHumidityRecord = record;
                } else {
                    int lowestHumidity = Integer.parseInt(lowestHumidityRecord.get(HumidityCol));

                    if (humidity < lowestHumidity) {
                        lowestHumidityRecord = record;
                    }
                }
            }
        }

        return lowestHumidityRecord;
    }

    public void testLowestHumidityInFile()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord lowestHumidityRecord = lowestHumidityInFile(parser);

        System.out.println("Lowest Humidity was " + lowestHumidityRecord.get(HumidityCol) + " at " + lowestHumidityRecord.get(DateCol));
    }


    public CSVRecord lowestHumidityInManyFiles()
    {
        DirectoryResource dr = new DirectoryResource();
        CSVRecord lowestHumidityRecord = null;

        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRecord = lowestHumidityInFile(fr.getCSVParser());

            if (lowestHumidityRecord == null) {
                lowestHumidityRecord = currentRecord;
            } else {
                int lowestHumidity = Integer.parseInt(lowestHumidityRecord.get(HumidityCol));
                int currentHumidity = Integer.parseInt(currentRecord.get(HumidityCol));

                if (currentHumidity < lowestHumidity) {
                    lowestHumidityRecord = currentRecord;
                }
            }
        }

        return lowestHumidityRecord;
    }

    public void testLowestHumidityInManyFiles()
    {
        CSVRecord lowestHumidityRecord = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was " + lowestHumidityRecord.get(HumidityCol) + " at " + lowestHumidityRecord.get(DateCol));
    }


    public double averageTemperatureInFile(CSVParser parser)
    {
        double totalTemperature = 0;
        int recordCount = 0;

        for (CSVRecord record : parser) {
            double currentTemperature = Double.parseDouble(record.get(TemperatureCol));

            if (currentTemperature != -9999) {
                totalTemperature += currentTemperature;
                recordCount++;
            }

        }

        return totalTemperature / recordCount;
    }


    public void testAverageTemperatureInFile()
    {
        FileResource fr = new FileResource();
        double averageTemperature = averageTemperatureInFile(fr.getCSVParser());
        System.out.println("Average temperature in file is " + averageTemperature);
    }

    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value) {
        double totalTemperature = 0;
        int recordCount = 0;

        for (CSVRecord record : parser) {
            int currentHumidity = Integer.parseInt(record.get(HumidityCol));

            if (currentHumidity >= value) {
                double currentTemperature = Double.parseDouble(record.get(TemperatureCol));

                if (currentTemperature != -9999) {
                    totalTemperature += currentTemperature;
                    recordCount++;
                }
            }
        }

        if (recordCount == 0) {
            return Double.NEGATIVE_INFINITY;
        } else {
            return totalTemperature / recordCount;
        }
    }

    public void testAverageTemperatureWithHighHumidityInFile() {
        FileResource fr = new FileResource();
        double averageTemperature = averageTemperatureWithHighHumidityInFile(fr.getCSVParser(),80);

        if (averageTemperature == Double.NEGATIVE_INFINITY) {
            System.out.println("No temperature with that humidity");
        } else {
            System.out.println("Average temperature when high humidity is " + averageTemperature);
        }
    }


    public static void main(String[] args) {
        Assignment asgn=new Assignment();
        asgn.testAverageTemperatureInFile();
    }
}