package level1.num012910;

// 필요한 패키지 불러오기
import java.util.PriorityQueue;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static int[] solution(int[] arr, int divisor) {
		
		// 나누어 떨어지는 숫자를 오름차순으로 정렬할 PriorityQueue 객체 sorter 초기화
		PriorityQueue<Integer> sorter = new PriorityQueue<>();
		
		// for 반복문을 사용해 배열의 각 원소를 순회
		for (int idx = 0; idx < arr.length; idx++) {
			
			// 해당 배열의 원소를 변수 element에 할당
			int element = arr[idx];
			
			// 해당 원소가 나누어 떨어지는 경우 sorter에 저장
			if (element % divisor == 0)
				sorter.offer(element);
		}
		
		// 나누어 떨어지는 숫자가 없는 경우 -1을 담은 배열 반환
		if (sorter.isEmpty())
			return new int[] {-1};
		
		// 값을 저장할 배열의 인덱스를 나타낼 변수 index 초기화
		int index = 0;
		
		// 나누어 떨어지는 숫자를 저장할 배열 sortedArray 초기화
		int[] sortedArray = new int[sorter.size()];
		
		// while 반복문을 사용해 나누어 떨어지는 숫자를 배열 sortedArray에 저장
		while (!sorter.isEmpty())
			sortedArray[index++] = sorter.poll();
		
		// 나누어 떨어지는 숫자를 저장한 배열 반환
		return sortedArray;
    }
}