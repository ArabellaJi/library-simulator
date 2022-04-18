/*
 * RenewalUseCase.java
 */
package library.controller;

import library.model.Copy;

/**
 *
 * @author wenla
 */
public class RenewalUseCase {

    /** Renew all copies currently in the list to the patron
     *
     *  @param copy the copy to be renewed 
     *  @exception IllegalArgumentException if the copy is not checked out
     */
    public static void perform(Copy copy) throws IllegalArgumentException  {
        if(!copy.isCheckedOut()) {
            throw new IllegalArgumentException("The copy is not checked out.");
        } else {
            copy.renew();
        }
    }

    /***************************************************************************
     * PRIVATE METHOD AND VARIABLES
     **************************************************************************/

    // Private constructor - other classes should access through the singleton
    // pattern
    private RenewalUseCase() {
    }

    // Variable used for the singleton pattern
    private static RenewalUseCase theRenewalUseCase;
}
