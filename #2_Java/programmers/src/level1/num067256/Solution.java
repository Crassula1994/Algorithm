package level1.num067256;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static String solution(int[] numbers, String hand) {
		
		// 각 번호를 누른 손가락이 왼손인지 오른손인지 저장할 StringBuilder 객체 sb 초기화
		StringBuilder sb = new StringBuilder();
		
		// 왼손과 오른손의 위치를 저장할 각 배열 초기화
		int[] leftHand = new int[] {3, 0};
		int[] rightHand = new int[] {3, 2};
		
		// 각 번호의 위치를 저장할 2차원 배열 numpad 초기화
		int[][] numpad = new int[][] {
			{3, 1}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}
		};
		
		// for 반복문을 사용해 각 번호를 순회
		for (int number : numbers) {
			
			// 번호가 1, 4, 7의 경우 왼손을 사용한 것으로 처리
			if (number == 1 || number == 4 || number == 7) {
				sb.append("L");
				leftHand = numpad[number];
				
			// 번호가 3, 6, 9의 경우 오른손을 사용한 것으로 처리
			} else if (number == 3 || number == 6 || number == 9) {
				sb.append("R");
				rightHand = numpad[number];
				
			// 번호가 2, 5, 8, 0인 경우
			} else {
				
				// abs() 메서드를 사용해 두 손의 거리를 계산해 각 변수에 할당
				int distL = Math.abs(leftHand[0] - numpad[number][0]) + Math.abs(leftHand[1] - numpad[number][1]);
				int distR = Math.abs(rightHand[0] - numpad[number][0]) + Math.abs(rightHand[1] - numpad[number][1]);
				
				// 왼손을 사용해야 하는 경우 왼손을 사용한 것으로 처리
				if (distL < distR || (distL == distR && hand.equals("left"))) {
					sb.append("L");
					leftHand = numpad[number];
					
				// 오른손을 사용해야 하는 경우 오른손을 사용한 것으로 처리
				} else {
					sb.append("R");
					rightHand = numpad[number];
				}
			}
		}
		
		// toString() 메서드를 사용해 각 번호를 누른 손가락이 왼손인지 오른손인지 저장한 문자열을 반환
        return sb.toString();
    }
}