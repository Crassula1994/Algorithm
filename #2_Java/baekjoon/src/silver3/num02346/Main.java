package silver3.num02346;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
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
		Deque<int[]> balloons = new LinkedList<>();
		
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
		
		// write() 메서드를 사용해 

		// while 반복문을 사용해 balloons가 빌 때까지 순회
		while (!balloons.isEmpty()) {
			
			//
			
			
			
		}

		// write() 메서드를 사용해 8진수로 변환한 결과를 출력
		out.write("");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}