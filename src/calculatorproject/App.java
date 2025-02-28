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
        int appSaveResultCounter=0;
        String delite;

        do {
            // 양의 정수 입력받기
            System.out.println("계산기 입니다. 두 숫자를 입력하세요");

            System.out.print("첫번째 숫자입니다. ");
            firstIntergerApp = scanner.nextInt();
            calculator.setInterger(firstIntergerApp);

            System.out.print("두번째 숫자입니다. ");
            secondIntergerApp = scanner.nextInt();
            calculator.setInterger(secondIntergerApp);

            System.out.println("당신이 입력한 두 숫자입니다. 첫번째는 " + firstIntergerApp + " 이고 두번째는 " + secondIntergerApp + " 입니다");

            scanner.nextLine(); // 버퍼에 남은 개행문자 제거

            System.out.println("사칙연산 기호를 넣어주세요 (+, -, *, /): ");
            String arithmeticOperations = scanner.nextLine();
            calculator.setOperation(arithmeticOperations.charAt(0));

            // 사칙 연산 계산기
            calculator.Calculator();

            // 결과 받아오기
            result = calculator.getResult();

            // 잘못 입력했을때 결과값 출력하지 않기
            if(!calculator.noShowResult) {
                System.out.println("값은: " + result);
                System.out.println("저장된 값은: " + calculator.getsaveResult() + " 입니다.");
                appSaveResultCounter++;
                calculator.setSaveResultCounter(appSaveResultCounter);
            }
            calculator.noShowResult = false;
            // 저장된 데이터 삭제 하기
            System.out.println("가장 먼저 저장된 데이터를 삭제 하실려면 delite를 입력하세요.");
            delite = scanner.nextLine();

            if (delite.equals("delite")) {
                if (appSaveResultCounter > 0) {
                    System.out.println("가장 먼저 저장된: " + calculator.setShowArraySaveResult() + " 를 삭제하였습니다.");
                    calculator.removeResult();
                    appSaveResultCounter--;
                    } else {
                    System.out.println("저장된 데이터가 없습니다!");
                }
            }
            System.out.println("계산기를 종료하고 싶으면 exit를 입력하세요.");
            end = scanner.nextLine();
        } while (!end.equals("exit"));
    }
}
