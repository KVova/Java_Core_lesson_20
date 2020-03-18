package volodymyr;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ApplicationExecutorService {

	public static synchronized void main(String[] args) {
		
		ExecutorService executable = Executors.newFixedThreadPool(2);
		executable.execute(new RunnableThread(100));
		executable.execute(new MyThread());
		executable.shutdown();
	
		ExecutorService executable1 = Executors.newWorkStealingPool(20);
		executable1.execute(new RunnableThread(100));
		executable1.execute(new MyThread());
		executable1.shutdown();
		
		ExecutorService executable2 = Executors.newSingleThreadExecutor();
		executable2.execute(new RunnableThread(100));
		executable2.execute(new MyThread());
		executable2.shutdown();
		
		ExecutorService executable3 = Executors.newCachedThreadPool();
		executable3.execute(new RunnableThread(100));
		executable3.execute(new MyThread());
		executable3.shutdown();
	}
}