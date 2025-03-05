package calculatorproject;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        String end;
        double result;
        double firstScanNumber;
        double secondScanNumber;
        double compareNumber;
        String delete;

        do {
            // 양의 정수 입력받기, 숫자 입력 오류 예외처리
            System.out.println("계산기 입니다. 두 숫자를 입력하세요");

            while(true) {
                System.out.print("첫번째 숫자입니다. ");
                try{
                    calculator.setFirstNumber(scanner.nextDouble());
                    break;
                } catch (Exception e){
                    System.out.println("숫자가 아닙니다. 다시 입력하세요.");
                    scanner.nextLine();
                }
            }
            while(true) {
                System.out.print("두번째 숫자입니다. ");
                try{
                    calculator.setSecondNumber(scanner.nextDouble());
                    break;
                } catch (Exception e){
                    System.out.println("숫자가 아닙니다. 다시 입력하세요.");
                    scanner.nextLine();
                }
            }

            firstScanNumber = (double)calculator.getFirstNumber();
            secondScanNumber = (double)calculator.getSecondNumber();

            System.out.println("당신이 입력한 두 숫자입니다. 첫번째는 " + firstScanNumber + " 이고 두번째는 " + secondScanNumber + " 입니다");

            scanner.nextLine(); // 버퍼에 남은 개행문자 제거

            System.out.println("사칙연산 기호를 넣어주세요 (+, -, *, /): ");
            String arithmeticOperations = scanner.nextLine();
            calculator.setOperation(arithmeticOperations.charAt(0));

            // 사칙 연산 계산기
            calculator.calculator();

            // 결과 받아오기
            result = calculator.getResult();

            // 사칙연산 기호를 잘못 입력했을때 결과값 출력하지 않기
            if(calculator.getIsShowResult()!=false) {
                System.out.println("값은: " + result);
            }

            System.out.println("저장된 값은: " + calculator.getArraylistResult() + "입니다.");

            // 비교 숫자 받기
            while(true) {
                System.out.print("저장된 값과 비교할 숫자를 입력하세요.");
                try{
                    compareNumber = scanner.nextDouble();
                    break;
                } catch (Exception e){
                    System.out.println("숫자가 아닙니다. 다시 입력하세요.");
                    scanner.nextLine();
                }
            }
            // 비교 연산 함수 실행
            calculator.moreHughesResult(compareNumber);

            scanner.nextLine(); // 버퍼에 남은 개행문자 제거

            // 저장된 데이터 삭제 하기
            System.out.println("가장 먼저 저장된 데이터를 삭제 하실려면 delete를 입력하세요.");
            delete = scanner.nextLine();

            if (delete.equals("delete")) {
                if (calculator.getArrayResultSize()>0) {
                    System.out.println("가장 먼저 저장된: " + calculator.getArrayResultFirst() + " 를 삭제하였습니다.");
                    calculator.removeResult();
                } else {
                    System.out.println("저장된 데이터가 없습니다.");
                }
            }

            // exit로 프로그램 종료
            System.out.println("계산기를 종료하고 싶으면 exit를 입력하세요.");
            end = scanner.nextLine();
        } while (!end.equals("exit"));
    }
}
