//import java.util.Scanner;
public class part1
{
	public static String findSimpleGene(String geneSequence)
	{

		if(geneSequence.contains("ATG"))
     {
      if(geneSequence.contains("TAA"))
      {
		  String s = geneSequence.substring(geneSequence.indexOf("ATG") + 3, geneSequence.indexOf("TAA"));

		  if((s.length() % 3) == 0) {
			s = "ATG" + s + "TAA";
			return s;
		}

      }

     }
     return "";
	}


	public static void testSimpleGene()
	{
		String Test1="ATCTGAATCG";
		String Test2="ATGTGCCATT";
		String Test3="ATTTGCCATT";
		String Test4="ATGTGCCAGTAA";
		String Test5="ATGTGCCATAA";

		System.out.println(Test1+" "+"gene: "+findSimpleGene(Test1));
		System.out.println(Test2+" "+"gene: "+findSimpleGene(Test2));
		System.out.println(Test3+" "+"gene: "+findSimpleGene(Test3));
		System.out.println(Test4+" "+"gene: "+findSimpleGene(Test4));
		System.out.println(Test5+" "+"gene: "+findSimpleGene(Test5));

	}



	public static void main(String[] args) {
		//Scanner sc=new Scanner(System.in);
        //String inputString=sc.next();

        //System.out.println(findSimpleGene(inputString));
        testSimpleGene();

	}
}