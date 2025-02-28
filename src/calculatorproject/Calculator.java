package calculatorproject;

import java.util.ArrayList;


public class Calculator {
    private int firstInteger;
    private int secondInteger;
    private double result;
    private char operation;
    private boolean isShowResult; // App과 Calculator의 데이터가 주고 받아야 하기에 protected 선언


    // 배열 선언
    private ArrayList<Double> arrayResult = new ArrayList<>();

    //세터
    void firstInteger(int Integer) {
        this.firstInteger = Integer;
    }
    void secondInteger(int Integer) {
        this.secondInteger = Integer;
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
    public double Calculator() {
        switch (operation) {
            case '+':
                result = firstInteger + secondInteger;
                arrayResult.add(result);
                break;
            case '-':
                result = firstInteger - secondInteger;
                arrayResult.add(result);
                break;
            case '*':
                result = firstInteger * secondInteger;
                arrayResult.add(result);
                break;
            case '/':
                if (secondInteger != 0) {
                    result = firstInteger / (double) secondInteger;
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
        arrayResult.remove(0);
    }
}