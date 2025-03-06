package calculatorproject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

// 제네릭 메서드 선언, 제네릭 함수로 스캐너 받기
public class Calculator<T> {
    private T firstNumber;
    private T secondNumber;
    private double result;
    private char operator;
    private boolean againSymbol;

    // 배열 선언
    private ArrayList<Double> arrayResult = new ArrayList<>();

    //세터
    void setFirstNumber(T num) {
        this.firstNumber = num;
    }
    void setSecondNumber(T num) {
        this.secondNumber = num;
    }
    void setOperation(char operator) {
        this.operator = operator;
    }

    // 게터
    T getSeSecondNumber() {
        return this.secondNumber;
    }
    double getResult() {
        return this.result;
    }
    double getArrayResultSize() {
        return this.arrayResult.size();
    }
    double getArrayResultFirst() {
        return this.arrayResult.get(0);
    }
    boolean getAgainSymbol() {
        return this.againSymbol;
    }
    char getOperator(){
        return  this.operator;
    }
    List<Double> getArraylistResult() {
        return arrayResult;
    }

    // enum 을 이용한 사칙연산 계산기
    enum Operation {
        ADD('+', (x, y) -> x + y),
        SUBTRACT('-', (x, y) -> x - y),
        MULTIPLY('*', (x, y) -> x * y),
        DIVIDE('/', (x, y) -> x / y),
        REMAIN('%', (x,y) -> x % y),
        SQUARE('^', (x,y) -> Math.pow(x,y)),
        ROOT('(', (x,y) -> Math.sqrt(x));

        private final char symbol;
        private final BiFunction<Double, Double, Double> operation;

        Operation(char symbol, BiFunction<Double, Double, Double> operation) {
            this.symbol = symbol;
            this.operation = operation;
        }

        public double apply(double x, double y) {
            return operation.apply(x, y);
        }

        public static Operation fromSymbol(char symbol) {
            for (Operation op : values()) {
                if (op.symbol == symbol) {
                    return op;
                }
            }
            return null;
        }
    }

    // 실질적으로 계산 처리하는 메소드
    public double calculator() {
        Operation inOperation = Operation.fromSymbol(operator);
        if (inOperation != null) {
            result = inOperation.apply((double) firstNumber, (double) secondNumber);
            arrayResult.add(result);
        }
        return result;
    }

    // 연산기호를 잘못 받으면 수행되는 메소드
    public boolean doAgainSymbol() {
        Operation operation = Operation.fromSymbol(operator);
        if (operation != null) {
            return againSymbol = false;
        } else {
            return againSymbol = true;
        }
    }

    // 저장된 값 중 첫번째 저장값 제거 메소드
    public void removeResult() {
        this.arrayResult.remove(0);
    }

    // 저장된 값을 스캔한 값과 비교해서 큰 숫자 출력
    public void moreHughesResult(double value) {
        List<Double> HughesResult = arrayResult.stream().filter(num -> num>value).collect(Collectors.toList());

        if(HughesResult.isEmpty()) {
            System.out.println("저장된 값 중 입력된 값보다 큰 숫자는 없습니다.");
        } else {
            System.out.println("입력된 값보다 큰 저장된 숫자들: " + HughesResult);
        }
    }
}
