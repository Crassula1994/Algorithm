package gold3.num02342;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 지시 사항을 나타내는 수열의 길이를 저장할 변수 length 초기화
	static int length;
	
	// 각 지시 사항을 나타내는 수열을 저장할 배열 sequence 초기화
	static int[] sequence;
	
	// 각 지시 사항을 만족 후 두 발의 위치에 따라 사용되는 최소의 힘을 저장할 3차원 배열 minStrength 초기화
	static int[][][] minStrengths;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// countTokens() 메서드를 사용해 지시 사항을 나타내는 수열의 길이를 변수 length에 할당
		length = st.countTokens() - 1;
		
		// 각 지시 사항을 나타내는 수열을 저장할 배열 sequence 초기화
		sequence = new int[length + 1];
		
		// 각 지시 사항을 만족 후 두 발의 위치에 따라 사용되는 최소의 힘을 저장할 3차원 배열 minStrengths 초기화
		minStrengths = new int[5][5][length + 1];
		
		// for 반복문을 사용해 각 지시 사항을 순회
		for (int idx = 1; idx <= sequence.length; idx++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 지시 사항을 변수 command에 할당
			int command = Integer.parseInt(st.nextToken());
			
			// 지시 사항이 0인 경우 반복문 탈출
			if (command == 0)
				break;
			
			// 입력 받은 지시 사항을 배열 sequence에 저장
			sequence[idx] = command;
		}
		
		// feetMover() 메서드를 호출해 모든 지시 사항을 만족하는 데 사용되는 최소의 힘을 변수 minStrength에 할당
		int minStrength = feetMover(0, 0, 1);
		
		// valueOf() 및 write() 메서드를 사용해 모든 지시 사항을 만족하는 데 사용되는 최소의 힘을 출력
		out.write(String.valueOf(minStrength));
			
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// feetMover() 메서드 정의
	public static int feetMover(int leftFoot, int rightFoot, int curCommand) {
		
		// 마지막 지시 사항을 만족한 경우 이동한 거리를 반환
		if (curCommand > length)
			return 0;
		
		// 해당 발의 배치를 이미 확인한 경우 사용된 최소의 힘을 반환
		if (minStrengths[leftFoot][rightFoot][curCommand] != 0)
			return minStrengths[leftFoot][rightFoot][curCommand];
		
		/* 왼쪽 발과 오른쪽 발을 각각 이동한 경우를 상정해 feetMover() 메서드를 호출하고
		strengthCalculator() 메서드를 호출해 다음 지시 사항까지 사용한 힘을 더해 각 변수에 할당 */
		int strengthL = feetMover(sequence[curCommand], rightFoot, curCommand + 1)
				+ strengthCalculator(leftFoot, sequence[curCommand]);
		int strengthR = feetMover(leftFoot, sequence[curCommand], curCommand + 1)
				+ strengthCalculator(rightFoot, sequence[curCommand]);
		
		// min() 메서드를 사용해 사용된 최소의 힘을 갱신
		minStrengths[leftFoot][rightFoot][curCommand] = Math.min(strengthL, strengthR);
		
		// 두 발의 위치에 따라 사용되는 최소의 힘을 반환
		return minStrengths[leftFoot][rightFoot][curCommand];
	}

	// ----------------------------------------------------------------------------------------------------
	
	// strengthCalculator() 메서드 정의
	public static int strengthCalculator(int startLoc, int endLoc) {
		
		// 중앙에 있던 발이 움직이는 경우 2 반환
		if (startLoc == 0)
			return 2;
		
		// 같은 위치로 움직이는 경우 1 반환
		if (startLoc == endLoc)
			return 1;
		
		// 발을 반대편으로 움직이는 경우 4 반환
		if (startLoc % 2 == endLoc % 2)
			return 4;
		
		// 발을 인접한 지점으로 움직이는 경우 3 반환
		return 3;
	}
}