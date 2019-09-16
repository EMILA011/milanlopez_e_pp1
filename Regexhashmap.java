/**
 *
 *@author Elena Milan Lopez
 *@version 1.0
 *Programming Project One 
 *CS322-Compiler Construction 
 *Spring 2019
 */
import java.util.regex.Pattern;
import java.util.*;

public class Regexhashmap{
    
    public static HashMap<String,Integer> hmIpv4;
    public static HashMap<String,Integer> hmUsername;
        
    /*
    
    */
    public Regexhashmap() {
        hmIpv4 = new HashMap<>();
        hmUsername = new HashMap<>();
        
    }//constructor
    
    /*

     */
     public static void analyzeIpv4(String line){

         Pattern ipv4Pattern = Pattern.compile("^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$");

            String [] tokens = line.split(" ");
            for (int i = 0; i != tokens.length; i++) {
                int dataIndex = tokens[i].indexOf('=')+1;
                String data = tokens[i].substring(dataIndex);
                if(ipv4Pattern.matcher(data).matches())
                   hmIpv4.merge(data, 1, Integer::sum);

            }//for 

    }//analyzeIpv4

    /*

    */
    public static void analyzeUsernames(String line){

         Pattern usernamePattern = Pattern.compile("^[a-z]\\w{1,15}$");

            String [] tokens = line.split(" ");
            for (int i = 0; i != tokens.length; i++) {
                if(tokens[i].equals("user")){
                    int dataIndex = tokens[i].indexOf('=')+1;
                    String data = tokens[i+1].substring(dataIndex);
                    if(usernamePattern.matcher(data).matches())
                       hmUsername.merge(data, 1, Integer::sum);
                }

            }//for 

    }//analyzeUsernames

    /*

    */
    public static void outputIpv4()
    {
            hmIpv4.forEach((key, value) -> System.out.println(key + " : " + value));
            

    }//outputIpv4

    /*

    */
    public static void outputUsername(){

        hmUsername.forEach((key, value) -> System.out.println(key + " : " + value));
        

    }//outputUsername

    /*

    */
    public static int sizeHmIpv4(){

        return hmIpv4.size();

    }//sizeHmIpv4

    /*

    */
    public static int sizeHmUsername(){

        return hmUsername.size();

    }//sizeHmUsername
        
}//class Regexhashmap

