/*
 * Patron.java
 */

package library.model;
import java.util.ArrayList;
import java.util.Iterator;

/** Representation for a library patron
 * 
 * @author  Russell C. Bjork
 * 
 * MODIFIED BY:  Team 8
 */
public class Patron implements java.io.Serializable {
    
    /** Constructor
     * 
     *  @param firstName the first name of the patron
     *  @param lastName the last name of the patron
     *  @param address the address of the patron
     */
    public Patron(String firstName, 
                  String lastName, 
                  String address,
                  String phoneNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        checkoutList = new ArrayList<Copy>();
    }
    
    /** Accessor for the full name of this patron
     *
     *	@return the full name (first and last)
     */
    public String getFullName()
    {
        return firstName + " " + lastName;
    }
    
    /** Accessor for the phone number of this patron
     * 
     *  @return the phone number
     */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    
    /** Accessor for the number of copies currently checked out to this patron
     * 
     *  @return the number of copies currently out
     */
    public int getCurrentCopiesOut()
    {
        return checkoutList.size();
    }

    /** Get the number of copies currently checked out that are overdue
     *  
     *  @return the number overdue
     */
    public int getNumberOverdue()
    {
    int number = 0;
    for (int i = 0; i < getCurrentCopiesOut(); i++) {
      if (checkoutList.get(i).getDateDue().isAfter(SimpleDate.getToday())) {
        number++;
      }
    }
    return number;
    }
    
    /** Check out a copy to this patron
     * 
     *  @param copy the copy being checked out
     */
    public void checkOut(Copy copy)
    {
        checkoutList.add(copy);
    }
    
    /** Return a copy that was checked out to this patron
     * 
     *  @param copy the copy to return
     */
    public void returnCopy(Copy copy)
    {
        checkoutList.remove(copy);
    }
    
    /** Get an iterator over all the copies this patron has checked out
     * 
     *  @return an iterator
     */
    public Iterator<Copy> getCopiesCheckedOut()
    {
        return checkoutList.listIterator();
    }
    
    static final long serialVersionUID = 1;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String phoneNumber;
    private final ArrayList<Copy> checkoutList;
}