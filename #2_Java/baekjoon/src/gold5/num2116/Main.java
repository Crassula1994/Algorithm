package gold5.num2116;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {

	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 주사위의 개수를 변수 diceNum에 할당
		int diceNum = Integer.parseInt(in.readLine());

		// 각 주사위의 눈의 수를 차례로 저장할 2차원 배열 dice 초기화
		int[][] dice = new int[diceNum][6];
		
		// 각 주사위의 눈의 쌍 위치를 저장할 Map 객체 planarFigure 초기화
		Map<Integer, Integer> planarFigure = new HashMap<>(); 
		
		// put() 메서드를 사용해 각 주사위의 눈의 쌍 위치를 planarFigure에 추가
		planarFigure.put(0, 5);
		planarFigure.put(1, 3);
		planarFigure.put(2, 4);
		planarFigure.put(3, 1);
		planarFigure.put(4, 2);
		planarFigure.put(5, 0);
		
		// for 반복문을 사용해 각 주사위를 순회
		for (int die = 0; die < diceNum; die++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 각 주사위의 눈을 배열 dice에 저장
			for (int i = 0; i < 6; i++)
				dice[die][i] = Integer.parseInt(st.nextToken());
		}
		
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}