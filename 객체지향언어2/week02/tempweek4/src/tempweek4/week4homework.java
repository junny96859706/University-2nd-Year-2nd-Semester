package tempweek4;

import java.util.Scanner;

// 배열 조작 유틸리티 클래스
class ArrayUtil {
    // a와 b를 연결한 새로운 배열을 리턴
    public static int[] concat(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            result[a.length + i] = b[i];
        }
        
        return result;
    }

    // 배열 a를 출력
    public static void print(int[] a) {
        System.out.print("[ ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("]");
    }
}

// 메인 클래스
public class week4homework {
    public static void main(String[] args) {
        // 과제 필수 조건: 제출자 이름 출력
        System.out.println("제출자: 이지형");
        System.out.println();

        int[] array1 = { 1, 5, 7, 9 };
        int[] array2 = { 3, -1, 100, 77 };
        
        int[] array3 = ArrayUtil.concat(array1, array2);
        ArrayUtil.print(array3);
    }
}