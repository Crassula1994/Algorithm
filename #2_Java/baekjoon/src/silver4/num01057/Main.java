package silver4.num01057;

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
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 참가자의 수, 김지민의 번호, 임한수의 번호를 각 변수에 할당
		@SuppressWarnings("unused")
		int participantNum = Integer.parseInt(st.nextToken());
		int kimNum = Integer.parseInt(st.nextToken());
		int limNum = Integer.parseInt(st.nextToken());
		
		// 김지민과 임한수가 대결하는 라운드 번호를 저장할 변수 roundNum 초기화
		int roundNum = 0;

		// while 반복문을 사용해 두 참가자가 만날 때까지 순회
		while (kimNum != limNum) {

			// 라운드 번호를 갱신
			roundNum++;

			// 김지민의 번호와 임한수의 번호를 갱신
			kimNum = kimNum / 2 + kimNum % 2;
			limNum = limNum / 2 + limNum % 2;
		}
		
		// valueOf() 및 write() 메서드를 사용해 김지민과 임한수가 대결하는 라운드 번호를 출력
		out.write(String.valueOf(roundNum));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}