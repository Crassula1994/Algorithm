package silver3.num02346;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 풍선의 개수를 변수 balloonNum에 할당
		int balloonNum = Integer.parseInt(in.readLine());
		
		// 각 풍선을 순서대로 저장할 Deque 객체 balloons 초기화
		Deque<int[]> balloons = new ArrayDeque<>();
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 풍선의 정보를 순회
		for (int balloon = 1; balloon <= balloonNum; balloon++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 해당 풍선에 적힌 숫자를 변수 number에 할당
			int number = Integer.parseInt(st.nextToken());
			
			// addLast() 메서드를 사용해 해당 풍선을 balloons에 저장
			balloons.addLast(new int[] {balloon, number});
		}
		
		// pollFirst() 메서드를 사용해 현재 뽑힌 풍선을 저장할 배열 currentBalloon 초기화
		int[] currentBalloon = balloons.pollFirst();

		// while 반복문을 사용해 balloons가 빌 때까지 순회
		while (!balloons.isEmpty()) {
			
			// write() 메서드를 사용해 현재 뽑힌 풍선의 번호를 출력
			out.write(currentBalloon[0] + " ");
			
			// for 반복문을 사용해 해당 풍선에 적힌 숫자만큼의 풍선을 순회
			for (int b = 1; b < Math.abs(currentBalloon[1]); b++) {
				
				// 해당 숫자가 양수인 경우 앞의 풍선을 뒤로 보내기
				if (currentBalloon[1] > 0) {
					balloons.addLast(balloons.pollFirst());
				
				// 해당 숫자가 음수인 경우 뒤의 풍선을 앞으로 보내기
				} else {
					balloons.addFirst(balloons.pollLast());
				}				
			}
			
			// 다음에 뽑힌 풍선 정보를 배열 currentBalloon에 할당
			currentBalloon = (currentBalloon[1] > 0) ? balloons.pollFirst() : balloons.pollLast();
		}
		
		// valueOf() 및 write() 메서드를 사용해 마지막으로 뽑힌 풍선의 번호를 출력
		out.write(String.valueOf(currentBalloon[0]));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}