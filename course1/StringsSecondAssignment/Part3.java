public class Part3 {
    public static int findStopCodon(String dna,int startIndex,String stopCodon)
    {
        int tempS=startIndex;
        int index;
      while(true)
      {
          index =dna.indexOf(stopCodon,tempS+3);

          if(index==-1 || (index-startIndex)%3==0)
          {
             break;
          }

          tempS=index+1;
          if(tempS>dna.length()-1) break;
      }
      if(index!=-1)
      {
          return index;
      }
      return dna.length();

    }
    public static String findGene(String dna,int beginIndex) {
        final String START_CODON = "ATG";
        int startIndex = dna.indexOf(START_CODON,beginIndex);

        if (startIndex == -1) {
            return "";
        }
        
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        
        int minIndex = Math.min(taaIndex, Math.min(tagIndex, tgaIndex));
        
        if (minIndex == dna.length()) {
            return "";
        } else {
            return dna.substring(startIndex, minIndex + 3);
        }
    }

    public static void printAllGenes(String dna)
    {
        int begin=0;
        while(true)
        {
          String gene=findGene(dna,begin);
          if(gene=="")
          {
              break;
          }
          System.out.println("dna: "+gene);
          begin=dna.indexOf(gene,begin)+gene.length();

        }
    }

    public static int countGenes(String dna)
    {
        int begin=0, count=0;
        while(true)
        {
          String gene=findGene(dna,begin);
          if(gene=="")
          {
              break;
          }
          count++;
          begin=dna.indexOf(gene,begin)+gene.length();

        }

        return count;
    }

    public static void testCountGenes() {
        String dna = "ATGTAAGATGCCCTAGT";
        System.out.println("Gene count on " + dna + " = " + countGenes(dna));
    }

    public static void main(String[] args) {
        testCountGenes();
    }
}
