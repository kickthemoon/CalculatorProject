package calculatorproject;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("계산기 입니다. 두 숫자를 입력 하세요");

        System.out.print("첫번째 숫자 입니다. ");
        int firstInterger = scanner.nextInt();

        System.out.print("두번째 숫자 입니다. ");
        int secondInterger = scanner.nextInt();

        System.out.println("당신이 입력한 두 숫자 입니다. 첫번째는 " + firstInterger + " 이고 두번째는 " + secondInterger + " 입니다");

    }
}
