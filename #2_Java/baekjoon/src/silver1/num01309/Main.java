package silver1.num01309;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 우리의 크기를 변수 size에 할당
		int size = Integer.parseInt(in.readLine());
		
		// 각 위치에 사자를 배치하는 가짓수를 저장할 2차원 배열 counter 초기화
		int[][] counter = new int[size + 1][3];
		
		// 첫 줄의 가짓수를 초기화
		counter[1][0] = 1;
		counter[1][1] = 1;
		counter[1][2] = 1;
		
		// for 반복문을 사용해 각 줄을 순회
		for (int r = 2; r <= size; r++) {
			
			// 해당 줄에 사자를 배치하지 않는 경우의 개수를 갱신
			counter[r][0] = (counter[r - 1][0] + counter[r - 1][1] + counter[r - 1][2]) % 9901;
			
			// 해당 줄의 왼쪽에 사자를 배치하는 경우의 개수를 갱신
			counter[r][1] = (counter[r - 1][0] + counter[r - 1][2]) % 9901;
			
			// 해당 줄의 오른쪽에 사자를 배치하는 경우의 개수를 갱신
			counter[r][2] = (counter[r - 1][0] + counter[r - 1][1]) % 9901;
		}
		
		// 사자를 배치하는 경우의 수를 계산해 변수 totalCnt에 할당
		int totalCnt = (counter[size][0] + counter[size][1] + counter[size][2]) % 9901;
		
		// valueOf() 및 write() 메서드를 사용해 사자를 배치하는 경우의 수를 출력
		out.write(String.valueOf(totalCnt));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}