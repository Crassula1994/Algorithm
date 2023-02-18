package bronze1.num14696;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 총 라운드 수를 변수 roundNum에 할당
		int roundNum = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 라운드를 순회
		for (int round = 0; round < roundNum; round++) {
			
			// 각 카드의 개수를 저장할 2차원 배열 ttakjis 초기화
			int[][] ttakjis = new int[2][4];
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 A의 딱지의 개수를 변수 ttakjiA에 할당
			int ttakjiA = Integer.parseInt(st.nextToken());
			
			// for 반복문을 사용해 A의 각 딱지를 배열에 저장
			for (int t = 0; t < ttakjiA; t++)
				ttakjis[0][Integer.parseInt(st.nextToken()) - 1]++;
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 B의 딱지의 개수를 변수 ttakjiB에 할당
			int ttakjiB = Integer.parseInt(st.nextToken());
			
			// for 반복문을 사용해 B의 각 딱지를 배열에 저장
			for (int t = 0; t < ttakjiB; t++)
				ttakjis[1][Integer.parseInt(st.nextToken()) - 1]++;
			
			// 최종 결과를 저장할 변수 result 초기화
			char result = 'D';
				
			// for 반복문을 사용해 각 딱지를 차례로 순회
			for (int t = 3; t >= 0; t--) {
				
				// A가 이긴 경우 A를 result에 저장 후 반복문 탈출
				if (ttakjis[0][t] > ttakjis[1][t]) {
					result = 'A';
					break;
				
				// B가 이긴 경우 B를 result에 저장 후 반복문 탈출
				} else if (ttakjis[0][t] < ttakjis[1][t]) {
					result = 'B';
					break;
				}
			}

			// write() 메서드를 사용해 결과를 출력
			out.write(result + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}