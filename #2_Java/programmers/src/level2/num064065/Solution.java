package level2.num064065;

// 필요한 패키지 불러오기
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static int[] solution(String s) {
		
		// 문자열의 길이에 따라 정렬할 PriorityQueue 객체 stringSorter 초기화
		PriorityQueue<String> stringSorter = new PriorityQueue<>((s1, s2) -> {
            return s1.length() - s2.length();
        });
		
		// 이미 튜플에 저장된 숫자를 저장할 Set 객체 uniqueNumbers 초기화
		Set<Integer> uniqueNumbers = new HashSet<>();
		
		// 튜플을 순서대로 저장할 List 객체 tupleList 초기화
		List<Integer> tupleList = new ArrayList<>();
		
		// length() 및 substring() 메서드를 사용해 양끝의 중괄호를 제거한 문자열을 변수 elementStr에 할당
		String elementStr = s.substring(2, s.length() - 2);
		
		// split() 메서드를 사용해 각 집합의 문자열을 배열 elements에 저장
		String[] elements = elementStr.split("\\},\\{");
        
		// for 반복문을 사용해 각 집합의 문자열을 stringSorter에 추가
        for (int idx = 0; idx < elements.length; idx++)
            stringSorter.offer(elements[idx]);
        
        // while 반복문을 사용해 stringSorter가 빌 때까지 순회
        while (!stringSorter.isEmpty()) {
            
        	// StringTokenizer 객체를 불러와 변수 st에 할당
            StringTokenizer st = new StringTokenizer(stringSorter.poll(), ",");
            
            // countTokens() 메서드를 사용해 원소의 개수를 변수 size에 할당
            int size = st.countTokens();
            
            // for 반복문을 사용해 각 원소를 순회
            for (int idx = 0; idx < size; idx++) {
            	
            	// nextToken() 및 parseInt() 메서드를 사용해 해당 원소를 변수 element에 할당
                int element = Integer.parseInt(st.nextToken());
                
                // 해당 원소가 이미 튜플에 저장된 경우 다음 원소를 순회
                if (uniqueNumbers.contains(element))
                    continue;
                
                // add() 메서드를 사용해 uniqueNumbers 및 tupleList에 해당 원소 추가
                uniqueNumbers.add(element);
                tupleList.add(element);
                
                // 반복문 탈출
                break;
            }
        }
        
        // size() 메서드를 사용해 튜플을 배열에 담아 저장할 배열 tupleArray 초기화
        int[] tupleArray = new int[tupleList.size()];
        
        // for 반복문을 사용해 tupleList의 원소를 tupleArray에 저장
        for (int idx = 0; idx < tupleArray.length; idx++)
        	tupleArray[idx] = tupleList.get(idx);
        
        // 튜플의 원소를 배열에 담아 반환
        return tupleArray;
    }
}