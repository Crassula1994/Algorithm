package silver1.num18079;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 날짜의 수를 변수 dayNum에 할당
			int dayNum = Integer.parseInt(in.readLine());
			
			// 난이도의 차이가 같은 세 문제를 선택하는 방법의 수를 저장할 변수 count 초기화
			int count = 0;
			
			// 각 날짜별 문제의 난이도를 저장할 배열 difficulties 초기화
			int[] difficulties = new int[dayNum];
			
			// 중간 문제 이전의 가능한 첫 문제 난이도와 그 개수를 저장할 Map 객체 leftProblems 초기화
			Map<Integer, Integer> leftProblems = new HashMap<>();
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 각 날짜별 문제의 난이도를 배열 difficulties에 저장
			for (int idx = 0; idx < difficulties.length; idx++)
				difficulties[idx] = Integer.parseInt(st.nextToken());
			
			// for 반복문을 사용해 중간 문제를 순회
			for (int mid = 1; mid < dayNum - 1; mid++) {
				
				// getOrDefault() 및 put() 메서드를 사용해 중간 문제 이전의 가능한 첫 문제 난이도와 그 개수를 leftProblems에 저장
				leftProblems.put(difficulties[mid - 1], leftProblems.getOrDefault(difficulties[mid - 1], 0) + 1);
				
				// for 반복문을 사용해 난이도의 차이가 같은 세 문제를 선택하는 방법의 수를 갱신
				for (int right = mid + 1; right < dayNum; right++)
					count += leftProblems.getOrDefault(difficulties[mid] * 2 - difficulties[right], 0);
			}
			
			// write() 메서드를 사용해 난이도의 차이가 같은 세 문제를 선택하는 방법의 수를 출력
			out.write(count + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}