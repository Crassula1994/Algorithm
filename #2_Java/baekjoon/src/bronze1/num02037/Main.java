package bronze1.num02037;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 각 알파벳별 누르는 횟수 및 번호를 저장할 배열 alphabets 초기화
		int[][] alphabets = {
			{1, 2}, {2, 2}, {3, 2},
			{1, 3}, {2, 3}, {3, 3},
			{1, 4}, {2, 4}, {3, 4},
			{1, 5}, {2, 5}, {3, 5},
			{1, 6}, {2, 6}, {3, 6},
			{1, 7}, {2, 7}, {3, 7}, {4, 7},
			{1, 8}, {2, 8}, {3, 8},
			{1, 9}, {2, 9}, {3, 9}, {4, 9}
		};
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());

		/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 버튼을 누르는 데 걸리는 시간,
		같은 숫자인 문자를 연속으로 찍기 위해 기다리는 시간을 각 변수에 할당 */
		int pushTime = Integer.parseInt(st.nextToken());
		int waitTime = Integer.parseInt(st.nextToken());
		
		// readLine() 메서드를 사용해 입력 받은 영어 메시지를 변수 message에 할당
		String message = in.readLine();
		
		// 메시지를 적는 데 걸리는 시간을 저장할 변수 totalTime 초기화
		int totalTime = 0;
		
		// for 반복문을 사용해 메시지의 각 글자를 순회
		for (int idx = 0; idx < message.length(); idx++) {
			
			// charAt() 메서드를 사용해 각 글자를 변수 currentChar에 할당
			char currentChar = message.charAt(idx);
			
			// 해당 글자가 띄어쓰기인 경우 누르는 시간만 추가
			if (currentChar == ' ') {
				totalTime += pushTime;
			
			// 해당 글자가 알파벳 대문자인 경우
			} else {
				
				// 해당 글자를 누르기 위해 필요한 시간을 추가
				totalTime += alphabets[currentChar - 'A'][0] * pushTime;
				
				// 해당 글자가 첫 번째 글자가 아닌 경우
				if (idx != 0) {
					
					// 직전의 글자를 변수 previousChar에 할당
					char previousChar = message.charAt(idx - 1);
					
					// 직전 글자가 빈 칸이 아니고 두 글자가 같은 숫자에 있는 경우 대기 시간을 추가
					if (previousChar != ' ' && alphabets[currentChar - 'A'][1] == alphabets[previousChar - 'A'][1])
						totalTime += waitTime;
				}
			}
		}
			
		// valueOf() 및 write() 메서드를 사용해 메시지를 적는 데 걸리는 시간을 출력
		out.write(String.valueOf(totalTime));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}