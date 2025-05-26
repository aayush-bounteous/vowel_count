import java.io.*;
import java.util.*;

public class input {
    public static void main(String[] args) {
        String inputFile = "input.txt";     // Your source file
        String outputFile = "output.txt";   // File to write the result

        int vowelWordCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+"); // Split by whitespace

                for (String word : words) {
                    if (!word.isEmpty()) {
                        char firstChar = Character.toLowerCase(word.charAt(0));

                        if ("aeiou".indexOf(firstChar) != -1) {
                            vowelWordCount++;
                        }
                    }
                }
            }

            // Write result to output file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                writer.write("Number of words starting with a vowel: " + vowelWordCount);
                System.out.println("Result written to " + outputFile);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

                // NEW: Store the vowel words for printing
        List<String> vowelWords = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        char firstChar = Character.toLowerCase(word.charAt(0));

                        if ("aeiou".indexOf(firstChar) != -1) {
                            vowelWordCount++;
                            vowelWords.add(word);  // Collect the vowel-starting word
                        }
                    }
                }
            }
            
            // Now write result including words
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                writer.write("Number of words starting with a vowel: " + vowelWordCount + "\n");
                writer.write("Words starting with vowels: " + String.join(", ", vowelWords));
                System.out.println("Result written to " + outputFile);
            }
            
            // Also print to console
            System.out.println("Number of words starting with a vowel: " + vowelWordCount);
            System.out.println("Words starting with vowels: " + String.join(", ", vowelWords));
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
