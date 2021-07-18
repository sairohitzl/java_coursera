import java.util.*;
import edu.duke.*;
public class CaesarCipher {

    public static boolean isSpecialCharacter(char ch)
    {
        Set<Character> hs = new HashSet<>(Arrays.asList('!','@','#','$','%','^','&','*'));
        if(hs.contains(ch))
        {
            return true;
        }
        return false;
    }
    public static String encrypt(String input,int key)
    {
        key=key%26;
        StringBuilder result= new StringBuilder();
 
        for (int i=0; i<input.length(); i++)
        {
            if(input.charAt(i)==' ')
            {
                result.append(' ');
            }
            else if (Character.isUpperCase(input.charAt(i)))
            {
                char ch = (char)(((int)input.charAt(i) +
                                  key - 65) % 26 + 65);
                result.append(ch);
            }
            else
            {
                char ch = (char)(((int)input.charAt(i) +
                                  key - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static void testCaesar() {
        int key = 23;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message,key);
        System.out.println("Key is "+ key+"\n"+encrypted);
    }
    public static String encryptTwoKeys(String input,int key1,int key2)
    {
        key1=key1%26;
        key2=key2%26;
        StringBuilder result= new StringBuilder();
        char ch;
        for (int i=0; i<input.length(); i++)
        {
            if(input.charAt(i)==' ')
            {
                result.append(' ');
            }
            else if (Character.isUpperCase(input.charAt(i)))
            {   
                if(i%2==0)
                {
                     ch = (char)(((int)input.charAt(i) + key1 - 65) % 26 + 65);
                }
                else
                {
                
                     ch = (char)(((int)input.charAt(i) + key2 - 65) % 26 + 65);
                }
                result.append(ch);
            }
            else
            { 
                if(i%2==0)
                {
                     ch = (char)(((int)input.charAt(i) + key1 - 97) % 26 + 97);
                }
                else
                {
                     ch = (char)(((int)input.charAt(i) + key2 - 97) % 26 + 97);
                }
                result.append(ch);
            }
        }   
        return result.toString();
    }
    

    public static void main(String[] args)
    {
        String text="FIRST LEGION ATTACK EAST FLANK";
        System.out.println(encrypt(text,23));
        System.out.println("................");
        System.out.println(encryptTwoKeys("First Legion", 23, 17));
    }
}
