import edu.duke.*;
import org.apache.commons.csv.*;

import java.io.File;

public class AssignmentNames {
    public static void totalBirths(FileResource fr)
    {
        int totalBirths=0,numberOfBirths=0,females=0,males=0;
        for(CSVRecord record:fr.getCSVParser(false))
        {
            numberOfBirths=Integer.parseInt(record.get(2));
            totalBirths+=numberOfBirths;
            if(record.get(1).equals("F"))
            {
                females+=1;
            }
            else if(record.get(1).equals("M"))
            {
                males+=1;
            }
        }
        System.out.println("total births: "+totalBirths);
        System.out.println("no of:: females: "+females+" males:"+males);
    }

    public static void testTotalBirths() {
        FileResource fr = new FileResource();
        totalBirths(fr);
    }

    public static int getRank(int year, String name, String gender) {
        FileResource fr = new FileResource();
        int rank = 0;
        boolean recordFound = false;

        for (CSVRecord record : fr.getCSVParser(false)) {
            String currentName = record.get(0);
            String currentGender = record.get(1);

            if (currentGender.equals(gender)) {
                rank++;

                if (currentName.equals(name)) {
                    recordFound = true;
                    break;
                }
            }
        }

        if (recordFound) {
            return rank;
        } else {
            return -1;
        }
    }

    public static void testGetRank() {
        int year = 2012;
        String name = "Mason";
        String gender = "M";

        int rank = getRank(year, name, gender);
        System.out.println(name + " rank is " + rank);
    }


    public static String getName(int year, int rank, String gender) {
        FileResource fr = new FileResource();
        String name = "null";
        int currentRank = 0;

        for (CSVRecord record : fr.getCSVParser(false)) {
            String currentGender = record.get(1);

            if (currentGender.equals(gender)) {
                currentRank++;

                if (currentRank == rank) {
                    name = record.get(0);
                    break;
                }
            }
        }

        return name;
    }

    public static void testGetName() {
        int year = 2012;
        int rank = 2;
        String gender = "M";

        String name = getName(year, rank, gender);
        System.out.println(year + " rank " + rank + " is " + name);
    }

    public void whatIsNameInYear(String name, int year, int newYear, String gender) {
        int currentYearRank = getRank(year, name, gender);
        String newName = getName(newYear, currentYearRank, gender);

        System.out.println(name + " born in " + newYear + " would be " + newName + " if she was born in " + newYear);
    }

    public void testWhatIsNameInYear() {
        whatIsNameInYear("Isabella", 2012, 2014, "F");
    }

    public int yearOfHighestRank(String name, String gender) {
        int year = Integer.MIN_VALUE;
        int rank = Integer.MAX_VALUE;
        DirectoryResource dr = new DirectoryResource();

        for (File f : dr.selectedFiles()) {
            int currentYear = Integer.parseInt(f.getName().substring(3, 7));
            int currentRank = getRank(currentYear, name, gender);

            if (currentRank != -1 && currentRank < rank) {
                rank = currentRank;
                year = currentYear;
            }

        }

        if (year == Integer.MIN_VALUE) {
            return -1;
        } else {
            return year;
        }
    }

    public void testYearOfHighestRank() {
        String name = "Mason";
        String gender = "M";
        System.out.println(name + " most popular year is " + yearOfHighestRank(name, gender));
    }


    public int getTotalBirthsRankedHigher(int year, String name, String gender) {
        FileResource fr = new FileResource();
        int rank = getRank(year, name, gender);
        int totalBirths = 0;
        int currentRank = 0;

        for (CSVRecord record : fr.getCSVParser(false)) {
            String currentGender = record.get(1);

            if (currentGender.equals(gender)) {
                currentRank++;

                if (currentRank < rank) {
                    int currentBirths = Integer.parseInt(record.get(2));
                    totalBirths += currentBirths;
                } else {
                    break;
                }
            }
        }

        return totalBirths;
    }

    public void testGetTotalBirthsRankedHigher() {
        int year = 2012;
        String name = "Ethan";
        String gender = "M";
        System.out.println("Total births higher than " + name + " is " + getTotalBirthsRankedHigher(year, name, gender));
    }

    public static void main(String[] args) {
     testTotalBirths();
    }
}
