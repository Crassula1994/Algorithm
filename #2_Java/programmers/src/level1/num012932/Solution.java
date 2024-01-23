package level1.num012932;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static int[] solution(long n) {

		// valueOf() 및 length() 메서드를 사용해 각 자리 숫자를 저장할 배열 digits 초기화
		int[] digits = new int[String.valueOf(n).length()];
		
		// 현재 숫자를 저장할 배열의 인덱스를 나타낼 변수 index 초기화
		int index = 0;
		
		// while 반복문을 사용해 숫자가 0이 될 때까지 순회
		while (n > 0) {
			
			// 각 자리 숫자를 배열 digits에 저장
			digits[index++] = (int) (n % 10);
			
			// 숫자를 갱신
			n /= 10;
		}
		
        // 각 자리 숫자를 저장한 배열 반환
        return digits;
    }
}