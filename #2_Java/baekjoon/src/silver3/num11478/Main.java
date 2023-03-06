package silver3.num11478;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

// Main 클래스 정의
public class Main {

	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 메서드를 사용해 입력 받은 문자열을 변수 string에 할당
		String string = in.readLine();
		
		// 부분 문자열을 저장할 Set 객체 subString 초기화
		Set<String> subString = new HashSet<>();
		
		// for 반복문을 사용해 각 부분 문자열을 순회
		for (int size = 1; size <= string.length(); size++) {
			for (int idx = 0; idx < string.length() - size + 1; idx++)
				
				// substring() 및 add() 메서드를 사용해 부분 문자열을 subString에 추가
				subString.add(string.substring(idx, idx + size));
		}

		// size(), valueOf(), write() 메서드를 사용해 서로 다른 부분 문자열의 개수를 출력
		out.write(String.valueOf(subString.size()));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}