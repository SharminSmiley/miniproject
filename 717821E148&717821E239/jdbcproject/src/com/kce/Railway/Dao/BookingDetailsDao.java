package com.kce.Railway.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.kce.Railway.bean.BookingDetails;

public class BookingDetailsDao {
static Scanner sc=new Scanner(System.in);
public static void Customer(BookingDetails bd)
{
	try
	{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/3306","root","Sharmin@09");
        PreparedStatement pstmt=con.prepareStatement("Insert into cus_Details(name,phoNo,TrainNo,noOfSeats) values(?,?,?,?");
        pstmt.setString(1, bd.getName());
        pstmt.setInt(1, bd.getPhoNo());
        pstmt.setInt(1, bd.getTrainNo());
        pstmt.setInt(1, bd.getNoOfSeats());
        pstmt.executeUpdate();
        System.out.println("Data saved");

	}catch(SQLException e)
	{
        System.out.println("Error: "+e.getMessage());
	
	}
}
public static void update()
{
	try
	{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/3306","root","Sharmin@09");
        PreparedStatement pstmt=con.prepareStatement("update cus_Details set noOfSeats=? where name=?");
        System.out.println("Enter the seats to be updated");
        int noOfSeats=sc.nextInt();
        System.out.println("enter the new name");
        String name=sc.nextLine();
        pstmt.setInt(1, noOfSeats);
        pstmt.setString(2, name);
        int rowsAffected=pstmt.executeUpdate();
        if(rowsAffected>0)
        {
        	System.out.println("updated successfully");
        }else
        {
        	System.out.println("No records found for given name");
        }
	}catch(SQLException e)
	{

        System.out.println("Error: "+e.getMessage());
	}
}
public static void deleteRows()
{
	try
	{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/3306","root","Sharmin@09");
        PreparedStatement pstmt=con.prepareStatement("Truncate table cus_details");
        pstmt.executeUpdate();
    	System.out.println("Table records deleted successfully");
	}catch(SQLException e)
	{
		System.out.println(e);
	}}
	public static void displayTable()
	{
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/3306","root","Sharmin@09");
	        PreparedStatement pstmt=con.prepareStatement("select *from cus_details");
            ResultSet rs=pstmt.executeQuery();
            System.out.println("Customer Details:");
            while(rs.next())
            {
            	System.out.printf("| %-20s | | %-20s | | %-20s | | %-20s |%n",rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getInt(4));
		}
            rs.close();
	}catch(SQLException e)
		{
        System.out.println("Error: "+e.getMessage());

		}
}
}
