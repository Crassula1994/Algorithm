package level1.num012935;

// Solution 클래스 정의
public class Solution {

	// solution() 메서드 정의
	public static int[] solution(int[] arr) {
		
		// 하나의 원소만 존재하는 경우 -1을 담은 배열을 반환
		if (arr.length < 2)
			return new int[] {-1};
		
		// 가장 작은 수를 저장할 각 변수 초기화
		int minValue = Integer.MAX_VALUE;
		
		// for 반복문을 사용해 배열의 각 원소를 순회
		for (int idx = 0; idx < arr.length; idx++) {
			
			// 해당 인덱스에 위치한 수를 변수 number에 할당
			int number = arr[idx];
			
			// 해당 수가 저장된 가장 작은 수보다 작은 경우 가장 작은 수를 갱신
			if (number < minValue)
				minValue = number;
		}
		
		// 가장 작은 수를 제거한 배열의 인덱스를 나타낼 변수 index 초기화
		int index = 0;
		
		// 가장 작은 수를 제거한 배열을 저장할 배열 removedArr 초기화
		int[] removedArr = new int[arr.length - 1];
		
		// for 반복문을 사용해 배열의 각 원소를 순회
		for (int idx = 0; idx < arr.length; idx++) {
			
			// 해당 인덱스에 위치한 수를 변수 number에 할당
			int number = arr[idx];
			
			// 해당 수가 저장된 가장 작은 수인 경우 다음 원소를 순회
			if (number == minValue)
				continue;
			
			// 가장 작은 수를 제거한 배열에 수를 저장
			removedArr[index++] = number;
		}
		
		// 가장 작은 수를 제거한 배열을 반환
		return removedArr;
    }
}