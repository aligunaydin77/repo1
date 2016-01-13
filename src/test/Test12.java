package test;

import java.util.Arrays;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Test12 {

	public static void main(String[] args) {

		Arrays.asList("red","green","blue")
         .stream()
         .map(s -> !s.startsWith("b"))     
         .forEach(System.out::println);
		
		
	}
}

class Bs implements Spliterator<String> {

	@Override
	public boolean tryAdvance(Consumer<? super String> action) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Spliterator<String> trySplit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long estimateSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int characteristics() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
