package calculatorproject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

// 제네릭 메서드 선언, 제네릭 함수로 스캐너 받기
public class Calculator<T> {
    private T firstNumber;
    private T secondNumber;;
    private double result;
    private char operator;
    private boolean isShowResult;

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
    T getFirstNumber() {
        return this.firstNumber;
    }

    T getSecondNumber() {
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

    boolean getIsShowResult() {
        return this.isShowResult;
    }

    List<Double> getArraylistResult() {
        return arrayResult;
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

        public static Operation fromSymbol(char symbol) {
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
        isShowResult = true;
        Operation operation = Operation.fromSymbol(operator);
        if (operation != null) {
            result = operation.apply((double) firstNumber, (double) secondNumber);
            arrayResult.add(result);
        } else {
            System.out.println("잘못된 연산자입니다");
            System.out.println(arrayResult);
            isShowResult = false;
        }
        return result;
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