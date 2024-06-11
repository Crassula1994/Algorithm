package bronze3.num02965;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 세 캥거리의 초기 위치를 각 변수에 할당
		int kangarooA = Integer.parseInt(st.nextToken());
		int kangarooB = Integer.parseInt(st.nextToken());
		int kangarooC = Integer.parseInt(st.nextToken());
		
		// max() 메서드를 사용해 캥거루가 최대 움직일 수 있는 횟수를 계산하고 변수 maxCount에 할당
		int maxCount = Math.max(kangarooB - kangarooA, kangarooC - kangarooB) - 1;
		
		// valueOf() 및 write() 메서드를 사용해 캥거루가 최대 움직일 수 있는 횟수를 출력
		out.write(String.valueOf(maxCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}