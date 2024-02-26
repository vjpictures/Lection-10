import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Task {
    public static void main(String[] args) {
        List<String> myList1 = new ArrayList<>();
        myList1.add("a1");
        myList1.add("a2");
        myList1.add("a3");
        myList1.add("b1");
        myList1.add("b3");
        myList1.add("c2");
        myList1.add("c1");
        myList1.add("c5");

        List<String> myList2 = new ArrayList<>();
        myList2.add("a3");
        myList2.add("b3");

        myList1.removeIf(myList2::contains);
        System.out.println("Удаление всех элементов с цифрой 3:");
        myList1.forEach(System.out::println);

        System.out.println("\nСортировка по возрастанию:");
        List<String> sortedList = myList1.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList()).reversed();
        System.out.println(sortedList);

        System.out.println("\nСортировка по убыванию:");
        sortedList = myList1.stream()
                .sorted()
                .collect(Collectors.toList())
                .reversed();
        System.out.println(sortedList);

        System.out.println("\nУдаление первого и последнего элемента:");
        sortedList.removeFirst();
        sortedList.removeLast();
        System.out.println(sortedList);

        System.out.println("\nUpper Case:");
        sortedList.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        int result = countOfWords(String.valueOf(sortedList));
        System.out.println("Количество оставшихся элементов: \n" + result + "\n");

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
}

