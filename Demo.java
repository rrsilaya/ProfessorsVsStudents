/* Import Professors vs. Students Library */
import pvs.University;
import pvs.objects.Timer;

/* Import Professors */
import pvs.essentials.*;

/* Import Java Native Classes */
import java.util.Scanner;

public class Demo {
	private static int menu() {
		Scanner sc = new Scanner(System.in);

		System.out.println("-----------------------------------------------------------");
		System.out.println("*                  Professors vs. Zombies                 *");
		System.out.println("-----------------------------------------------------------");
		System.out.println(" [1] Option 1");
		System.out.println(" [2] Option 2");
		System.out.println(" [3] Option 3");
		System.out.println("-----------------------------------------------------------");

		System.out.print(" Choice: ");
		return sc.nextInt();
	}

	public static void main(String[] args) {
		University uplb = new University(1);
		WaterThrower waterThrower1 = new WaterThrower();
		WaterThrower waterThrower2 = new WaterThrower();
		WaterThrower waterThrower3 = new WaterThrower();
		WaterThrower waterThrower4 = new WaterThrower();
		WaterThrower waterThrower5 = new WaterThrower();

		uplb.hireProfessor(0, 0, waterThrower1);
		uplb.hireProfessor(0, 1, waterThrower2);
		uplb.hireProfessor(0, 2, waterThrower3);
		uplb.hireProfessor(0, 3, waterThrower4);
		uplb.hireProfessor(0, 4, waterThrower5);

		uplb.log();
	}
}