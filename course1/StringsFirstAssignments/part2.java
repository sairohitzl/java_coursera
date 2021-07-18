import java.util.*;
public class part2
{
    public static boolean isAllUpper(String s)
    {
      for(int i=0;i<s.length();i++)
      {
          if(!Character.isUpperCase(s.charAt(i)))
          {
              return false;
          }
      }
      return true;
    }

    public static boolean isAllLower(String s)
    {
      for(int i=0;i<s.length();i++)
      {
          if(!Character.isLowerCase(s.charAt(i)))
          {
              return false;
          }
      }
      return true;
    }

	public static String findSimpleGene(String dna,String startCodon,String stopCodon)
	{
     
     if(dna.indexOf(startCodon)>-1)
     {
      if(dna.indexOf(stopCodon)>-1)
      {
      	String s=dna.substring(dna.indexOf(startCodon)+3,dna.indexOf(stopCodon));

      	if(s.length()%3==0)
      	{
      		 s=startCodon+s+stopCodon;
              return s;
      	}

      }

     }
     return "";
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        String inputString=sc.next();
        String startcodon=sc.next();
        String stopcodon=sc.next();
        sc.close();
        if(isAllLower(inputString)) 
        {
            startcodon=startcodon.toLowerCase();
            stopcodon=stopcodon.toLowerCase();
            
        }
        else
        {
            startcodon=startcodon.toUpperCase();
            stopcodon=stopcodon.toUpperCase(); 
        }
        System.out.println("gene: "+findSimpleGene(inputString,startcodon,stopcodon));
        
	}
}