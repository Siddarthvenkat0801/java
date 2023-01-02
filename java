
moment maker
photograpger
customer
mawa time ayipothundhi

package progusingjava;

//DO NOT MODIFY THE CODE PROVIDED TO YOU

public class MomentMaker {
	private static int counter = 1000;
	private String bookingId;
	private Customer customer;
	private int earlyBirdBooking;
	private String[] occasionAvailable = { "ThemeParty", "Birthday", "Wedding" };
	private double totalBill;

	public MomentMaker(Customer customer, int earlyBirdBooking) {
		this.customer = customer;
		this.earlyBirdBooking = earlyBirdBooking;
	}

	public String getBookingId() {
		return this.bookingId;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public int getEarlyBirdBooking() {
		return this.earlyBirdBooking;
	}
		
	public double getTotalBill() {
		return this.totalBill;
	}

	public String[] getOccasionAvailable() {
		return this.occasionAvailable;
	}

	//To Trainees
	public void generateBookingId() {
		
        // Implement your logic here
        
        MomentMaker.counter++;
        this.bookingId=customer.getCustomerName().substring(0,2).toUpperCase()+MomentMaker.counter;
        
        
		
	}

	//To Trainees
	public Boolean validateOccasion(String occasion) {
        // Implement your logic here
        boolean x=false;
        customer.validateCustomer();
        if(customer.validateCustomer())
        {
            for(int i=0;i<this.getOccasionAvailable().length;i++)
            {
                if(this.getOccasionAvailable()[i]==occasion)
                {
                    x= true;
                }
            }

        
        }
        //Change the return statement accordingly
        return x;
	}

	//To Trainees
	public void calculateFinalBill(Photographer photographer) {
		
        // Implement your logic here
        photographer.calculatePhotographerBill();
        boolean occasionStatus=this.validateOccasion(customer.getOccasion());
        if(occasionStatus==true && photographer.getPhotographerFee()!=-1.0)
        {
            if(customer.getLocation().equals("OutDoor"))
            {
                this.totalBill=photographer.getPhotographerFee()+5000.0;
            }
            else if(customer.getLocation().equals("InDoor"))
            {
                this.totalBill=photographer.getPhotographerFee();
            }
            if(this.getEarlyBirdBooking()>=20)
            {
                double x;
                x=this.totalBill*0.12;
                this.totalBill=this.totalBill-x;
            }
            double serviceTax=this.totalBill*0.8;
            this.totalBill+=serviceTax;
            this.generateBookingId();
            
        }
        else{
            this.totalBill=-1.0;
            this.bookingId="NA";
        }
        
		
	}
	
	@Override
	public String toString() {
		return "MomentMaker (customer =" +this.customer + ", earlyBirdBooking=" + this.earlyBirdBooking +")";
	}
}
