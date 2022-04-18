/*
 * ReturnUseCase.java
 */

package library.controller;

import library.model.Copy;

/**
 *
 * @author wenla
 */
public class ReturnUseCase {

    /** Return the copy
     *
     *  @param copy the copy to be returned
     *  @exception IllegalArgumentException if the copy is not checked out
     */
    public static void perform(Copy copy) throws IllegalArgumentException {
        if(!copy.isCheckedOut()) {
            throw new IllegalArgumentException("The copy is not checked out.");
        } else {
            copy.getCheckedOutTo().returnCopy(copy);
            copy.recordReturn();
        }   
    }

    /***************************************************************************
     * PRIVATE METHOD AND VARIABLES
     **************************************************************************/


    // The list of copy to be returned

    // Private constructor - other classes should access through the singleton
    // pattern
    private ReturnUseCase() {
    }

    // Variable used for the singleton pattern
    private static ReturnUseCase theReturnUseCase;
}
