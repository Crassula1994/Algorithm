package gold2.num10775;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 각 게이트 번호에 대하여 현재 비어 있는 게이트 중 가장 큰 번호를 저장할 배열 maxGates 초기화
	static int[] maxGates;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 게이트의 수 및 비행기의 수를 각 변수에 할당
		int gateNum = Integer.parseInt(in.readLine());
		int planeNum = Integer.parseInt(in.readLine());
		
		// 승원이가 도킹시킬 수 있는 최대의 비행기 수를 저장할 변수 maxCount 초기화
		int maxCount = 0;
		
		// 각 게이트 번호에 대하여 현재 비어 있는 게이트 중 가장 큰 번호를 저장할 배열 maxGates 초기화
		maxGates = new int[gateNum + 1];
		
		// for 반복문을 사용해 번호에 대하여 현재 비어 있는 게이트 중 가장 큰 번호를 초기화
		for (int idx = 1; idx < maxGates.length; idx++)
			maxGates[idx] = idx;
		
		// for 반복문을 사용해 각 비행기를 순회
		for (int plane = 0; plane < planeNum; plane++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 비행기가 도킹할 수 있는 최대 게이트의 번호를 변수 gateLimit에 할당
			int gateLimit = Integer.parseInt(in.readLine());
			
			// gateFinder() 메서드를 호출해 비행기를 도킹할 게이트의 번호를 변수 targetGate에 할당
			int targetGate = gateFinder(gateLimit);
			
			// 더 이상 비행기를 도킹시킬 수 없는 경우 반복문 탈출
			if (targetGate == 0)
				break;
			
			// gateDocker() 메서드를 호출해 해당 게이트를 도킹 처리
			gateDocker(targetGate, targetGate - 1);
			
			// 승원이가 도킹시킬 수 있는 최대의 비행기 수를 갱신
			maxCount++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 승원이가 도킹시킬 수 있는 최대의 비행기 수를 출력
		out.write(String.valueOf(maxCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// gateFinder() 메서드 정의
	public static int gateFinder(int gate) {
		
		/* 현재 비어 있는 게이트 중 가장 큰 번호가 자기 자신이 아닌 경우
		gateFinder() 메서드를 재귀 호출하여 비어 있는 게이트 중 가장 큰 번호를 찾아 갱신 */
		if (maxGates[gate] != gate)
			maxGates[gate] = gateFinder(maxGates[gate]);
		
		// 현재 비어 있는 게이트 중 가장 큰 번호를 반환
		return maxGates[gate];
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// gateDocker() 메서드 정의
	public static void gateDocker(int gateA, int gateB) {
		
		// gateFinder() 메서드를 호출해 각 게이트의 비어 있는 게이트 중 가장 큰 번호를 각 변수에 할당
		int maxGateA = gateFinder(gateA);
		int maxGateB = gateFinder(gateB);
		
		// 두 게이트가 다른 경우 더 작은 게이트 번호를 현재 비어 있는 게이트 중 가장 큰 번호로 갱신
		if (maxGateA != maxGateB)
			maxGates[maxGateA] = maxGateB;
	}
}