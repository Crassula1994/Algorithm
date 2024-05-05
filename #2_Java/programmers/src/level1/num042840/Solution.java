package level1.num042840;

// 필요한 패키지 불러오기
import java.util.ArrayList;
import java.util.List;

// Solution 클래스 정의
public class Solution {

	// solution() 메서드 정의
	public static int[] solution(int[] answers) {
		
		// 각 수포자가 정답을 맞힌 개수를 저장할 배열 counts 초기화
		int[] counts = {0, 0, 0, 0};
		
		// 각 수포자가 정답을 찍는 방식을 저장할 각 배열 초기화
		int[] student1 = {1, 2, 3, 4, 5};
		int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		
		// for 반복문을 사용해 각 문제의 정답을 순회
		for (int idx = 0; idx < answers.length; idx++) {
			
			// 해당 문제의 정답을 변수 answer에 할당
			int answer = answers[idx];
			
			// 1번 수포자가 정답을 맞힌 경우 1번 수포자가 정답을 맞힌 개수를 갱신
			if (answer == student1[idx % 5])
				counts[1]++;
			
			// 2번 수포자가 정답을 맞힌 경우 2번 수포자가 정답을 맞힌 개수를 갱신
			if (answer == student2[idx % 8])
				counts[2]++;
			
			// 3번 수포자가 정답을 맞힌 경우 3번 수포자가 정답을 맞힌 개수를 갱신
			if (answer == student3[idx % 10])
				counts[3]++;
		}
		
		// 정답을 가장 많이 맞힌 수포자의 번호를 저장할 List 객체 maxWinner 초기화
		List<Integer> maxWinner = new ArrayList<>();
		
		// max() 메서드를 사용해 가장 정답을 많이 맞힌 개수를 변수 maxCount에 할당
		int maxCount = Math.max(counts[1], Math.max(counts[2], counts[3]));
		
		// for 반복문을 사용해 각 수포자를 순회
		for (int idx = 1; idx <= 3; idx++) {
			
			// 해당 수포자가 가장 정답을 많이 맞힌 경우 maxWinner에 추가
			if (maxCount == counts[idx])
				maxWinner.add(idx);
		}
		
		// stream(), mapToInt(), toArray() 메서드를 사용해 정답을 가장 많이 맞힌 수포자의 번호를 저장한 배열을 반환
		return maxWinner.stream().mapToInt(i -> i).toArray();
    }
}