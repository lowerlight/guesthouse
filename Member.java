/**************************************************************************************************/
//
//  Project : Kalong Bay Guesthouse Reservation and Logistic System
//  Filename : Member.java
//  Author : Jeffrey Nursalim
//  Student No: TP031319
//  Module Code & Title: CE00204-7 Object-Oriented Software Systems Engineering
//  Due Date : 15 July 2013
//
/**************************************************************************************************/
import java.util.Iterator;
import java.util.ArrayList;
import java.math.BigDecimal;


public class Member //implements SQLData
{
    //Command DP: Receiver

    //Instance variables and methods prototype
    public String name;
    public BigDecimal balance;

    //Constructor
    public Member(String nm, BigDecimal bal)
    {
        name = nm;
        balance = bal;
    }

    public boolean addMember()
    {
        Object[] sqlParam = new Object[]{name, balance};

        boolean status = false;
        String stringOfQnMark = "";
        for(int i=0; i<sqlParam.length; i++)
        {
            if(i==0)
            {
                stringOfQnMark = "?";
            }
            else
            {
                stringOfQnMark += ",?";
            }
        }

        String sqlUpdate = "INSERT INTO member (name, balance) VALUES (" + stringOfQnMark + ")";
        int stat = SQLAdaptor.update(sqlUpdate, sqlParam);
        if(stat >= 0)
        {
            status = true;
        }
        return status;
    }

    public static Member getMember(String name)
    {
        Member mem = null;
        String sqlQuery = "SELECT * FROM member WHERE name = ?";
        ArrayList arrList = SQLAdaptor.query(sqlQuery, name);
        System.out.println(arrList);

        Iterator iterator = arrList.iterator();
        if(iterator.hasNext())
        {
            Object[] temp = (Object[])iterator.next();
            if(!(name.equals(temp[1])))
            {
                System.out.println("Something wrong!");
                System.out.println(name);
                System.out.println(temp[1]);
            }
            mem = new Member((String)temp[1], (BigDecimal)temp[2]);
            for (int i = 0; i < temp.length; i++)
            {
                System.out.print(temp[i] + " " + temp[i].getClass().getName() + " ");
            }
            System.out.println();
        }
        return mem;
    }

    public boolean removeMember(String nm)
    {
        return true;
    }

    public BigDecimal getBalance(String nm)
    {
        return balance;
    }

    public boolean creditToBal(String nm, double amt)
    {
        return true;
    }

    public boolean debitFromBal(String nm, double amt)
    {
        return true;
    }
}