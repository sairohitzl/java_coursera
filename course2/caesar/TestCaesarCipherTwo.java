import edu.duke.*;

public class TestCaesarCipherTwo {
    
    
    public static void simpleTests() {
    FileResource fr = new FileResource("demo.txt");
    String message = fr.asString();
    
    String bcc = breakCaesarCipher(message);
    System.out.println("decryption: "+ bcc);
    }
    
    /*private String halfOfString(String my_message,int start) { 
        String result = new String(); 
        for (int i = start; i < my_message.length(); i = i+2) {
           result = result + my_message.charAt(i);
        }
    
    return result; 
    }*/
    public static String halfOfString(String message,int start)
    {
        int flag=0;
        StringBuilder sb=new StringBuilder();
        for(int i=start;i<message.length();i++)
        {
            
            if(flag%2==0)
            {
                sb.append(message.charAt(i));
                flag++;
            }
            else
            {
                flag++;
            }
        }

        return sb.toString();
    }
    
    private static int[] countLetters(String message) {
       String alph = "abcdefghijklmnopqrstuvwxyz";
         int[] counts = new int[26];
         for(int k=0; k < message.length();k++) {
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = alph.indexOf(ch);
            if(dex!=-1){
                counts[dex]++;
            }
         }
            return counts;
    }
    
    private static int getKey(String s) {
       int[] freqs = countLetters(s);
       int maxDex = maxIndex(freqs);
       int dKey = maxDex - 4;
       if (maxDex < 4) {
           dKey = 26 - (4 -maxDex);
       }
       
       return dKey;
    }
    
   
   private static int maxIndex(int[] values) {
        int max = 0;
        int indexOfMax = 0;
        for(int k = 0;k<values.length;k++) {
            if (values[k]> max){
            max = values[k];
            indexOfMax = k;
            }
        
        }
        
        return indexOfMax; 
        
    }
        
    private static String breakCaesarCipher(String input) {
       
       String message1 = halfOfString(input,0);
       String message2 = halfOfString(input,1);
       
       
       int key1= getKey(message1);
       int key2= getKey(message2);
      
       CaesarCipherTwo cc3 = new CaesarCipherTwo(key1,key2);
    
       String decryption = cc3.decrypt(input);       
       return decryption;
    }

    public static void main(String[] args) {
        simpleTests();
    }

}
