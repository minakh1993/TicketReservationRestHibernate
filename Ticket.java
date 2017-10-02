package HW12RestHibernate;

public class Ticket {
	private String customerName;
	private String origin;
	private String destination;
	private String date;
	private int flightNumber;
	private int ticketCode;


	public Ticket(){

	}

	public Ticket(String customerName, String origin, String destination, String date, int flightNumber, int ticketCode) {
		super();
		this.customerName = customerName;
		this.origin = origin;
		this.destination = destination;
		this.date = date;
		this.flightNumber = flightNumber;
		this.ticketCode = ticketCode;
	}

	public String getcustomerName() {
		return customerName;
	}

	public void setcustomerame(String customerName) {
		this.customerName = customerName;
	}

	public String getorigin() {
		return origin;
	}

	public void setorigin(String origin) {
		this.origin = origin;
	}

	public String getdestination() {
		return destination;
	}

	public void setdestination(String destination) {
		this.destination = destination;
	}

	public String getdate() {
		return date;
	}

	public void setdate(String date) {
		this.date = date;
	}

	public int getflightNumber() {
		return flightNumber;
	}

	public void setflightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public int getticketCode() {
		return ticketCode;
	}

	public void setticketCode(int ticketCode) {
		this.ticketCode = ticketCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public int getTicketCode() {
		return ticketCode;
	}

	public void setTicketCode(int ticketCode) {
		this.ticketCode = ticketCode;
	}



}
