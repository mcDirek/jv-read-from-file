package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> words = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("[^a-zA-Z]+");
                for (String word : parts) {
                    if (!word.isEmpty() && word.toLowerCase().startsWith("w")) {
                        words.add(word.toLowerCase());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + fileName, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + fileName, e);
        }

        if (words.isEmpty()) {
            return new String[0];
        }

        Collections.sort(words);

        return words.toArray(new String[0]);
    }
}
