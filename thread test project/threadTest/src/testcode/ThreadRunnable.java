package testcode;



public class ThreadRunnable
{


public boolean done = false;

// I feel like this might be the problem
ThreadCommunication threadComms = new ThreadCommunication();

public ThreadRunnable ()
{

}

Thread t1 = new Thread(new Runnable()
{
	@Override
	public void run ()
	{
		System.out.println(
            "Begining of t1 run: " + Thread.currentThread());
		try
        {
			threadComms.Thread1Comm();
        }
		catch (InterruptedException e)
        {
			e.printStackTrace();
        }
	}
});

// Create another thread object that calls
// pc.consume()
Thread t2 = new Thread(new Runnable()
{
	@Override
	public void run ()
	{
		System.out.println(
            "Begining of t2 run: " + Thread.currentThread());
		try
        {
			threadComms.Thread2Comm();
        }
		catch (InterruptedException e)
        {
			e.printStackTrace();
        }
	}
});



public void run ()
{
    System.out.println("Begining of Run: " + Thread.currentThread());


    // boolean ran = false;
    // Teleop teleop = new Teleop();
    // long sum = 0;
    // for (int i = 1; i < 100; i++)
    // {
    // sum++;
    // System.out.println(Thread.currentThread().getName() + sum);
    //
    // if (sum >= 100)
    // {
    // Teleop.ThreadComm = true;
    //
    // }
    // }
    // System.out.println(
    // Thread.currentThread().getName()
    // + " thread printing out its id " + countUntil);
    //





    // Start both threads
    System.out.println("Starting T1 and T2");
    t1.start();
    t2.start();

    // this code doesn't appear to do anything because it only runs once
    // before the other threads do their stuff
    
    // t1 finishes before t2
    if (threadComms.recievedData == true
            || threadComms.endThreads == true)
    {
        System.out.println("recieved that threadsCOmm has finished");
        try
        {
            t1.join();
            System.out.println("joining thread 1");
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try
        {
            t2.join();
            System.out.println("joining thread 2");
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        done = true;
    }
}

}


