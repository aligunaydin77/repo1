package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {
	public static <T> void main(String[] args) {
		System.out.println("test");

		Thread thread = new Thread(() ->  System.out.println("Running from Lambda"));
		thread.start();

		Person person1 = new Person(LocalDate.parse("2015-03-27"));
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				person1.log1();
			}
			
		});		
		Thread thread3= new Thread(()-> {person1.log1();});
		
		Thread thread4= new Thread(person1::log1);
		thread4.start();
		
		ExecutorService executorService1 = Executors.newSingleThreadExecutor();
		Future<String> future = executorService1.submit(() -> {

			System.out.println("from future");
			return "ali";
		});
		try {
			System.out.println(future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		executorService1.shutdown();
		
		LocalDate birthday = LocalDate.parse("2005-12-29");
		Person[] rosterAsArray = {new Person(birthday), new Person(birthday.plusDays(2)), new Person(birthday.minusDays(6))};
		Arrays.sort(rosterAsArray, Person::compareByAge);
		Arrays.sort(rosterAsArray,  new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				
				return 0;
			}

		});

		for (Person person : rosterAsArray) {
			System.out.println(person);
		}

		
		Collection<Person> roster = Arrays.asList(rosterAsArray);
		
		Set<Person> rosterClassical =
			    transferElements(roster, new Supplier<Set<Person>>(){

					@Override
					public Set<Person> get() {
						return new HashSet<Person>();
					}
			    	
			    });
		
		
		
		Set<Person> rosterMethodLambda = transferElements(roster, () -> {return new HashSet<Person>();});
		
		Set<Person> rosterMethodRef =
			    transferElements(roster, HashSet::new);
		
		
//		myDeck.sort(Comparator.comparing((card) -> card.getRank()));  
		List<String> allJedi = Arrays.asList("Luke","Obiwan","Quigon");
		allJedi.forEach( jedi -> System.out.println(jedi) );
		
		List<Person> people =  Arrays.asList(new Person("Luke","Skywalker"),new Person("Obiwan","Kenobi"),
				new Person("Quigon","Whatever"));
		people.sort(Comparator.comparing(Person::getFirstName).thenComparing(Person::getLastName));
		people.forEach(p -> System.out.println(p));
		
		List<String> l = new ArrayList(Arrays.asList("one", "two"));
	     Stream<String> sl = l.stream();
	     l.add("three");
	     Stream<Integer> d=  sl.filter(a -> a.startsWith("o"))
	    		 	  .distinct()
	    		 	  .map(String::length);
	     d.forEach(f -> System.out.println(f));
	     
	     sl.close();
	     d=  sl.filter(a -> a.startsWith("o"))
   		 	  .distinct()
   		 	  .map(f -> f.length());
	     
	     d.forEach(f -> System.out.println(f));
	     
		
	}

	public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>>	DEST transferElements(
			SOURCE sourceCollection,
			Supplier<DEST> collectionFactory) {

		DEST result = collectionFactory.get();
		for (T t : sourceCollection) {
			result.add(t);
		}
		return result;
	}
}

class Person {
	private LocalDate  birthday;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	private String firstName;
	
	private String lastName;

	public Person(LocalDate birthday) {
		super();
		this.birthday = birthday;
	}

	public static int compareByAge(Person a, Person b) {
		return a.birthday.compareTo(b.birthday);
	}
	@Override
	public String toString() {
		if(birthday != null)
		return "born on " + birthday;
		return firstName + " " + lastName;
	}
	
	public void log1() {
		System.out.println("hey");
	}
}

