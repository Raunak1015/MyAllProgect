package jira;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class LikeOperator {

	public static void main(String[] args) throws FilloException {
		Fillo file=new Fillo();
		Connection connection=file.getConnection("D:\\Test.xlsx");
		System.out.println("Like Operator Examples:----- ");
		//I want Name Start with R
		
		String strQuery2="Select * from test where SALARY like '1%'";
		Recordset rs3=connection.executeQuery(strQuery2);
		while(rs3.next())
		{
			System.out.println(rs3.getField("FNAME")+"---"+rs3.getField("LNAME"));
		}
		
		
	}

}
