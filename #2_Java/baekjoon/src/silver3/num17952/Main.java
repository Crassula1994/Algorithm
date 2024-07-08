package silver3.num17952;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Homework 클래스 정의
	public static class Homework {
		
		// 해당 과제의 만점과 남은 시간을 저장할 각 변수 초기화
		int score;
		int remainTime;
		
		// 매개변수를 입력 받는 생성자 정의
		public Homework(int score, int remainTime) {
			this.score = score;
			this.remainTime = remainTime;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 학기의 시간을 변수 semesterTime에 할당
		int semesterTime = Integer.parseInt(in.readLine());
		
		// 성애가 받을 과제 점수를 저장할 변수 totalScore 초기화
		int totalScore = 0;
		
		// 현재 수행 중인 과제의 목록을 저장할 Stack 객체 homeworks 초기화
		Stack<Homework> homeworks = new Stack<>();
		
		// for 반복문을 사용해 각 시간을 순회
		for (int time = 0; time < semesterTime; time++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 현재 주어진 과제가 있는지 여부를 hasHomework에 할당
			boolean hasHomework = Integer.parseInt(st.nextToken()) == 1;
			
			// 과제가 존재하는 경우
			if (hasHomework) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 해당 과제의 만점과 소요 시간을 각 변수에 할당
				int score = Integer.parseInt(st.nextToken());
				int remainTime = Integer.parseInt(st.nextToken());
				
				// 해당 과제를 바로 완료한 경우 성애가 받을 과제 점수 갱신 후 다음 시간을 순회
				if (remainTime == 1) {
					totalScore += score;
					continue;
				}
				
				// add() 메서드를 사용해 해당 과제를 homeworks에 추가
				homeworks.add(new Homework(score, remainTime - 1));
				
				// 다음 시간을 순회
				continue;
			}
			
			// 더 이상 수행할 과제가 없는 경우 다음 시간을 순회
			if (homeworks.isEmpty())
				continue;
			
			// peek() 메서드를 사용해 가장 최신의 과제를 수행 처리
			homeworks.peek().remainTime--;
			
			// 해당 과제를 완료한 경우 homeworks에서 제거 및 성애가 받을 과제 점수 갱신
			if (homeworks.peek().remainTime == 0)
				totalScore += homeworks.pop().score;
		}
		
		// valueOf() 및 write() 메서드를 사용해 성애가 받을 과제 점수를 출력
		out.write(String.valueOf(totalScore));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}