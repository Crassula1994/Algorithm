package bronze4.num14924;

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
		
		// nextToken() 및 pasreInt() 메서드를 사용해 입력 받은 기차의 속도, 파리의 속도, 두 기차 사이의 거리를 각 변수에 할당
		int trainSpeed = Integer.parseInt(st.nextToken());
		int flySpeed = Integer.parseInt(st.nextToken());
		int trainDist = Integer.parseInt(st.nextToken());
		
		// 두 기차가 만날 때까지 파리의 이동거리를 계산해 변수 flyDist에 저장
		int flyDist = (trainDist / (trainSpeed * 2)) * flySpeed;
		
		// valueOf() 및 write() 메서드를 사용해 두 기차가 만날 때까지 파리의 이동거리를 출력
		out.write(String.valueOf(flyDist));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}