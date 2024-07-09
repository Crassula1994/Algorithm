package silver1.num30412;

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
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 탑의 개수와 춘배가 원하는 차이를 각 변수에 할당
		int towerNum = Integer.parseInt(st.nextToken());
		int targetDiff = Integer.parseInt(st.nextToken());
		
		// 춘배가 원하는 자리를 만들기 위해 이안이가 시행해야 하는 최소 횟수를 저장할 변수 minCount 초기화
		long minCount = Integer.MAX_VALUE;
		
		// 각 탑의 높이를 저장할 배열 towers 초기화
		long[] towers = new long[towerNum + 2];
		
		// 양끝의 탑의 높이를 초기화
		towers[0] = towers[towerNum + 1] = Integer.MIN_VALUE;
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 탑의 높이를 배열 towers에 저장
		for (int idx = 1; idx <= towerNum; idx++)
			towers[idx] = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 각 탑의 높이를 순회
		for (int idx = 1; idx <= towerNum; idx++) {
			
			// abs() 메서드를 사용해 양 옆의 탑과의 차이를 각 변수에 할당
			long leftDiff = Math.abs(towers[idx - 1] - towers[idx]);
			long rightDiff = Math.abs(towers[idx + 1] - towers[idx]);
			
			// 춘배가 원하는 자리가 이미 존재하는 경우 최소 횟수 갱신 후 반복문 탈출
			if (leftDiff >= targetDiff && rightDiff >= targetDiff) {
				minCount = 0;
				break;
			}
			
			// 각 경우의 수를 저장할 배열 counts 초기화
			long[] counts = new long[4];
			
			/* countCalculator() 메서드를 호출해 각 경우의 수를 배열 counts에 저장
				1. 왼쪽 탑과 오른쪽 탑을 높이는 경우
				2. 왼쪽 탑과 가운데 탑을 높이는 경우
				3. 오른쪽 탑과 가운데 탑을 높이는 경우
				4. 가운데 탑을 높이는 경우
			*/
			counts[0] = countCalculator(towers[idx] + targetDiff, towers[idx - 1])
					+ countCalculator(towers[idx] + targetDiff, towers[idx + 1]);
			counts[1] = countCalculator(towers[idx + 1] + targetDiff, towers[idx])
					+ countCalculator(Math.max(towers[idx], towers[idx + 1] + targetDiff) + targetDiff, towers[idx - 1]);
			counts[2] = countCalculator(towers[idx - 1] + targetDiff, towers[idx])
					+ countCalculator(Math.max(towers[idx], towers[idx - 1] + targetDiff) + targetDiff, towers[idx + 1]);
			counts[3] = countCalculator(Math.max(towers[idx - 1], towers[idx + 1]) + targetDiff, towers[idx]);
			
			// for 반복문을 사용해 이안이가 시행해야 하는 최소 횟수를 갱신
			for (long count : counts)
				minCount = Math.min(count, minCount);
		}
		
		// valueOf() 및 write() 메서드를 사용해 춘배가 원하는 자리를 만들기 위해 이안이가 시행해야 하는 최소 횟수를 출력
		out.write(String.valueOf(minCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// diffCalculator() 메서드 정의
	public static long countCalculator(long targetHeight, long currentHeight) {
		
		// max() 메서드를 사용해 목표 높이를 만들기 위해 시행해야 하는 횟수를 반환
		return Math.max(0, targetHeight - currentHeight);
	}
}