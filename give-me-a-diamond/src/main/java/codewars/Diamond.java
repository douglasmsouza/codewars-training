package codewars;

import java.util.ArrayList;

public class Diamond {

    public static String print(int n) {
        if(n < 1 || n % 2 == 0) {
            return null;
        }

        var lines = new ArrayList<String>();
        var numSpaces = n / 2;
        for (int i = 1; i <= n; i += 2) {
            var spaces = " ".repeat(numSpaces);
            var asterisks = "*".repeat(i);
            lines.add("%s%s\n".formatted(spaces, asterisks));
            numSpaces--;
        }

        for (int i = lines.size() - 2; i >= 0; i--) {
            lines.add(lines.get(i));
        }

        return String.join("", lines);
    }
}