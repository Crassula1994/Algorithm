package bronze2.num05176;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// 대회에 참가하지 못하는 사람의 수를 저장할 변수 count 초기화
			int count = 0;
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 참가자의 수와 자리의 수를 각 변수에 할당
			int participantNum = Integer.parseInt(st.nextToken());
			int seatNum = Integer.parseInt(st.nextToken());
			
			// 각 자리에 사람이 존재하는지 여부를 저장할 배열 seats 초기화
			boolean[] seats = new boolean[seatNum + 1];
			
			// while 반복문을 사용해 각 사람을 순회
			while (participantNum-- > 0) {
				
				// readLine() 및 parseInt() 메서드를 사용해 해당 참가자가 선호하는 자리를 변수 seat에 할당
				int seat = Integer.parseInt(in.readLine());
				
				// 해당 사람이 선호하는 자리에 이미 사람이 존재하는 경우
				if (seats[seat]) {
					
					// 대회에 참가하지 못하는 사람의 수를 갱신 후 다음 사람을 순회
					count++;
					continue;
				}
				
				// 해당 자리에 참가자가 앉은 것으로 처리
				seats[seat] = true;
			}
			
			// write() 메서드를 사용해 대회에 참가하지 못하는 사람의 수를 출력
			out.write(count + "\n");
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}