package bronze1.num25183;

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

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 로또 문자열의 길이 및 로또 문자열을 각 변수에 할당
		int stringLength = Integer.parseInt(in.readLine());
		String lottoString = in.readLine();
		
		// 인접한 부분 문자열의 최대 길이를 저장할 변수 maxLength 초기화
		int maxLength = 1;
		
		// for 반복문을 사용해 로또 문자열의 각 문자를 순회
		for (int idx = 1, length = 1; idx < stringLength; idx++) {
			
			// 해당 글자가 이전 글자와 이웃한 문자인 경우 인접한 부분문자열의 최대 길이를 갱신
			if (Math.abs(lottoString.charAt(idx - 1) - lottoString.charAt(idx)) == 1) {
				maxLength = Math.max(++length, maxLength);
				
			// 해당 글자가 이전 글자와 이웃한 문자가 아닌 경우 인접한 부분 문자열의 길이를 1로 초기화
			} else {
				length = 1;
			}
		}
		
		// write() 메서드를 사용해 로또에 당첨되었는지 여부를 출력
		out.write((maxLength >= 5) ? "YES" : "NO");

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}