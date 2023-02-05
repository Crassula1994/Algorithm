package bronze1.num2775;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 저장
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int i = 0; i < testCase; i++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 층수 및 호수를 각 변수에 저장
			int floor = Integer.parseInt(in.readLine());
			int room = Integer.parseInt(in.readLine());
			
			// 각 호의 거주민 수를 담을 2차원 배열 rooms 초기화
			int[][] rooms = new int[floor + 1][room];
			
			// for 반복문을 사용해 0층의 사람 수를 초기화
			for (int j = 0; j < room; j++)
				rooms[0][j] = j + 1;
			
			// for 반복문을 사용해 1호의 거주민 수를 1로 초기화
			for (int k = 1; k < floor +1; k++)
				rooms[k][0] = 1;
			
			// for 반복문을 사용해 각 층을 순회
			for (int r = 1; r < floor + 1; r++) {
				
				// for 반복문을 사용해 각 호를 순회하며 거주민 수 계산
				for (int c = 1; c < room; c++)
					rooms[r][c] = rooms[r - 1][c] + rooms[r][c - 1];
			}
				
			// write() 메서드를 사용해 입력 받은 호수의 거주민 수를 출력
			out.write(rooms[floor][room - 1] + "\n");			
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}