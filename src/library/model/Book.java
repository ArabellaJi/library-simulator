/*
 *  Book.java
 */

package library.model;

/** Representation for a book
 * 
 * @author  Russell C. Bjork
 * 
 * MODIFIED BY:  Team 8
 */
public class Book extends Item implements java.io.Serializable {
    
    /** Constructor
     * 
     *  @param callNumber the call number of this book
     *  @param title the title of this book
     *  @param author the principal author of this book
     */
    public Book(String callNumber, String title, String author)
    {
        super(callNumber, title);
        this.callNumber = callNumber;
        this.title = title;
        this.author = author;
    }
    
    // Implementation of abstract methods of base class
    @Override
    public String getDescription()
    {
        return title;
    }
    
    @Override
    public int getCheckoutPeriod()
    {
        return 28;
    }
      
    @Override
    public int getAllowedNumberOfRenewals()
    {
        return 1;
    }
    
    static final long serialVersionUID = 1;
    private final String title;
    private final String callNumber;
    private final String author;
}
