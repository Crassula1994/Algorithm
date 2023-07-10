package bronze2.num15596;

// Test 클래스 정의
public class Test {
	
	// sum() 메서드 정의
	long sum(int[] a) {
		
		// 총합을 저장할 변수 ans 초기화
		long ans = 0;
		
		// for 반복문을 사용해 배열 a의 각 원소를 순회하며 총합을 계산
		for (int element : a)
			ans += element;
		
		// 총합을 반환
		return ans;
	}
}