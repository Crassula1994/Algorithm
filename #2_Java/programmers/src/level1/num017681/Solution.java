package level1.num017681;

// Solution 클래스 정의
public class Solution {

	// solution() 메서드 정의
	public static String[] solution(int n, int[] arr1, int[] arr2) {
		
		// 비밀지도를 저장할 배열 secretMap 초기화
		String[] secretMap = new String[n];
		
		// for 반복문을 사용해 지도 1과 지도 2의 각 정수를 순회
		for (int r = 0; r < n; r++) {
			
			// toBinaryString(), parseLong(), format() 메서드를 사용해 지도 1과 지도 2의 주어진 정수를 2진수로 바꾸어 각 변수에 할당
			String binaryNum1 = String.format("%0" + n + "d", Long.parseLong(Long.toBinaryString(arr1[r])));
			String binaryNum2 = String.format("%0" + n + "d", Long.parseLong(Long.toBinaryString(arr2[r])));
			
			// StringBuilder 객체를 불러와 변수 sb에 할당
			StringBuilder sb = new StringBuilder();
			
			// for 반복문을 사용해 2진수의 각 자릿수를 순회
			for (int c = 0; c < n; c++) {
				
				// 해당 자릿수 중 한 개 이상이 1인 경우 벽을 추가
				if (binaryNum1.charAt(c) == '1' || binaryNum2.charAt(c) == '1') {
					sb.append("#");
					
				// 해당 자릿수가 모두 0인 경우 공백을 추가
				} else {
					sb.append(" ");
				}
			}
			
			// toString() 메서드를 사용해 해당 행의 상태를 배열 secretMap에 저장
			secretMap[r] = sb.toString();
		}
		
		// 비밀지도를 저장한 배열 반환
		return secretMap;
    }
}