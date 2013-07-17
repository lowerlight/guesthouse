/**************************************************************************************************/
//
//  Project : Kalong Bay Guesthouse Reservation and Logistic System
//  Filename : Menu1stLevel.java
//  Author : Jeffrey Nursalim
//  Student No: TP031319
//  Module Code & Title: CE00204-7 Object-Oriented Software Systems Engineering
//  Due Date : 15 July 2013
//
/**************************************************************************************************/
import java.util.Scanner;

public class Menu1stLevel extends Menu
{
    public enum MenuName
    {
        //MANAGEMEMBER(10, "Manage Member-Add Member/Delete Member/Update Balance"),
        ADDMEMBER(11),
        DELETEMEMBER(12),
        UPDATEBALANCE(13),

        //MANAGEBOOKING(20),
        ADDBOOKING(21),
        GETBOOKING(22),
        DELETEBOOKING(23),

        //MANAGEROOM(30),
        SETROOMINSPECTION(31),

        //CHECKINCHECKOUT(40),
        CHECKIN(41),
        CHECKOUT(42),

        LOGOUT(99);

        private int number;

        MenuName(int nbr)
        {
            this.number = nbr;
        }
    }

    MenuName choices;
    static int chosen;

    protected void setupAndDisplayMenu()
    {
        System.out.println("Menu Choices:");
        for(MenuName mn : choices.values())
        {
            System.out.println(mn.number + " " + mn);
        }
    }

    protected void waitForInput()
    {
        System.out.println("Type your menu choice here: ");
        chosen = kybd.nextInt();
    }

    protected void waitForConfirmation()
    {
        //Do nothing
    }

    protected void runNextMenuOrAction()
    {
        //Command DP: Client
        if(chosen == choices.LOGOUT.number)
        {
            stat = 0;
        }

        //if userid == 'reservationManager'
        //accept these inputs

        if(chosen == choices.ADDMEMBER.number)
        {
            MenuAddMember mm = new MenuAddMember();
            mm.displayMenu();
        }
        if(chosen == choices.ADDBOOKING.number)
        {
            MenuAddBooking mm = new MenuAddBooking();
            mm.displayMenu();
        }
        if(chosen == choices.GETBOOKING.number)
        {
            MenuAddBooking mm = new MenuAddBooking();
            mm.displayMenu();
        }

        //if userid == 'logisticsManager'
        //accept these inputs below
        //:
        //:
    }
}
