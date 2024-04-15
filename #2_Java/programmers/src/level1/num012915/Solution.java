package level1.num012915;

// 필요한 패키지 불러오기
import java.util.PriorityQueue;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static String[] solution(String[] strings, int n) {
		
		// 정렬한 문자열을 저장할 배열 sortedStrings 초기화
		String[] sortedStrings = new String[strings.length];
		
		// 문자열을 주어진 인덱스에 따라 정렬할 PriorityQueue 객체 stringSorter 초기화
		PriorityQueue<String> stringSorter = new PriorityQueue<>((s1, s2) -> {
			return (s1.charAt(n) == s2.charAt(n)) ? s1.compareTo(s2) : s1.charAt(n) - s2.charAt(n);
		});
		
		// for 반복문을 사용해 주어진 문자열을 stringSorter에 추가
		for (String string : strings)
			stringSorter.offer(string);
		
		// for 반복문을 사용해 주어진 문자열을 정렬해 배열 sortedStrings에 저장
		for (int idx = 0; idx < sortedStrings.length; idx++)
			sortedStrings[idx] = stringSorter.poll();
		
		// 정렬한 문자열을 저장한 배열 반환
		return sortedStrings;
    }
}