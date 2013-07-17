/**************************************************************************************************/
//
//  Project : Kalong Bay Guesthouse Reservation and Logistic System
//  Filename : MenuAddMember.java
//  Author : Jeffrey Nursalim
//  Student No: TP031319
//  Module Code & Title: CE00204-7 Object-Oriented Software Systems Engineering
//  Due Date : 15 July 2013
//
/**************************************************************************************************/
import java.math.BigDecimal;

import java.util.Scanner;

public class MenuAddMember extends Menu
{
    String name;
    String strBalance;

    protected void setupAndDisplayMenu()
    {
        //Do nothing
    }

    protected void waitForInput()
    {
        System.out.println("Type the new member name here (only single name accepted): ");
        name = kybd.next();

        System.out.println("Type the new member balance here: ");
        strBalance = kybd.next();
    }

    protected void waitForConfirmation()
    {
        //Do nothing
    }

    protected void runNextMenuOrAction()
    {
        //Command DP: Client
        Member newMember = new Member(name, new BigDecimal(strBalance));
        Command addMemMenuCmd = new AddMemberMenuCommand(newMember);
        MenuRunner myMenuRunner = new MenuRunner();
        myMenuRunner.runMenuOrAction(addMemMenuCmd);
    }
}
