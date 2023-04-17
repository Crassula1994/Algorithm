package gold3.num02252;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 학생의 수 및 키를 비교한 횟수를 각 변수에 할당
		int studentNum = Integer.parseInt(st.nextToken());
		int measureCnt = Integer.parseInt(st.nextToken());
		
		// 학생별로 앞에 서야 할 학생의 수를 저장할 배열 aheadCounter 초기화
		int[] aheadCounter = new int[studentNum + 1];
		
		// 각 학생 간의 줄 서야 하는 순서를 저장할 배열 orders 초기화
		@SuppressWarnings("unchecked")
		List<Integer>[] orders = new ArrayList[studentNum + 1];
		
		// for 반복문을 사용해 줄 서야 하는 순서를 저장할 List 객체 초기화
		for (int idx = 0; idx <= studentNum; idx++)
			orders[idx] = new ArrayList<>();
		
		// for 반복문을 사용해 각 비교 결과를 순회
		for (int measure = 0; measure < measureCnt; measure++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 앞에 서야 하는 학생과 뒤에 서야 하는 학생을 각 변수에 할당
			int frontStudent = Integer.parseInt(st.nextToken());
			int rearStudent = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 뒤에 서야 하는 학생을 추가
			orders[frontStudent].add(rearStudent);
			
			// 학생별로 앞에 서야 할 학생의 수를 갱신
			aheadCounter[rearStudent]++;
		}
		
		// 다음에 줄을 세울 학생을 저장할 Queue 객체 lineUpList 초기화
		Queue<Integer> lineUpList = new LinkedList<>();
		
		// for 반복문을 사용해 배열 aheadCounter의 각 원소를 순회
		for (int idx = 1; idx <= studentNum; idx++) {
			
			// 앞에 서야 할 학생의 수가 0인 경우 lineUpList에 추가
			if (aheadCounter[idx] == 0)
				lineUpList.offer(idx);
		}
		
		// while 반복문을 사용해 lineUpList가 빌 때까지 순회
		while (!lineUpList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 줄을 세운 학생을 변수 currentStudent에 할당
			int currentStudent = lineUpList.poll();
			
			// write() 메서드를 사용해 현재 줄을 세운 학생을 출력
			out.write(currentStudent + " ");
			
			// for 반복문을 사용해 현재 줄을 세운 학생이 앞에 서야 하는 학생을 순회
			for (int idx = 0; idx < orders[currentStudent].size(); idx++) {
				
				// get() 메서드를 사용해 현재 줄을 세운 학생이 앞에 서야 하는 학생을 변수 nextStudent에 할당
				int nextStudent = orders[currentStudent].get(idx);
				
				// 해당 학생의 앞에 서야 할 학생 수를 갱신
				aheadCounter[nextStudent]--;
				
				// 해당 학생의 앞에 서야 할 학생 수가 0인 경우 lineUpList에 추가
				if (aheadCounter[nextStudent] == 0)
					lineUpList.offer(nextStudent);
			}
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}