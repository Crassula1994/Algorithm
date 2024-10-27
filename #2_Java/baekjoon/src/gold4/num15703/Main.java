package gold4.num15703;

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

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 주사위의 수를 변수 diceNum에 할당
		int diceNum = Integer.parseInt(in.readLine());
		
		// 만들 수 있는 주사위 탑의 최소 개수를 저장할 변수 minTower 초기화
		int minTower = 0;
		
		// 각 숫자가 쓰인 주사위의 개수를 저장할 배열 diceCount 초기화
		int[] diceCount = new int[1001];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// while 반복문을 사용해 입력 받은 각 주사위의 개수를 갱신
		while (diceNum-- > 0)
			diceCount[Integer.parseInt(st.nextToken())]++;
		
		// while 반복문을 사용해 더 이상 쌓을 주사위가 없을 때까지 순회
		while (true) {
			
			// 주사위 탑의 현재 높이를 저장할 변수 height 초기화
			int height = 0;
			
			// for 반복문을 사용해 각 주사위의 숫자를 순회
			for (int die = 0; die <= 1000; die++) {
				
				// while 반복문을 사용해 주사위 탑을 쌓을 수 있을 때까지 순회
				while (diceCount[die] > 0 && height <= die) {
					diceCount[die]--;
					height++;
				}				
			}
			
			// 더 이상 쌓을 주사위가 없는 경우 반복문 탈출
			if (height == 0)
				break;
			
			// 만들 수 있는 주사위 탑의 최소 개수를 갱신
			minTower++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 만들 수 있는 주사위 탑의 최소 개수를 출력
		out.write(String.valueOf(minTower));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}