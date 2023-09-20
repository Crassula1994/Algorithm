package level2.num12913;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static int solution(int[][] land) {

		// 각 행을 선택했을 때의 최대 점수를 저장할 2차원 배열 maxPoints 초기화
		int[][] maxPoints = new int[land.length][4];

		// for 반복문을 사용해 첫 번째 행의 최대 점수를 초기화
		for (int idx = 0; idx < 4; idx++)
			maxPoints[0][idx] = land[0][idx];

		// for 반복문을 사용해 두 번째 행부터 마지막 행까지 순회
		for (int r = 1; r < land.length; r++) {

			// for 반복문을 사용해 각 열을 순회
			for (int c = 0; c < 4; c++) {

				// for 반복문을 사용해 이전 행의 각 열을 순회
				for (int d = 0; d < 4; d++) {

					// 이전 행이 현재 행과 같은 열이 아닌 경우 최대 점수를 갱신
					if (d != c)
						maxPoints[r][c] = Math.max(maxPoints[r - 1][d] + land[r][c], maxPoints[r][c]);
				}
			}
		}

		// 최고점을 저장할 변수 maxPoint 초기화
		int maxPoint = 0;

     	// for 반복문을 사용해 최고점을 갱신
     	for (int idx = 0; idx < 4; idx++)
    	 	maxPoint = Math.max(maxPoints[land.length - 1][idx], maxPoint);
     	
     	// 최고점을 반환
     	return maxPoint;
	}
}