package ie.gmit.rmiStuff;


import java.rmi.registry.LocateRegistry;
import java.rmi.Naming;

public class StringCompareServant  {

	
	public static void main(String[] args) throws Exception {	//This main method is RMI server side 
		
		StringServiceImpl sci = new StringServiceImpl();
		
		
		LocateRegistry.createRegistry(1099);
		
		Naming.rebind("String Compare", sci);
		System.out.println("Server ready  : Port Number 1099");		//message (Server Ready ...)
		
	}
	

}
