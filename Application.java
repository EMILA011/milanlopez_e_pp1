/**
 *This class launches the application of the Regexhashmap class.
 *@author Elena Milan Lopez
 *@version 1.0
 *Programming Project One
 *CS322 - Compiler Construction
 *Spring 2019
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {

    public static int lines = 0;
    public static Regexhashmap regex = new Regexhashmap();

        public static void main(String[] args){

                File file = new File(args[0]);

                analyzeFile(file);

                int secondArg;

                secondArg=Integer.parseInt(args[1]);

                if(secondArg == 1){

                    regex.outputIpv4();
                }

                else if (secondArg == 2){

                     regex.outputUsername();
                }

                System.out.println(lines+ " lines in the log file were parsed.");
                System.out.println("There are " + regex.sizeHmIpv4() + " unique IP addresses in the log.");
                System.out.println("There are " + regex.sizeHmUsername() + " unique users in the log.");

        }//main

        /*
	This method analize a given file. First reads the file. 
	Then creates a String of lines and while the line is not a white space it increments the variable lines(which counts the number of lines. 
	Everytime each line is added to the string, it checks to see if it is an ipv4 or an username.  
	It also catch FileNotFoundException and IOException.
        */
        public static void analyzeFile(File file){

                try{

                        FileInputStream fileStream = new FileInputStream(file);
                        InputStreamReader input = new InputStreamReader(fileStream);
                        BufferedReader reader = new BufferedReader(input);
                        String line;
                        while ((line = reader.readLine())!=null)
                                if (!(line.equals(""))){
                                        lines++;
                                        regex.analyzeIpv4(line);
                                        regex.analyzeUsernames(line);

                                }//if
                }//try
                catch(FileNotFoundException e){

                        System.out.println("Cannot find the specified file");
                }//catch

                catch(IOException i){

                        System.out.println("Cannot read file");
                }//catch

        }//analyzeFile

}

