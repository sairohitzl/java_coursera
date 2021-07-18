public class Part3 {

    public static boolean twoOccurences(String stringa,String stringb)
    {
        
      if(stringb.contains(stringa))
      {
           int index=stringb.indexOf(stringa);
           String lastPartString=stringb.substring(index+stringa.length(),stringb.length());
           if(lastPartString.contains(stringa))
           {
               return true;
           }
           
      }
      return false;


    }

    public static void testing()
    {
        System.out.println(twoOccurences("by","let us c by yashwanth kanetkar"));
        System.out.println(twoOccurences("ana","banana"));
        System.out.println(twoOccurences("dig","combat"));

        System.out.println("the last part of string after an in banana is "+lastPart("ana","banana"));
        System.out.println("the last part of string after zoo in forest is "+lastPart("zoo","forest"));
        
    }

    public static String lastPart(String a,String b)
    {
        int pos=b.indexOf(a);
        if(pos>-1)
        {
            String lastpart=b.substring(pos+a.length(),b.length());
            return lastpart;
        }
        return b;
    }
    public static void main(String[] args) {
        testing();
    }
}

