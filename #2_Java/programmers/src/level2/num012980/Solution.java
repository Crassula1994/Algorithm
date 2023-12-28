package level2.num012980;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static int solution(int n) {

		// 사용해야 하는 건전지 사용량의 최솟값을 저장할 변수 minAmount 초기화
		int minAmount = 0;
        
		// while 반복문을 사용해 이동하려는 거리가 0이 될 때까지 순회
        while (n > 0) {
            
        	// 이동하려는 거리가 짝수인 경우 순간 이동을 한 것으로 처리
            if (n % 2 == 0) {
                n /= 2;
                
            // 이동하려는 거리가 홀수인 경우 한 칸 점프하여 건전지를 1 사용한 것으로 처리
            } else {
                n -= 1;
                minAmount++;
            }
        }
        
        // 사용해야 하는 건전지 사용량의 최솟값을 반환
        return minAmount;
	}
}