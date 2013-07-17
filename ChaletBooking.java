/**************************************************************************************************/
//
//  Project : Kalong Bay Guesthouse Reservation and Logistic System
//  Filename : ChaletBooking.java
//  Author : Jeffrey Nursalim
//  Student No: TP031319
//  Module Code & Title: CE00204-7 Object-Oriented Software Systems Engineering
//  Due Date : 15 July 2013
//
/**************************************************************************************************/
import java.sql.Date;

import java.util.ArrayList;
import java.util.Iterator;

import java.math.BigDecimal;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ChaletBooking
{
    public String chaletName;
    public String bookedBy;
    public Date startDate;
    public Date endDate;
    public Date actualCheckInDate;
    public Date actualCheckOutDate;
    public boolean roomInspected;
    public BigDecimal bill;
    public boolean billPaid;

    public ChaletBooking(String chaletNm, String booker, Date startDt, Date endDt, Date acStartDt, Date acEndDt, boolean roomIns, BigDecimal bl, boolean blpd)
    {
        chaletName = chaletNm;
        bookedBy = booker;
        startDate = startDt;
        endDate = endDt;
        actualCheckInDate = acStartDt;
        actualCheckOutDate = acEndDt;
        roomInspected = roomIns;
        bill = bl;
        billPaid = blpd;
    }

    public boolean addChaletBooking()
    {
        Object[] sqlParam = new Object[]{chaletName, bookedBy, startDate, endDate};

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

        //Check that the booking date range for that chalet does not overlap with other booking's
        ArrayList<ChaletBooking> othB = getChaletBooking();
        if(othB != null)
        {
            //Otherwise, chalet's already booked!
            System.out.println("Chalet is already booked!");
            return status;
        }

        String sqlUpdate = "INSERT INTO chaletbooking (chaletName, bookedBy, startDate, endDate) VALUES (" + stringOfQnMark + ")";
        int stat = SQLAdaptor.update(sqlUpdate, sqlParam);
        if(stat >= 0)
        {
            status = true;
        }
        return status;
    }

    public ArrayList<ChaletBooking> getChaletBooking()
    {
        ArrayList<ChaletBooking> cbList = null;

        String sqlQuery = "SELECT * FROM chaletbooking WHERE chaletName = ? AND (startDate < ? OR endDate > ?) ";
        Object[] sqlParam = new Object[]{chaletName, startDate, endDate};
        ArrayList arrList = SQLAdaptor.query(sqlQuery, sqlParam);

        Iterator iterator = arrList.iterator();
        while(iterator.hasNext())
        {
            Object[] temp = (Object[])iterator.next();

            try
            {
                for (int i = 0; i < temp.length; i++)
                {
                    if(temp[i] == null)
                    {
                        continue;
                    }
                    System.out.print(temp[i] + " " + temp[i].getClass().getName() + " ");
                }
                cbList.add(new ChaletBooking((String)temp[0], null, (Date)temp[2], (Date)temp[3], null, null, false, null, false));
            }
            catch(NullPointerException e)
            {
                Logger lgr = Logger.getLogger(ChaletBooking.class.getName());
                lgr.log(Level.WARNING, e.getMessage(), e);
            }
        }
        return cbList;
    }

    public boolean deleteChaletBooking(String booker)
    {
        Object[] sqlParam = new Object[]{booker};

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

        String sqlUpdate = "DELETE FROM chaletbooking WHERE bookedBy = ?";
        int stat = SQLAdaptor.update(sqlUpdate, sqlParam);
        if(stat >= 0)
        {
            status = true;
        }
        return status;
    }

    public boolean setCheckIn(String nm, Date checkInDt)
    {
        Object[] sqlParam = new Object[]{checkInDt, nm};

        boolean status = false;

        String sqlUpdate = "UPDATE chaletbooking SET checkInDt = ? WHERE bookedBy = ?";
        int stat = SQLAdaptor.update(sqlUpdate, sqlParam);
        if(stat >= 0)
        {
            status = true;
        }
        return status;
    }

    public BigDecimal setCheckOutAndGetBill(String nm, Date checkOutDt)
    {
        Object[] sqlParam = new Object[]{checkOutDt, nm};
        ChaletBooking b = null;
        boolean status = false;

        String sqlUpdate = "UPDATE chaletbooking SET checkOutDt = ? WHERE bookedBy = ?";
        int stat = SQLAdaptor.update(sqlUpdate, sqlParam);
        if(stat >= 0)
        {
            status = true;
        }

        String sqlQuery = "SELECT * FROM chaletbooking WHERE bookedBy = ?";
        sqlParam = new Object[]{nm};
        ArrayList arrList = SQLAdaptor.query(sqlQuery, sqlParam);

        Iterator iterator = arrList.iterator();
        try
        {
            while(iterator.hasNext())
            {
                Object[] temp = (Object[])iterator.next();

                b = new ChaletBooking((String)temp[0], (String)temp[1], (Date)temp[2], (Date)temp[3], (Date)temp[4], (Date)temp[5], (Boolean)temp[6], (BigDecimal)temp[7], (Boolean)temp[8]);
                for (int i = 0; i < temp.length; i++)
                {
                    System.out.print(temp[i] + " " + temp[i].getClass().getName() + " ");
                }
                System.out.println();
            }
        }
        catch(NullPointerException e)
        {
            Logger lgr = Logger.getLogger(ChaletBooking.class.getName());
            lgr.log(Level.WARNING, e.getMessage(), e);
        }

        BigDecimal bill = b.bill;
        return bill;
    }

    public boolean setBillPaid(String nm, boolean billPd)
    {
        return true;
    }
}
