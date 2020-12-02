/**
 * Books class contains contructor,instance variables,setters, and tostring() method for 
 * BooksTester class
 * 
 * 
 * @author Calice
 * 
 */

public class Books {
    private String title;
    private String author;
    private int rating; 
     
    /**
     * Initialize instance variables
     * @param title
     * @param author
     * @param rating
     */

    public Books(String title, String author, int rating) {
        this.title = title;
        this.author = author; 
        this.rating = rating; 
    }

    /**
     * setter for title
     * @param title
     */
    public void setTitle(String title){
        this.title = title;
    }
    /**
     * setter for author
     * @param author
     */
    public void setAuthor(String author){
        this.author = author;
    }

    /**
     * setter for rating
     * @param rating
     */
    public void setRating(int rating){
        this.rating = rating;
    }

    /**
     * toString() method to print string outputs
     */
    public String toString() {
        return this.title + ",  " + this.author + ",  " + "   " + this.rating;

    }
    

}
