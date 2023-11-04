package silver5.num09625;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 버튼을 누른 횟수를 변수 pushCnt에 할당
		int pushCnt = Integer.parseInt(in.readLine());
		
		// 각 버튼을 누른 횟수마다 A와 B의 개수를 저장할 2차원 배열 counter 초기화
		int[][] counter = new int[pushCnt + 1][2];
		
		// 처음 문자열의 상태를 2차원 배열 counter에 갱신
		counter[0][0] = 1;
		
		// for 반복문을 사용해 각 버튼을 누른 횟수를 순회
		for (int idx = 1; idx <= pushCnt; idx++) {
			
			// 해당 버튼을 눌렀을 때 A의 개수를 갱신
			counter[idx][0] = counter[idx - 1][1];
					
			// 해당 버튼을 눌렀을 때 B의 개수를 갱신
			counter[idx][1] = counter[idx - 1][0] + counter[idx - 1][1];
		}
		
		// write() 메서드를 사용해 해당 버튼을 누른 횟수에서의 A의 개수와 B의 개수를 출력
		out.write(counter[pushCnt][0] + " " + counter[pushCnt][1]);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}