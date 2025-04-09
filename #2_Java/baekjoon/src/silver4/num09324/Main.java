package silver4.num09324;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// readLine() 메서드를 사용해 입력 받은 메시지를 변수 message에 할당
			String message = in.readLine();
			
			// 입력 받은 메시지가 진짜 메시지인지 여부를 저장할 변수 isGenuine 초기화
			boolean isGenuine = true;
			
			// 등장한 각 알파벳의 개수를 저장할 배열 counts 초기화
			int[] counts = new int[26];
			
			// for 반복문을 사용해 메시지의 각 알파벳을 순회
			for (int idx = 0; idx < message.length(); idx++) {
				
				// charAt() 메서드를 사용해 현재 알파벳과 해당 알파벳의 순서를 각 변수에 할당
				char alphabet = message.charAt(idx);
				int alphabetIdx = alphabet - 'A';
				
				// 해당 알파벳의 개수를 갱신
				counts[alphabetIdx]++;
				
				// 해당 알파벳이 세 번째로 등장한 경우
				if (counts[alphabetIdx] % 3 == 0) {
					
					/* 뒤에 더 이상의 문자가 존재하지 않거나 중복된 알파벳이 존재하지 않는 경우
					입력 받은 메시지가 진짜 메시지인지 여부를 갱신 후 반복문 탈출 */
					if (idx == message.length() - 1 || alphabet != message.charAt(idx + 1)) {
						isGenuine = false;
						break;
					}
					
					// 다음 알파벳을 건너뛰고 다음 알파벳을 순회
					idx++;
				}
			}
			
			// write() 메서드를 사용해 입력 받은 메시지가 진짜 메시지인지 여부를 출력
			out.write((isGenuine) ? "OK" : "FAKE");
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}