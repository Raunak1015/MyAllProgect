package jira;

import java.util.ArrayList;
import java.util.List;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ReaddataFromBugReport {

	public static void main(String[] args) throws FilloException {
		List<String> listOfStatus=new ArrayList<>();
		List<String> Label=new ArrayList<>();

		Fillo file=new Fillo();
		Connection connection=file.getConnection("D:\\Defect_2.xlsx");		
		String strQuery="Select * from TestCase";
		Recordset rs=connection.executeQuery(strQuery);
		System.out.println("Total Row Count="+rs.getCount());
		while(rs.next())
		{
			//System.out.println(rs.getField("Label")+"----"+rs.getField("Status"));
			listOfStatus.add(rs.getField("Status"));
			Label.add(rs.getField("Label"));
		}
		rs.close();
		connection.close();
		System.out.println("listOfStatus");
		for(int i=0;i<listOfStatus.size();i++)
		{
			System.out.println(listOfStatus.get(i));
		}
		System.out.println(Label.get(0));
	
	}

}
