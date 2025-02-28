package calculatorproject;

public class Calculator {
    int firstInterger;
    int secondInterger;
    double result;
    char operation;
    boolean noResult;

    public double Calculator() {

        if (operation == '+' || operation == '-' || operation == '*' || operation == '/') {
            switch (operation) {
                case '+':
                    result = firstInterger + secondInterger;
                    break;
                case '-':
                    result = firstInterger - secondInterger;
                    break;
                case '*':
                    result = firstInterger * secondInterger;
                    break;
                case '/':
                    if (secondInterger != 0) {
                        result = firstInterger / (double) secondInterger;
                        break;
                    } else {
                        System.out.println("두번째 숫자에는 0이 오면 나눌 수 없습니다.");
                        noResult = true;
                    }
            }
        } else {
            System.out.println("사칙연산 기호가 아닙니다.");
            noResult = true;
        }
        return result;
    }
}