package calculatorproject;

import java.util.ArrayList;
import java.util.function.BiFunction;

public class Calculator {
    private int firstNumber;
    private int secondNumber;
    private double result;
    private char operator;
    private boolean isShowResult;

    // 배열 선언
    private ArrayList<Double> arrayResult = new ArrayList<>();

    //세터
    void setFirstNumber(int Num) {
        this.firstNumber = Num;
    }
    void setSecondNumber(int Num) {
        this.secondNumber = Num;
    }
    void setOperation(char operator) {
        this.operator = operator;
    }
    void setIsShowResult(boolean isShowResult){
        this.isShowResult = isShowResult;
    }


    // 게터
    double getResult(){
        return this.result;
    }
    double getArrayResultSize(){
        return this.arrayResult.size();
    }
    double getArrayResultFirst() {
        return this.arrayResult.get(0);
    }
    boolean getIsShowResult() {
        return this.isShowResult;
    }
    // enum 을 이용한 사칙연산 계산기
    enum Operation {
        ADD('+', (x, y) -> x + y),
        SUBTRACT('-', (x, y) -> x - y),
        MULTIPLY('*', (x, y) -> x * y),
        DIVIDE('/', (x, y) -> {
            if (y == 0) throw new ArithmeticException("0으로 나눌 수 없습니다.");

            return x / y;
        });

        private final char symbol;
        private final BiFunction<Double, Double, Double> operation;

        Operation(char symbol, BiFunction<Double, Double, Double> operation) {
            this.symbol = symbol;
            this.operation = operation;
        }

        public double apply(double x, double y) {
            return operation.apply(x, y);
        }

        public static Operation fromSymbol (char symbol) {
            for (Operation op : values()) {
                if (op.symbol == symbol) {
                    return op;
                }
            }
            return null;
        }
    }

    // 실질적으로 계산 처리 하는 메소드
    public double calculator() {
        Operation operation = Operation.fromSymbol(operator);
        if(operation != null) {
            result = operation.apply(firstNumber, secondNumber);
            arrayResult.add(result);
        } else {
            System.out.println("잘못된 연산자입니다");
            isShowResult = false;
        }
        return result;
    }

    // 제거 메소드
    public void removeResult() {
        this.arrayResult.remove(0);
    }
}