package calculatorproject;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String end;

        do {
            // 양의 정수 입력받기
            System.out.println("계산기 입니다. 두 숫자를 입력하세요");

            System.out.print("첫번째 숫자입니다. ");
            int firstInterger = scanner.nextInt();

            System.out.print("두번째 숫자입니다. ");
            int secondInterger = scanner.nextInt();

            System.out.println("당신이 입력한 두 숫자입니다. 첫번째는 " + firstInterger + " 이고 두번째는 " + secondInterger + " 입니다");

            scanner.nextLine(); // 버퍼에 남은 개행문자 제거

            // 사칙연산 기호 입력받기
            double result = 0;

            while (true) {
                System.out.println("사칙연산 기호를 넣어주세요 (+, -, *, /): ");
                String arithmeticOperations = scanner.nextLine();
                char operation = arithmeticOperations.charAt(0);

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
                                continue;
                            }
                    }
                    break;
                } else {
                    System.out.println("사칙연산 기호가 아닙니다.");
                }
            }
            System.out.println("값은: " + result);
            System.out.println("계산기를 종료하고 싶으면 exit를 입력하세요.");
            end = scanner.nextLine();
        } while (!end.equals("exit"));
    }
}
