package bronze1.num32132;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 문자열의 길이를 변수 length에 할당
		int length = Integer.parseInt(in.readLine());
		
		// readLine() 및 toCharArray() 메서드를 사용해 입력 받은 문자열을 배열 string에 저장
		char[] string = in.readLine().toCharArray();
		
		// 'PS' 문자열이 앞에 존재하는지 여부를 나타낼 변수 isPS 초기화
		boolean isPS = false;
		
		// for 반복문을 사용해 각 문자열의 문자를 순회
		for (int idx = 0; idx < length; idx++) {
			
			// 'PS' 문자열인 경우 'PS' 문자열이 앞에 존재하는지 여부를 갱신
			if (idx > 0 && string[idx] == 'S' && string[idx - 1] == 'P') {
				isPS = true;
				
			// 'PS' 문자열이 아닌 경우
			} else {
				
				// 직전에 'PS' 문자열이 존재하고 해당 문자가 4 또는 5인 경우 다음 문자를 순회
				if (isPS && (string[idx] == '4' || string[idx] == '5'))
					continue;
			
				// 'PS' 문자열이 앞에 존재하는지 여부를 갱신
				isPS = false;
			}
			
			// write() 메서드를 사용해 해당 문자를 출력
			out.write(string[idx]);
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}