import java.util.Map;
import java.util.TreeMap;

import edu.duke.*;
public class WordLengths {
    
   
public static void countWordLengths(FileResource Resource, int[] counts) 
{ 
        Map<Integer,String> wordMap=new TreeMap<>();
        for (String word : Resource.words()){
            int Wordlength = word.length();
            for (int i=0; i<word.length();i++){
                char currChar = word.charAt(i);
                if ((i==word.length()-1))
                {
                    if (!Character.isLetter(currChar))
                    { 
                        Wordlength--;
                        word=word.substring(0, word.length()-1);
                    }
                }
            }  
            counts[Wordlength]++;
            if(wordMap.containsKey(Wordlength))
            {
                String s=wordMap.get(Wordlength);
                s=s+" "+word;
                wordMap.put(Wordlength,s);
            }
            else
            {
              wordMap.put(Wordlength, word);  
            }   
            //System.out.println(" Words of length "+ Wordlength +" "+ word);
        }
        for (int length : wordMap.keySet())
        {
            System.out.println(" Words of length "+ length +" "+ wordMap.get(length));
        
        }
}
   
 
public static void indexOfMax(int[] values) {

        int max = 0;
        int position = 0;
            for (int i = 0; i <values.length;i++) 
              {
                  if (values[i] > max) 
                    {
                        max = values[i];
                        position = i;
                    } 
        }
        
      System.out.println("The most common word is :"+ position); 
        
    }
       
    
public static void testCountWordLengths(){
     FileResource Resource = new FileResource("demo.txt");
      int [] counts = new int[31];
      countWordLengths(Resource,counts);     
      indexOfMax(counts);    
      }
      
      public static void main(String[] args) {
          FileResource fr=new FileResource("demo.txt");
          int[] counts=new int[31];
          countWordLengths(fr, counts);
      }
    
    } 