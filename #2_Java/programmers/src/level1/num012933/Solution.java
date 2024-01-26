package level1.num012933;

// Solution 클래스 정의
public class Solution {

	// solution() 메서드 정의
	public static long solution(long n) {
		
		// 자릿수를 큰 것부터 작은 것 순으로 정렬한 새로운 정수를 저장할 변수 sortedNumber 초기화
		long sortedNumber = 0;
		
		// 각 자릿수의 개수를 저장할 배열 count 초기화
		int[] count = new int[10];
		
		// while 반복문을 사용해 입력 받은 정수가 0이 될 때까지 순회
		while (n > 0) {
			
			// 해당 자릿수를 계산해 변수 digit에 할당
			int digit = (int) (n % 10);
			
			// 해당 자릿수의 개수를 갱신
			count[digit]++;
			
			// 입력 받은 정수를 갱신
			n /= 10;
		}
		
		// for 반복문을 사용해 각 자릿수의 개수를 순회
		for (int digit = 9; digit >= 0; digit--) {
			
			// for 반복문을 사용해 해당 자릿수의 개수만큼 순회하며 새로운 정수를 갱신
			for (int c = 0; c < count[digit]; c++) {
				sortedNumber *= 10;
				sortedNumber += digit;
			}
		}
		
		// 자릿수를 큰 것부터 작은 것 순으로 정렬한 새로운 정수를 반환
		return sortedNumber;
    }
}