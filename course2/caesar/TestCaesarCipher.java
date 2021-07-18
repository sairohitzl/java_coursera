import edu.duke.*;
public class TestCaesarCipher {
        
    public static void simpleTests() {
          FileResource fr = new FileResource("message.txt");
          String message = fr.asString();
          CaesarCipher2 cc = new CaesarCipher2(18);
          String encrypted = cc.encrypt(message);
          System.out.println("The encryption result is "+ encrypted);
          String decrypted = cc.decrypt(encrypted,18);
          System.out.println("The decryption outcome is "+ decrypted);
          
         }
         
           
    public static String breakCaesarCipher(String input) {
        
        int [] freqs = countLetters(input);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if (dkey < 0)
        { 
            dkey = 26 - (4 - maxDex);
        }
        CaesarCipher2 cc = new CaesarCipher2(dkey);
        
        String message = cc.decrypt(input,dkey);
        return message;
    }
           
    private static int maxIndex(int[] values) {
        int max = 0;
        int position = 0;
        
        for (int i = 0; i <values.length;i++) {
              if (values[i] > max) 
                {
                    max = values[i];
                    position = i;
                    
                }
                
        } 
        System.out.println("index of max value in array :"+ position); 
        return position;  
    }
    
    private static int[] countLetters(String message) {
            
            String alph = "abcdefghijklmnopqrstuvwxyz";
            int[] counts = new int[26];
            for (int k = 0; k < message.length();k++) {
                char ch = Character.toLowerCase(message.charAt(k));
                int dex = alph.indexOf(ch);
                if(dex!=-1){
                    counts[dex]+=1;
                }
            }
            return counts;
        }
        
        public static void main(String[] args) {
            simpleTests();
        }
          
    }