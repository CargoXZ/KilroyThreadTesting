package testcode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadRunning {
	private static final int NTHREDS = 1;

	public static boolean RanThreads = false;

	public void testThreads() 
	{
	System.out.println("in thread running");
	ThreadCommunication threadComms = new ThreadCommunication();
    // System.out.println("in periodic");
    // System.out.println("checking if both threads are running");
    // System.out.println(thread1.getState());
    // System.out.println(thread2.getState());
    ThreadRunnable threadsRun = new ThreadRunnable(NTHREDS);
    
    //commented out because it wasn't doing anything
//    ExecutorService executor = Executors.newSingleThreadExecutor();

    if (RanThreads == false)
        {
        threadsRun.run();
        RanThreads = true;
        System.out.println("run threads");
        }
System.out.println("here");
System.out.println("ReceivedData: " + threadComms.publicRecievedData);

// commented out because this code was never ran; wasn't in a loop, so was tested once
// before receivedData was ever set to true.

//    if ( threadComms.recievedData == true)
//        {
//    	//threadsRun.done == true || 
//    	//threadComms.endThreads == true || 
//    	System.out.println("now here");
//        executor.shutdown();
//        if (!executor.isShutdown())
//            {
//            System.out.println("Shutting down");
//
//            }
//        else
//            {
//            System.out.println("is shutdown " + executor.isShutdown());
//            System.out.println(
//                    "thread when shut down: " + Thread.currentThread());
//            }
//        }
	
        }
}
