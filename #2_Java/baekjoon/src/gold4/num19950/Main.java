package gold4.num19950;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 시작점과 끝점의 좌표를 저장할 각 배열 초기화
	static int[] startPoint = new int[3];
	static int[] endPoint = new int[3];
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 시작점의 각 좌표를 배열 startPoint에 저장
		for (int idx = 0; idx < startPoint.length; idx++)
			startPoint[idx] = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 입력 받은 끝점의 각 좌표를 배열 endPoint에 저장
		for (int idx = 0; idx < endPoint.length; idx++)
			endPoint[idx] = Integer.parseInt(st.nextToken());
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 막대기의 개수를 변수 stickNum에 할당
		int stickNum = Integer.parseInt(in.readLine());
		
		// sqrt() 및 distCalculator() 메서드를 사용해 두 점 사이의 거리를 계산해 변수 distance에 할당
		double distance = Math.sqrt(distCalculator(0) + distCalculator(1) + distCalculator(2));
		
		// 막대기의 총 길이 및 가장 긴 막대기의 길이를 저장할 각 변수 초기화
		int totalLength = 0;
		int maxLength = 0;
		
		// 막대기의 길이를 저장할 배열 sticks 초기화
		int[] sticks = new int[stickNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 막대기를 순회
		for (int idx = 0; idx < sticks.length; idx++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 막대기의 길이를 배열 sticks에 저장
			sticks[idx] = Integer.parseInt(st.nextToken());
			
			// max() 메서드를 사용해 막대기의 총 길이 및 가장 긴 막대기의 길이를 갱신
			totalLength += sticks[idx];
			maxLength = Math.max(sticks[idx], maxLength);
		}
		
		// 시작점과 끝점을 막대기를 이용해 연결할 수 있는 경우 'YES' 출력
		if (totalLength == distance || (totalLength > distance && maxLength * 2 - totalLength <= distance)) {
			out.write("YES");
			
		// 시작점과 끝점을 막대기를 이용해 연결할 수 없는 경우 'NO' 출력
		} else {
			out.write("NO");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// distCalculator() 메서드 정의
	public static double distCalculator(int index) {
		
		// pow() 메서드를 사용해 입력 받은 좌표의 차이의 제곱을 계산해 반환
		return Math.pow(endPoint[index] - startPoint[index], 2);
	}
}