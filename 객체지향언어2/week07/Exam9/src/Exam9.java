public class Exam9 {
    
    // 두 정수 배열을 하나로 합쳐서 반환하는 메서드
    public static int[] concat(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        
        // 첫 번째 배열 복사
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i];
        }
        
        // 두 번째 배열 이어 붙이기
        for (int i = 0; i < b.length; i++) {
            result[a.length + i] = b[i];
        }
        
        return result;
    }

    // 배열 원소들을 양식에 맞게 출력하는 메서드
    public static void print(int[] a) {
        System.out.print("[ ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("]");
    }
}