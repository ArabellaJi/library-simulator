/*
 * GUI.java
 *
 * The main GUI is a frame that uses a card layout to display a single
 * card at a time.  Each card belongs to a class called ___Card (e.g.
 * MainCard is the primary card for the GUI).   Each card has a name
 * that can be used when asking to show that particular card - e.g. the
 * name of the main card is "main".  The various cards are added by
 * the calls to "addCard" in the constructor for the frame.  (To add
 * another card to the GUI, an "addCard" call must be added for it.)
 * A history mechanism allows going back from any card to the card that
 * was showing just before it was last shown - but only one deep - i.e.
 * for any card only its immediate predecessor is recorded.
 * 
 */

package library.gui;
import library.controller.Main;
import library.controller.LoginOutUseCase;

/** Main GUI for the Library project
 *
 * @author  Russell C. Bjork
 * 
 * MODIFIED BY: 
 */
public class GUI extends javax.swing.JFrame 
{
    /** Accessor for the one and only object of this class (singleton pattern)
     *
     *  @return the one and only object of this class
     */
    public static GUI getInstance()
    {
        if (theGUI == null)
            theGUI = new GUI();
        return theGUI;
    }
    
    /** Show a specific card.  The name of the card that was showing
     *  (if it is different from that specified) is remembered to
     *  allow returning to it
     *
     *  @param name the name of the card to show.  (If no such card
     *         exists, nothing happens)
     */
    public void gotoCard(String name) 
    {
        if (! name.equals(currentCardName)) 
        {
            history.put(name, currentCardName);
            currentCardName = name;
            ((java.awt.CardLayout) getContentPane().getLayout()).
                    show(getContentPane(), name);
        }
    }
    
    /** Go back to the card that was showing just before the current
     *  card was shown with gotoCard().  (If there is no such card, 
     *  nothing happens).
     */
    public void goBack() 
    {
        String last = history.get(currentCardName);
        if (last != null && last != currentCardName) 
        {
            currentCardName = last;
            ((java.awt.CardLayout) getContentPane().getLayout()).
                   show(getContentPane(), last);
        }
    }
   
    /** Show a message to the user in a popup dialog
     *
     *  @param message the message to show.  Can be null or an empty String, in
     *         which case nothing is actually shown
     */
    public void showMessage(String message) 
    {
        if (message != null && message.length() > 0)
            javax.swing.JOptionPane.showMessageDialog(this, message);
    }
    
    /** Ask the user a question that expects a short answer
     *  via a popup dialog
     *
     *  @param question the question to ask
     *  @return the user's answer; null if the user cancelled or closed
     *          the dialog instead of answering
     */
    public String askQuestion(String question)
    {
        return javax.swing.JOptionPane.showInputDialog(this, question);
    }
      
    /** Ask the user a yes-no question via a popup dialog
     *
     *  @param question the question to ask
     *  @return true if the user answered yes, false if no or the user
     *          closed the dialog instead of answering
     */
    public boolean askYesNoQuestion(String question)
    {
        return javax.swing.JOptionPane.showConfirmDialog(this, question,
                    "Select an Option", javax.swing.JOptionPane.YES_NO_OPTION) ==
                javax.swing.JOptionPane.YES_OPTION;
    }
      
    /** Request a password
     * 
     *  @return the password entered - or null if none entered
     */
     public String requestPassword()
     {
         PasswordDialog passwordDialog = new PasswordDialog(this, true);
         passwordDialog.setVisible(true);
         String result = passwordDialog.getPassword();
         return result;
     }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        swingMenuBar = new javax.swing.JMenuBar();
        swingFileMenu = new javax.swing.JMenu();
        swingSaveItem = new javax.swing.JMenuItem();
        swingQuitItem = new javax.swing.JMenuItem();
        swingDateMenu = new javax.swing.JMenu();
        swingDiddleItem = new javax.swing.JMenuItem();
        managerMenu = new javax.swing.JMenu();
        loginItem = new javax.swing.JMenuItem();
        logoutItem = new javax.swing.JMenuItem();

        swingFileMenu.setMnemonic('F');
        swingFileMenu.setText("File");

