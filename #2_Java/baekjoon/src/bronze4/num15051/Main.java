package bronze4.num15051;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 가장 이상적으로 기계를 배치했을 때 소비되는 총 시간을 저장할 변수 minTotalTime 초기화
		int minTotalTime = Integer.MAX_VALUE;
		
		// 각 층에서 일하고 있는 사람의 수를 저장할 배열 peopleCounts 초기화
		int[] peopleCounts = new int[3];
		
		// for 반복문을 사용해 입력 받은 각 층에서 일하고 있는 사람의 수를 배열 peopleCounts에 저장
		for (int idx = 0; idx < peopleCounts.length; idx++)
			peopleCounts[idx] = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 층에 기계를 배치한 경우를 순회
		for (int floor = 0; floor < 3; floor++) {
			
			// 해당 층에 기계를 배치했을 때 소비되는 총 시간을 저장할 변수 totalTime 초기화
			int totalTime = 0;
			
			// for 반복문을 사용해 해당 층에 기계를 배치했을 때 소비되는 총 시간을 갱신
			for (int idx = 0; idx < peopleCounts.length; idx++)
				totalTime += peopleCounts[idx] * Math.abs(floor - idx) * 2;
			
			// 해당 층에 기계를 배치했을 때 소비되는 총 시간이 지금까지 가장 이상적인 경우 이를 갱신
			if (minTotalTime > totalTime)
				minTotalTime = totalTime;
		}
		
		// valueOf() 및 write() 메서드를 사용해 가장 이상적으로 기계를 배치했을 때 소비되는 총 시간을 출력
		out.write(String.valueOf(minTotalTime));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}