import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operator {

    PLUS("+", (left, right) -> left + right),
    MINUS("-", (left, right) -> left - right),
    MULTIPLY("*", (left, right) -> left * right),
    DIVIDE("/", (left, right) -> left / right);

    private static final Map<String, Operator> OPERATORS = Collections.unmodifiableMap(
            Stream.of(values()).collect(Collectors.toMap(Operator::getSymbol, Function.identity())));
    private final String symbol;
    private final IntBinaryOperator operation;

    Operator(String symbol, IntBinaryOperator operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public static Operator findBySymbol(String symbol) {
        return Optional.ofNullable(OPERATORS.get(symbol)).orElseThrow(() -> new IllegalArgumentException("Unknown Operator"));
    }

    public int operate(int left, int right) {
        return operation.applyAsInt(left, right);
    }

    public String getSymbol() {
        return symbol;
    }

    public IntBinaryOperator getOperation() {
        return operation;
    }
}
