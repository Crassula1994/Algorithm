package silver4.num02847;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 레벨의 수를 변수 levelNum에 할당
		int levelNum = Integer.parseInt(in.readLine());
		
		// 레벨이 1개인 경우 0을 출력
		if (levelNum == 1) {
			out.write(String.valueOf(0));
		
		// 레벨이 1개 이상인 경우
		} else {
		
			// 각 레벨의 점수를 저장할 배열 points 초기화
			int[] points = new int[levelNum];
			
			// for 반복문을 사용해 입력 받은 각 레벨을 배열 points에 저장
			for (int idx = 0; idx < levelNum; idx++)
				points[idx] = Integer.parseInt(in.readLine());
			
			// 감소시키는 레벨의 수를 저장할 변수 count 초기화
			int count = 0;
			
			// for 반복문을 사용해 각 레벨을 순회
			for (int idx = levelNum - 2; idx >= 0; idx--) {
				
				// 해당 레벨이 앞의 레벨에 비해 더 높은 점수인 경우 감소시키는 레벨을 갱신
				if (points[idx] >= points[idx + 1]) {
					count += points[idx] - points[idx + 1] + 1;
					points[idx] = points[idx + 1] - 1;
				}
			}

			// valueOf() 및 write() 메서드를 사용해 감소시키는 레벨의 수를 출력
			out.write(String.valueOf(count));
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}