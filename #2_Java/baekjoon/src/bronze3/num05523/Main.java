package bronze3.num05523;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 경기 라운드의 수를 변수 roundNum에 할당
		int roundNum = Integer.parseInt(in.readLine());
		
		// A가 이긴 횟수와 B가 이긴 횟수를 저장할 각 변수 초기화
		int countA = 0;
		int countB = 0;
		
		// while 반복문을 사용해 각 라운드를 순회
		while (roundNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 해당 라운드의 A와 B의 점수를 각 변수에 할당
			int scoreA = Integer.parseInt(st.nextToken());
			int scoreB = Integer.parseInt(st.nextToken());
			
			// A의 점수가 B의 점수보다 높은 경우 A가 이긴 횟수를 갱신
			if (scoreA > scoreB) {
				countA++;
				
			// B의 점수가 A의 점수보다 높은 경우 B가 이긴 횟수를 갱신
			} else if (scoreA < scoreB) {
				countB++;
			}
		}
		
		// write() 메서드를 사용해 A가 이긴 횟수와 B가 이긴 횟수를 출력
		out.write(countA + " " + countB);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}