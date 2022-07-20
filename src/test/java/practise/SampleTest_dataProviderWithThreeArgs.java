package practise;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleTest_dataProviderWithThreeArgs {

@Test(dataProvider= "BookTickets")
public void BookTicketsAirways(String src,String dest,int ticket)
{
	System.out.println("BookingTicket From src "+ src+"dest "+dest+"Tickets "+ticket);
}


@DataProvider


public Object[][] BookTickets()
{
	Object[][] objArr= new Object[5][3];
	objArr[0][0]="Bangalore";
	objArr[0][1]="Goa";
	objArr[0][2]=100;
	
	
	objArr[1][0]="Bangalore";
	objArr[1][1]="Delhi";
	objArr[1][2]=100;
	
	objArr[2][0]="Bangalore";
	objArr[2][1]="Hyderabad";
	objArr[2][2]=100;
	
	objArr[3][0]="Bangalore";
	objArr[3][1]="Mumbai";
	objArr[3][2]=100;
	
	objArr[4][0]="Bangalore";
	objArr[4][1]="Kolkata";
	objArr[4][2]=100;
	
			
	
	return objArr;
	
}
}
