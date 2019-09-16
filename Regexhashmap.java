/**
 *This class checks for pattern matching for ipv4 addressess and usernames using regular expresions using a given log file. 
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
    This is a constructor for the class Regexhashmap.
    It initialize the hashmaps that contain the ipv4addresses and usernames respectively.
    */

    public Regexhashmap() {
        hmIpv4 = new HashMap<>();
        hmUsername = new HashMap<>();
        
    }//constructor
    
    /*
	This method analize the given line to check if it contains the specific ipv4pattern.
	It creates an array of Strings per each word .
	If the pattern is found, it is added to the  Hashmap countainig the ipv4 addresses and the number of times each address appear in the file.
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
	This method analize the given line to check if it contains the specific username pattern.
        It creates an array of Strings per each word .
	If the string user is found, then it adds the following word to the Hashmap(which should follow the given pattern). 
        The  Hashmap countains the usernames  and the number of times each username appear in the file.

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
	This method prints the content of the ipv4 Hashmap.
    */
    public static void outputIpv4()
    {
            hmIpv4.forEach((key, value) -> System.out.println(key + " : " + value));
            

    }//outputIpv4

    /*
	This method prints the content of the usernames Hashmap.
    */
    public static void outputUsername(){

        hmUsername.forEach((key, value) -> System.out.println(key + " : " + value));
        

    }//outputUsername

    /*
	This method returns the size of the ipv4 Hashmap.
    */
    public static int sizeHmIpv4(){

        return hmIpv4.size();

    }//sizeHmIpv4

    /*
	This method returns the size of the usernames Hashmap.
    */
    public static int sizeHmUsername(){

        return hmUsername.size();

    }//sizeHmUsername
        
}//class Regexhashmap

