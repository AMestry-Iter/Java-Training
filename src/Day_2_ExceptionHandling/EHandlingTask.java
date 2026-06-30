package Day_2_ExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class InvalidAgeException extends Exception{
    public InvalidAgeException(String m){
        super(m);
    }
}

public class EHandlingTask {
    public static void StrNum(String num) {
        try {
            int count = Integer.parseInt(num);
            System.out.println(count);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid number string.");
        }
    }

    public static void validateAge(int age) throws InvalidAgeException {

            if(age<18){
                throw new InvalidAgeException("Age should be 18 or above.");
            }

        System.out.println("Valid Age: " +age);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        try {
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Excepetion caught: " +e);
        }finally {
            System.out.println("The block executes anyway");
        }

        StrNum("5");
        StrNum("A");

        try{
            validateAge(12);
        } catch (InvalidAgeException e) {
            System.out.println("Caught Exception: " +e.getMessage());
        }

        try{
            validateAge(19);
        } catch (InvalidAgeException e) {
            System.out.println("Caught Exception: " +e.getMessage());
        }


        try{
            int numbers[] = {10,20,30};
            String s = null;
            System.out.println(numbers[9]);
            System.out.println(s.length());


        }catch(NullPointerException e){
            System.out.println("Excepetion caught: " +e);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Excepetion caught: " +e);
        }

        try{
            File obj = new File("Students.txt");
            Scanner sc = new Scanner(obj);
            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
            sc.close();
        }catch(FileNotFoundException e){
            System.out.println("File not Found.");
        }






    }
}
