package utilities;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import core.TestFactory;

public class ThreadExecutorService {
	private ExecutorService executor;

	public ThreadExecutorService(int size) {
		// TODO Auto-generated constructor stub
		executor = Executors.newFixedThreadPool(size);
	}

	public void getWikiLinks() {
		WikiRunner worker1 = null;
		int mobilePlatformCount = Integer.valueOf(System.getProperty("mobileplatform"));
		for (String movieName : TestFactory.movieMap.keySet()) {
			if (mobilePlatformCount>0) {
				worker1 = new WikiRunner(TestFactory.movieMap.get(movieName),"mobile");
				mobilePlatformCount--;
				} else 
				worker1 = new WikiRunner(TestFactory.movieMap.get(movieName),"desktop");
			executor.execute(worker1);
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
	}
}

	
	