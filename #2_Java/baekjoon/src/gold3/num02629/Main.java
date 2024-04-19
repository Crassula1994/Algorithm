package gold3.num02629;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 추의 개수를 저장할 변수 weightNum 초기화
	static int weightNum;
	
	// 각 추의 무게를 저장할 배열 weights 초기화
	static int[] weights;
	
	// 각 구슬의 무게를 확인할 수 있는지를 나타낼 2차원 배열 measurable 초기화
	static boolean[][] measurable;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 추의 개수를 변수 weightNum에 할당
		weightNum = Integer.parseInt(in.readLine());
		
		// 각 추의 무게를 저장할 배열 weights 초기화
		weights = new int[weightNum];
		
		// 각 구슬의 무게를 확인할 수 있는지를 나타낼 2차원 배열 measurable 초기화
		measurable = new boolean[weightNum + 1][40001];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 추의 무게를 배열 weights에 저장
		for (int idx = 0; idx < weights.length; idx++)
			weights[idx] = Integer.parseInt(st.nextToken());
		
		// beadMeasurer() 메서드를 호출해 각 무게에 대하여 측정이 가능한지를 갱신
		beadMeasurer(0, 0);
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 구슬의 개수를 변수 beadNum에 할당
		int beadNum = Integer.parseInt(in.readLine());
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 구슬의 무게를 순회
		for (int b = 0; b < beadNum; b++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 구슬의 무게를 변수 bead에 할당
			int bead = Integer.parseInt(st.nextToken());
			
			// 해당 구슬의 무게를 확인할 수 있는 경우 'Y'를 출력
			if (measurable[weightNum][bead]) {
				out.write("Y ");
				
			// 해당 구슬의 무게를 확인할 수 없는 경우 'N'을 출력
			} else {
				out.write("N ");
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// beadMeasurer() 메서드 정의
	public static void beadMeasurer(int selected, int totalWeight) {

		// 해당 무게를 이미 잴 수 있다고 확인한 경우 메서드 종료
		if (measurable[selected][totalWeight])
			return;
		
		// 해당 무게를 잴 수 있는 것으로 갱신
		measurable[selected][totalWeight] = true;
		
		// 무게 추를 모두 선택한 경우 메서드 종료
		if (selected == weightNum)
			return;
		
		// abs() 메서드를 사용해 해당 무게 추를 각 팔에 올렸을 때, 올리지 않았을 때를 상정하고 beadMeasurer() 메서드 재귀 호출
		beadMeasurer(selected + 1, Math.abs(totalWeight - weights[selected]));
		beadMeasurer(selected + 1, totalWeight);
		beadMeasurer(selected + 1, totalWeight + weights[selected]);
	}
}