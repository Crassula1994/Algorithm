package level2.num012939;

// 필요한 패키지 불러오기
import java.util.StringTokenizer;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static String solution(String s) {
		
		// 최솟값과 최댓값을 저장할 각 변수 초기화
        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;

		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(s);
		
		// countTokens() 메서드를 사용해 문자열에 존재하는 숫자의 개수를 변수 size에 할당
        int size = st.countTokens();
        
        // for 반복문을 사용해 각 숫자를 순회
        for (int n = 0; n < size; n++) {
            
        	// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
            int number = Integer.parseInt(st.nextToken());
            
            // min() 및 max() 메서드를 사용해 최솟값과 최댓값을 갱신
            minNum = Math.min(number, minNum);
            maxNum = Math.max(number, maxNum);
        }
        
        // valueOf() 메서드를 사용해 최솟값과 최댓값의 문자열을 변수 extrmeNum에 할당
        String extremeNum = String.valueOf(minNum) + " " + String.valueOf(maxNum);
        
        // 최솟값과 최댓값의 문자열을 반환
        return extremeNum;
    }
}