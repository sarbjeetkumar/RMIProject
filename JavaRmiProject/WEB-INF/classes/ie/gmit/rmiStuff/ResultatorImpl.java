package ie.gmit.rmiStuff;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

//Classs extends Resultators 

public class ResultatorImpl extends UnicastRemoteObject implements Resultator{

	public ResultatorImpl() throws RemoteException{
		super();
	}
	
	//instance Variable
	private static final long serialVersionUID = 1L;
	private String result;
	private boolean processed = false;
	
	//implement methods
	
	
	@Override
	public String getResult() throws RemoteException {
		
		return this.result;
	}
	@Override
	public void setResult(String result) throws RemoteException {
		this.result = result;
		
	}
	@Override
	public boolean isProcessed() throws RemoteException {
		
		return this.processed;
	}
	@Override
	public void setProcessed() throws RemoteException {
		
		this.processed = true;
	}
	
	
	
	

}
