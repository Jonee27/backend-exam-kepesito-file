package hu.nive.ujratervezes.io.phonebook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class Phonebook {

    public void exportPhonebook(Map<String, String> contacts, String output) throws IOException {
        if (contacts == null || output == null) {
            throw new IllegalArgumentException();
        }

        String result = getResultString(contacts);
        Files.write(Path.of(output), result.getBytes());
    }

    private String getResultString(Map<String, String> contacts) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            result.append(String.format("%s: %s\n", entry.getKey(), entry.getValue()));
        }
        return result.toString();
    }
}