import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Formula {

    private List<Integer> value;
    private final String REGEX = "\\D";
    private final String EMPTY = " ";

    public Formula(String value) {
        this.value = split(value);
    }

    private List<Integer> split(String value) {
        String values = value.replaceAll(REGEX, EMPTY);
        return Arrays.stream(values.split(EMPTY))
                .filter(v -> !v.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Integer> getValue() {
        return value;
    }
}
