package bronze2.num09076;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
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
			
			// 심판이 준 점수를 저장할 배열 scores 초기화
			int[] scores = new int[5];
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 점수를 배열 scores에 저장
			for (int idx = 0; idx < 5; idx++)
				scores[idx] = Integer.parseInt(st.nextToken());
			
			// sort() 메서드를 사용해 점수를 오름차순으로 정렬
			Arrays.sort(scores);
			
			// 중간 점수의 최고점과 최저점의 차이가 4점 이상인 경우 'KIN' 출력
			if (scores[3] - scores[1] >= 4) {
				out.write("KIN");
				
			// 중간 점수의 최고점과 최저점의 차이가 4점 미만인 경우 총점을 출력
			} else {
				out.write(String.valueOf(scores[1] + scores[2] + scores[3]));
			}
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}