package silver5.num06550;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 입력 받은 테스트 케이스를 저장할 변수 line 초기화
		String line;
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while ((line = in.readLine()) != null) {
			
			// 해당 부분 문자열이 목표 문자열의 부분 문자열인지 여부를 저장할 변수 isSubstring 초기화
			boolean isSubstring = false;
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(line);
			
			// nextToken() 메서드를 사용해 주어진 부분 문자열과 목표 문자열을 각 배열에 할당
			char[] substring = st.nextToken().toCharArray();
			char[] targetString = st.nextToken().toCharArray();
			
			// for 반복문을 사용해 목표 문자열의 각 글자를 순회
			for (int idx = 0, subIdx = 0; idx < targetString.length; idx++) {
					
				// 남은 글자보다 비교할 글자가 더 많은 경우 반복문 탈출
				if (substring.length - subIdx > targetString.length - idx)
					break;
				
				// 글자가 일치하지 않는 경우 다음 글자 순회
				if (targetString[idx] != substring[subIdx])
					continue;
				
				// 비교할 문자의 인덱스를 갱신
				subIdx++;
				
				// 모든 글자가 일치하는 경우 해당 부분 문자열이 목표 문자열의 부분 문자열인지 여부를 갱신 후 반복문 탈출
				if (subIdx == substring.length) {
					isSubstring = true;
					break;
				}
			}
			
			// write() 메서드를 사용해 해당 부분 문자열이 목표 문자열의 부분 문자열인지 여부를 출력
			out.write((isSubstring) ? "Yes" : "No");
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}