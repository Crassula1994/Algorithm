package bronze2.num16770;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 소의 수를 변수 cowNum에 할당
		int cowNum = Integer.parseInt(in.readLine());
		
		// 농부 존이 필요한 양동이의 수를 저장할 변수 maxCount 초기화
		int maxCount = 0;
		
		// 각 시간별 필요한 양동이 수의 변화를 저장할 배열 bucketCounts 초기화
		int[] bucketCounts = new int[1002];
		
		// while 반복문을 사용해 각 소의 정보를 순회
		while (cowNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 소의 착유 시작 시간, 종료 시간, 필요한 양동이 수를 각 변수에 할당
			int startTime = Integer.parseInt(st.nextToken());
			int endTime = Integer.parseInt(st.nextToken());
			int count = Integer.parseInt(st.nextToken());
			
			// 각 시간별 필요한 양동이 수의 변화를 배열 bucketCounts에 저장
			bucketCounts[startTime] += count;
			bucketCounts[endTime + 1] -= count;
		}
		
		// for 반복문을 사용해 농부 존이 필요한 양동이의 수를 갱신
		for (int idx = 1, count = 0; idx < bucketCounts.length - 1; idx++) {
			count += bucketCounts[idx];
			maxCount = Math.max(count, maxCount);
		}
		
		// valueOf() 및 write() 메서드를 사용해 농부 존이 필요한 양동이의 수를 출력
		out.write(String.valueOf(maxCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}