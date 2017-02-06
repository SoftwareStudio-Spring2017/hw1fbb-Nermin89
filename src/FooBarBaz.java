import java.util.Scanner;
import java.util.regex.*;
import java.util.regex.Matcher;
import java.io.*;

public class FooBarBaz {

    static String theRegex = "\\d[0-9]*";
    static int flag = 0; // a flag to print out the suitable message to the user
    static FileWriter fwriter;
    static BufferedWriter bwriter;
    static Boolean shouldStop = false;
    static File FileName;
    static int firstRun = 0;

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        userInput();
    }

    public static void userInput() {
        int number;

        if (flag == 0) {
            System.out.println("Enter a Number To Count Up To");
        }
        else {
            System.out.println('\n' + "Two Options:" + '\n'
                    + "1.Enter a Number To Count Up To" + '\n'
                    + "2. Type the word \"Stop\" to stop counting and print the result");
        }

        String word = readingInput();

        if (word.equalsIgnoreCase("stop")) // no matter how the user write it
                                           // with upper or lower or even a mix
                                           // of both
        {
            shouldStop = true;
            System.out.println("Stopped");
        }
        else {
            flag++;
            Pattern ptr = Pattern.compile(theRegex);
            Matcher regexmatcher = ptr.matcher(word);
            // Created the Regex to make sure that the input is only Integer.

            if (regexmatcher.find()) {
                number = Integer.valueOf(word); // converting the string input
                                                // to Integer

                if (number > 0) // handling edge case of Zero or less.
                {
                    try {
                        printFooBarGame(number);
                    }
                    catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                   
                }
                else {
                    invalidInput();
                    // Prompt the user to enter a number again
                    //userInput();
                }
            }
            else {
                invalidInput();
            }
        }
    }

    private static String readingInput() {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        return word;
    }

    private static void invalidInput() {
        System.out.println("Invalid Input, Please Enter Only Integers");
        userInput();
    }

    public static void printFooBarGame(int number) throws IOException {

        FileName = new File("foobarbaz.txt");

        try {

            if (firstRun == 0) {
                if (FileName.exists()) {
                    FileName.delete();
                }
                fwriter = new FileWriter(FileName, false);
                bwriter = new BufferedWriter(fwriter);
                firstRun++;

            }
            else {
                fwriter = new FileWriter(FileName, true);
                bwriter = new BufferedWriter(fwriter);
            }

            for (int i = 1; i <= number; i++) {
                boolean myFlag = false;

                if (i % 3 == 0) {
                    bwriter.write("Foo");
                    myFlag = true;
                }
                if (i % 5 == 0) {
                    bwriter.write("Bar");
                    myFlag = true;
                }
                if (i % 7 == 0) {
                    bwriter.write("Baz");
                    myFlag = true;
                }

                if (myFlag) {
                    bwriter.newLine();
                }
                else {
                    bwriter.write(String.valueOf(i)); // because the
                                                      // BufferedWriter print
                                                      // strings only
                    bwriter.newLine();
                }
            }
            
          
            
            

           

        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            if (bwriter != null) {
                bwriter.close();    
            }
            
            if (fwriter != null) {
                fwriter.close();
            }
        }
        userInput();
     
    }
}
