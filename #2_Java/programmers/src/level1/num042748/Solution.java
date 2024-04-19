package level1.num042748;

// 필요한 패키지 불러오기
import java.util.PriorityQueue;

// Solution 클래스 정의
public class Solution {

	// solution() 메서드 정의
	public static int[] solution(int[] array, int[][] commands) {
		
		// 각 연산을 적용했을 때 나온 결과를 저장할 배열 results 초기화
		int[] results = new int[commands.length];
		
		// for 반복문을 사용해 각 연산을 순회
		for (int c = 0; c < commands.length; c++) {
			
			// 해당 연산을 수행한 결과를 저장할 변수 result 초기화
			int result = 0;
			
			// 해당 연산을 배열 commands에 할당
			int[] command = commands[c];
			
			// 자른 배열을 오름차순으로 정렬할 PriorityQueue 객체 arraySorter 초기화
			PriorityQueue<Integer> arraySorter = new PriorityQueue<>();
			
			// for 반복문을 사용해 자른 배열의 원소를 arraySorter에 저장
			for (int idx = command[0] - 1; idx < command[1]; idx++)
				arraySorter.offer(array[idx]);
			
			// for 반복문을 사용해 연산을 수행한 결과를 갱신
			for (int count = 0; count < command[2]; count++)
				result = arraySorter.poll();
			
			// 해당 연산을 수행한 결과를 배열 results에 저장
			results[c] = result;
		}
		
		// 각 연산을 적용했을 때 나온 결과를 저장한 배열을 반환
		return results;
    }
}