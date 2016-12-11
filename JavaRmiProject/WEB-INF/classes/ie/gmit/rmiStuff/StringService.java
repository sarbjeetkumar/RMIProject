package ie.gmit.rmiStuff;

import java.rmi.Remote;
import java.rmi.RemoteException;

//Remote interface 

public interface StringService extends Remote{
	
	public Resultator compare(String str1 , String str2 , String algo )throws RemoteException;

}
