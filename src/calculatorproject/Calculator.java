package calculatorproject;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    private int firstInterger;
    private int secondInterger;
    private double result;
    private char operation;
    public boolean noShowResult; // App과 Calculator의 데이터가 주고 받아야 하기에 public 선언
    private int intergerCounter=0;
    private int saveResultCounter=0;

    private ArrayList<Double> arraySaveResult = new ArrayList<>();
    //세터
    void setInterger(int Interger) {
        if (intergerCounter==0) {
            this.firstInterger = Interger;
        } else {
            this.secondInterger = Interger;
        }
        intergerCounter++;
    }
    void setOperation(char operation) {
        this.operation = operation;
    }
    void setSaveResultCounter(int saveResultCounter) {
        this.saveResultCounter = saveResultCounter;
    }
    double setShowArraySaveResult() {
        return this.arraySaveResult.get(0);
    }

    // 게터
    double getResult(){
        return this.result;
    }
    double getsaveResult(){
        return this.arraySaveResult.get(saveResultCounter);
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
                        noShowResult = true;
                    }
            }
        } else {
            System.out.println("사칙연산 기호가 아닙니다.");
            noShowResult = true;
        }
        intergerCounter = 0;
        arraySaveResult.add(result);
        return result;
    }

    public void removeResult() {
        arraySaveResult.remove(0);
    }
}