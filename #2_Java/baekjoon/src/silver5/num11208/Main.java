package silver5.num11208;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 수잔이 찾고자 하는 거리를 저장할 변수 targetDist 초기화
		int targetDist = Integer.parseInt(in.readLine());
		
		// 수잔이 찾고자 하는 두 프레임을 찾는 것이 가능한지 여부를 나타낼 변수 isPossible 초기화
		boolean isPossible = false;
		
		// for 반복문을 사용해 수잔이 찾고자 하는 두 프레임 사이의 간격을 순회
		for (int interval = 1; interval <= Math.sqrt(targetDist); interval++) {
			
			// 시작 프레임을 계산하기 위한 분모와 분자를 각 변수에 할당
			int denominator = 2 * interval;
			int numerator = targetDist - interval * interval;
			
			// 시작 프레임이 정수가 아닌 경우 다음 간격을 순회
			if (numerator % denominator != 0)
				continue;
			
			// 수잔이 찾고자 하는 두 프레임을 각 변수에 할당
			int startFrame = numerator / denominator;
			int endFrame = startFrame + interval;
			
			// write() 메서드를 사용해 수잔이 찾고자 하는 두 프레임을 출력
			out.write(startFrame + " " + endFrame);
			
			// 수잔이 찾고자 하는 두 프레임을 찾는 것이 가능한지 여부를 갱신 후 반복문 탈출
			isPossible = true;
			break;
		}
		
		// 수잔이 찾고자 하는 두 프레임을 찾는 것이 불가능한 경우 'impossible' 출력
		if (!isPossible)
			out.write("impossible");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}