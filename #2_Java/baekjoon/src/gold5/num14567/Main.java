package gold5.num14567;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 과목의 수 및 선수 조건의 수를 각 변수에 할당
		int courseNum = Integer.parseInt(st.nextToken());
		int conditionNum = Integer.parseInt(st.nextToken());
		
		// 과목별 선수 과목의 수를 저장할 배열 prerequisites 초기화
		int[] prerequisites = new int[courseNum + 1];
		
		// 각 과목 간의 선수 관계를 저장할 배열 conditions 초기화
		@SuppressWarnings("unchecked")
		List<Integer>[] conditions = new ArrayList[courseNum + 1];
		
		// for 반복문을 사용해 선수 관계를 저장할 List 객체 초기화
		for (int idx = 0; idx <= courseNum; idx++)
			conditions[idx] = new ArrayList<>();
		
		// for 반복문을 사용해 각 선수 조건을 순회
		for (int condition = 0; condition < conditionNum; condition++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 선수 과목과 이후 들을 수 있는 과목을 각 변수에 할당
			int prevCourse = Integer.parseInt(st.nextToken());
			int nextCourse = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 선수 조건을 추가
			conditions[prevCourse].add(nextCourse);
			
			// 과목별 선수 과목의 수를 갱신
			prerequisites[nextCourse]++;
		}
		
		// 해당 과목의 수강 학기를 저장할 배열 semesters 초기화
		Integer[] semesters = new Integer[courseNum + 1];
		
		// 다음에 수강할 과목을 저장할 Queue 객체 registerList 초기화
		Queue<Integer> registerList = new LinkedList<>();
		
		// for 반복문을 사용해 배열 prerequisites의 각 원소를 순회
		for (int idx = 1; idx <= courseNum; idx++) {
			
			// 선수 과목의 수가 0인 경우
			if (prerequisites[idx] == 0) {
				
				// offer() 메서드를 사용해 registerList에 추가 및 1학기 수강 처리
				registerList.offer(idx);
				semesters[idx] = 1;
			}
		}
		
		// while 반복문을 사용해 registerList가 빌 때까지 순회
		while (!registerList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 수강 중인 과목을 변수 currentCourse에 할당
			int currentCourse = registerList.poll();
			
			// for 반복문을 사용해 현재 수강 중인 과목이 선수 과목인 과목을 순회
			for (int idx = 0; idx < conditions[currentCourse].size(); idx++) {
				
				// get() 메서드를 사용해 현재 수강 중인 과목이 선수 과목인 과목을 변수 nextCourse에 할당
				int nextCourse = conditions[currentCourse].get(idx);
				
				// 해당 과목의 선수 과목 수를 갱신
				prerequisites[nextCourse]--;
				
				// 해당 과목의 선수 과목의 수가 0인 경우
				if (prerequisites[nextCourse] == 0) {
					
					// offer() 메서드를 사용해 registerList에 추가 및 다음 학기 수강 처리
					registerList.offer(nextCourse);
					semesters[nextCourse] = semesters[currentCourse] + 1;
				}
			}
		}
		
		// for 반복문을 사용해 각 과목을 최소 몇 학기에 이수할 수 있는지를 출력
		for (int idx = 1; idx <= courseNum; idx++)
			out.write(semesters[idx] + " ");

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}