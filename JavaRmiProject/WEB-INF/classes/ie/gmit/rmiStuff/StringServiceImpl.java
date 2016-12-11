package ie.gmit.rmiStuff;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;



public class StringServiceImpl extends UnicastRemoteObject implements StringService{

	
	public StringServiceImpl() throws RemoteException {
		
	}
	
	private static final long serialVersionUID = 1L;
	
	private Resultator res;

	@Override
	public Resultator compare(String str1, String str2, String algo) throws RemoteException {
		
		
		res = new ResultatorImpl();
		
		StringCompareImpl compare = new StringCompareImpl(str1,str2,res,algo);
		Thread cj = new Thread(compare);
		cj.start();
											//start the thread and return the current status of resultator
		return res;
	}
	
	
	
	
	
	
	
	
	
}
