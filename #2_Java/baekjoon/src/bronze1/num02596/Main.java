package bronze1.num02596;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 비밀편지의 내용을 저장할 StringBuilder 객체를 불러와 변수 sb에 할당
		StringBuilder sb = new StringBuilder();
		
		// 각 비밀편지의 문자를 저장할 Map 객체 dictionary 초기화
		Map<String, String> dictionary = new HashMap<>();
		
		// put() 메서드를 사용해 각 비밀편지의 문자를 저장
		dictionary.put("000000", "A");
		dictionary.put("001111", "B");
		dictionary.put("010011", "C");
		dictionary.put("011100", "D");
		dictionary.put("100110", "E");
		dictionary.put("101001", "F");
		dictionary.put("110101", "G");
		dictionary.put("111010", "H");
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 문자의 개수와 비밀편지의 내용을 각 변수에 할당
		int charNum = Integer.parseInt(in.readLine());
		String message = in.readLine();
		
		// 모르는 문자가 있는지 여부를 나타낼 변수 isCorrect 초기화
		boolean isCorrect = true;
		
		// for 반복문을 사용해 각 문자를 순회
		for (int c = 0; c < charNum; c++) {
			
			// substring() 메서드를 사용해 각 문자를 변수 character에 할당
			String character = message.substring(c * 6, (c + 1) * 6);

			// 여섯 글자가 모두 일치하는 경우 비밀편지의 내용을 갱신
			if (dictionary.containsKey(character)) {
				sb.append(dictionary.get(character));
			
			// 한 글자 이상 일치하지 않는 경우
			} else {
				
				// 해당 글자를 해독할 수 있는지 여부를 나타낼 변수 canDecode 초기화
				boolean canDecode = false;
				
				// for 반복문을 사용해 각 글자를 순회
				for (int idx = 0; idx < character.length(); idx++) {
					
					// charAt() 메서드를 사용해 해당 위치의 글자를 변수 digit에 할당
					char digit = character.charAt(idx);
					
					// substring() 메서드를 사용해 해당 위치의 글자를 바꾼 글자를 변수 newCharacter에 할당
					String newCharacter = (digit == '0') ?
							character.substring(0, idx) + '1' + character.substring(idx + 1) :
							character.substring(0, idx) + '0' + character.substring(idx + 1);
					
					// 해당 글자를 해독할 수 있는 경우
					if (dictionary.containsKey(newCharacter)) {
						
						// get() 및 append() 메서드를 사용해 비밀편지의 내용을 갱신
						sb.append(dictionary.get(newCharacter));
						
						// 해당 글자를 해독할 수 있는지 여부를 갱신 후 반복문 탈출
						canDecode = true;
						break;
					}
				}
				
				// 해당 글자를 해독할 수 없는 경우
				if (!canDecode) {
				
					// valueOf() 및 write() 메서드를 사용해 해당 문자의 위치를 출력
					out.write(String.valueOf(c + 1));
					
					// 모르는 문자가 있는지 여부를 갱신 후 반복문 탈출
					isCorrect = false;
					break;
				}
			}
		}
		
		// 모르는 문자가 없는 경우 비밀편지의 내용을 출력
		if (isCorrect)
			out.write(sb.toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}