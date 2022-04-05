/*
 *  DVD.java
 */

package library.model;

/** Representation for a DVD
 * 
 * @author  Russell C. Bjork
 * 
 * MODIFIED BY:  Team 8
 */
public class DVD extends Item implements java.io.Serializable {
    
    /** Constructor
     * 
     *  @param callNumber the call number of this DVD
     *  @param title the title of this DVD
     *  @param leadActor the lead actor of this DVD
     *	@param rating the rating of this DVD
     */
    public DVD(String callNumber, String title, String leadActor, String rating)
    {
        super(callNumber, title);
        this.leadActor = leadActor;
        this.title = title;
        this.rating = rating;        
    }
    
    // Implementation of abstract methods of base class
    
    public String getDescription()
    {
        return title + " (DVD)";
    }
    
    public int getCheckoutPeriod()
    {
        return 7;
    }
      
    public int getAllowedNumberOfRenewals()
    {
        return 0;
    }
    static final long serialVersionUID = 1;
    private final String title;
    private final String leadActor;
    private final String rating;
}
