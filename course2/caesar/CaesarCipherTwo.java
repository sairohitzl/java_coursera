public class CaesarCipherTwo{
    
    private int mainKey1;
    private int mainKey2;
    private String Alphabet;
    private String alphabet;
    private String supperAlpha1;
    private String slowerAlpha1;
    private String supperAlpha2;
    private String slowerAlpha2;
    
    
    
    public CaesarCipherTwo(int key1, int key2) 
    {
        key1=key1%26;
        key2=key2%26;
        mainKey1 = key1;
        mainKey2 = key2;
        Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        alphabet = Alphabet.toLowerCase();
        supperAlpha1 = Alphabet.substring(key1)+ Alphabet.substring(0,key1);
        slowerAlpha1 = alphabet.substring(key1)+ alphabet.substring(0,key1);
        supperAlpha2 = Alphabet.substring(key2)+ Alphabet.substring(0,key2);
        slowerAlpha2 = alphabet.substring(key2)+ alphabet.substring(0,key2);
    }
    
    
    public String encrypt(String input) 
    {
        StringBuilder encrypted = new StringBuilder(input);

        for (int i = 0; i <encrypted.length();i+=2)
        {
        char currChar = encrypted.charAt(i);
        if ((i %2 == 0) && (Character.isLowerCase(currChar)))
        {
        
            int index = alphabet.indexOf(currChar);
        
        if (index!= 0)
            {
            char newChar = slowerAlpha1.charAt(index);
            encrypted.setCharAt(i,newChar);
            }
        }
        
        else if ((i %2 == 0) && (Character.isUpperCase(currChar)))
        {
            int index = Alphabet.indexOf(currChar);
        if (index != 0)
            {
            char newChar = supperAlpha1.charAt(index);
            encrypted.setCharAt(i,newChar);
            }
        }
        
    }
    
       for (int i = 1; i <encrypted.length();i+=2) 
       {
            char currChar = encrypted.charAt(i);
            if ((i %2 != 0) && (Character.isLowerCase(currChar)))
            {
                int index = alphabet.indexOf(currChar);
            if (index != 0)
                {
                char newChar = slowerAlpha2.charAt(index);
                encrypted.setCharAt(i,newChar);
                }
        }
        
            else if ((i %2 != 0) && (Character.isUpperCase(currChar)))
            {
                int idx = Alphabet.indexOf(currChar);
            if (idx != 0)
            {
                char newChar = supperAlpha2.charAt(idx);
                encrypted.setCharAt(i,newChar);
            }
        }
                
    } 
    
        return encrypted.toString();   
    }
    
    
    public String decrypt(String encrypted)
    {
        
       CaesarCipherTwo cc = new CaesarCipherTwo(26 - mainKey1,26 - mainKey2);
       String decrypted = cc.encrypt(encrypted);
       return decrypted;
       
    }
    
}