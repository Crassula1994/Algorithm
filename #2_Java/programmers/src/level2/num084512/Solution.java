package level2.num084512;

// 필요한 패키지 불러오기
import java.util.PriorityQueue;

// Solution 클래스 정의
public class Solution {
	
	// 알파벳 모음을 저장할 배열 vowels 초기화
	static String[] vowels = {"A", "E", "I", "O", "U"};
	
	// 각 단어를 사전순으로 정렬할 PriorityQueue 객체 dictionary 초기화
	static PriorityQueue<String> dictionary = new PriorityQueue<>();
	
	// ----------------------------------------------------------------------------------------------------
	
	// solution() 메서드 정의
	public static int solution(String word) {
		
		// 입력 받은 단어의 순서를 저장할 변수 order 초기화
        int order = 0;
		
		// for 반복문을 사용해 길이 5까지의 단어를 wordMaker() 메서드를 호출해 dictionary에 저장
		for (int len = 1; len <= 5; len++)
            wordMaker(len, "");
        
		// while 반복문을 사용해 dictionary가 빌 때까지 순회
        while (!dictionary.isEmpty()) {
        	
        	// 입력 받은 단어의 순서를 갱신
            order++;
            
            // 해당 단어가 입력 받은 단어인 경우 반복문 탈출
            if (dictionary.poll().equals(word))
                break;
        }
        
        // 입력 받은 단어의 순서를 반환
        return order;
    }
	
	// ----------------------------------------------------------------------------------------------------
    
	// wordMaker() 메서드 정의
    public static void wordMaker(int length, String word) {
        
    	// 원하는 길이의 단어를 완성한 경우
        if (word.length() == length) {
        	
        	// offer() 메서드를 사용해 해당 단어를 dictionary에 추가
            dictionary.offer(word);
            
            // 메서드 종료
            return;
        }
        
        // for 반복문을 사용해 각 모음을 순회
        for (int idx = 0; idx < 5; idx++) {
        	
        	// 각 모음을 더한 새로운 단어를 변수 newWord에 할당
            String newWord = word + vowels[idx];
            
            // wordMaker() 메서드를 재귀 호출
            wordMaker(length, newWord);
        }
    }
}