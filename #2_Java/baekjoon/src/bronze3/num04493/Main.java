package bronze3.num04493;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 플레이어가 이긴 횟수를 저장할 각 변수 초기화
	static int count1;
	static int count2;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 가위바위보를 한 횟수를 변수 totalCount에 할당
			int totalCount = Integer.parseInt(in.readLine());
			
			// 각 플레이어가 이긴 횟수를 저장할 각 변수 초기화
			count1 = 0;
			count2 = 0;
			
			// while 반복문을 사용해 각 가위바위보 횟수를 순회
			while (totalCount-- > 0) {
				
				// StringTokenizer 객체를 불러와 변수 st에 할당
				StringTokenizer st = new StringTokenizer(in.readLine());
				
				// nextToken(), charAt(), winnerCounter() 메서드를 사용해 각 플레이어가 이긴 횟수를 갱신
				winnerCounter(st.nextToken().charAt(0), st.nextToken().charAt(0));
			}
			
			// 첫 번째 플레이어가 승자인 경우 'Player 1'을 출력
			if (count1 > count2) {
				out.write("Player 1");
				
			// 두 번째 플레이어가 승자인 경우 'Player 2'를 출력
			} else if (count1 < count2) {
				out.write("Player 2");
				
			// 두 플레이어가 비겼을 경우 'TIE'를 출력
			} else {
				out.write("TIE");
			}
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// winnerCounter() 메서드 정의
	public static void winnerCounter(char result1, char result2) {
		
		// 두 플레이어가 비긴 경우 메서드 종료
		if (result1 == result2)
			return;
		
		// 첫 번째 플레이어가 이긴 경우 첫 번째 플레이어가 이긴 횟수를 갱신 후 메서드 종료
		if ((result1 == 'S' && result2 == 'P') || (result1 == 'R' && result2 == 'S') || (result1 == 'P' && result2 == 'R')) {
			count1++;
			return;
		}
		
		// 두 번째 플레이어가 이긴 경우 두 번째 플레이어가 이긴 횟수를 갱신
		count2++;
	}
}