package bronze2.num10834;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 벨트의 개수를 변수 beltNum에 할당
		int beltNum = Integer.parseInt(in.readLine());
		
		// 마지막 바퀴의 회전 방향과 분당 회전수를 저장할 각 변수 초기화
		int targetDirection = 0;
		int targetRPM = 1;
		
		// while 반복문을 사용해 각 벨트의 정보를 순회
		while (beltNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 마지막 바퀴의 회전 방향과 분당 회전수를 갱신
			targetRPM = targetRPM / Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
			targetDirection += Integer.parseInt(st.nextToken());
		}
		
		// write() 메서드를 사용해 마지막 바퀴의 회전 방향과 분당 회전수를 출력
		out.write((targetDirection & 1) + " " + targetRPM);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}