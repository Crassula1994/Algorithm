package silver4.num25192;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 채팅방의 기록 수를 변수 logNum에 할당
		int logNum = Integer.parseInt(in.readLine());
		
		// 곰곰티콘이 사용된 횟수를 저장할 변수 emoticonCnt 초기화
		int emoticonCnt = 0;
		
		// 곰곰티콘을 사용한 유저를 저장할 Set 객체 emoticonUser 초기화
		Set<String> emoticonUser = new HashSet<>();
		
		// for 반복문을 사용해 채팅방의 각 기록을 순회
		for (int log = 0; log < logNum; log++) {
			
			// readLine() 메서드를 사용해 입력 받은 채팅방의 기록을 변수 message에 할당
			String message = in.readLine();
			
			// 'ENTER'가 입력된 경우
			if (message.equals("ENTER")) {
				
				// size() 메서드를 사용해 곰곰티콘을 사용한 횟수를 갱신
				emoticonCnt += emoticonUser.size();
				
				// emoticonUser 초기화
				emoticonUser = new HashSet<>();
				
			// 유저의 닉네임이 입력된 경우
			} else {
				
				// add() 메서드를 사용해 곰곰티콘을 사용한 유저의 닉네임을 emoticonUser에 추가
				emoticonUser.add(message);
			}
		}
		
		// size() 메서드를 사용해 곰곰티콘을 사용한 횟수를 갱신
		emoticonCnt += emoticonUser.size();

		// valueOf() 및 write() 메서드를 사용해 곰곰티콘이 사용된 횟수를 출력
		out.write(String.valueOf(emoticonCnt));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}