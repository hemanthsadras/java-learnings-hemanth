package org.CountWordsTask;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class WordCounter {


	private Map<String, Integer> getFrequencyInLine(String[] words) {
		return Arrays.stream(words)
				.collect(groupingBy(Function.identity(), collectingAndThen(counting(), Long::intValue)));
	}

	public Map<String, Integer> getFrequencyCountInFile(Path filePath) throws IOException {
		List<String> lines = getAllLinesFromFile(filePath);
		Map<String, Integer> result = new HashMap<>();
		for (String line : lines) {
			String[] words = line.split(" ");
			Map<String, Integer> wordCount = getFrequencyInLine(words);
			addWordCountToResult(wordCount, result);
		}

		return result;
	}

	public void addWordCountToResult(Map<String, Integer> wordCount, Map<String, Integer> result) {
		
		wordCount.forEach((key, value) -> {
			result.compute(key, (k, v) -> {
				return value == null ? 1 : value + 1;
			});

		});

	}
	
	private List<String> getAllLinesFromFile(Path filePath) throws IOException {
		 return Files.readAllLines(filePath);
	}

}
