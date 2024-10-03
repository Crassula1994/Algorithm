package bronze2.num25053;

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
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 문제의 수를 변수 problemNum에 할당
			int problemNum = Integer.parseInt(in.readLine());
			
			// 선택한 문제의 아름다운 정도의 합 및 문제가 부족한지 여부를 나타낼 각 변수 초기화
			int beautySum = 0;
			boolean isOmit = false;
			
			// 각 난이도의 문제 중 가장 아름다운 문제를 저장할 배열 problems 초기화
			int[] problems = new int[11];
			
			// while 반복문을 사용해 각 문제를 순회
			while (problemNum-- > 0) {
				
				// StringTokenizer 객체를 불러와 변수 st에 할당
				StringTokenizer st = new StringTokenizer(in.readLine());
				
				// nextToken() 및 parseInt() 메서드를 사용해 해당 문제의 난이도와 아름다움의 정도를 각 변수에 할당
				int beauty = Integer.parseInt(st.nextToken());
				int difficulty = Integer.parseInt(st.nextToken());
				
				// max() 메서드를 사용해 해당 난이도의 가장 아름다운 문제를 갱신
				problems[difficulty] = Math.max(beauty, problems[difficulty]);
			}
			
			// for 반복문을 사용해 각 난이도를 순회
			for (int idx = 1; idx < problems.length; idx++) {
				
				// 해당 난이도의 문제가 존재하지 않는 경우 문제가 부족한지 여부를 갱신 후 반복문 탈출
				if (problems[idx] == 0) {
					isOmit = true;
					break;
				}
				
				// 선택한 문제의 아름다운 정도의 합을 갱신
				beautySum += problems[idx];
			}
			
			// valueOf() 및 write() 메서드를 사용해 문제가 부족한지, 부족하지 않다면 선택한 문제의 아름다운 정도의 합을 출력
			out.write((isOmit) ? "MOREPROBLEMS" : String.valueOf(beautySum));
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}