package bronze2.num16171;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;  
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 메서드를 사용해 입력 받은 교과서의 문자열과 키워드의 문자열의 각 변수에 할당
		String textString = in.readLine();
		String keywordString = in.readLine();
		
		// 숫자를 제거한 교과서의 문자열을 저장할 StringBuilder 객체 sb 초기화
		StringBuilder sb = new StringBuilder();
		
		// for 반복문을 사용해 교과서 문자열의 각 문자를 순회
		for (int idx = 0; idx < textString.length(); idx++) {
			
			// charAt() 메서드를 사용해 입력 받은 문자를 변수 character에 할당
			char character = textString.charAt(idx);
			
			// 해당 문자가 숫자인 경우 다음 문자를 순회
			if (character >= '0' && character <= '9')
				continue;
			
			// append() 메서드를 사용해 알파벳 소문자와 대문자를 sb에 저장
			sb.append(character);
		}
		
		// toString(), contains(), write() 메서드를 사용해 성민이가 찾고자 하는 키워드가 문자열 내에 존재하는지 여부를 출력
		out.write((sb.toString().contains(keywordString)) ? "1" : "0");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}