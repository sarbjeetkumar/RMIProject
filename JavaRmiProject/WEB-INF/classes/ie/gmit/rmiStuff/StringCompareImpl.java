package ie.gmit.rmiStuff;



import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;



public class StringCompareImpl implements Runnable{

	//instance variables to get the values which is passed from StringServiceImpl
	String str1;
	String str2;
	String algo; // Algorithm
	Resultator res;
	
	
	public StringCompareImpl(String str1, String str2 ,Resultator r ,String algo )throws RemoteException {
		this.str1 = str1;
		this.str2 = str2;
		this.algo = algo;
		this.res = r;
		
	}
	
	//create objects for diffrent algorithms 
	private DamerauLevenshtein dl = new DamerauLevenshtein();
	private HammingDistance hd = new HammingDistance();
	private Levenshtein ll = new Levenshtein();
	Resultator r = new ResultatorImpl();
 	

	@Override
	public void run() {
		
		
		
		
		switch(algo){
			
		case  "DamerauLevenshtein" :
			try {
				r.setResult(dl.distance(str1, str2));	//set result 
				Thread.sleep(5000);
				r.setProcessed();
			} catch (RemoteException | InterruptedException e) {
				e.printStackTrace();
			}	
			break;
		case "HammingDistance" :
			try {
				r.setResult(hd.distance(str1, str2));		//set result 
				Thread.sleep(5000);
				r.setProcessed();//process done here 
			} catch (RemoteException | InterruptedException e) {
				
				e.printStackTrace();
			}
			break;
		case "Levenshtein" :
			try {
				r.setResult(ll.distance(str1, str2));	//set result 
				Thread.sleep(5000);
				r.setProcessed();//process done here 
			} catch (RemoteException | InterruptedException e) {
				e.printStackTrace();
			}
			
		
			break;
		}//switch ends here 
		
		
		
		
	}

	
	
	
	
}
