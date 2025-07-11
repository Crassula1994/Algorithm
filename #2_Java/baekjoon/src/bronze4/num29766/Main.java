package bronze4.num29766;

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
		
		// readLine() 메서드를 사용해 입력 받은 문자열을 변수 string에 할당
		String string = in.readLine();
		
		// 문자열에서 'DKSH'가 나타나는 횟수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 각 문자열의 글자를 순회
		for (int idx = 0; idx < string.length() - 3; idx++) {
			
			// 해당 문자로부터 'DKSH'인 경우 문자열에서 'DKSH'가 나타나는 횟수 및 다음에 확인할 글자를 갱신
			if (string.charAt(idx) == 'D' && string.charAt(idx + 1) == 'K'
					&& string.charAt(idx + 2) == 'S' && string.charAt(idx + 3) == 'H') {
				count++;
				idx += 3;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 문자열에서 'DKSH'가 나타나는 횟수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}