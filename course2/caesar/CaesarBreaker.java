public class CaesarBreaker
{
    

    public static String decrypt(String encryptedText, int key) 
    {
        key = key%26;
        String decrypted = CaesarCipher.encrypt(encryptedText, (26 - key));
        return decrypted;
     
    }

    public static String decryptTwoKey(String encryptedText,int key1,int key2)
    {
        key1=key1%26;
        key2=key2%26;
        String decrypted = CaesarCipher.encryptTwoKeys(encryptedText, (26-key1), (26-key2));
        return decrypted;
    }
    
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
    
    public static void testDecrypt()
    {
       System.out.println(decrypt("BC",1));
       System.out.println(decrypt("mno",1));
    }

    public int[] CountLetters(String message) {
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for(int k=0; k < message.length();k++) {
           char ch = Character.toLowerCase(message.charAt(k));
           int dex = alph.indexOf(ch);
           if(dex!=-1) {
               counts[dex]++;
           }

           }
       return counts;
   }

    public static int maxIndex(int[] values) {
        
        int max = 0;
        int indexOfMax = 0;
        for(int k = 0;k<values.length;k++) {
            if (values[k]> max) {
            max = values[k];
            indexOfMax = k;
            }
        
        }
        
        return indexOfMax; 
    }

    

    public static void main(String[] args) 
    {
        //System.out.println(decrypt("BC",1));
        System.out.println(decryptTwoKey("Czojq Ivdzle", 23, 17));
        System.out.println(halfOfString("Qbkm Zgis",1));

    }
}












