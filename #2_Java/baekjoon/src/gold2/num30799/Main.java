package gold2.num30799;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 조건을 만족하도록 고구마 간식을 넣는 방법의 수를 나눌 제수를 나타낼 상수 DIVISOR 초기화
	static final int DIVISOR = 998_244_353;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 간식을 숨길 수 있는 위치의 개수를 변수 spotNum에 할당
		int spotNum = Integer.parseInt(in.readLine());
		
		// 각 위치까지 각 종류의 간식을 차례로 먹을 수 있는 방법의 수를 저장할 2차원 배열 counts 초기화
		long[][] counts = new long[spotNum + 1][8];
		
		// 시작 위치에서 먹을 수 있는 간식이 없는 경우 해당 위치까지 각 종류의 간식을 차례로 먹을 수 있는 방법의 수를 초기화
		counts[0][0] = 1;
		
		// for 반복문을 사용해 각 위치를 순회
		for (int spot = 1; spot <= spotNum; spot++) {
			
			// for 반복문을 사용해 각 종류의 간식을 순회
			for (int category = 0; category < 8; category++) {
			
				// 간식을 아무 것도 먹지 않은 경우 해당 위치까지 각 종류의 간식을 차례로 먹을 수 있는 방법의 수를 갱신
				if (category == 0) {
					counts[spot][category] = counts[spot - 1][category] * 6 % DIVISOR;
					
				// 간식을 1개 이상 7개 미만 먹은 경우 해당 위치까지 각 종류의 간식을 차례로 먹을 수 있는 방법의 수를 갱신
				} else if (category < 7) {
					counts[spot][category] = (counts[spot - 1][category - 1] + counts[spot - 1][category] * 6) % DIVISOR;
					
				// 간식을 7개 모두 먹은 경우 해당 위치까지 각 종류의 간식을 차례로 먹을 수 있는 방법의 수를 갱신
				} else {
					counts[spot][category] = (counts[spot - 1][category - 1] + counts[spot - 1][category] * 7) % DIVISOR;
				}
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 조건을 만족하도록 고구마 간식을 넣는 방법의 수를 출력
		out.write(String.valueOf(counts[spotNum][7]));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}