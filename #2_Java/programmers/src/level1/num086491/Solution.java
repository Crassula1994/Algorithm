package level1.num086491;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static int solution(int[][] sizes) {
		
		// 모든 명함을 담을 지갑의 크기를 저장할 각 변수 초기화
		int maxWidth = 0;
		int maxHeight = 0;
		
		// for 반복문을 사용해 각 명함의 크기를 순회
		for (int idx = 0; idx < sizes.length; idx++) {
		
			// 각 명함의 크기를 각 변수에 할당
			int width = sizes[idx][0];
			int height = sizes[idx][1];
			
			// min() 및 max() 메서드를 사용해 모든 명함을 담을 지갑의 크기를 갱신
			maxWidth = Math.max(Math.max(width, height), maxWidth);
			maxHeight = Math.max(Math.min(width, height), maxHeight);
		}
		
		// 모든 명함을 담을 지갑의 크기를 반환 
		return maxWidth * maxHeight;
    }
}