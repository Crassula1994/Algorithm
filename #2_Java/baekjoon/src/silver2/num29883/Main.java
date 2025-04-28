package silver2.num29883;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 가장 많이 풀 수 있는 과제의 수를 저장할 상수 MAX_TASK 초기화
	static final int MAX_TASK = 1_000_000;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 날짜의 수와 질문의 수를 각 변수에 할당
		int dayNum = Integer.parseInt(st.nextToken());
		int questionNum = Integer.parseInt(st.nextToken());
		
		// 각 날짜까지의 과제 누적 합 및 각 개수만큼의 과제를 연속적으로 푼 날짜가 존재하는지 여부를 저장할 각 배열 초기화
		int[] taskSum = new int[dayNum + 1];
		boolean[] isConsecutive = new boolean[MAX_TASK + 1];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 날짜를 순회
		for (int curIdx = 1; curIdx < taskSum.length; curIdx++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 현재 날짜까지의 과제 누적 합을 갱신
			taskSum[curIdx] = taskSum[curIdx - 1] + Integer.parseInt(st.nextToken());
			
			// for 반복문을 사용해 이전까지의 구간에 대해 각 개수만큼의 과제를 연속적으로 푼 날짜가 존재하는지 여부를 갱신
			for (int prevIdx = curIdx - 1; prevIdx >= 0; prevIdx--)
				isConsecutive[taskSum[curIdx] - taskSum[prevIdx]] = true;
		}
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// while 반복문을 사용해 각 질문을 순회
		while (questionNum-- > 0) {
			
			// nextToken(), parseInt(), write() 메서드를 사용해 주어진 개수만큼의 과제를 연속적으로 푼 날짜가 존재하는지 여부를 출력
			out.write((isConsecutive[Integer.parseInt(st.nextToken())]) ? "JAH" : "EI");
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}