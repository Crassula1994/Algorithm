package bronze3.num02460;

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
		
		// 기차의 현재 인원 수와 최대 인원 수를 저장할 각 변수 초기화
		int currentCnt = 0;
		int maxCnt = 0;
		
		// for 반복문을 사용해 각 역을 순회
		for (int station = 0; station < 10; station++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 내린 사람과 탄 사람의 수를 각 변수에 할당
			int alighted = Integer.parseInt(st.nextToken());
			int boarded = Integer.parseInt(st.nextToken());
			
			// 기차의 현재 인원 수를 갱신
			currentCnt += boarded - alighted;
			
			// max() 메서드를 사용해 기차의 최대 인원 수를 갱신
			maxCnt = Math.max(currentCnt, maxCnt);
		}
		
		// valueOf() 및 write() 메서드를 사용해 기차의 최대 인원 수를 출력
		out.write(String.valueOf(maxCnt));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}