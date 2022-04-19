/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.controller;

import library.model.Book;
import library.model.DVD;
import library.model.Item;
import library.model.LibraryDatabase;

/**This is the controller for the use case that manages adding a new Item
 *
 * @author team 8
 */
public class ItemUseCase {
  /** Accessor for the one and only object of this class (singleton
   *  pattern)
   *
   *  @return the one and only object of this class
   */
  public static ItemUseCase getInstance() {
    if (theItemUseCase == null)
      theItemUseCase = new ItemUseCase();
    return theItemUseCase;
  }
  
  /** Start the use case
   *
   */
  public void start() {
  }
  
  /** Add a new Patron
     * @param callNumber call number of adding book
     * @param title title of adding book
     * @param author author of adding book
   */
  public void addBook(String callNumber, String title, String author)throws IllegalArgumentException {
    Item book = new Book (callNumber,
                          title,
                          author);
    if(callNumber.isEmpty()||title.isEmpty()||author.isEmpty()) {
      throw new IllegalArgumentException("Please enter all informations of the book");   
    } else {
        LibraryDatabase.getInstance().add(book);
        //System.out.println( LibraryDatabase.getInstance().getPatronList().size());
    }
  }  
  /** Add a new DVD
     * @param callNumber call number of adding DVD
     * @param title title of adding DVD
     * @param leaderActor leader actor of DVD
     * @param rating rating of adding DVD
   */
  public void addDvd(String callNumber, String title, String leaderActor, String rating)throws IllegalArgumentException {
    Item dvd = new DVD (callNumber,
                          title,
                          leaderActor,
                          rating);
    if(callNumber.isEmpty()||title.isEmpty()||leaderActor.isEmpty()||rating.isEmpty()) {
      throw new IllegalArgumentException("Please enter all informations of the DVD");   
    } else {
        LibraryDatabase.getInstance().add(dvd);
        //System.out.println( LibraryDatabase.getInstance().getPatronList().size());
    }
  }  
  
  
  /** Cancel this use case
   */
  public void cancel() {
  }
  

  /***************************************************************************
   * PRIVATE METHOD AND VARIABLES
   **************************************************************************/

  // All need information of adding book and dvd
  private String callNumber;
  private String title;
  private String author;
  private String leaderActor;
  private String rating;
  // Private constructor - other classes should access through the singleton
  // pattern
  private ItemUseCase() {
  }

  // Variable used for the singleton pattern
  private static ItemUseCase theItemUseCase; 
}
