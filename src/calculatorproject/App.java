package calculatorproject;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        String end;
        double result;
        int firstIntergerApp;
        int secondIntergerApp;

        do {
            // 양의 정수 입력받기
            System.out.println("계산기 입니다. 두 숫자를 입력하세요");

            System.out.print("첫번째 숫자입니다. ");
            firstIntergerApp = scanner.nextInt();
            calculator.setFirstInterger(firstIntergerApp);

            System.out.print("두번째 숫자입니다. ");
            secondIntergerApp = scanner.nextInt();
            calculator.setSecondInterger(secondIntergerApp);

            System.out.println("당신이 입력한 두 숫자입니다. 첫번째는 " + 1 + " 이고 두번째는 " + 2 + " 입니다");

            scanner.nextLine(); // 버퍼에 남은 개행문자 제거

            System.out.println("사칙연산 기호를 넣어주세요 (+, -, *, /): ");
            String arithmeticOperations = scanner.nextLine();
            calculator.setOperation(arithmeticOperations.charAt(0));

            // 사칙 연산 계산기
            calculator.Calculator();

            // 결과 받아오기
            result = calculator.getResult();

            //잘못 입력했을때 결과값 출력하지 않기
            if(!calculator.noshowResult) {
                System.out.println("값은: " + result);
            }
            calculator.noshowResult = false;

            System.out.println("계산기를 종료하고 싶으면 exit를 입력하세요.");
            end = scanner.nextLine();
        } while (!end.equals("exit"));
    }
}
