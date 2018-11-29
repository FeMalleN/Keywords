package keywords;

import java.text.Collator;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        LinkedList<String> keys = new LinkedList<>();
        LinkedList<String> answer = new LinkedList<>();
        keys.addAll(Arrays.asList("abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "continue",
                "default", "do", "double", "else", "enum", "extends", "false", "final", "finally", "float", "for", "goto", "if", "implements",
                "import", "instanceof", "int", "interface", "long", "native", "new", "null", "package", "private", "protected", "public",
                "return", "short", "static", "strictfp", "super", "switch", "synhronized", "this", "throw", "throws", "transient",
                "true", "try", "void", "volatile", "while"));
        Scanner sc = new Scanner(System.in);
        while (keys.size() != 0) {
            System.out.println("Enter the keyword or \"help\" for hint!");
            String a = sc.nextLine();
            if (a.equals("help") || a.equals("Help")) {                             //check on help and output hint
                String word = keys.getFirst();
                word = word.substring(0, word.length() / 2);
                char star = '*';
                String stars = "";
                int size = keys.getFirst().length() - word.length();
                for (int i = 0; i < size; i++) {
                    stars += star;
                }
                System.out.println(word + stars);
            } else {
                if (keys.contains(a)) {                                             //check on true answer
                    answer.add(a);
                    keys.remove(a);
                } else {
                    if (answer.contains(a)) {                                       //check on repeat word
                        System.out.println("The word is already guessed");
                    } else
                        System.out.println("The word is not right");
                }
                System.out.println("Remained words: " + keys.size());
                Collections.sort(answer, new Comparator<String>() {                 //sorting our answers
                    @Override
                    public int compare(String o1, String o2) {
                        return Collator.getInstance().compare(o1, o2);
                    }
                });
                System.out.println("The guessed words: " + answer.toString().replace("]", "").replace("[", ""));
                System.out.println();
            }
        }
        System.out.println("We congratulate, you guessed all words!!");
        sc.close();
    }
}