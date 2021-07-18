class Part1
{
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
    
   
    public static void testfindStopCodon()
    {
        String dna="AGCATGGGCCTATGGGTTCATAAGCAAGCTGATCCGTAA";
        int index = findStopCodon(dna, 0, "TAA");
        System.out.println("index = " + index);
        
        index = findStopCodon(dna, 9, "TAA");
        System.out.println("index = " + index);
                
        index = findStopCodon(dna, 1, "TAA");
        System.out.println("index = " + index);
                
        index = findStopCodon(dna, 0, "TAG");
        System.out.println("index = " + index);

    }

    public static void testfindGene() {
        String dna1 = "GTTAATGTAGCTTAAACCTTTAAAGCAAGGCACTGAAAATGCCTAGATGA";
        System.out.println("Gene1: " + findGene(dna1,0));
        
        String dna2 = "GTGAGCTCACTCCATAGACACAAAGGTTTGGTCCTGGCCTTCTTATTAGT";
        System.out.println("Gene2: " + findGene(dna2,0));
        
        String dna3 = "TTTCAGTGAGCTTACACATGCAAGTATCCGCGCGCCAGTGAAAATGCCCT";
        System.out.println("Gene3: " + findGene(dna3,0));
        
        String dna4 = "TCAAATCATTACTGACCATAAAGGAGCGGGTATCAAGCACACACCTATGT";
        System.out.println("Gene4: " + findGene(dna4,0));
        
        String dna5 = "AGCTCAATGCACCTTGCTTAGCCACACTAGCACGGGATACAGCAGTGATA";
        System.out.println("Gene5: " + findGene(dna5,0));
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


    public static void main(String[] args) {
        testfindStopCodon();
        System.out.println(".................");
        testfindGene();
        System.out.println(".................");
        printAllGenes("ATGATCTAATTTATGCTGCAACGGTGAAGA");

    }
}
