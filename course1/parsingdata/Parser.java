import edu.duke.*;
import org.apache.commons.csv.*;
public class Parser
{

    public static String countryInfo(CSVParser parser, String country) {
        for (CSVRecord record : parser) {
            String currentCountry = record.get("Country");

            if (currentCountry.equalsIgnoreCase(country)) {
                String export = record.get("Exports");
                String money = record.get("Value (dollars)");

                return currentCountry + ": " + export + ": " + money;
            }
        }

        return "no record";
    }

    public static void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2)
    {
        for (CSVRecord record : parser) {
            String exports = record.get("Exports");

            if (exports.contains(exportItem1) && exports.contains(exportItem2)) {
                String country = record.get("Country");
                System.out.println(country);
            }
        }
    }

    public static int numberOfExporters(CSVParser parser, String exportItem)
    {
        int totalCountry = 0;

        for (CSVRecord record : parser) {
            String exports = record.get("Exports");

            if (exports.contains(exportItem)) {
                totalCountry++;
            }
        }

        return totalCountry;
    }

    public static void bigExporters(CSVParser parser, String amount)
    {
        for (CSVRecord record : parser) {
            String currentAmount = record.get("Value (dollars)");

            if (currentAmount.length() > amount.length()) {
                String country = record.get("Country");
                System.out.println(country + " " + currentAmount);
            }
        }
    }

    public static void tester()
    {
        FileResource fr = new FileResource();

        CSVParser parser = fr.getCSVParser();
        System.out.println(countryInfo(parser, "germany"));

        parser = fr.getCSVParser();
        listExportersTwoProducts(parser, "gold", "diamonds");

        parser = fr.getCSVParser();
        System.out.println(numberOfExporters(parser, "gold"));

        parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999");
    }

    public static void main(String[] args)
    {
        tester();
    }
}

