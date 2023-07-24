package bronze3.num02476;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 참여하는 사람의 수를 변수 participantNum에 할당
		int participantNum = Integer.parseInt(in.readLine());

		// 가장 많은 상금을 받은 사람의 상금을 저장할 변수 maxPrize 초기화
		int maxPrize = 0;
		
		// for 반복문을 사용해 각 사람의 주사위 결과를 순회
		for (int p = 0; p < participantNum; p++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 주사위 눈을 각 변수에 할당
			int spot1 = Integer.parseInt(st.nextToken());
			int spot2 = Integer.parseInt(st.nextToken());
			int spot3 = Integer.parseInt(st.nextToken());
			
			// 세 개의 눈이 모두 같은 경우 가장 많은 상금을 갱신
			if (spot1 == spot2 && spot2 == spot3) {
				maxPrize = Math.max(10000 + spot1 * 1000, maxPrize);
			
			// 두 개의 눈만 같은 경우 가장 많은 상금을 갱신
			} else if (spot1 == spot2 || spot1 == spot3) {
				maxPrize = Math.max(1000 + spot1 * 100, maxPrize);
			} else if (spot2 == spot3) {
				maxPrize = Math.max(1000 + spot2 * 100, maxPrize);
				
			// 세 개의 눈이 모두 다른 경우 가장 많은 상금을 갱신
			} else {
				maxPrize = Math.max(Math.max(spot1, Math.max(spot2, spot3)) * 100, maxPrize);
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 가장 많은 상금을 받은 사람의 상금을 출력
		out.write(String.valueOf(maxPrize));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}