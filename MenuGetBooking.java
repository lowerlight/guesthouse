/**************************************************************************************************/
//
//  Project : Kalong Bay Guesthouse Reservation and Logistic System
//  Filename : MenuGetBooking.java
//  Author : Jeffrey Nursalim
//  Student No: TP031319
//  Module Code & Title: CE00204-7 Object-Oriented Software Systems Engineering
//  Due Date : 15 July 2013
//
/**************************************************************************************************/
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuGetBooking extends Menu
{
    String chaletName;
    java.util.Date dt;
    Date startDate;
    Date endDate;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    protected void setupAndDisplayMenu()
    {
        //Do nothing
    }

    protected void waitForInput()
    {
        format.setLenient(false);

        System.out.println("Type the chalet name here: ");
        chaletName = kybd.next();

        System.out.println("Type the start date here as yyyy-MM-dd: ");
        try
        {
            dt = format.parse(kybd.next());
            startDate = new Date(dt.getTime());
        }
        catch(java.text.ParseException e)
        {
            Logger lgr = Logger.getLogger(MenuAddBooking.class.getName());
            lgr.log(Level.WARNING, e.getMessage(), e);
        }

        System.out.println("Type the end date here as yyyy-MM-dd: ");
        try
        {
            dt = format.parse(kybd.next());
            endDate = new Date(dt.getTime());
        }
        catch(java.text.ParseException e)
        {
            Logger lgr = Logger.getLogger(MenuAddBooking.class.getName());
            lgr.log(Level.WARNING, e.getMessage(), e);
        }
    }

    protected void waitForConfirmation()
    {
        //Do nothing
    }

    protected void runNextMenuOrAction()
    {
        //Command DP: Client
        ChaletBooking newBooking = new ChaletBooking(chaletName, null, startDate, endDate, null, null, false, null, false);
        Command getBookingMenuCmd = new GetBookingMenuCommand(newBooking);
        MenuRunner myMenuRunner = new MenuRunner();
        myMenuRunner.runMenuOrAction(getBookingMenuCmd);
    }
}
