package bronze4.num04562;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 좀비가 먹는 뇌의 수와
			좀비가 살기 위해 먹어야 하는 뇌의 수를 각 변수에 할당 */
			int brainEaten = Integer.parseInt(st.nextToken());
			int brainNeeded = Integer.parseInt(st.nextToken());
			
			// 좀비가 먹는 뇌의 수가 좀비가 살기 위해 먹어야 하는 뇌의 수 이상인 경우 'MMM BRAINS' 출력
			if (brainEaten >= brainNeeded) {
				out.write("MMM BRAINS");
				
			// 좀비가 먹는 뇌의 수가 좀비가 살기 위해 먹어야 하는 뇌의 수 미만인 경우 'NO BRAINS' 출력
			} else {
				out.write("NO BRAINS");
			}
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}