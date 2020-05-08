package jira;

import java.util.ArrayList;
import java.util.List;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ReadExcelWithFILO {

	public static void main(String[] args) throws Exception{
		
		List<String> data=new ArrayList<>();

		Fillo file=new Fillo();
		Connection connection=file.getConnection("D:\\Test.xlsx");
		String strQuery="Select * from test";
		Recordset rs=connection.executeQuery(strQuery);
		while(rs.next())
		{
			System.out.println(rs.getField("FNAME")+"---"+rs.getField("LNAME"));
			data.add(rs.getField("SALARY"));
		}
		System.out.println("_________________");
		System.out.println("All emp Salary" +data); // Print all Employee Salary [0, 100, 125465, 22000, 15000, 70000]
		
		System.out.println("_________________");
		
		System.out.println("Total Rows In Excel Sheet:" +rs.getCount());
		
		System.out.println("_________________");
		rs.moveLast();
		System.out.println(rs.getField("FNAME")+"---"+rs.getField("LNAME"));//Print last Record
		System.out.println("_________________");
		rs.movePrevious();
		System.out.println(rs.getField("FNAME")+"---"+rs.getField("LNAME"));//Print previous record
		System.out.println("_________________");
		rs.moveFirst();
		System.out.println(rs.getField("FNAME")+"---"+rs.getField("LNAME"));//Print first row data
		

		System.out.println("_________________");
		rs.moveNext();
		System.out.println(rs.getField("FNAME")+"---"+rs.getField("LNAME"));//Print next row
		
		int totalColumn=rs.getFieldNames().size();
		System.out.println("_________________");
		System.out.println(totalColumn);// Total Column Name
		
		String FirstColumnName=rs.getFieldNames().get(0);
		System.out.println(FirstColumnName); // First Column Name
		
		for(int i=0;i<rs.getFieldNames().size();i++)
		{
			System.out.println(rs.getFieldNames().get(i));// All Column Name
		}		
		rs.close();
		connection.close();
	}

}
