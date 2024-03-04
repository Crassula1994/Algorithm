package bronze1.num08595;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 단어의 길이와 단어를 각 변수에 할당
		int length = Integer.parseInt(in.readLine());
		String word = in.readLine();
		
		// 모든 히든 넘버의 합과 현재 히든 넘버를 저장할 각 변수 초기화
		long sum = 0;
		int hiddenNumber = 0;
		
		// for 반복문을 사용해 단어의 각 문자를 순회
		for (int idx = 0; idx < length; idx++) {
			
			// charAt() 메서드를 사용해 단어의 각 문자를 변수 character에 할당
			int character = word.charAt(idx) - '0';
			
			// 해당 문자가 숫자인 경우 히든 넘버를 갱신
			if (character >= 0 && character < 10) {
				hiddenNumber *= 10;
				hiddenNumber += character;
			
			// 해당 문자가 숫자가 아닌 경우 히든 넘버의 합을 갱신 후 히든 넘버 초기화
			} else {
				sum += hiddenNumber;
				hiddenNumber = 0;
			}
			
			// 마지막 글자인 경우 히든 넘버의 합을 갱신
			if (idx == length - 1)
				sum += hiddenNumber;
		}
		
		// valueOf() 및 write() 메서드를 사용해 히든 넘버의 합을 출력
		out.write(String.valueOf(sum));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}