package gold2.num22880;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 마을을 구간으로 나누는 방법의 가짓수를 나눌 제수를 저장할 상수 DIVISOR 초기화
	static final int DIVISOR = 1_000_000_007;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 마을의 개수를 변수 villageNum에 할당
		int villageNum = Integer.parseInt(in.readLine());
		
		// 해당 마을까지 구간으로 나누는 방법의 가짓수를 저장할 배열 counts 초기화
		int[] counts = new int[villageNum + 1];
		
		// 봉화대를 설치하지 않는 가짓수를 초기화
		counts[0] = 1;
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 마을의 높이를 순회
		for (int idx = 1, maxAltitude = 0, countSum = 1; idx <= villageNum; idx++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 현재 마을의 높이를 변수 altitude에 할당
			int altitude = Integer.parseInt(st.nextToken());
			
			// 해당 마을의 높이가 현재까지 가장 높은 마을의 높이인 경우
			if (altitude > maxAltitude) {
				
				// 가장 높은 마을의 높이 및 해당 마을까지 구간으로 나누는 방법의 가짓수를 갱신
				maxAltitude = altitude;
				counts[idx] = countSum;

			// 해당 마을의 높이가 가장 높은 마을의 높이 미만인 경우 해당 마을까지 구간으로 나누는 방법의 가짓수를 갱신
			} else {
				counts[idx] = counts[idx - 1];
			}
			
			// 해당 마을까지 구간으로 나누는 방법의 가짓수의 누적합을 갱신
			countSum = (countSum + counts[idx]) % DIVISOR;
		}
		
		// valueOf() 및 write() 메서드를 사용해 마을을 구간으로 나누는 방법의 가짓수를 출력
		out.write(String.valueOf(counts[villageNum]));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}