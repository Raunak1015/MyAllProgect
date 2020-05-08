package jira;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class FetchDataBasedOnCondition {

	public static void main(String[] args) throws FilloException {
		Fillo file=new Fillo();
		Connection connection=file.getConnection("D:\\Test.xlsx");
		//String Data1="Select * from test where FNAME='Raunak'";//Single where condition//First Way
		//Recordset rs=connection.executeQuery(Data1);
		
		Recordset rs=connection.executeQuery("Select * from test").where("FNAME='Raunak'");//Second Way

		while(rs.next())
		{
			System.out.println(rs.getField("FNAME")+"---"+rs.getField("LNAME"));
		}
		
		System.out.println("*********************************");
		//Using Multiple where Condition
		
		String strQuery="Select * from test where FNAME='RAUNAK' and SALARY='0'";
		Recordset rs2=connection.executeQuery(strQuery);
		while(rs2.next())
		{
			System.out.println(rs.getField("FNAME")+"---"+rs.getField("LNAME"));
		}
		
	
		
		
		
	}

}
