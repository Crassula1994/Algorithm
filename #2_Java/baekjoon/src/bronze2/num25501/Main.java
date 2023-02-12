package bronze2.num25501;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// recursion() 메서드의 호출 횟수를 저장할 변수 count 초기화
	static int count = 0;
	
	//----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 저장
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int i = 0; i < testCase; i++) {
			
			// readLine() 메서드를 사용해 입력 받은 단어를 변수 word에 저장
			String word = in.readLine();
			
			// isPalindrome() 메서드를 호출해 나온 결과를 변수 result에 할당
			int result = isPalindrome(word);
			
			// write() 메서드를 사용해 결과 및 호출 횟수를 출력
			out.write(result + " " + count + "\n");
			
			// recursion() 메서드의 호출 횟수를 초기화
			count = 0;
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	//----------------------------------------------------------------------------------------------------
	
	// recursion() 메서드 정의
    public static int recursion(String word, int start, int end) {
    	
    	// recursion() 메서드의 호출 횟수 갱신
    	count++;
    	
    	// 해당 단어가 팰린드롬 문자열인 경우 1 반환
        if (start >= end) {
        	return 1;
        	
        // 해당 단어가 팰린드롬 문자열이 아닌 경우 0 반환
        } else if (word.charAt(start) != word.charAt(end)) {
        	return 0;
        	
        // recursion() 메서드 재귀 호출
        } else {
        	return recursion(word, start + 1, end - 1);
        }
    }
    
	//----------------------------------------------------------------------------------------------------
	
	// isPalindrome() 메서드 정의
    public static int isPalindrome(String word) {
    	
    	// recursion() 메서드 호출
        return recursion(word, 0, word.length() - 1);
    }
}