package bronze2.num05586;

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
		
		// 문자열에 포함된 JOI와 IOI의 개수를 저장할 각 변수 초기화
		int countJ = 0;
		int countI = 0;
		
		// for 반복문을 사용해 각 부분 문자열을 순회
		for (int idx = 0; idx < string.length() - 2; idx++) {
			
			// charAt() 메서드를 사용해 해당 알파벳을 변수 alphabet에 할당
			char alphabet = string.charAt(idx);
			
			// 해당 알파벳이 I이거나 J가 아닌 경우 다음 부분 문자열을 순회
			if (alphabet != 'I' && alphabet != 'J')
				continue;
			
			// substring() 메서드를 사용해 해당 부분 문자열을 변수 substring에 할당
			String substring = string.substring(idx, idx + 3);
			
			// 해당 부분문자열이 JOI인 경우 문자열에 포함된 JOI의 개수를 갱신
			if (substring.equals("JOI")) {
				countJ++;
				
			// 해당 부분문자열이 IOI인 경우 문자열에 포함된 IOI의 개수를 갱신
			} else if (substring.equals("IOI")) {
				countI++;
			}
		}
		
		// write() 메서드를 사용해 문자열에 포함된 JOI와 IOI의 개수를 출력
		out.write(countJ + "\n" + countI);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}