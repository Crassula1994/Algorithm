package silver3.num07484;

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

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// 해당 볼링 게임에서 얻은 점수, 이전 프레임과 그 전 프레임의 보너스를 저장할 각 변수 초기화
			int totalScore = 0;
			int strikeBonus = 0;
			int spareBonus = 0;
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 각 프레임을 순회
			for (int frame = 1; st.hasMoreTokens();) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 첫 번째 공으로 얻은 점수를 변수 firstScore에 할당
				int firstScore = Integer.parseInt(st.nextToken());

				// 스트라이크를 친 경우
				if (firstScore == 10) {
					
					// 해당 볼링 게임에서 얻은 점수를 갱신
					totalScore += (strikeBonus + spareBonus + 1) * 10;
					
					// 이전 프레임과 그 전 프레임의 보너스를 갱신
					spareBonus = strikeBonus;
					strikeBonus = (frame++ < 10) ? 1 : 0;
					
					// 다음 프레임을 순회
					continue;
				}
				
				// 스트라이크를 치지 못한 경우 해당 볼링 게임에서 얻은 점수를 갱신
				totalScore += (strikeBonus + spareBonus + 1) * firstScore;
				
				// 이전 프레임과 그 전 프레임의 보너스를 갱신
				spareBonus = strikeBonus;
				strikeBonus = 0;
				
				// 두 번째 공을 던질 수 있는 경우
				if (st.hasMoreTokens()) {
				
					// nextToken() 및 parseInt() 메서드를 사용해 두 번째 공으로 얻은 점수를 변수 secondScore에 할당
					int secondScore = Integer.parseInt(st.nextToken());
					
					// 두 번째 공으로 해당 볼링 게임에서 얻은 점수를 갱신
					totalScore += (spareBonus + 1) * secondScore;
					
					// 이전 프레임의 보너스를 갱신
					spareBonus = (frame++ < 10 && firstScore + secondScore == 10) ? 1 : 0;
				}
			}
			
			// write() 메서드를 사용해 해당 볼링 게임에서 얻은 점수를 출력
			out.write(totalScore + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}