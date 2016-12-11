package rmiStuff;

import java.rmi.RemoteException;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

public class Worker implements Runnable {

	
	private BlockingQueue<Requester> inQueue;
	private Map<String, Resultator> outQueue;
	private Resultator res;
	private StringServiceImpl ssi;
	
	

	public Worker(BlockingQueue<Requester> inQueue, Map<String, Resultator> outQueue, 
			StringServiceImpl ssi){
		this.inQueue = inQueue;
		this.outQueue = outQueue;
		this.ssi = ssi;
		
	}
	
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		Requester reqes = inQueue.poll();
		
		try {
			System.out.println("\nCheck Status of current Task No: " + reqes.getTaskNumber());
			Thread.sleep(5000);
			
			reqes = (Requester) ssi.compare(reqes.getStr1(), reqes.getStr2(), reqes.getAlgo());
			
			System.out.println(reqes.getStr1());
			
			outQueue.put(reqes.taskNumber, res);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			((Throwable) e).printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
		
		
		
	}

	

