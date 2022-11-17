import java.math.BigInteger;
import java.rmi.*;

/* 
	Service Interface
*/
public interface Service extends java.rmi.Remote
{
	// Calculate the square of a number
	public BigInteger square ( int number )
		throws RemoteException;

	// Calculate the power of a number
	public BigInteger power  ( int num1, int num2) 
		throws RemoteException;
	
	
	// Addition of two big integers 
	public BigInteger add(int num1,int num2)
		throws RemoteException;
	
	//Substraction of two big integers 
	public BigInteger substract(int num1,int num2)
		throws RemoteException;
	
	//Multiplication of two big integeres 
	public BigInteger multiply(int num1,int num2)
		throws RemoteException;
	
	//Integer floor division 
	public BigInteger[] floorDivision(int num1,int num2)
		throws RemoteException;
	
	//GCD between two numbers
	public BigInteger gcd(int num1,int num2)
		throws RemoteException;
	
	// //lcm between two numbers 
	public BigInteger lcm(int num1,int num2)
		throws RemoteException;

}
