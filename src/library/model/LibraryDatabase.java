/*
 *  LibraryDatabase.java
 */

package library.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/** A singleton object of this class represents the library's database
 *
 * @author  Russell C. Bjork
 * 
 * MODIFIED BY:  Team 8
 */
public class LibraryDatabase implements java.io.Serializable
{
    /** Accessor for the one and only object of this class (singleton
     *  pattern)
     *
     *  @return the one and only object of this class
     */
    public static LibraryDatabase getInstance()
    {
        if (theLibraryDatabase == null)
        {
            try {
                ObjectInputStream stream = new ObjectInputStream(
                    new FileInputStream(SAVED_DATABASE_NAME));
                theLibraryDatabase = (LibraryDatabase) stream.readObject();
                stream.close();
            }
            catch(FileNotFoundException e) {
                theLibraryDatabase = new LibraryDatabase();
            }
            catch(Throwable e) {
                System.err.println("Unexpected exception " + e);
                e.printStackTrace(System.err);
                System.exit(1);
            }
        }
        return theLibraryDatabase;
    }
    
    /** Get a Tree map of call numbers of all items 
     *
     *  @return the set coutain all items' call number 
     */  
    public  TreeMap<String, Item> getItemList()
    {
        return items;
    }
      
    /** Get a Tree map of call numbers of all items 
     *
     *  @return the set coutain all items' call number 
     */  
    public  Set<Map.Entry<String, Item>> getItemEntry()
    {
        return items.entrySet();
    }

    /** Get a Tree map of all patrons 
     *
     *  @return the set coutain all patrons
     */  
    public  TreeMap<String, Patron> getPatronList()
    {
        return patrons;
    }

    /** Get a Tree map of all patrons 
     *
     *  @return the set coutain all patrons
     */  
    public  Set<Map.Entry<String, Patron>> getPatronEntry()
    {
        return patrons.entrySet();
    }
    
    /** Save the library database
     *
     *  @exception Exception any Exception thrown during the save is propagated
     */
    public void save() throws Exception
    {
        library.gui.GUI.getInstance().showMessage("Saving of data not yet enabled");
        ObjectOutputStream stream = new ObjectOutputStream(
                    new FileOutputStream(SAVED_DATABASE_NAME));
        stream.writeObject(theLibraryDatabase);
        stream.close();
    }
        
    /** Add a patron to the list of patrons
     * 
     *  @param patron the patron to add
     *	@exception IllegalArgumentException if a patron with this phone number is
     *			   already in the database
     */
    public void add(Patron patron) throws IllegalArgumentException
    {   
        if(patrons.containsKey(patron.getPhoneNumber())) {
            throw new IllegalArgumentException("This patron with entered phone number already exist");
        } else {
            patrons.put(patron.getPhoneNumber(), patron);
        } 
    }
    
    /** Add an item to the list of items
     * 
     *  @param item the item to add
     *	@exception IllegalArgumentException if an item with this call number is
     *			   already in the database
     */
    public void add(Item item) throws IllegalArgumentException
    {
        if(items.containsKey(item.getCallNumber())) {
            throw new IllegalArgumentException("This item already exist");
        } else {
            items.put(item.getCallNumber(), item);
        }
    }
    
    /** Get the patron having a given phone number
     * 
     *  @param phoneNumber the phone number of the patron
     *  @return the patron having this phone number
     *  @exception IllegalArgumentException if this patron does not exist
     */
    public Patron getPatron(String phoneNumber)
    {
        if(patrons.containsKey(phoneNumber)) {
            return patrons.get(phoneNumber);
        } else {
            throw new IllegalArgumentException("This patron does not exist");
        }
    }
    
    /** Get the item having a given call number
     * 
     *  @param callNumber the call number of the item
     *  @return the patron having this phone number
     *  @exception IllegalArgumentException if this item does not exist
     */
    public Item getItem(String callNumber)
    {
        if(!items.containsKey(callNumber)) {
            throw new IllegalArgumentException("This item does not exist.");
        } else {
            return items.get(callNumber);
        }
    }
    
    /** Get the copy having a given call number and copy number
     * 
     *  @param callNumber the call number of the copy
     *  @param copyNumber the copy number of the copy
     *  @return the copy having this call number and copy number
     *  @exception IllegalArgumentException if this copy does not exist
     */
    public Copy getCopy(String callNumber, int copyNumber)
    {
        if(!items.containsKey(callNumber)){
            throw new IllegalArgumentException("This Item does not exist");
        } else {
            return items.get(callNumber).getCopy(copyNumber);
        }
    }
    
    // Private constructor.  Other classes should access through the singleton
    // pattern
    private LibraryDatabase() 
    {
        patrons = new TreeMap<String, Patron>();
        items = new TreeMap<String, Item>();  
        theLibraryDatabase = this;
        createDummyData();
    }
    
    // Populate the database with dummy data.  Needed only until code for
    // adding patrons, etc. has been written
    private void createDummyData() 
    {
        Patron aardvark = new Patron("Anthony", 
                                     "Aardvark", 
                                     "Jenks Subbasement",
                                     "1");
        add(aardvark);
        
        Patron buffalo = new Patron("Boris", 
                                    "Buffalo", 
                                    "Hamilton Common",
                                    "2");
        add(buffalo);
        
        Patron cat = new Patron("Charlene",
                                "Cat",
                                "20 Litterbox Lane",
                                "3");
    	add(cat);
        
        Patron dog = new Patron("Donna",
                                "Dog",
                                "Fire Hydrant",
                                "4");
		add(dog);
        
		Book oo = new Book("QA","A Student Guide to OO Development",
						"Britton and Doake"); 
        add(oo);
        Copy op1 = oo.makeCopy();
        Copy oo2 = oo.makeCopy();
        
        DVD shrek = new DVD("PN", "Shrek", "Myers, Mike", "PG");
        add(shrek);
        Copy shrek1 = shrek.makeCopy();
        Copy shrek2 = shrek.makeCopy();
        
        DVD hobbit = new DVD("YA", "The Hobbit", "Freeman, Martin", "PG" );
        add(hobbit);
        Copy hobbit1 = hobbit.makeCopy();
        Copy hobbit2 = hobbit.makeCopy();
        
   }
    
    // The one and only instance of this class
    private static LibraryDatabase theLibraryDatabase;
        
    // Name to use for saved database
    private static final String SAVED_DATABASE_NAME = "library.database";

    // Symbolic constant needed to prevent unnecessary ClassCastExceptions
    // when reading a serialized object created by an earlier version of this
    // class
    static final long serialVersionUID = 1;
    private TreeMap<String, Patron> patrons;
    private TreeMap<String, Item> items;
}
