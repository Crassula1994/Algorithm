package level1.num068644;

// 필요한 패키지 불러오기
import java.util.Set;
import java.util.TreeSet;

// Solution 클래스 정의
public class Solution {

	// solution() 메서드 정의
	public static int[] solution(int[] numbers) {
		
		// 두 개의 수를 더해서 만들 숫자를 저장할 Set 객체 sumSorter 초기화
		Set<Integer> sumSorter = new TreeSet<>();
		
		// for 반복문을 사용해 서로 다른 인덱스의 두 수를 더한 수를 sumSorter에 추가
		for (int n1 = 0; n1 < numbers.length - 1; n1++) {
			for (int n2 = n1 + 1; n2 < numbers.length; n2++) 
				sumSorter.add(numbers[n1] + numbers[n2]);
		}
		
		// size() 메서드를 사용해 서로 다른 인덱스의 두 수를 더한 수를 저장할 배열 sumNumbers 초기화
		int[] sumNumbers = new int[sumSorter.size()];
		
		// sumNumbers 배열의 인덱스를 저장할 변수 index 초기화
		int index = 0;
		// for 반복문을 사용해 서로 다른 인덱스의 두 수를 더한 수를 배열 sumNumbers에 저장
		for (int number : sumSorter)
			sumNumbers[index++] = number;
		
		// 서로 다른 인덱스의 두 수를 더한 수를 저장한 배열 반환
		return sumNumbers;
    }
}