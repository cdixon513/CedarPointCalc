import java.util.Scanner;
import java.text.DecimalFormat;

public class CedarPointCalc{
	public static void main(String[] args){
		//Declare variables
		int numOfStudents, numOfChaperones;
		DecimalFormat money = new DecimalFormat("$.00");
		double fallCost, springCost, charterBusCost, schoolBusCost, foodCost;
		final double schoolBusCostPerPerson = 1300.42 / 44; //school buses are $1300.42 per 44 person bus
		final double charterBusCostPerPerson = 1738.92 /55; //charter buses are $1738.92 per 55 person bus
		final double fallTicketPrice = 39.00;
		final double springTicketPrice = 42.00;
		Scanner scanner = new Scanner(System.in);

		//Get inputs
		System.out.print("Students attending: ");
		numOfStudents = scanner.nextInt();

		//Calculate number of chaperones needed and print
		numOfChaperones = numOfStudents / 4;
		System.out.println(numOfChaperones + " chaperones are needed.");

		//Calculate fall and spring admission costs
		fallCost = (numOfStudents + numOfChaperones) * fallTicketPrice;
		springCost = (numOfStudents + numOfChaperones) * springTicketPrice;

		//Calculate cost of transportation with school and charter bus
		schoolBusCost = (numOfStudents + numOfChaperones) * schoolBusCostPerPerson;
		charterBusCost = (numOfStudents + numOfChaperones) * charterBusCostPerPerson;

		//Total cost for food allowance and print
		foodCost = (numOfStudents + numOfChaperones) * 25.00;
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