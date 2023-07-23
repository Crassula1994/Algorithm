package silver5.num02535;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 대회 참가 학생의 수를 변수 studentNum에 할당
		int studentNum = Integer.parseInt(in.readLine());
		
		// 각 학생의 대회 결과를 저장할 PrioirtyQueue 객체 results 초기화
		PriorityQueue<int[]> results = new PriorityQueue<>((r1, r2) -> {
			return r2[2] - r1[2];
		});
		
		// 각 나라 학생의 수상 현황을 나타낼 배열 prizeCnt 초기화
		int[] prizeCnt = new int[101];
		
		// for 반복문을 사용해 입력 받은 각 학생의 대회 결과를 순회
		for (int s = 0; s < studentNum; s++) {
			
			// StringTokeznier 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 학생의 대회 결과를 각 변수에 할당
			int nation = Integer.parseInt(st.nextToken());
			int sequence = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			
			// offer() 메서드를 사용해 학생의 대회 결과를 results에 추가
			results.offer(new int[] {nation, sequence, grade});
		}
		
		// 수상자의 수를 저장할 변수 count 초기화
		int count = 0;
		
		// while 반복문을 사용해 세 명의 수상자가 나올 때까지 순회
		while (count < 3) {
			
			// poll() 메서드를 사용해 현재 확인 중인 학생을 배열 currentStudent에 할당
			int[] currentStudent = results.poll();
			
			// 해당 학생의 국가의 수상자가 2명일 경우 다음 학생을 순회
			if (prizeCnt[currentStudent[0]] == 2)
				continue;
			
			// 수상자의 수 및 해당 국가의 수상자의 수를 갱신
			count++;
			prizeCnt[currentStudent[0]]++;
			
			// write() 메서드를 사용해 수상자의 소속국가 번호와 학생 번호를 출력
			out.write(currentStudent[0] + " " + currentStudent[1] + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}