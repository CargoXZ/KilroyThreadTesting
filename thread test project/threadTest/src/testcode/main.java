package testcode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class main {
	
	// I added a comment in main to test GitHub.
	
	public static void main(String[] args) 
	{
		System.out.println("in main");
		ThreadRunning runThreads = new ThreadRunning();
		runThreads.testThreads();	 
		System.out.println(" -END OF MAIN- ");
	}
	

}
