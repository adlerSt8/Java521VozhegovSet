import java.util.*;

public class Main {
    public static boolean uniqueSymbols(String line) {
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < line.length(); i++) {
            char currentChar = line.charAt(i);
            if (charSet.contains(currentChar)) {
                return false;
            }
            charSet.add(currentChar);
        }
        return true;
    }

    public static Set<String> combiningSets(Set<String> set1, Set<String> set2) {
        Set<String> result = new HashSet<>();
        result.addAll(set1);
        result.addAll(set2);
        return result;
    }

    ;

    public static Set<String> intersectionOfSets(Set<String> set1, Set<String> set2) {
        Set<String> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }

    public static Set<String> differenceOfSets(Set<String> set1, Set<String> set2) {
        Set<String> diff1 = new HashSet<>(set1);
        Set<String> diff2 = new HashSet<>(set2);
        Set<String> result = new HashSet<>();
        diff1.removeAll(set2);
        diff2.removeAll(set1);
        result.addAll(diff1);
        result.addAll(diff2);
        return result;
    }

    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        set1.add("Береза");
        set1.add("Дуб");
        set1.add("Осина");
        set1.add("Ель");
        set1.add("Баобаб");

        set2.add("Яблоня");
        set2.add("Дуб");
        set2.add("Осина");
        set2.add("Клен");
        set2.add("Тополь");

        Comparator<Product> productComparator = Comparator
                .comparingDouble((Product p) -> p.getPrice())
                .thenComparingInt(p -> -p.getRating());
        TreeSet<Product> products = new TreeSet<>(productComparator);

        products.add(new Product("Сок апельсиновый", 90F, 4));
        products.add(new Product("Шоколад молочный", 35F, 5));
        products.add(new Product("Чай черный", 120F, 3));
        products.add(new Product("Печенье овсяное", 35F, 4));
        products.add(new Product("Кофе зерновой", 300F, 5));
        products.add(new Product("Молоко 3.2%", 60F, 4));
        products.add(new Product("Йогурт клубничный", 80F, 3));
        products.add(new Product("Вода минеральная", 40F, 5));

        while (true) {
            System.out.println("Выберите пункт меню: ");
            System.out.println("""
                1. Проверка на уникальность
                2: Объединение множеств
                3: Пересечение множеств
                4: Разность множеств
                5: Сортировка товаров по цене и рейтингу TreeSet
                6: Выход
                """);
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Введите строку: ");
                    String line = scanner.nextLine();
                    System.out.println(uniqueSymbols(line));
                    break;
                case 2:
                    System.out.println("Элементы из обоих множеств: " + combiningSets(set1, set2));
                    break;
                case 3:
                    System.out.println("Элементы, которые присутствуют в обоих множествах: "
                            + intersectionOfSets(set1, set2));
                    break;
                case 4:
                    System.out.println("Элементы, которые есть только в первом и только во втором множестве: " +
                            differenceOfSets(set1, set2));
                    break;
                case 5:
                    for (Product product : products) {
                        System.out.println(product);
                    }
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Выбран неверный пункт.");
            }
        }
    }
}