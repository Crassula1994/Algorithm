package level2.num076502;

// 필요한 패키지 불러오기
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// Solution 클래스 정의
public class Solution {
    
    // 현재 문자열의 상태를 저장할 Queue 객체 curString 초기화
    static Queue<Character> curString = new LinkedList<>();
	
	// ----------------------------------------------------------------------------------------------------
	
	// solution() 메서드 정의
	public static int solution(String s) {

		// 올바른 괄호 문자열이 되게 하는 x의 개수를 저장할 변수 count 초기화
        int count = 0;
        
        // for 반복문을 사용해 문자열의 각 괄호를 순회
        for (int idx = 0; idx < s.length(); idx++) {
            
            // charAt() 메서드를 사용해 해당 괄호를 변수 bracket에 할당
            char bracket = s.charAt(idx);
            
            // offer() 메서드를 사용해 해당 괄호를 curString에 저장
            curString.offer(bracket);
        }
        
        // for 반복문을 사용해 각 x만큼 이동했을 때를 순회
        for (int x = 0; x < s.length(); x++) {
            
            // x가 0이 아닌 경우 현재 curString의 문자열을 조정
            if (x != 0)
                curString.offer(curString.poll());
            
            // stringChecker() 메서드를 호출해 해당 문자열이 올바른 괄호 문자열인지를 변수 isCorrect에 저장
            boolean isCorrect = stringChecker(s);
            
            // 올바른 괄호 문자열일 경우 올바른 괄호 문자열이 되게 하는 x의 개수를 갱신
            if (isCorrect)
            	count++;
        }
        
        // 올바른 괄호 문자열이 되게 하는 x의 개수를 반환
        return count;
    }
	
	// ----------------------------------------------------------------------------------------------------
	
	// stringChecker() 메서드 정의
	public static boolean stringChecker(String s) {
		
		// 해당 문자열이 올바른 괄호 문자열인지 검사할 Stack 객체 checker 초기화
        Stack<Character> checker = new Stack<>();
        
        // for 반복문을 사용해 각 괄호를 순회
        for (int b = 0; b < s.length(); b++) {
            
            // poll() 메서드를 사용해 해당 괄호를 변수 bracket에 할당
            char bracket = curString.poll();
            
            // 앞의 원소가 없는 경우 해당 괄호를 추가
            if (checker.isEmpty()) {
                checker.push(bracket);

            // 앞의 원소가 '('이고 현재 괄호가 ')'인 경우 앞의 원소 제거
            } else if (checker.peek() == '(' && bracket == ')') {
                checker.pop();

            // 앞의 원소가 '['이고 현재 괄호가 ']'인 경우 앞의 원소 제거
            } else if (checker.peek() == '[' && bracket == ']') {
                checker.pop();

            // 앞의 원소가 '{'이고 현재 괄호가 '}'인 경우 앞의 원소 제거
            } else if (checker.peek() == '{' && bracket == '}') {
                checker.pop();
                    
            // 나머지 경우 해당 괄호를 추가
            } else {
                checker.push(bracket);
            }
            
            // 해당 괄호를 다시 curStirng에 추가
            curString.offer(bracket);
        }
        
        // 올바른 괄호 문자열인 경우 true 반환
        if (checker.isEmpty())
            return true;
            
        // 올바르지 않은 괄호 문자열인 경우 false 반환
        return false;
    }
}