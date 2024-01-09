package bronze1.num05533;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 참가자의 수를 변수 playerNum에 할당
		int playerNum = Integer.parseInt(in.readLine());
		
		// 각 플레이어의 점수를 저장할 배열 scores 초기화
		int[] scores = new int[playerNum];
		
		// 각 플레이어가 쓴 숫자를 저장할 2차원 배열 results 초기화
		int[][] results = new int[playerNum][3];
		
		// for 반복문을 사용해 각 플레이어를 순회
		for (int player = 0; player < playerNum; player++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 플레이어가 적은 숫자를 2차원 배열 result에 저장
			for (int idx = 0; idx < 3; idx++)
				results[player][idx] = Integer.parseInt(st.nextToken());
		}
		
		// for 반복문을 사용해 각 플레이어를 순회
		for (int player = 0; player < playerNum; player++) {
			
			// for 반복문을 사용해 각 게임을 순회
			for (int idx = 0; idx < 3; idx++) {
				
				// 해당 플레이어가 점수를 얻었는지를 나타내는 변수 canWin 초기화
				boolean canWin = true;
				
				// for 반복문을 사용해 다른 플레이어를 순회
				for (int other = 0; other < playerNum; other++) {
					
					// 다른 플레이어가 같은 숫자를 적어낸 경우
					if (player != other && results[player][idx] == results[other][idx]) {
						
						// 해당 플레이어가 점수를 얻었는지를 나타내는 변수 갱신 후 반복문 탈출
						canWin = false;
						break;
					}
				}
				
				// 해당 플레이어가 점수를 얻은 경우 점수를 갱신
				if (canWin)
					scores[player] += results[player][idx];
			}
		}
		
		// for 반복문을 사용해 각 플레이어가 얻은 총 점수를 출력
		for (int player = 0; player < playerNum; player++)
			out.write(scores[player] + "\n");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}