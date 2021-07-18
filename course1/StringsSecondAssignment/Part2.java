public class Part2 {
    public static int howMany(String a,String b)
    {
        int occurences=0, indexOfOccurence,start=0;
        while(true)
        {
            indexOfOccurence=b.indexOf(a,start);
            if(indexOfOccurence==-1){
                break;
            }
            else
            {
                occurences++;
            }
            start=indexOfOccurence+a.length();

        }

        return occurences;
    } 

    public static void testHowMany() {
        String stringa = "GAA";
        String stringb = "ATGAACGAATTGAATC";
        System.out.println("Total occurences of " + stringa + " in " + stringb + " = " + howMany(stringa, stringb));
        
        stringa = "AA";
        stringb = "ATAAAA";
        System.out.println("Total occurences of " + stringa + " in " + stringb + " = " + howMany(stringa, stringb));

        stringa = "AAG";
        stringb = "KANGAROO";
        System.out.println("Total occurences of " + stringa + " in " + stringb + " = " + howMany(stringa, stringb));
    }

public static void main(String[] args) {
    testHowMany();
}
}