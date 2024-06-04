package level1.num131128;

// Solution 클래스 정의
public class Solution {

	// solution() 메서드 정의
	public static String solution(String X, String Y) {
		
		// X, Y의 짝궁을 저장할 StringBuilder 객체 sb 초기화
		StringBuilder sb = new StringBuilder();
		
		// X와 Y의 각 숫자의 개수를 저장할 2차원 배열 counts 초기화
		int[][] counts = new int[10][2];
		
		// for 반복문을 사용해 X의 각 숫자의 개수를 배열 counts에 저장
		for (int idx = 0; idx < X.length(); idx++)
			counts[X.charAt(idx) - '0'][0]++;
		
		// for 반복문을 사용해 Y의 각 숫자의 개수를 배열 counts에 저장
		for (int idx = 0; idx < Y.length(); idx++)
			counts[Y.charAt(idx) - '0'][1]++;
		
		// for 반복문을 사용해 짝궁을 만들 수 있는 각 숫자를 순회
		for (int number = 9; number >= 0; number--) {
			
			// min() 메서드를 사용해 짝궁을 만들 수 있는 해당 숫자의 개수를 변수 count에 할당
			int count = Math.min(counts[number][0], counts[number][1]);
			
			// while 반복문을 사용해 짝궁을 만들 수 있는 해당 숫자의 개수만큼 해당 숫자를 sb에 추가
			while (count-- > 0)
				sb.append(number);
		}
		
		// 짝궁이 존재하지 않는 경우 -1을 반환
		if (sb.toString().isEmpty())
			return "-1";
		
		// X와 Y의 짝궁이 0으로만 구성되어 있는 경우 0을 반환
		if (sb.toString().charAt(0) == '0')
			return "0";
		
		// toString() 메서드를 사용해 X, Y의 짝궁을 반환
		return sb.toString();
	}
}