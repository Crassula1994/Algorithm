package silver1.num01342;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 행운의 문자열의 길이 및 개수를 저장할 각 변수 초기화
	static int length;
	static int count = 0;
	
	// 행운의 문자열에 사용할 수 있는 알파벳의 수를 저장할 배열 alphabets 초기화
	static int[] alphabets = new int[26];
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 메서드를 사용해 입력 받은 문자열을 변수 string에 할당
		String string = in.readLine();
		
		// length() 메서드를 사용해 행운의 문자열의 길이를 변수 length에 할당
		length = string.length();
		
		// for 반복문을 사용해 각 알파벳의 개수를 배열 alphabets에 저장
		for (int idx = 0; idx < string.length(); idx++)
			alphabets[string.charAt(idx) - 'a']++;
		
		// stringMaker() 메서드를 호출해 행운의 문자열의 개수를 갱신
		stringMaker(0, -1);
		
		// valueOf() 및 write() 메서드를 사용해 행운의 문자열의 개수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// stringMaker() 메서드 정의
	public static void stringMaker(int curLength, int prevAlphabet) {
		
		// 행운의 문자열을 완성한 경우 행운의 문자열의 개수를 갱신 후 메서드 종료
		if (curLength == length) {
			count++;
			return;
		}
		
		// for 반복문을 사용해 각 알파벳을 순회
		for (int idx = 0; idx < alphabets.length; idx++) {
			
			// 해당 알파벳이 없거나 이전에 사용한 알파벳인 경우 다음 알파벳을 순회
			if (alphabets[idx] == 0 || idx == prevAlphabet)
				continue;
			
			// 해당 알파벳을 사용한 것으로 처리
			alphabets[idx]--;
			
			// stringMaker() 메서드 재귀 호출
			stringMaker(curLength + 1, idx);
			
			// 해당 알파벳을 사용하지 않은 것으로 원상 복구
			alphabets[idx]++;
		}
	}
}