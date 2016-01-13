package test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkAndJoinTest1 extends RecursiveAction{

	public static void main(String[] args) {
		ForkAndJoinTest1  forkAndJoinTest1  = new ForkAndJoinTest1();
		ForkJoinPool fjp = new ForkJoinPool();
		fjp.invoke(forkAndJoinTest1);
	}

	@Override
	protected void compute() {
		
		
	}

}
