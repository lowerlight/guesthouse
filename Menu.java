/**************************************************************************************************/
//
//  Project : Kalong Bay Guesthouse Reservation and Logistic System
//  Filename : Menu.java
//  Author : Jeffrey Nursalim
//  Student No: TP031319
//  Module Code & Title: CE00204-7 Object-Oriented Software Systems Engineering
//  Due Date : 15 July 2013
//
/**************************************************************************************************/
import java.util.Scanner;
import java.math.BigDecimal;

public abstract class Menu
{
    Scanner kybd = new Scanner(System.in);
    String user;
    int stat = 1;

    //Template Method DP
    public int displayMenu()
    {
        //Step0: Setup menu choices
        setupAndDisplayMenu();

        //Step1: Display menu and wait for input
        waitForInput();

        //Step2: (Only for Some) Display Filled-in values and wait for Confirmation
        waitForConfirmation();

        //Step3: Execute the action(incl invoking another menu/form instead)
        runNextMenuOrAction();

        //Step4: Go back to parent menu
        goBackToParentMenu();

        return stat;
    }

    abstract protected void setupAndDisplayMenu();

    abstract protected void waitForInput();

    abstract protected void waitForConfirmation();

    abstract protected void runNextMenuOrAction();

    protected void goBackToParentMenu()
    {
        System.out.println("Menu.goBackToParentMenu");
    }
}
