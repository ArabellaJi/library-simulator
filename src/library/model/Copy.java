/*
 *  Copy.java
 */

package library.model;

/** Representation for a single copy that can be checked out from the library
 * 
 * @author  Russell C. Bjork
 * 
 * MODIFIED BY:  Team 8
 */
public class Copy implements java.io.Serializable {
    
    /** Constructor
     * 
     *  @param item the item this is a copy of
     *  @param copyNumber the copy number of this copy of the item
     */
    public Copy(Item item, int copyNumber)
    {
        this.item = item;
        this.copyNumber = copyNumber;
    }
    
    /** Accessor for the item of which this is a copy
     * 
     * @param the item
     */
    public Item getItem()
    {
        return item;
    }
    
    /** Accessor for the copy number of this copy
     * 
     *  @return the copy number
     */
    public int getCopyNumber()
    {
        return copyNumber;
    }
    
    /** Check this copy out to a patron
     *
     *  @param patron the patron to check this item out to
     *  @param dateDue the date on which the it will be due
     */
    public void checkOutTo(Patron patron, SimpleDate dateDue)
    {
        // ? Do we need this
        this.patron = patron;
        this.dateDue = dateDue;
    }
    
    /** Get the patron to whom this copy is checked out
     * 
     *  @return the patron, or null if not checked out
     */
    public Patron getCheckedOutTo()
    {
        return patron;
    }
    
    /** Get the date this copy will be due if it is checked out now
     * 
     *  @return the date it will be due
     */
    public SimpleDate getDateWillBeDue() 
    {
        dateDue = dateCheckOut.daysLater(item.getCheckoutPeriod());
        return dateDue;
    }
    
    /** Get the date when this copy is due if it is already checked out
     * 
     *  @return the date due,
     */
    // ? 
    public SimpleDate getDateDue()
    {
        return dateDue;
    }
    
    /** Test to see whether this copy is checked out
     *
     *	@return true if this copy is checked out
     */
    public boolean isCheckedOut()
    {
        return patron != null;
    }
    
    /** Calculate the number of days this copy is overdue
     * 
     * @return the number of days overdue - 0 if not overdue
     * 
     * Precondition: only applicable if copy is currently checked out
     */
    public int daysOverdue()
    {
        if (SimpleDate.getToday().isAfter(getDateDue())) {
            return SimpleDate.getToday().daysAfter(getDateDue());
        } else {
            return 0;
        }
    }
    
    /** Renew this copy (to patron who currently has it out)
     *
     *	Precondition; this copy is checked out
     * 
     *  @return the new due date
     *  @exception IllegalArgumentException if this copy cannot be renewed
     *             because it is a copy of a non-renewable item, or has been
     *             renewed as many times as allowed, or is overdue.  (The
     *             message in the exception will specify the reason.)
     */
    public SimpleDate renew() throws IllegalArgumentException
    {
        if(item.getAllowedNumberOfRenewals() < 1) {
            throw new IllegalArgumentException("This is a copy of a "
                    + "non-renewable item");
        } else if(dateDue.isAfter(dateCheckOut.daysLater(item.getCheckoutPeriod()))) {
            throw new IllegalArgumentException("This copy has been "
                    + "renewed as many times as allowed.");
        } else if(SimpleDate.getToday().isAfter(dateDue)) {
            throw new IllegalArgumentException("This copy is overdue.");
        } else {
            dateDue = dateCheckOut.daysLater(2 * item.getCheckoutPeriod()); 
            return dateCheckOut.daysLater(2 * item.getCheckoutPeriod());
        }
    }
    
    /** Record the return of this book
     * 
     *  @return if overdue, the number of days overdue; 0 if it is returned on time
     */
    public int recordReturn()
    {
        patron = null;
        return daysOverdue();
    }
    
    private final Item item;
    private final int copyNumber;
    private Patron patron;
    private SimpleDate dateDue;
    private SimpleDate dateCheckOut = SimpleDate.getToday();
    static final long serialVersionUID = 1;
}