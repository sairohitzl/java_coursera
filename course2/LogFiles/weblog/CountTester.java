import java.util.*;

public class CountTester {
    
    private ArrayList<String> maximumIPs;
    private ArrayList<String> mostAccessesDay;
    
    public CountTester(){
        maximumIPs = new ArrayList<String>();
        mostAccessesDay = new ArrayList<String>();
    }
    
    public HashMap<String,Integer> testCounts() {   
    LogAnalyzer la = new LogAnalyzer();
    la.readFile("weblog3-short_log");
    HashMap<String,Integer> counts = la.countVisitsPerIP();
    System.out.println(counts);
    return counts;
    }
    
    public void testmostNumberVisitsByIP() {
    LogAnalyzer le = new LogAnalyzer();

    le.readFile("weblog2_log");
    int max_value = le.mostNumberVisitsByIP(testCounts());
    System.out.println("max value in the HashMap "+ max_value);
    }
    
    public void testiPsMostVisits() {
    LogAnalyzer Sol = new LogAnalyzer();
    
    Sol.readFile("weblog2_log");
    HashMap<String,Integer> myCounts = Sol.countVisitsPerIP();
    maximumIPs = Sol.iPsMostVisits(myCounts);
    for (int k=0;k<maximumIPs.size();k++) {
        System.out.println(" IP addresses that all have the maximum number of visits "+ maximumIPs.get(k));
       }
    }
    
   public void testiPsForDays() {
    LogAnalyzer LA = new LogAnalyzer();
    LA.readFile("weblog3-short_log");
    HashMap<String,ArrayList<String>> map_day_ipaddress = LA.iPsForDays(); 
        for (String s: map_day_ipaddress.keySet()) {
            System.out.println(s+" maps to"+"\t"+map_day_ipaddress.get(s));
        }
   }
    
   public void testdayWithMostIPVisits() {
    String dayMostIP;
    LogAnalyzer LogA = new LogAnalyzer();
    LogA.readFile("weblog2_log");
    HashMap<String,ArrayList<String>> map_day_ipaddress = LogA.iPsForDays(); 
    dayMostIP = LogA.dayWithMostIPVisits(map_day_ipaddress);
    System.out.println("The day that has the most IP address"+ dayMostIP);
   }
    
   public void testIPsWithMostVisitsOnDay() {
    LogAnalyzer myLog = new LogAnalyzer();
    myLog.readFile("weblog2_log");
    HashMap<String,ArrayList<String>> day_and_ipaddress = myLog.iPsForDays();
    mostAccessesDay = myLog.iPsWithMostVisitsOnDay(day_and_ipaddress,"Sep 29");
    for (int k=0;k<mostAccessesDay.size();k++) {
        System.out.println(" IP addresses that all have the maximum number of visits on Sep 29 "
        + mostAccessesDay.get(k));
       }
    }

    public static void main(String[] args) {
        CountTester ct=new CountTester();
        //ct.testIPsWithMostVisitsOnDay();
        ct.testdayWithMostIPVisits();
    }

}
