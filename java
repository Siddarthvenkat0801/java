
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



package progusingjava;

//DO NOT MODIFY THE CODE PROVIDED TO YOU

public class Photographer {
	private String photographerName;
	private int noOfDays;
	private double photographerFee;
	private static double[] photographersFeesPerDayArr = { 5000.0, 7000.0, 8000.0 };
	private static String[] photographersAvailableArr = { "Jack", "Emily", "Joe" };

	public Photographer(String photographerName, int noOfDays) {
		this.photographerName = photographerName;
		this.noOfDays = noOfDays;
	}

	public String getPhotographerName() {
		return this.photographerName;
	}

	public static String[] getPhotographersAvailableArr() {
		return Photographer.photographersAvailableArr;
	}

	public int getNoOfDays() {
		return this.noOfDays;
	}

	public static double[] getPhotographersFeesPerDayArr() {
		return Photographer.photographersFeesPerDayArr;
	}

	public double getPhotographerFee() {
		return this.photographerFee;
	}

	//To Trainees
	public void calculatePhotographerBill() {
        double basicFare = 0.0;
        for(int i=0;i<Photographer.photographersAvailableArr.length;i++)
        {
            if(this.getPhotographerName().equals(Photographer.photographersAvailableArr[i]))
            {
                basicFare=Photographer.photographersFeesPerDayArr[i];
                break;
            }
            else
            {
                basicFare=-1.0;
            }
        }
        if(basicFare!=-1.0)
        {
            basicFare=basicFare*this.getNoOfDays();
            
            this.photographerFee=basicFare;
            
        }
        else{
            this.photographerFee=basicFare;
        }
    
		
		// Implement your logic here
		
	}

	@Override
	public String toString() {
		return "Photographer (photographerName=" + this.photographerName + ", noOfDays=" + this.noOfDays
				+ ")";
	}
}
