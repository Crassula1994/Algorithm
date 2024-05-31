package gold3.num01069;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 은진이의 위치와 점프하는 시간과 거리를 각 변수에 할당
		int startX = Integer.parseInt(st.nextToken());
		int startY = Integer.parseInt(st.nextToken());
		int jumpDist = Integer.parseInt(st.nextToken());
		int jumpTime = Integer.parseInt(st.nextToken());
		
		// timeCalculator() 메서드를 호출해 집에 돌아오는 데 걸리는 시간의 최솟값을 변수 minTime에 할당
		double minTime = timeCalculator(startX, startY, jumpDist, jumpTime);
		
		// valueOf() 및 write() 메서드를 사용해 집에 돌아오는 데 걸리는 시간의 최솟값을 출력
		out.write(String.valueOf(minTime));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// timeCalculator() 메서드 정의
	public static double timeCalculator(int startX, int startY, int jumpDist, int jumpTime) {
		
		// pow() 및 sqrt() 메서드를 사용해 은진이와 집의 거리를 계산하고 변수 distance에 할당
		double distance = Math.sqrt(Math.pow(startX, 2) + Math.pow(startY, 2));
		
		// 해당 거리를 일직선으로 최대한 점프할 수 있는 횟수를 계산해 변수 count에 할당
		int jumpCount = (int) (distance / jumpDist);
		
		// 걷기만 하는 경우, 점프와 걷기를 병행하는 경우, 점프만 하는 경우의 소요 시간을 계산해 각 변수에 할당
		double walkOnly = distance;
		double walkJump = walkJumpCalculator(distance, jumpCount, jumpDist, jumpTime);
		double jumpOnly = (jumpDist * 2 >= distance) ? 2 * jumpTime : (jumpCount + 1) * jumpTime;
		
		// min() 메서드를 사용해 집에 돌아오는 데 걸리는 시간의 최솟값을 변수 minTime에 할당
		double minTime = Math.min(walkOnly, Math.min(walkJump, jumpOnly));
		
		// 집에 돌아오는 데 걸리는 시간의 최솟값을 반환
		return minTime;
	}
	
	// ----------------------------------------------------------------------------------------------------

	// walkJumpCalculator() 메서드 정의
	public static double walkJumpCalculator(double distance, int jumpCount, int jumpDist, int jumpTime) {
		
		/* 점프 후 남은 거리는 걷는 방법 및 한 번 더 점프 후 초과한 거리를 다시 걸어서 돌아오는 방법을 상정하고,
		해당 방법을 택했을 때 걸리는 시간을 각 변수에 할당 */
		double timeA = jumpTime * jumpCount + distance - jumpDist * jumpCount;
		double timeB = jumpTime * (jumpCount + 1) + jumpDist * (jumpCount + 1) - distance;
		
		// min() 메서드를 사용해 두 방법 중 더 짧은 시간을 반환
		return Math.min(timeA, timeB);
	}
}