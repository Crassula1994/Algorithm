package bronze3.num10103;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 라운드의 수를 변수 roundNum에 할당
		int roundNum = Integer.parseInt(in.readLine());
		
		// 창영이와 상덕이의 점수를 저장할 각 변수 초기화
		int scoreCY = 100;
		int scoreSD = 100;
		
		// for 반복문을 사용해 각 라운드를 순회
		for (int round = 0; round < roundNum; round++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 창영이와 상덕이의 주사위 숫자를 각 변수에 할당
			int diceCY = Integer.parseInt(st.nextToken());
			int diceSD = Integer.parseInt(st.nextToken());
			
			// 창영이의 주사위 숫자가 더 큰 경우 상덕이의 점수를 갱신
			if (diceCY > diceSD) {
				scoreSD -= diceCY;
				
			// 상덕이의 주사위 숫자가 더 큰 경우 창영이의 점수를 갱신
			} else if (diceCY < diceSD) {
				scoreCY -= diceSD;
			}
		}
		
		// write() 메서드를 사용해 창영이와 상덕이의 점수를 출력
		out.write(scoreCY + "\n" + scoreSD);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}