        swingSaveItem.setAccelerator(keystroke(java.awt.event.KeyEvent.VK_S, 0));
        swingSaveItem.setText("Save");
        swingSaveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveItemActionPerformed(evt);
            }
        });
        swingFileMenu.add(swingSaveItem);

        swingQuitItem.setAccelerator(keystroke(java.awt.event.KeyEvent.VK_Q, 0));
        swingQuitItem.setText("Quit");
        swingQuitItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitItemActionPerformed(evt);
            }
        });
        swingFileMenu.add(swingQuitItem);

        swingMenuBar.add(swingFileMenu);

        swingDateMenu.setMnemonic('D');
        swingDateMenu.setText("Date");

        swingDiddleItem.setAccelerator(keystroke(java.awt.event.KeyEvent.VK_D, 0));
        swingDiddleItem.setText("Diddle");
        swingDiddleItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diddleItemActionPerformed(evt);
            }
        });
        swingDateMenu.add(swingDiddleItem);

        swingMenuBar.add(swingDateMenu);

        managerMenu.setText("Manager");

        loginItem.setText("Login");
        loginItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginItemActionPerformed(evt);
            }
        });
        managerMenu.add(loginItem);

        logoutItem.setText("Logout");
        logoutItem.setEnabled(false);
        logoutItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutItemActionPerformed(evt);
            }
        });
        managerMenu.add(logoutItem);

        swingMenuBar.add(managerMenu);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("CPS122 Library Project");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.CardLayout());

        setSize(new java.awt.Dimension(600, 500));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosing
    {//GEN-HEADEREND:event_formWindowClosing
        Main.getInstance().quitProgram();
    }//GEN-LAST:event_formWindowClosing

    private void saveItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_saveItemActionPerformed
    {//GEN-HEADEREND:event_saveItemActionPerformed
        try
        {
            Main.getInstance().saveLibraryDatabase();
        }
        catch(Exception e)
        {
            showMessage(e.getMessage());
        }
    }//GEN-LAST:event_saveItemActionPerformed

    private void quitItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_quitItemActionPerformed
    {//GEN-HEADEREND:event_quitItemActionPerformed
        Main.getInstance().quitProgram();        
    }//GEN-LAST:event_quitItemActionPerformed

    private void diddleItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_diddleItemActionPerformed
    {//GEN-HEADEREND:event_diddleItemActionPerformed
        gotoCard("date");
    }//GEN-LAST:event_diddleItemActionPerformed

    private void loginItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginItemActionPerformed
       String password = requestPassword();
       if (password != null)
           try
           {

               LoginOutUseCase.getInstance().doLogin(password);
               if (LoginOutUseCase.getInstance().isManagerLoggedIn())
               {
                   loginItem.setEnabled(false);
                   logoutItem.setEnabled(true);
               }
           }
           catch(IllegalArgumentException e)
           {
               showMessage(e.getMessage());
           }
    }//GEN-LAST:event_loginItemActionPerformed

    private void logoutItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutItemActionPerformed
       LoginOutUseCase.getInstance().doLogout();
       if (! LoginOutUseCase.getInstance().isManagerLoggedIn())
       {
           loginItem.setEnabled(true);
           logoutItem.setEnabled(false);
       }
    }//GEN-LAST:event_logoutItemActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem loginItem;
    private javax.swing.JMenuItem logoutItem;
    private javax.swing.JMenu managerMenu;
    private javax.swing.JMenu swingDateMenu;
    private javax.swing.JMenuItem swingDiddleItem;
    private javax.swing.JMenu swingFileMenu;
    private javax.swing.JMenuBar swingMenuBar;
    private javax.swing.JMenuItem swingQuitItem;
    private javax.swing.JMenuItem swingSaveItem;
    // End of variables declaration//GEN-END:variables
    
    /***************************************************************************
     * PRIVATE METHODS AND VARIABLES
     **************************************************************************/
    
    /** Create a platform-independent keystroke for menu accelerators
     *
     *  @param key the menu key
     *  @param modifiers other keys that must be pressed with this key - other
     *         than the platform specific prefix (e.g. control on many
     *         platforms, command on Macintoshes)
     *  @return a KeyStroke object representing this selection
     */
    private static javax.swing.KeyStroke keystroke(int key, int modifiers) 
    {
        return javax.swing.KeyStroke.getKeyStroke(key, 
            java.awt.Toolkit.getDefaultToolkit().getMenuShortcutKeyMask() | 
                modifiers);
    }
    
    // Private constructor - other classes should access through the singleton
    // pattern
    private GUI() 
    {
        initComponents();
        managerMenu.setVisible(false);
        setJMenuBar(swingMenuBar);

        // Add the individual cards.  The first card added will
        // be the one showing at startup
        
        getContentPane().add(new MainCard(), "main");
        getContentPane().add(new DateCard(), "date");
        getContentPane().add(new CheckoutDetailsCard(), "checkoutdetails");
        
        currentCardName = "main";
        history = new java.util.HashMap<String, String>();
     }
    
    // The card currently showing
    private String currentCardName;
    // The prior card for each card
    private java.util.HashMap<String, String> history; 
    // The one and only instance of the GUI  
    private static GUI theGUI;
}
