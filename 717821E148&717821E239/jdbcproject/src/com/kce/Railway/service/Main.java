package com.kce.Railway.service;

import java.sql.SQLException;
import java.util.Scanner;
import com.kce.Railway.service.*;
import com.kce.Railway.Dao.BookingDetailsDao;
import com.kce.Railway.Dao.TrainDetailsDao;
import com.kce.Railway.bean.BookingDetails;
import com.kce.Railway.bean.TrainDetails;
public class Main {
	
	static Scanner sc=new Scanner(System.in);
    public static void main(String[] args)throws ClassNotFoundException,SQLException {
    	System.out.println("If you want to see train details enter 1");
    	System.out.println("If you want to book  enter 2");
    	int press=sc.nextInt();
    	while(true)
    	{
    		if(press==1)
    		{
    	System.out.println("---------------------------------------------------------------------------------------------------");
    	System.out.println("Enter choice");
    	System.out.println("1.insert records");
    	System.out.println("2.update records");
    	System.out.println("3.Delete records");
    	System.out.println("4.show records");
    	System.out.println("5.exit");
    	int choice=sc.nextInt();
    	sc.nextLine();
    	switch(choice)
    	{
    	case 1:
        	System.out.println("Enter the records want to be inserted:");
        	TrainDetailsDao.insert(sc.nextInt());
        	break;
    	case 2:
    		TrainDetailsDao.update();
    		break;
    	case 3:
    		TrainDetailsDao.delete();
    		break;
    	case 4:
    		TrainDetailsDao.displayTable();
    		break;
    	case 5:
    	    	System.out.println("welcome");
    	    	System.exit(0);
    	    	break;
    	    	default:
    	        	System.out.println("invalid choice");
    	        	break;
    	}
    		}else if(press==2)
    		{
    			while(true)
    			{
    			System.out.println("Enter the choice");	
    			System.out.println("1.Customer");	
    			System.out.println("2.Delete Rows");	
    			System.out.println("3.Update data");	
    			System.out.println("4.display");	
    			System.out.println("5.exit");	
    			int choice =sc.nextInt();
    			sc.nextLine();
    			switch(choice)
    			{
    			case 1:
    				BookingDetailsDao.displayTable();
    				System.out.println("Enter customer Name:");
    				String name=sc.next();
    				System.out.println("Enter phono:");
    				int phoNo=sc.nextInt();
    				System.out.println("Enter Train Id:");
    				int TrainNo=sc.nextInt();
    	    		System.out.println("Enter No of Seats::");
                    int noOfSeats=sc.nextInt();
                    BookingDetails bookingDetails=new BookingDetails(name,phoNo,TrainNo,noOfSeats);
                    BookingDetailsDao.Customer(bookingDetails);
                    break;
    			case 2:
    				BookingDetailsDao.deleteRows();
    				break;
    			case 3:
    				BookingDetailsDao.update();
    				break;
    			case 4:
    				BookingDetailsDao.displayTable();
    				break;
    			case 5:
    	             System.out.println("Welcome");
    	             System.exit(0);
    	             break;
    	             default:
    	            	 System.out.println("Invalid choice");
    	            	 break;
    			}
    	    	System.out.println("---------------------------------------------------------------------------------------------------");
    			
    			}
    		}


    	}


    
    
	}

}
