package silver1.num11497;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 통나무의 수를 변수 logNum에 할당
			int logNum = Integer.parseInt(in.readLine());
			
			// 난이도가 가장 낮게 각 통나무를 저장할 배열 logs 초기화
			int[] logs = new int[logNum];
			
			// 통나무의 높이를 오름차순으로 정렬할 PriorityQueue 객체 logSorter 초기화
			PriorityQueue<Integer> logSorter = new PriorityQueue<>();

			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// while 반복문을 사용해 입력 받은 통나무의 높이를 logSorter에 저장
			while (st.hasMoreTokens())
				logSorter.offer(Integer.parseInt(st.nextToken()));
			
			// for 반복문을 사용해 난이도가 가장 낮게 각 통나무를 배열 logs에 저장
			for (int idx = 0; idx < logNum / 2; idx++) {
				logs[idx] = logSorter.poll();
				logs[logNum - idx - 1] = logSorter.poll();
			}
			
			// 통나무의 개수가 홀수인 경우 정가운데의 통나무를 배열 logs에 저장
			if (logNum % 2 == 1)
				logs[logNum / 2] = logSorter.poll();
			
			// 최소 난이도를 저장할 변수 minDiff 초기화
			int minDiff = logs[logNum - 1] - logs[0];
			
			// for 반복문을 사용해 최소 난이도를 갱신
			for (int idx = 1; idx < logs.length; idx++)
				minDiff = Math.max(Math.abs(logs[idx] - logs[idx - 1]), minDiff);
			
			// write() 메서드를 사용해 통나무들로 만들 수 있는 최소 난이도를 출력
			out.write(minDiff + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}