package silver4.num28324;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 중간 지점의 개수를 변수 waypointNum에 할당
		int waypointNum = Integer.parseInt(in.readLine());
		
		// 해당 코스에서 얻을 수 있는 가장 큰 연습의 성과를 저장할 변수 maxResult 초기화
		long maxResult = 0;
		
		// 각 중간 지점의 속력 제한을 저장할 배열 speedLimits 초기화
		int[] speedLimits = new int[waypointNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 중간 지점의 속력 제한을 배열 speedLimits에 저장
		for (int idx = 0; idx < speedLimits.length; idx++)
			speedLimits[idx] = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 각 중간 지점을 거꾸로 순회
		for (int idx = speedLimits.length - 1, curSpeed = 0; idx >= 0; idx--) {
			
			// min() 메서드를 사용해 현재 중간 지점에서의 속도를 갱신
			curSpeed = Math.min(curSpeed + 1, speedLimits[idx]);
			
			// 해당 코스에서 얻을 수 있는 가장 큰 연습의 성과를 갱신
			maxResult += curSpeed;
		}
		
		// valueOf() 및 write() 메서드를 사용해 해당 코스에서 얻을 수 있는 가장 큰 연습의 성과를 출력
		out.write(String.valueOf(maxResult));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}