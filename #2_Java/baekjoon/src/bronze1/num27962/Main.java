package bronze1.num27962;

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
		
		// readLine() 및 charAt() 메서드를 사용해 입력 받은 문자열을 배열 string에 저장
		char[] string = in.readLine().toCharArray();
		
		// 해당 문자열이 '비타민 문자열'인지 여부를 저장할 변수 isVitamin 초기화
		boolean isVitamin = false;
		
		// for 반복문을 사용해 각 부분 문자열의 길이를 순회
		for (int l = 1; l < length; l++) {
			
			// 해당 부분 문자열 간의 다른 문자의 개수 및 접미사의 시작 위치를 저장할 각 변수 초기화
			int count = 0;
			int startIdx = length - l;
			
			// for 반복문을 사용해 각 글자를 순회
			for (int idx = 0; idx < l; idx++) {
				
				// 두 부분 문자열의 문자가 다른 경우
				if (string[idx] != string[startIdx + idx]) {
					
					// 해당 부분 문자열 간의 다른 문자의 개수를 갱신
					count++;
					
					// 해당 부분 문자열 간의 다른 문자의 개수가 2개 이상인 경우 반복문 탈출
					if (count > 1)
						break;
				}
			}
			
			// 해당 부분 문자열이 '비타민 문자열'인 경우 해당 문자열이 '비타민 문자열'인지 여부를 갱신 후 반복문 탈출
			if (count == 1) {
				isVitamin = true;
				break;
			}
		}
		
		// write() 메서드를 사용해 해당 문자열이 '비타민 문자열'인지 여부를 출력
		out.write((isVitamin) ? "YES" : "NO");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}