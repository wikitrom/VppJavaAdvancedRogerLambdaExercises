package exercise;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.Test;
import org.omg.Messaging.SyncScopeHelper;

public class ExerciseLambda {

	/*
	 * This is an exercise just to get your feet wet and try some lambda
	 * expressions. Make use of the collection streams to finish these exercises.
	 * (List<String> yourCollection; yourCollection.stream()) The stream have
	 * methods such as .filter(Predicate), .map(Function), .sorted(Comparator),
	 * .reduce() .sum/.average/.count .collect(Collector) (Collectors.asList())
	 */

	/*
	 * Initial set of words to work with.
	 */
	static List<String> listOfWords = Arrays.asList("every", "problem", "in", "computer", "science", "can", "be",
			"solved", "by", "adding", "another", "level", "of", "indirection", "except", "too", "many", "levels", "of",
			"indirection");

	/*
	 * Print out all the words in listOfWords
	 */
	@Test
	public void printAllWords() {
		listOfWords.forEach(s -> System.out.println(s.toString()));
		System.out.println("....................................");
		listOfWords.forEach(System.out::println);
		// fail();
	}

	/*
	 * Create a string that consists of the first letter of each word in the list of
	 * Strings.
	 */
	@Test
	public void stringOfFirstLetterFromEveryWord() {
		String result;
		result = listOfWords.stream().map(s -> s.substring(0, 1)).collect(Collectors.joining());
		System.out.println(result);

		assertEquals("epicscbsbaaloietmloi", result);
		// fail();
	}

	// Exercise 2: Convert all words in wordList to upper case
	@Test
	public void makeUpperCase() {

		List<String> output;

		output = listOfWords.stream().map(word -> word.toUpperCase()).collect(Collectors.toList());

		assertEquals(Arrays.asList("EVERY", "PROBLEM", "IN", "COMPUTER", "SCIENCE", "CAN", "BE", "SOLVED", "BY",
				"ADDING", "ANOTHER", "LEVEL", "OF", "INDIRECTION", "EXCEPT", "TOO", "MANY", "LEVELS", "OF",
				"INDIRECTION"), output);
		// fail();

	}

	/*
	 * Find all the words in wordList that have even length
	 */
	@Test
	public void findEvenLengthWords() {

		List<String> output;

		output = listOfWords.stream().filter(word -> ((word.length() % 2) == 0)).collect(Collectors.toList());

		assertEquals(
				Arrays.asList("in", "computer", "be", "solved", "by", "adding", "of", "except", "many", "levels", "of"),
				output);

		// same thing 'spelled out'
		Predicate<String> evenWordLength = word -> {
			return (word.length() % 2) == 0;
		};

		List<String> output2 = listOfWords.stream().filter(evenWordLength).collect(Collectors.toList());

		assertEquals(
				Arrays.asList("in", "computer", "be", "solved", "by", "adding", "of", "except", "many", "levels", "of"),
				output2);

		// just playing with predicate... this should give true false
		System.out.println();
		System.out.println(evenWordLength.test("mats") + " " + evenWordLength.test("kalle"));
		System.out.println();

		assertTrue(evenWordLength.test("Mats"));
		assertFalse(evenWordLength.test("kalle"));
		// fail();
	}

	/*
	 * Count the words in wordList
	 */
	@Test
	public void countNumberOfWords() {
		int count;
		count = (int) listOfWords.stream().count();
		assertEquals(20, count);
		// fail();
	}

	/*
	 * Count the total amount of characters in the words in wordList
	 */
	@Test
	public void countNumberOfCharactersInWords() {
		int count;
		count = listOfWords.stream().mapToInt(s -> s.length()).sum();
		assertEquals(105, count);
		// fail();
	}

	/*
	 * Find the first square that is divisible by five
	 */
	@Test
	public void findFirstSquareThatIsDivisibleBy5() {
		// HINT: IntStream.range(1, 100) creates a stream 1, 2, ... 99
		// final int first = 0; // TODO

		// TODO assertEquals(25, first);
		fail();
	}

	/*
	 * Join the second, third and forth strings of the list into a single string,
	 * where each word is separated by a hyphen (-). Print the resulting string.
	 * (Hint: skip/limit)
	 */
	@Test
	public void joinChosenStringsAndSeparateByHyphen() {
		List<String> list = Arrays.asList("The", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog");

		String merged;

		merged = list.stream().skip(1).limit(3).collect(Collectors.joining("-"));
		assertEquals("quick-brown-fox", merged);
		// fail();
	}

	/*
	 * Convert every key-value pair of the map into a string and append them all
	 * into a single string, in iteration order. Hint: StringBuilder
	 */
	@Test
	public void mapTheKeyValuePairsToString() {
		Map<String, Integer> map = new TreeMap<>();
		map.put("c", 3);
		map.put("b", 2);
		map.put("a", 1);

		StringBuilder sb = new StringBuilder();
		map.forEach((k, v) -> sb.append(k.toString()).append(v.toString()));
		System.out.println(sb.toString());
		assertEquals("a1b2c3", sb.toString());
		// fail();
	}

	/**
	 * Create a new thread that prints the numbers from the list.
	 */
	@Test
	public void printNumbersFromNewThread() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		// TODO Thread t;
		fail();
	}
}
