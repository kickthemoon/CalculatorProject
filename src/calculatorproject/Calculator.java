package calculatorproject;

import java.util.ArrayList;


public class Calculator {
    private int firstNumber;
    private int secondNumber;
    private double result;
    private char operation;
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
    void setOperation(char operation) {
        this.operation = operation;
    }
    void setIsShowResult(boolean isShowResult) {
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
    boolean getisShowResult() {
        return this.isShowResult;
    }

    // 계산기 메소드
    public double calculator() {
        switch (operation) {
            case '+':
                result = firstNumber + secondNumber;
                arrayResult.add(result);
                break;
            case '-':
                result = firstNumber - secondNumber;
                arrayResult.add(result);
                break;
            case '*':
                result = firstNumber * secondNumber;
                arrayResult.add(result);
                break;
            case '/':
                if (secondNumber != 0) {
                    result = firstNumber / (double) secondNumber;
                    arrayResult.add(result);
                    break;
                } else {
                    System.out.println("두번째 숫자에는 0이 오면 나눌 수 없습니다.");
                    isShowResult = true;
                    break;
                }
            default:
                System.out.println("사칙연산 기호가 아닙니다.");
                isShowResult = true;
        }
        return result;
    }

    // 제거 메소드
    public void removeResult() {
        this.arrayResult.remove(0);
    }
}