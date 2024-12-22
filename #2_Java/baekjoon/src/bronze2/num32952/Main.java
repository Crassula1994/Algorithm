package bronze2.num32952;

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
		
		// nextToken() 및 parseLong() 메서드를 사용해 입력 받은 초기 보상, 반감기 간격, 특정 블록의 번호를 각 변수에 할당
		long startReward = Long.parseLong(st.nextToken());
		long interval = Long.parseLong(st.nextToken());
		long targetBlock = Long.parseLong(st.nextToken());
		
		// 특정 블록의 채굴 보상 및 반감기 횟수를 저장할 각 변수 초기화
		long targetReward = startReward;
		long halfLifeCount = targetBlock / interval;
		
		// while 반복문을 사용해 특정 블록의 채굴 보상을 갱신
		while (halfLifeCount-- > 0 && targetReward > 0)
			targetReward /= 2;
		
		// valueOf() 및 write() 메서드를 사용해 특정 블록의 채굴 보상을 출력
		out.write(String.valueOf(targetReward));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}