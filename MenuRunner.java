/**************************************************************************************************/
//
//  Project : Kalong Bay Guesthouse Reservation and Logistic System
//  Filename : MenuRunner.java
//  Author : Jeffrey Nursalim
//  Student No: TP031319
//  Module Code & Title: CE00204-7 Object-Oriented Software Systems Engineering
//  Due Date : 15 July 2013
//
/**************************************************************************************************/
public class MenuRunner
{
    //Command DP: Invoker
    public void runMenuOrAction(Command cmd)
    {
       cmd.execute();
    }
}
