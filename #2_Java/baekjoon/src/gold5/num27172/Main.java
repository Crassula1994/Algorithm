package gold5.num27172;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 플레이어의 수를 변수 playerNum에 할당
		int playerNum = Integer.parseInt(in.readLine());
		
		// 각 플레이어의 카드, 해당 카드가 존재하는지 여부, 해당 카드의 점수를 저장할 각 배열 초기화
		int[] players = new int[playerNum];
		boolean[] cards = new boolean[1000001];
		int[] scores = new int[1000001];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 플레이어의 카드에 적힌 정수를 순회
		for (int idx = 0; idx < players.length; idx++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 플레이어의 카드에 적힌 정수를 배열 players에 저장
			players[idx] = Integer.parseInt(st.nextToken());
			
			// 해당 카드가 존재하는지 여부를 갱신
			cards[players[idx]] = true;
		}
		
		// for 반복문을 사용해 각 플레이어의 카드를 순회
		for (int player : players) {
			
			// for 반복문을 사용해 해당 카드의 배수를 순회
			for (int card = player * 2; card < cards.length; card += player) {
				
				// 해당 카드의 배수가 존재하는 경우 각 카드의 점수를 갱신
				if (cards[card]) {
					scores[card]--;
					scores[player]++;
				}
			}
		}
		
		// for 반복문을 사용해 각 플레이어의 점수를 출력
		for (int player : players)
			out.write(scores[player] + " ");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}