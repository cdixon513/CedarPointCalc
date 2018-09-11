import java.util.Scanner;
import java.text.DecimalFormat;

public class CedarPointCalc{
	public static final double schoolBusCostPerBus = 1300.42;
	public static final double charterBusCostPerBus = 1738.92;
	public static final double numberOfPeopleOnSchoolBus = 44.0; //made double in order to allow number of buses to round up
	public static final double numberOfPeopleOnCharterBus = 55.0; //made double in order to allow number of buses to round up
	public static final double fallTicketPrice = 39.00;
	public static final double springTicketPrice = 42.00;
	public static final double foodAllowance = 25.00;
	public static final int numOfStudentsForFreeTicket = 15;
	public static final int numOfStudentsPerChaperone = 4;
	public static void main(String[] args){
		//Declare instance variables
		int numOfStudents, numOfChaperones, numOfFreeTickets, numOfSchoolBuses, numOfCharterBuses;
		DecimalFormat money = new DecimalFormat("$.00");
		double fallCost, springCost, charterBusCost, schoolBusCost, foodCost;
		Scanner scanner = new Scanner(System.in);

		//Get inputs
		System.out.print("Students attending: ");
		numOfStudents = scanner.nextInt();

		//Calculate number of students who will get in free
		numOfFreeTickets = numOfStudents / numOfStudentsForFreeTicket;

		//Calculate number of chaperones needed and print
		numOfChaperones = numOfStudents / numOfStudentsPerChaperone;
		System.out.println(numOfChaperones + " chaperones are needed.");

		//Calculate fall and spring admission costs
		fallCost = (numOfStudents + numOfChaperones) * fallTicketPrice;
		springCost = (numOfStudents + numOfChaperones) * springTicketPrice;

		//Calculate cost for fall and spring with free ticket deductions
		fallCost = fallCost - (numOfFreeTickets * fallTicketPrice);
		springCost = springCost - (numOfFreeTickets * springTicketPrice);

		//Calculate cost of transportation with school and charter bus
		numOfSchoolBuses = (int) Math.ceil((numOfStudents + numOfChaperones) / numberOfPeopleOnSchoolBus);
		numOfCharterBuses = (int) Math.ceil((numOfStudents + numOfChaperones) / numberOfPeopleOnCharterBus);
		schoolBusCost = numOfSchoolBuses * schoolBusCostPerBus;
		charterBusCost = numOfCharterBuses * charterBusCostPerBus;

		//Total cost for food allowance and print
		foodCost = (numOfStudents + numOfChaperones) * foodAllowance;
		System.out.println("Food will cost $" + foodCost + "0.");

		//Total trip cost for all four possibilities
		System.out.println("\nTotal Costs:");
		System.out.printf("%15s", "");
		System.out.printf("%15s", "Fall Cost");
		System.out.printf("%15s", "Spring Cost");
		System.out.println();
		System.out.printf("%15s", "School Bus");
		System.out.printf("%15s", money.format(fallCost + schoolBusCost + foodCost));
		System.out.printf("%15s", money.format(springCost + schoolBusCost + foodCost));
		System.out.println();
		System.out.printf("%15s", "Charter Bus");
		System.out.printf("%15s", money.format(fallCost + charterBusCost + foodCost));
		System.out.printf("%15s", money.format(springCost + charterBusCost + foodCost));
		System.out.println();
	}
}