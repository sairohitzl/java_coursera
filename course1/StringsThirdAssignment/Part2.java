public class Part2 {
    public static double cgRatio(String dna)
    {
        int cgCount=0,totalCount=dna.length();
        for(int i=0;i<totalCount;i++)
        {
            if(dna.charAt(i)=='C' || dna.charAt(i)=='G')
            {
                cgCount++;
            }
        }
        return (double) cgCount/totalCount;
    }

    public static int countCTG(String dna) {
        int totalOccurences = 0;
        int begin = 0;
        
        while(true) {
            int index = dna.toUpperCase().indexOf("CTG", begin);
            
            if (index == -1) {
                break;
            }
            
            totalOccurences++;
            
            begin = index + 3;
        }
        
        return totalOccurences;
    }

    public void testCountCTG() 
    {
        String dna = "CTGCCTGGCTGCTG";
        System.out.println("CTG occurences on " + dna + " = " + countCTG(dna));
    }

} 
