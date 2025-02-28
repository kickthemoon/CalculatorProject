package calculatorproject;

public class Calculator {
    private int firstInterger;
    private int secondInterger;
    private double result;
    private char operation;
    public boolean noshowResult;

    //세터
    void setFirstInterger(int firstInterger) {
        this.firstInterger = firstInterger;
    }
    void setSecondInterger(int secondInterger) {
        this.secondInterger = secondInterger;
    }
    void setOperation(char operation) {
        this.operation = operation;
    }

    // 게터
    double getResult(){
        return this.result;
    }


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
                        noshowResult = true;
                    }
            }
        } else {
            System.out.println("사칙연산 기호가 아닙니다.");
            noshowResult = true;
        }
        return result;
    }
}