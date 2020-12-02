import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * BooksTester implements taking an arraylist of an input of book title,author name, and
 * outputs it to a .txt file. It also takes the goal of the number of books the user wants to read
 * for the year and gives the remaining numberof books until the user reaches their reading goal  
 */
public class BooksTester {
    private static int goalInput = 30;

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        while (true){
        System.out.println("Enter (end) to exit");
        System.out.println("MENU: enter an option : (add books) ,(see goal), (see list) ");
        String option = scan.nextLine();
        if (option.equals("end")) {
           break; 
        }  else if (option.equals("add books")) {
            booksList();
            System.out.println();
        } else if (option.equals("see goal")) {
            bookGoal();
        } else if (option.equals("see list")){
            readBookList();
        }
        
    }
    scan.close();
}
    /**
     * bookGoal() outputs the goal number to the .txt file 
     *
     * @throws FileNotFoundException
     */
    public static void bookGoal() throws FileNotFoundException {
        
        System.out.println("You want to read " + goalInput + " books for 2020");
        
        FileOutputStream fos = new FileOutputStream("Books.txt", true);
        PrintWriter pw = new PrintWriter(fos);
        pw.println("Goal: " + goalInput + " books");
        pw.close();
       
    }
    /**
     * booksList() creates ArrayList, takes in input of book info,and outputs it to .txt file
     */
    public static void booksList() {
        Scanner scan = new Scanner(System.in);
        ArrayList<Books> lists = new ArrayList<>();
        while (true) {
            System.out.println("Enter end to go back to menu");
            System.out.println("Enter Book Title: ");
            String bookName = scan.nextLine();
            if (bookName.equals("end")) {
                break;
            } 

            System.out.println("Enter the author's name: ");
            String bookAuthor = scan.nextLine();
            if (bookAuthor.equals("end")) {
                break;
            } 
            System.out.println("Enter a number 1 to 5, to rate book, with five being the highest: ");
            int bookRating = Integer.valueOf(scan.nextLine());
            
            Books B1 = new Books(bookName, bookAuthor, bookRating);
            B1.setTitle(bookName);
            B1.setAuthor(bookAuthor);
            B1.setRating(bookRating);

            lists.add(B1);

            for (Books list : lists) {
                System.out.println(list);
            }
        }
             try {
                FileOutputStream writeToFile = new FileOutputStream("Books.txt", true);
                PrintWriter printToFile = new PrintWriter(writeToFile);
                for (Books list : lists) {
                    printToFile.print(list);
                    printToFile.println();
                    printToFile.flush();

            }
                    printToFile.close();
            } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            scan.close();
        }
       
    }
    /**
     * reaBookList() reads the .txt file, counts how many books read, and how many
     * books remaining until goal is reached
     * @throws IOException
     */
    public static void readBookList() throws IOException {
        int count = 0;
        FileInputStream readFile = new FileInputStream("Books.txt");
        Scanner scan = new Scanner(readFile);
        while(scan.hasNextLine()){
        System.out.println(scan.nextLine());
        count++;
        }
       int  numOfBooks = count - 1 ;
        readFile.close();
        scan.close();
        System.out.println("You have read: " + numOfBooks + " books");
        
        if(numOfBooks == goalInput){
            System.out.println("Congrats!!! YOU READ " + goalInput + " books for 2020");
        } else {
            System.out.println("You have " + (goalInput - numOfBooks) + " books to read to meet your 2020 goal");
        }
    }
}


    



    

  

