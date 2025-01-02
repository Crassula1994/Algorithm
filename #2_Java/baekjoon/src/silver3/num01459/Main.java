package silver3.num01459;

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
		
		// nextToken() 및 parseLong() 메서드를 사용해 입력 받은 집의 위치와 각 이동 시간을 각 변수에 할당
		long targetX = Long.parseLong(st.nextToken());
		long targetY = Long.parseLong(st.nextToken());
		long straightTime = Long.parseLong(st.nextToken());
		long diagonalTime = Long.parseLong(st.nextToken());
		
		// 세준이가 집에 가는 데 걸리는 최소 시간을 저장할 변수 minTime 초기화
		long minTime = 0;
		
		// 두 블록 움직이는 것이 더 빠른 경우 세준이가 집에 가는 데 걸리는 최소 시간을 갱신
		if (straightTime * 2 <= diagonalTime) {
			minTime = (targetX + targetY) * straightTime;
			
		// 대각선으로 한 블록 가로지르는 것이 더 빠른 경우
		} else {
			
			// min() 메서드를 사용해 대각선으로 갈 수 있는 거리만큼 이동한 것으로 상정하고 세준이가 집에 가는 데 걸리는 최소 시간을 갱신
			minTime += Math.min(targetX, targetY) * diagonalTime;
			
			// abs() 메서드를 사용해 세준이가 더 이동해야 하는 남은 거리를 변수 remains에 할당
			long remains = Math.abs(targetX - targetY);
			
			// 대각선으로 이동하는 것이 한 블록 움직이는 것보다 더 빠른 경우 세준이가 집에 가는 데 걸리는 최소 시간을 갱신
			if (straightTime > diagonalTime) {
				minTime = ((remains & 1) == 1)
						? minTime + (remains - 1) * diagonalTime + straightTime : minTime + remains * diagonalTime;
				
			// 대각선으로 이동하는 것이 한 블록 움직이는 것보다 더 느리거나 같은 경우 세준이가 집에 가는 데 걸리는 최소 시간을 갱신
			} else {
				minTime += remains * straightTime;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 세준이가 집에 가는 데 걸리는 최소 시간을 출력
		out.write(String.valueOf(minTime));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}