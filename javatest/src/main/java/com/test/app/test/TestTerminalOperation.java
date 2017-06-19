package com.test.app.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class TestTerminalOperation {

	public static void main(String args[]) {
		reduce();
		count();
		match();
		findFirst();
		example();
	}

	public static void reduce() {
		Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);

		Optional<Integer> intOptional = numbers.reduce((i, j) -> {
			return i * j;
		});
		if (intOptional.isPresent())
			System.out.println("Multiplication = " + intOptional.get()); // 120
	}

	public static void count() {
		Stream<Integer> numbers1 = Stream.of(1, 2, 3, 4, 5);

		System.out.println("Number of elements in stream=" + numbers1.count()); // 5
	}

	public static void match() {
		Stream<Integer> numbers3 = Stream.of(1, 2, 3, 4, 5);
		System.out.println("Stream contains 4? " + numbers3.anyMatch(i -> i == 4));
		// Stream contains 4? true

		Stream<Integer> numbers4 = Stream.of(1, 2, 3, 4, 5);
		System.out.println("Stream contains all elements less than 10? " + numbers4.allMatch(i -> i < 10));
		// Stream contains all elements less than 10? true

		Stream<Integer> numbers5 = Stream.of(1, 2, 3, 4, 5);
		System.out.println("Stream doesn't contain 10? " + numbers5.noneMatch(i -> i == 10));
		// Stream doesn't contain 10? true
	}

	public static void findFirst() {
		Stream<String> names4 = Stream.of("Pankaj", "Amit", "David", "Lisa");
		Optional<String> firstNameWithD = names4.filter(i -> i.startsWith("D")).findFirst();
		if (firstNameWithD.isPresent()) {
			System.out.println("First Name starting with D=" + firstNameWithD.get()); // David
		}
	}
	
	public static void example(){
		List<Integer> ss = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
		List<Integer> result = new ArrayList<Integer>();
		 
		Stream<Integer> stream = ss.parallelStream();
		 
		stream.map(s -> {
		        synchronized (result) {
		          if (result.size() < 10) {
		            result.add(s);
		          }
		        }
				return s;
		    }).forEach( e -> {});
		 System.out.println(result);   
	}

}
