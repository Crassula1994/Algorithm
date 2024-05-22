package gold4.num25308;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 방사형 그래프가 볼록 다각형인 경우의 수를 저장할 변수 count 초기화
	static int count = 0;
	
	// 배치할 능력치와 배치 여부, 배치된 능력치를 저장할 각 배열 초기화
	static int[] abilities = new int[8];
	static boolean[] arranged = new boolean[8];
	static int[] graph = new int[8];
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 능력치를 배열 abilities에 저장
		for (int idx = 0; idx < abilities.length; idx++)
			abilities[idx] = Integer.parseInt(st.nextToken());

		// graphDrawer() 메서드를 호출해 방사형 그래프가 볼록 다각형인 경우의 수를 갱신
		graphDrawer(0);
		
		// valueOf() 및 write() 메서드를 사용해 방사형 그래프가 볼록 다각형인 경우의 수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// graphDrawer() 메서드 정의
	public static void graphDrawer(int curIndex) {
		
		// 방사형 그래프에 능력치 배치가 끝난 경우
		if (curIndex == 8) {
			
			// convexityCalculator() 메서드를 호출해 볼록 다각형인 경우 볼록 다각형인 경우의 수를 갱신
			if (convexCalculator())
				count++;
			
			// 메서드 종료
			return;
		}
		
		// for 반복문을 사용해 각 능력치를 순회
		for (int idx = 0; idx < abilities.length; idx++) {
			
			// 해당 능력치를 이미 배치한 경우 다음 능력치를 순회
			if (arranged[idx])
				continue;
			
			// 해당 능력치를 배치한 것으로 처리
			arranged[idx] = true;
			graph[curIndex] = abilities[idx];
			
			// graphDrawer() 메서드 재귀 호출
			graphDrawer(curIndex + 1);
			
			// 해당 능력치를 배치하지 않은 것으로 처리
			graph[curIndex] = 0;
			arranged[idx] = false;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------

	// convexCalculator() 메서드 정의
	public static boolean convexCalculator() {
		
		// for 반복문을 사용해 방사형 그래프의 각 꼭짓점을 순회
		for (int idx = 0; idx < 8; idx++) {
			
			// sqrt() 메서드를 사용해 세 점의 좌표를 각 변수에 할당
			double x1 = 0;
			double y1 = graph[idx];
			double x2 = graph[(idx + 1) % 8] / Math.sqrt(2);
			double y2 = graph[(idx + 1) % 8] / Math.sqrt(2);
			double x3 = graph[(idx + 2) % 8];
			double y3 = 0;
						
			// 방사형 그래프가 볼록 다각형이 아닌 경우 false 반환
			if ((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1) >= 0)
				return false;
		}
		
		// 방사형 그래프가 볼록 다각형인 경우 true 반환
		return true;
	}
}