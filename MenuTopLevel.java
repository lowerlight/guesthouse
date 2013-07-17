/**************************************************************************************************/
//
//  Project : Kalong Bay Guesthouse Reservation and Logistic System
//  Filename : MenuTopLevel.java
//  Author : Jeffrey Nursalim
//  Student No: TP031319
//  Module Code & Title: CE00204-7 Object-Oriented Software Systems Engineering
//  Due Date : 15 July 2013
//
/**************************************************************************************************/
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Iterator;

import java.util.logging.Level;
import java.util.logging.Logger;


public class MenuTopLevel extends Menu
{
    static String userid;
    static String password;
    static int stat = 1;

    protected void setupAndDisplayMenu()
    {
        System.out.println("Please Log in");
    }

    protected void waitForInput()
    {
        System.out.println("Type your user id here: ");
        userid = kybd.next();
        System.out.println("Type your password here: ");
        password = kybd.next();
    }

    protected void waitForConfirmation()
    {
        //Do nothing
    }

    protected void runNextMenuOrAction()
    {
        String sqlQuery = "SELECT * FROM manager WHERE userid = ? AND password = ?";
        Object[] sqlParam = new Object[]{userid, password};
        ArrayList arrList = null;
        try
        {
            arrList = SQLAdaptor.query(sqlQuery, sqlParam);
        }
        catch(NullPointerException e)
        {
            Logger lgr = Logger.getLogger(MenuTopLevel.class.getName());
            lgr.log(Level.WARNING, e.getMessage(), e);
        }

        if(arrList.size() > 1)
        {
            System.out.println("Too many managers with the same userid and same password!");
        }

        if(arrList.size() == 0)
        {
            System.out.println("Wrong userid or password");
            stat = 0;
        }

        while(stat > 0)
        {
            user = userid;
            Menu nextMenu = new Menu1stLevel();
            stat = nextMenu.displayMenu();
        }
    }
}
