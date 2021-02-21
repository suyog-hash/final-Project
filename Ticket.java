package project1;

import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Ticket {
	
	private Train train;
	private int counter=100;
	private String pnr;
	private LocalDate TravelDate;
	
	private TreeMap <Passenger,Integer> Passengers;
	
	public Ticket(LocalDate travelDate, Train train) 
	{
		TravelDate = travelDate;
		this.train = train;
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	public String getPnr() {
		return pnr;
	}
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	public LocalDate getTravelDate() {
		return TravelDate;
	}
	public void setTravelDate(LocalDate travelDate) {
		TravelDate = travelDate;
	}
	public Train getTrain() {
		return train;
	}
	public void setTrain(Train train) {
		this.train = train;
	}
	public  String generatePNR()
	{
		String source=String.valueOf(train.getSource().charAt(0));
		String destinaion=String.valueOf(train.getDestination().charAt(0));;
		String date=TravelDate.format(DateTimeFormatter.ofPattern("YYYYMMdd"));
		String pnr=source+destinaion+""+date+""+counter++;
		if(TravelDate.isAfter(LocalDate.now()))
			return pnr;
		else
			return "Please Enter the valid date";
	}
	double calPassengerFare(Passenger Passenger)
	{
		if(Passenger.getAge()<=12)
			return (0.5)*(train.getTicketprice());
		else if(Passenger.getAge()>=60)
			return (0.6)*(train.getTicketprice());
		else if(Passenger.getGender()=='F' )
			return (0.25)*(train.getTicketprice());
		else
			return train.getTicketprice();
	}
	
	public void addPassenger(String name,int age,char gender)throws NullPointerException
	{ 
		Passengers=new TreeMap();
            Integer fare=(int) calPassengerFare(new Passenger(name, age, gender));
            System.out.println(fare);
		Passengers.put(new Passenger(name, age, gender),fare);
	}
	double calculateTotalTicketPrice()
	{
		double totalPrice=0;
		Collection<Integer> price=Passengers.values();
		for(Integer values:price)
		{
			totalPrice=totalPrice+values;
		}
		
		return totalPrice;
	}
	StringBuilder generateTicket()
	
	{
		return null;
	}
	public  void writeTicket()
	{
	}
}
