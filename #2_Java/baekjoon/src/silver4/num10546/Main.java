package silver4.num10546;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 참가자의 수를 변수 participantNum에 할당
		int participantNum = Integer.parseInt(in.readLine());
		
		// 참가자의 이름별 동명이인의 숫자를 저장할 Map 객체 nameCounts 초기화
		Map<String, Integer> nameCounts = new HashMap<>();
		
		// for 반복문을 사용해 각 참가자의 이름을 순회
		for (int participant = 0; participant < participantNum; participant++) {
			
			// readLine() 메서드를 사용해 입력 받은 참가자의 이름을 변수 name에 할당
			String name = in.readLine();
			
			// getOrDefault() 및 put() 메서드를 사용해 참가자의 이름별 동명이인의 숫자를 nameCounts에 저장
			nameCounts.put(name, nameCounts.getOrDefault(name, 0) + 1);
		}
		
		// for 반복문을 사용해 각 완주한 참가자의 이름을 순회
		for (int participant = 0; participant < participantNum - 1; participant++) {
			
			// readLine() 메서드를 사용해 입력 받은 완주한 참가자의 이름을 변수 name에 할당
			String name = in.readLine();
			
			// get() 및 put() 메서드를 사용해 완주한 참가자의 수를 nameCounts에서 제거
			nameCounts.put(name, nameCounts.get(name) - 1);
		}
		
		// for 반복문을 사용해 각 참가자의 이름을 순회
		for (String name : nameCounts.keySet()) {
			
			// 마라톤을 완주하지 못한 참가자인 경우 해당 참가자의 이름을 출력 후 반복문 탈출
			if (nameCounts.get(name) != 0) {
				out.write(name);
				break;
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}