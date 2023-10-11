package level2.num012914;

// Solution 클래스 정의
public class Solution {

	// solution() 메서드 정의
	public static long solution(int n) {

		// 멀리 뛰기의 칸이 1칸인 경우 1을 반환
		if (n == 1)
            return 1;
        
		// 각 칸에 도달하는 방법의 수를 저장할 배열 counts 초기화
		long[] counts = new long[n + 1];
		
		// 첫 두 칸의 방법의 수를 갱신
		counts[1] = 1;
		counts[2] = 2;
        
        // for 반복문을 사용해 각 칸에 도달하는 방법의 수를 갱신
		for (int idx = 3; idx <= n; idx++)
			counts[idx] = (counts[idx - 1] + counts[idx - 2]) % 1234567;

        // 해당 칸까지 도달하는 방법의 수를 반환
        return counts[n];
    }
}