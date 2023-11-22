package level1.num087389;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static int solution(int n) {

		// 나머지가 1이 되도록 하는 가장 작은 자연수를 저장할 변수 minDivisor 초기화
		int minDivisor = 0;
        
		// for 반복문을 사용해 각 자연수를 차례로 순회
        for (int divisor = 2; divisor < n; divisor++) {
        	
        	// 나머지가 1인 경우 나머지가 1이 되도록 하는 가장 작은 자연수를 갱신 후 반복문 탈출
            if (n % divisor == 1) {
            	minDivisor = divisor;
                break;
            }
        }
        
        // 나머지가 1이 되도록 하는 가장 작은 자연수를 반환
        return minDivisor;
    }
}