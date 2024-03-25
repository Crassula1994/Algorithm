package level1.num012950;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static int[][] solution(int[][] arr1, int[][] arr2) {
		
		// 행렬의 크기를 나타낼 각 변수 초기화
		int row = arr1.length;
		int column = arr1[0].length;
		
		// 행렬 덧셈의 결과를 저장할 2차원 배열 result 초기화
		int[][] result = new int[row][column];
		
		// for 반복문을 사용해 행렬의 덧셈 결과를 갱신
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < column; c++)
				result[r][c] = arr1[r][c] + arr2[r][c];
		}
		
		// 행렬 덧셈의 결과를 반환
		return result;
    }
}