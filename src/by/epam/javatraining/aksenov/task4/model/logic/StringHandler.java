package by.epam.javatraining.aksenov.task4.model.logic;

import by.epam.javatraining.aksenov.task4.model.container.Stack;
import org.apache.log4j.Logger;

public class StringHandler {
    private static Logger log = Logger.getRootLogger();

    public static boolean isPalindrome(String string) {
        if (string == null) {
            return false;
        }

        Stack<Character> stack = new Stack<>(string.length());
        int count = string.length() / 2;

        for (int i = 0; i < stack.size() / 2; i++) {
            stack.push(string.charAt(i));
            log.trace(string.charAt(i) + " - pushed to stack");
        }

        count += (string.length() % 2 == 0 ? 0 : 1);

        for (int i = count; i < string.length(); i++) {
            char ch = stack.pop();

            log.trace(ch + " - compare to " + string.charAt(i));

            if (ch != string.charAt(i)) {
                log.info("FALSE");
                return false;
            }
        }
        log.info("TRUE");

        return true;
    }
}
