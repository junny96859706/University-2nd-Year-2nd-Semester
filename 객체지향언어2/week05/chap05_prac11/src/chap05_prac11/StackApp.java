package chap05_prac11;

import java.util.Scanner;

//스택 인터페이스 정의
interface Stack {
 int length();          // 현재 스택에 저장된 개수 리턴
 int capacity();        // 스택의 전체 저장 가능 개수(용량) 리턴
 String pop();          // 스택의 톱(top)에 있는 문자열 팝 및 리턴
 boolean push(String val); // 스택의 톱(top)에 문자열 푸시
}

//Stack 인터페이스를 구현하는 StringStack 클래스
class StringStack implements Stack {
 private String[] element; // 스택 배열
 private int tos;          // 스택 포인터 (톱 위치)

 // 생성자: 스택 용량을 입력받아 배열 생성
 public StringStack(int capacity) {
     element = new String[capacity];
     tos = 0; // 저장된 데이터 개수이자 다음 들어올 위치
 }

 @Override
 public int length() {
     return tos;
 }

 @Override
 public int capacity() {
     return element.length;
 }

 @Override
 public String pop() {
     if (tos == 0) {
         return null; // 스택이 비어있는 경우
     }
     tos--;
     return element[tos];
 }

 @Override
 public boolean push(String val) {
     if (tos == element.length) {
         return false; // 스택이 가득 찬 경우
     }
     element[tos] = val;
     tos++;
     return true;
 }
}

//메인 실행 클래스
public class StackApp {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

     // 1. 제출자 이름 출력 (필수 항목)
     System.out.println("제출자: 이지형");
     System.out.println();

     // 2. 스택 용량 입력 받기
     System.out.print("스택 용량>>");
     int capacity = scanner.nextInt();
     StringStack stack = new StringStack(capacity);

     // 3. 문자열 입력 및 푸시(push) 반복
     while (true) {
         System.out.print("문자열 입력>>");
         String str = scanner.next();

         if (str.equals("그만")) {
             break;
         }

         // 스택에 저장 시도
         boolean result = stack.push(str);
         if (!result) {
             System.out.println("스택이 꽉 차서 " + str + " 저장 불가");
         }
     }

     // 4. 스택에 저장된 문자열 팝(pop) 및 출력 (LIFO 순서)
     System.out.print("스택에 저장된 문자열 팝 : ");
     int len = stack.length();
     for (int i = 0; i < len; i++) {
         System.out.print(stack.pop() + " ");
     }
     System.out.println();

     scanner.close();
 }
}
