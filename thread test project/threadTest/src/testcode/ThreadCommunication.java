package testcode;
import testcode.ThreadRunnable;


public class ThreadCommunication
{
	
boolean test = false;

public boolean endThreads = false;

public boolean recievedData = false;
public boolean publicRecievedData = recievedData;

public synchronized void Thread1Comm () throws InterruptedException
{
ThreadRunning runThreads = new ThreadRunning();
    synchronized (this)
        {
        System.out.println("thread1running: ");
        System.out.println(Thread.currentThread());

        // Thread1 = Thread-0,5,main
        // releases the lock on shared resource

        wait();
        if (endThreads == true)
            {
        	runThreads.ThreadRunning();
            }
        else if (test == false)
            {
            wait();
            }
        else if (test == true)
            {
            System.out.println(
                    "Thread 1 has gotten that the test boll is true");
            recievedData = true;
            System.out.println("sending recieved data is true");
            
            System.out.println("called threadRunning");
            runThreads.ThreadRunning();
            wait();
           
            
            }

        // and waits till some other method invokes notify().
        System.out.println("Resumed");
        }
}


public synchronized void Thread2Comm () throws InterruptedException
{
    System.out.println("Begining of thread2Comm: ");
    System.out.println(Thread.currentThread());
    // thread2 = Thread-1,5,main

    // this makes the thread1 thread to run first.

    Thread.sleep(2000);


    // synchronized block ensures only one thread
    // running at a time.
    synchronized (this)
        {
        System.out.println("Waiting");



        // notifies the produce thread that it
        // can wake up.
        if (test == false)
            {
            System.out.println(
                    "Thread 2 has gotten that test is false and is setting it to true");
            test = true;
            notifyAll();
            System.out.println("Just notified all");
            wait();
            System.out.println(
                    "just called wait and this probably shouldnt run, but i dont really know what im doing sooooooo");
            }
        // Sleep
        Thread.sleep(2000);
        }
}





}
