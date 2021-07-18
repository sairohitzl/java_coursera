
public class WordPlay{

    public static boolean isVowel(char ch)
    {
     
        if(ch=='a' || ch=='e'|| ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E'|| ch=='I' || ch=='O' || ch=='U')
        {
            return true;
        }


        return false;
    }


    public static String replaceVowel(String phrase,char ch)
    {
        StringBuilder sb=new StringBuilder();
        char c;
        for(int i=0;i<phrase.length();i++)
        {
            c=phrase.charAt(i);
            if(isVowel(c))
            {
                sb.append(ch);
            }
            else
            {
                sb.append(c);
            } 
        }
        return sb.toString();
    }

    public static String emphasize(String phrase,char ch)
    {
        StringBuilder sb=new StringBuilder();
        char c;
        for(int i=0;i<phrase.length();i++)
        {
         c=phrase.charAt(i);
         
          if(c==ch)
         {
             if(i%2==0)
             {
                 sb.append('*');
             }
             else
             {
                 sb.append('+');
             }
         }
         else
         {
             sb.append(c);
         }   
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String check="mary bella abracadabra";
        System.out.println(emphasize(check, 'a'));
        System.out.println("..................");
        System.out.println(replaceVowel("Hello world",'*'));
    }
}