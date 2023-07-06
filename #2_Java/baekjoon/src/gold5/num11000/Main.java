package gold5.num11000;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수업의 개수를 변수 lectureNum에 할당
		int lectureNum = Integer.parseInt(in.readLine());

		// 입력 받은 각 수업을 저장할 PriorityQueue 객체 fastLecture 초기화
		PriorityQueue<int[]> fastLecture = new PriorityQueue<>(
			(c1, c2) -> (c1[0] == c2[0]) ? c1[1] - c2[1] : c1[0] - c2[0]
		);
		
		// 해당 수업을 각 강의실에 배정할 PriorityQueue 객체 lectureRoom 초기화
		PriorityQueue<Integer> lectureRoom = new PriorityQueue<>();

		// for 반복문을 사용해 각 수업을 순회
		for (int c = 0; c < lectureNum; c++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 수업의 시작 시간과 종료 시간을 배열 time에 저장
			int[] time = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			
			// offer() 메서드를 사용해 fastLecture에 배열 time을 추가
			fastLecture.offer(time);
		}
		
		// poll() 및 offer() 메서드를 사용해 가장 먼저 시작하는 수업의 종료 시간을 lectureRoom에 저장
		lectureRoom.offer(fastLecture.poll()[1]);
		
		// while 반복문을 사용해 fastLecture가 모두 빌 때까지 순회
		while (!fastLecture.isEmpty()) {
			
			// poll() 메서드를 사용해 다음 수업을 배열 nextLecture에 할당 
			int[] nextLecture = fastLecture.poll();
			
			// 다음 수업의 시작 시간이 현재 수업의 종료 시간과 같거나 큰 경우
			if (nextLecture[0] >= lectureRoom.peek())
				
				// poll() 메서드를 사용해 기존 수업의 종료 시간을 제거
				lectureRoom.poll();
			
			// 다음 수업의 종료 시간을 lectureRoom에 저장
			lectureRoom.offer(nextLecture[1]);
		}
		
		// size() 메서드를 사용해 수업을 위해 필요한 최소의 강의실의 개수를 변수 roomCnt에 할당
		int roomCnt = lectureRoom.size();
		
		// valueOf() 및 write() 메서드를 사용해 수업을 위해 필요한 최소의 강의실의 개수를 출력
		out.write(String.valueOf(roomCnt));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}