import java.util.Scanner;

public class StringCalculator {

    private Scanner scanner = new Scanner(System.in);

    public String[] convert() {
        String value = scanner.nextLine();
        return value.split(" ");
    }

    public int calculate(String[] values) {
        int total = 0;
        char operator = '+';
        for (String value : values) {
            char charValue = value.charAt(0);
            if(!Character.isDigit(charValue)){
                operator = charValue;
                continue;
            }
            total = Operator.findBySymbol(String.valueOf(operator)).operate(total,Integer.parseInt(value));
        }
        return total;
    }

}
