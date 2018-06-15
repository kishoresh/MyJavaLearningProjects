package com.exercises;
/*
 * Read a text file line by line and display the words with the no of times it is repeated.
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MaxNoOfWords {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("D:/MaxNoOfWords.txt"));
			Map<String, Integer> hmap = new HashMap<>();
			String line;
			int count;
			while ((line = br.readLine()) != null){
				String[] words = line.split("\\s");
				for (int i=0; i < words.length; i++){
					count = 1;
					if (hmap.containsKey(words[i])){
						count += hmap.get(words[i]);
						hmap.put(words[i], count);
					}else
					   hmap.put(words[i], count);
				}
			}
			
			for(Map.Entry<String, Integer> e : hmap.entrySet()){
				System.out.println(String.format("%s = %s", e.getKey(), e.getValue()));
			}			 
		} catch (IOException e) {
			e.printStackTrace();
		}	

	}

}
