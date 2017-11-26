package testcode;


/* Right now, need to fix problems with field vs. local variables. For example, the tests appeard to indicate
 * that "receivedData" in the threadCommunications class was never set to true. However, this is because each call
 * of the testThreads() method created a new ThreadCommunications object and check if that instance had it's
 * receivedData set to true (which it of course didn't, because it was just created).
 * 
 * Also look into making the Thread objects static
 * 
 */



public class ThreadRunning {

	public static boolean RanThreads = false;

	// To understand why this is commented out, see
	// ThreadCommunication threadComms = new ThreadCommunication();
	
	ThreadRunnable threadsRun = new ThreadRunnable();
	
	public void testThreads() 
	{
		System.out.println("in thread running");

		// System.out.println("in periodic");
		// System.out.println("checking if both threads are running");
		// System.out.println(thread1.getState());
		// System.out.println(thread2.getState());

    
		//commented out because it wasn't doing anything
		//    ExecutorService executor = Executors.newSingleThreadExecutor();

		if (RanThreads == false)
        {
			threadsRun.run();
			RanThreads = true;
			System.out.println("run threads");
        }
		System.out.println("here");
		
		// The problem with the commented out code is that it was refering to the
		// ThreadCommunications field for this class. However, the code for threads was setting
		// the receivedData variable for the ThreadRunnable's ThreadCommunication field
		// 	System.out.println("ReceivedData: " + threadComms.recievedData);
		
		System.out.println("ReceivedData: " + threadsRun.threadComms.recievedData);

// commented out because this code was never ran; wasn't in a loop, so was tested only once
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
