/**************************************************************************************************/
//
//  Project : Kalong Bay Guesthouse Reservation and Logistic System
//  Filename : Chalet.java
//  Author : Jeffrey Nursalim
//  Student No: TP031319
//  Module Code & Title: CE00204-7 Object-Oriented Software Systems Engineering
//  Due Date : 15 July 2013
//
/**************************************************************************************************/
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.ArrayList;

public class Chalet
{
    public String name;
    public BigDecimal ratePerNight;

    public Chalet(String nm, BigDecimal rate)
    {
        name = nm;
        ratePerNight = rate;
    }

    public ArrayList<Chalet> getChalet(String nm)
    {
        ArrayList<Chalet> cList = null;
        String sqlQuery = "SELECT * FROM chalet WHERE name = ? ";
        Object[] sqlParam = new Object[]{nm};
        ArrayList arrList = SQLAdaptor.query(sqlQuery, sqlParam);
        System.out.println(arrList);

        Iterator iterator = arrList.iterator();
        while(iterator.hasNext())
        {
            Object[] temp = (Object[])iterator.next();

            cList.add(new Chalet((String)temp[0], (BigDecimal)temp[1]));
            for (int i = 0; i < temp.length; i++)
            {
                System.out.print(temp[i] + " " + temp[i].getClass().getName() + " ");
            }
            System.out.println();
        }
        return cList;
    }

    public boolean setChalet(String nm, BigDecimal rate)
    {
        Object[] sqlParam = new Object[]{nm, rate};

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

        String sqlUpdate = "INSERT INTO chalet (name, ratePerNight) VALUES (" + stringOfQnMark + ")";
        int stat = SQLAdaptor.update(sqlUpdate, sqlParam);
        if(stat >= 0)
        {
            status = true;
        }
        return status;

    }
}
