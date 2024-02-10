package level1.num070128;

// Solution 클래스 정의
public class Solution {

	// solution() 메서드 정의
	public static int solution(int[] a, int[] b) {
		
		// 각 정수 배열의 내적을 저장할 변수 innerProduct 초기화
		int innerProduct = 0;
		
		// for 반복문을 사용해 각 정수 배열의 내열을 갱신
		for (int idx = 0; idx < a.length; idx++)
			innerProduct += a[idx] * b[idx];

		// 각 정수 배열의 내적을 반환
		return innerProduct;
    }
}