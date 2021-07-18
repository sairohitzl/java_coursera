public class CaesarCipher2
{
    
    private static String Alphabet;
    private static String ShiftedAlphabet;
    private static String alphabet;
    private static String shiftedAlphabet;
    
    
    
    
    public CaesarCipher2(int key) 
    {   key=key%26;
        Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        alphabet = Alphabet.toLowerCase();
        ShiftedAlphabet = alphabet.substring(key)+ alphabet.substring(0,key);
        shiftedAlphabet = alphabet.substring(key)+ alphabet.substring(0,key);
    
    }
    
    public  String encrypt(String input) 
    {
        
        StringBuilder encrypted = new StringBuilder (input);
        
        
        for (int i = 0; i < encrypted.length();i++) 
        {
        
        char currChar = encrypted.charAt(i);
        if (Character.isLowerCase(currChar))
        {
        
            int index = CaesarCipher2.alphabet.indexOf(currChar);
        
        if (index !=-1) 
        {
            
            char newChar = shiftedAlphabet.charAt(index);
            encrypted.setCharAt(i,newChar);
        }
        
        }
        
        else {
         
            int index = Alphabet.indexOf(currChar);
        
        if (index !=-1){
            
            char newChar = ShiftedAlphabet.charAt(index);
            
            encrypted.setCharAt(i,newChar);
        }
            
        }
     
         
    }
    
     return encrypted.toString();
   }
   
   
   public  String decrypt(String input,int key) 
   {
       key=key%26;
       CaesarCipher2 cc = new CaesarCipher2(26 - key);
       String message = cc.encrypt(input);
       return message;
    }
    public static void main(String[] args) 
    {
        CaesarCipher2 c1 = new CaesarCipher2(4);
        System.out.println(c1.encrypt("abcd"));


        System.out.println(c1.decrypt("EFGH",1));
    }
}