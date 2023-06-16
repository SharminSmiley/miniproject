package com.kce.Railway.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import com.kce.Railway.bean.TrainDetails;
import com.kce.Railway.util.DBUtil;
 class InvalidDateException extends Exception {
public InvalidDateException(String message)
{
	super(message);
}


public class TrainDetailsDao {
static Scanner sc=new Scanner(System.in);
public static void insert(int a)throws ClassNotFoundException
{
	try
	{
		TrainDetails[]arr=new TrainDetails[a];
		for(int i=0;i<a;i++)
		{
			System.out.println("Enter Train id");
			int id=sc.nextInt();
			System.out.println("Enter Source");
			String Source=sc.next();
			System.out.println("Enter Destination");
			String Destination=sc.next();
			System.out.println("Enter the seat to be available");
			int seatsAvailable=sc.nextInt();
			System.out.println("Enter the date(DD/MM/YYYY): ");
			String dateStr=sc.next();
			System.out.println("Enter the price for seat:");
			double priceOfSeat=sc.nextDouble();
			arr[i]=new TrainDetails(id,Source,Destination,seatsAvailable,dateStr,priceOfSeat);
		}
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/3306","root","Sharmin@09");
		PreparedStatement pstmt=con.prepareStatement("insert ino Train values(?,?,?,?,?,?");
		for(int i=0;i<a;i++)
		{
			pstmt.setInt(1,arr[i].getTrainId());
			pstmt.setString(2,arr[i].getSource());
			pstmt.setString(3,arr[i].getDestination());
			pstmt.setInt(4,arr[i].getSeatsAvailable());
			pstmt.setString(5,arr[i].getDate());
			pstmt.setDouble(6,arr[i].getPriceOfSeat());
			pstmt.executeUpdate();
		}
		System.out.println("Data collected successsfully");	
	}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
private static LocalDate LocalDateValiddateAndParseDate(String dataStr) throws InvalidDateException
{
	try
	{
		return LocalDate.parse(dataStr,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}catch(DateTimeParseException e)
	{
		throw new InvalidDateException("Invalid date format.Please enter the date in the format DD/MM/YYYY.");
	}
}
public static void update()
{
	try
	{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/3306","root","Sharmin@09");
        PreparedStatement pstmt=con.prepareStatement("update Train set Destination=? where TraiId=?");
        System.out.println("Enter the Train id");
        int id=sc.nextInt();
        System.out.println("Enter the new Destination");
        String Destination=sc.next();
        pstmt.setInt(1, id);
        pstmt.setString(2,Destination);
        int rowsAffected=pstmt.executeUpdate();
        if(rowsAffected>0)
        {
        	System.out.println("Updated Successfully");
        }else
        {
        	System.out.println("No data found for the given id");
        }
	}catch(SQLException e)
	{
		System.out.println("Error: "+e.getMessage());
	}
}
public static void delete()
{
	try
	{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/3306","root","Sharmin@09");
        PreparedStatement pstmt=con.prepareStatement("Delete from Train where trainId=?");
		System.out.println("Enter Train id:");
		int id=sc.nextInt();
		pstmt.setInt(1, id);
        int rowsAffected=pstmt.executeUpdate();
        if(rowsAffected>0)
        {
        	System.out.println("Updated Successfully");
	
        }else
        {
        	System.out.println("No data found for the given id");
	
        }
	}
	catch(SQLException e)
	{
		System.out.println("Error: "+e.getMessage());
		
	}
}
public static  void displayTable() {
	try
	{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/3306","root","Sharmin@09");
		PreparedStatement pstmt=con.prepareStatement("select * from Train");
		ResultSet rs=pstmt.executeQuery();
		System.out.println("Train Details:");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("| %-20s | %-20s | %20s | %20s | %20s | %20s |%n","Train id","Source","Destination","SeatsAvailable","date","priceOfSeat");
		while(rs.next())
		{
			System.out.printf("| %-20s | %-20s | %20s | %20s | %20s | %20s |%n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getDouble(6));
			rs.close();
		}
	}catch(SQLException e)
	{
		System.out.println("Error: "+e.getMessage());
	}
}
}
}
