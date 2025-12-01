package silver4.num04604;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 각 숫자에 대응되는 문자를 저장할 배열 table 초기화
	static char[] table = {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '\'', ',', '-', '.', '?'};
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// 빈 칸의 개수를 저장할 변수 count 초기화
		int count = 0;
		
		// 찾아낸 숨겨진 메시지를 저장할 StringBuilder 객체를 불러와 변수 sb에 할당
		StringBuilder sb = new StringBuilder();
		
		// while 반복문을 사용해 주어진 글을 모두 순회
		while (true) {
			
			// readLine() 메서드를 사용해 입력 받은 글의 한 줄을 변수 line에 할당
			String line = in.readLine();
			
			// 모든 줄을 확인한 경우 반복문 탈출
			if (line.charAt(0) == '#')
				break;
			
			// 숨겨진 메시지의 한 줄이 끝난 경우
			if (line.charAt(0) == '*') {
				
				// toString(), messageDecoder(), write() 메서드를 사용해 숨겨진 메시지를 해독한 결과를 출력
				out.write(messageDecoder(sb.toString()));
				
				// setLength() 메서드를 사용해 저장된 숨겨진 메시지를 제거
				sb.setLength(0);
				
				// newLine() 메서드를 사용해 줄바꿈을 출력
				out.newLine();
				
				// 다음 줄을 순회
				continue;
			}
			
			// for 반복문을 사용해 각 글자를 순회
			for (int idx = 0; idx < line.length(); idx++) {
				
				// 해당 글자가 빈 칸인 경우 빈 칸의 개수를 갱신
				if (line.charAt(idx) == ' ') {
					count++;
					
				// 해당 글자가 빈 칸이 아니고 빈 칸의 개수가 0이 아닌 경우
				} else if (count > 0) {
					
					// append() 메서드를 사용해 빈 칸의 개수에 해당하는 숫자를 sb에 추가
					sb.append(((count & 1) == 1) ? "0" : "1");
					
					// 빈 칸의 개수를 초기화
					count = 0;
				}
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// messageDecoder() 메서드 정의
	public static String messageDecoder(String cryptogram) {
		
		// 숨겨진 메시지를 해독한 결과를 저장할 StringBuilder 객체 sb 초기화
		StringBuilder sb = new StringBuilder();
		
		// length() 메서드를 사용해 암호문의 길이를 변수 length에 할당
		int length = cryptogram.length();
		
		// 암호문의 길이가 5의 배수가 아닌 경우
		if (length % 5 > 0) {
			
			// for 반복문을 사용해 '0'을 추가
			for (int pad = 0; pad < 5 - (length % 5); pad++)
				cryptogram += "0";
		}
		
		// for 반복문을 사용해 5자리의 각 이진수를 순회
		for (int startIdx = 0; startIdx < cryptogram.length(); startIdx += 5) {
			
			// subString() 메서드를 사용해 5자리의 이진수를 변수 binaryString에 할당
			String binaryString = cryptogram.substring(startIdx, startIdx + 5);
			
			// parseInt() 및 append() 메서드를 사용해 해당 글자를 해독한 결과를 sb에 추가
			sb.append(table[Integer.parseInt(binaryString, 2)]);
		}
		
		// toString() 메서드를 사용해 숨겨진 메시지를 해독한 결과를 반환
		return sb.toString();
	}
}