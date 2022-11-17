import java.math.*;
import java.rmi.*;
import java.rmi.server.*;

/* 
    Server
    java  -Djava.security.policy=java.policy Server
*/
public class Server extends UnicastRemoteObject implements Service {
    public Server() throws RemoteException {
        super();
    }

    public BigInteger square(int number) throws RemoteException {
        String numrep = String.valueOf(number);
        BigInteger bi = new BigInteger(numrep);
        bi.multiply(bi);
        return (bi);
    }

    public BigInteger power(int num1, int num2) throws RemoteException {
        String numrep = String.valueOf(num1);
        BigInteger bi = new BigInteger(numrep);
        bi = bi.pow(num2);
        return bi;
    }

    public BigInteger add(int num1, int num2) throws RemoteException {
        String numrep1 = String.valueOf(num1);
        String numrep2 = String.valueOf(num2);
        BigInteger bi1 = new BigInteger(numrep1);
        BigInteger bi2 = new BigInteger(numrep2);
        return bi1.add(bi2);
    }

    public BigInteger substract(int num1, int num2) throws RemoteException {
        String numrep1 = String.valueOf(num1);
        String numrep2 = String.valueOf(num2);
        BigInteger bi1 = new BigInteger(numrep1);
        BigInteger bi2 = new BigInteger(numrep2);
        return bi1.subtract(bi2);
    }

    public BigInteger multiply(int num1,int num2) throws RemoteException{
        String numrep1 = String.valueOf(num1);
        String numrep2 = String.valueOf(num2);
        BigInteger bi1 = new BigInteger(numrep1);
        BigInteger bi2 = new BigInteger(numrep2);
        return bi1.multiply(bi2);
    }

    public BigInteger[] floorDivision(int num1,int num2) throws RemoteException{
        String numrep1 = String.valueOf(num1);
        String numrep2 = String.valueOf(num2);
        BigInteger bi1 = new BigInteger(numrep1);
        BigInteger bi2 = new BigInteger(numrep2); 
        return bi1.divideAndRemainder(bi2);
    }

    private BigInteger euler_gcd(BigInteger a, BigInteger b){
        if(b.toString().equals("0")){return a;}
        return euler_gcd(b, a.mod(b));
    }

    public BigInteger gcd(int num1,int num2) throws RemoteException{
        String numrep1 = String.valueOf(num1);
        String numrep2 = String.valueOf(num2);
        BigInteger bi1 = new BigInteger(numrep1);
        BigInteger bi2 = new BigInteger(numrep2);
        return euler_gcd(bi1, bi2);
    }

    public BigInteger lcm(int num1,int num2) throws RemoteException{
        String numrep1 = String.valueOf(num1);
        String numrep2 = String.valueOf(num2);
        BigInteger bi1 = new BigInteger(numrep1);
        BigInteger bi2 = new BigInteger(numrep2);
        BigInteger g = euler_gcd(bi1, bi2);
        BigInteger mul = bi1.multiply(bi2);
        return mul.divide(g);
    }


    public static void main(String args[]) throws Exception {
        if (System.getSecurityManager() == null){ System.setSecurityManager(new RMISecurityManager());}
        Server svr = new Server();
        Naming.bind("Service", svr);
        System.out.println("... bounding ....");
    }
}