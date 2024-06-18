package codewars;

import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TenMinWalk {

    public static boolean isValid(char[] walk) {
        if (walk.length > 10) {
            return false;
        }

        var countPerDirection = new String(walk).chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return Objects.equals(countPerDirection.get('w'), countPerDirection.get('e')) &&
                Objects.equals(countPerDirection.get('n'), countPerDirection.get('s'));
    }

}