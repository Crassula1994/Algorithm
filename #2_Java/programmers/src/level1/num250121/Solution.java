package level1.num250121;

// 필요한 패키지 불러오기
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static int[][] solution(int[][] data, String ext, int valExt, String sortBy) {
		
		// 뽑아낼 정보의 기준 인덱스 및 정렬 기준 인덱스를 저장할 각 변수 초기화
		int validIndex = 0;
		int sortByIndex = 0;
		
		// switch 조건문을 사용해 뽑아낼 정보의 기준 인덱스를 갱신
		switch (ext) {
			case "date":
				validIndex = 1;
				break;
			case "maximum":
				validIndex = 2;
				break;
			case "remain":
				validIndex = 3;
		}
		
		// switch 조건문을 사용해 정렬 기준 인덱스를 갱신
		switch (sortBy) {
			case "date":
				sortByIndex = 1;
				break;
			case "maximum":
				sortByIndex = 2;
				break;
			case "remain":
				sortByIndex = 3;
		}
		
		// 정렬 기준 인덱스를 변수 sortIndex에 할당
		int sortIndex = sortByIndex;
		
		// 기준에 적합한 데이터를 저장할 List 객체 sortedData 초기화
		List<int[]> sortedData = new ArrayList<>();
		
		// for 반복문을 사용해 각 데이터를 순회
		for (int[] datum : data) {
			
			// 해당 데이터가 기준을 만족하는 경우 sortedData에 추가
			if (datum[validIndex] < valExt)
				sortedData.add(datum);
		}

		// sort() 메서드를 사용해 정렬 기준에 따라 오름차순으로 정렬
		Collections.sort(sortedData, (d1, d2) -> {
			return d1[sortIndex] - d2[sortIndex];
		});
		
		// toArray() 메서드를 사용해 뽑아낸 데이터를 정렬한 결과를 2차원 배열로 반환
        return sortedData.toArray(new int[0][]);
    }
}