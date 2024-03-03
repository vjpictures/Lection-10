import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/resources/simple.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                int result = countOfWords(line);
                int punctuation = countOfPunctuation(line);
                System.out.println("Tекст: \n" + line + "\n");
                System.out.println("Количество слов в текстe: \n" + result + "\n");
                System.out.println("Kоличество знаков препинания: \n" + punctuation);
            }
        } catch (IOException e) {
            System.out.println("Number of characters in the given file are " + e.getMessage() + " occurred");
        }
    }

    public static int countOfWords(String line) {
        String stringPattern = "\\s";
        Pattern pattern = Pattern.compile(stringPattern);
        Matcher matcher = pattern.matcher(line);
        int count = 1;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    public static int countOfPunctuation(String line) {
        String stringPattern = "\\p{Punct}";
        Pattern pattern = Pattern.compile(stringPattern);
        Matcher matcher = pattern.matcher(line);
        int sign = 1;
        while (matcher.find()) {
            sign++;
        }
        return sign;
    }
}

