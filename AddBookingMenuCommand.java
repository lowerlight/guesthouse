/**************************************************************************************************/
//
//  Project : Kalong Bay Guesthouse Reservation and Logistic System
//  Filename : AddBookingMenuCommand.java
//  Author : Jeffrey Nursalim
//  Student No: TP031319
//  Module Code & Title: CE00204-7 Object-Oriented Software Systems Engineering
//  Due Date : 15 July 2013
//
/**************************************************************************************************/
public class AddBookingMenuCommand implements Command
{
    //Command DP: ConcreteCommand
    private ChaletBooking booking;

    public AddBookingMenuCommand(ChaletBooking bk)
    {
        this.booking = bk;
    }

    public void execute()
    {
        booking.addChaletBooking();
    }
}