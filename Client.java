import java.rmi.*;
import java.rmi.Naming;
import java.io.*;
import java.math.BigInteger;

/* 
	Client
	java -Djava.security.policy=java.policy Client localhost
*/
public class Client {
	public static void main(String args[]) throws Exception {
		if (args.length != 1) {
			System.out.println("Syntax - Client host");
			System.exit(1);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}

		Service service = (Service) Naming.lookup("rmi://" + args[0] + "/Service");
		DataInputStream din = new DataInputStream(System.in);

		for (;;) {
			System.out.println("1 - Add");
			System.out.println("2 - Mul");
			System.out.println("3 - Sub");
			System.out.println("4 - Sqr");
			System.out.println("5 - Pow");
			System.out.println("6 - Floor Div & Rmd");
			System.out.println("7 - GCD");
			System.out.println("8 - LCM");
			System.out.println("9 - Exit");
			System.out.println();
			System.out.print("Choice : ");

			String line = din.readLine();
			Integer choice = new Integer(line);

			int value = choice.intValue();

			switch (value) {
				case 1:
					System.out.print("Number : ");
					line = din.readLine();
					choice = new Integer(line);
					value = choice.intValue();
					System.out.print("Add  : ");
					line = din.readLine();
					choice = new Integer(line);
					int second = choice.intValue();

					System.out.println("Result : " + service.add(value, second));
				break;

				case 2:
					System.out.print("Number : ");
					line = din.readLine();
					choice = new Integer(line);
					value = choice.intValue();

					System.out.print("Multiply  : ");
					line = din.readLine();
					choice = new Integer(line);
					second = choice.intValue();

					System.out.println("Result : " + service.multiply(value, second));
				break;
				
				case 3:
					System.out.print("Number : ");
					line = din.readLine();
					choice = new Integer(line);
					value = choice.intValue();
					System.out.print("Substract  : ");
					line = din.readLine();
					choice = new Integer(line);
					second = choice.intValue();
					System.out.println("Result : " + service.substract(value, second));
				break;

				case 4:
					System.out.print("Number : ");
					line = din.readLine();
					System.out.println();
					choice = new Integer(line);
					value = choice.intValue();

					System.out.println("Result : " + service.square(value));
				break;

				case 5:
					System.out.print("Number : ");
					line = din.readLine();
					choice = new Integer(line);
					value = choice.intValue();
					System.out.print("Power  : ");
					line = din.readLine();
					choice = new Integer(line);
					int power = choice.intValue();

					System.out.println("Result : " + service.power(value, power));
				break;
				
				case 6:
					System.out.print("Number : ");
					line = din.readLine();
					choice = new Integer(line);
					value = choice.intValue();

					System.out.print("Multiply  : ");
					line = din.readLine();
					choice = new Integer(line);
					second = choice.intValue();

					BigInteger answer[] = service.floorDivision(value, second);
					System.out.println("Floor : " + answer[0] + " Remainder: " + answer[1]);
				break;

				case 7:
					System.out.print("Number : ");
					line = din.readLine();
					choice = new Integer(line);
					value = choice.intValue();

					System.out.print("Multiply  : ");
					line = din.readLine();
					choice = new Integer(line);
					second = choice.intValue();

					// Call remote method
					System.out.println("Result : " + service.gcd(value, second));
					break;

				case 8:
					System.out.print("Number : ");
					line = din.readLine();
					choice = new Integer(line);
					value = choice.intValue();

					System.out.print("Multiply  : ");
					line = din.readLine();
					choice = new Integer(line);
					second = choice.intValue();

					// Call remote method
					System.out.println("Result : " + service.lcm(value, second));
					break;
				case 9:
					System.exit(0);
				default:
					System.out.println("Invalid option");
					break;
			}
		}
	}

}