import edu.duke.*;
import java.util.ArrayList;

public class CharactersInPlay 
{

    private ArrayList<String> character_name;
    private ArrayList<Integer> count;
    
    public CharactersInPlay() 
    {
        character_name = new ArrayList<String>();
        count = new ArrayList<Integer>();
    }
    
    public void update(String person){
        
        
        int index = character_name.indexOf(person);
        if (index == -1) {
            character_name.add(person);
            count.add(1);
        }
        
        else {
                int freq = count.get(index);
                count.set(index,freq+1); 
             }
        
    }
    
    public void findAllCharacters() 
    {
        character_name.clear();
        count.clear();
        
        FileResource Resource = new FileResource("macbethSmall.txt");
        
        for (String line: Resource.lines())
        {
            
           
           if (line.contains(".")) 
           {
               
               int index = line.indexOf(".");
               String possible_name = line.substring(0,index);
               update(possible_name);
            
            }
            
            
        }
                                              
    }
            
    
   
    public void tester() 
    {
        findAllCharacters();
        
        for (int i=0; i < count.size();i++) 
        {
           
            if (count.get(i) > 1) 
            {
            
             System.out.println("main character is: "+ character_name.get(i) +" "
             +" number of speaking parts is: "+ count.get(i));
             
            }
            
        }
            
       int num1 = 2;
       int num2 = 3;
       charactersWithNumParts(num1, num2);
    
    }
    
    public void charactersWithNumParts(int num1, int num2)
    {
        
        for (int i =0; i < count.size();i++) {
           
            if (count.get(i) >= num1 && count.get(i)<= num2) 
            {
            
                System.out.println(" main character between : " + num1 + " and " + num2 + " is " + character_name.get(i) +" "+"The number of speaking parts is: "+ count.get(i));
             
            }
            
        }
    
    }

    public static void main(String[] args) 
    {
        CharactersInPlay cip = new CharactersInPlay();
        cip.tester();
    }
    
    
}