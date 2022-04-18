/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.controller;
import library.model.Patron;
import library.model.LibraryDatabase;

/**This is the controller for the use case that manages adding a new patron
 *
 * @author team 8
 */
public class PatronUseCase {
    
    /** Accessor for the one and only object of this class (singleton
     *  pattern)
     *
     *  @return the one and only object of this class
     */
    public static PatronUseCase getInstance() {
        if (thePatronUseCase == null)
            thePatronUseCase = new PatronUseCase();
        return thePatronUseCase;
    }

    /** Add a new Patron
       * @param firstName adding patron's first name
       * @param lastName adding patron's last name
       * @param address adding patron's address
       * @param phoneNumber adding patron's phone number
     */
    public void addPatron(String firstName, String lastName, String address, 
                          String phoneNumber)throws IllegalArgumentException {
        Patron patron = new Patron(firstName, lastName, address, phoneNumber);
        if(firstName.isEmpty()||lastName.isEmpty()||address.isEmpty()||phoneNumber.isEmpty()) {
            throw new IllegalArgumentException("Please enter all patron's informations");   
        } else {
            LibraryDatabase.getInstance().add(patron);
        }
    }
    
    /** Cancel this use case
     */
    public void cancel() {
    }
  /***************************************************************************
   * PRIVATE METHOD AND VARIABLES
   **************************************************************************/

  // Adding patron's all need information 
  private String firstName;
  private String lastName;
  private String address;
  private String phoneNumber;
  // Private constructor - other classes should access through the singleton
  // pattern
  private PatronUseCase() {
  }

  // Variable used for the singleton pattern
  private static PatronUseCase thePatronUseCase; 
}
