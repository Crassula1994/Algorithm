package silver1.num17610;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 추의 개수와 추의 무게 합을 저장할 각 변수 초기화
	static int weightNum;
	static int totalSum = 0;
	
	// 추의 무게와 각 무게의 측정 가능 여부를 저장할 각 배열 초기화
	static int[] weights;
	static boolean[] measurable;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 추의 개수를 변수 weightNum에 할당
		weightNum = Integer.parseInt(in.readLine());
		
		// 측정이 불가능한 경우의 수를 저장할 변수 count 초기화
		int count = 0;
		
		// 추의 무게를 저장할 배열 weights 초기화
		weights = new int[weightNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 추의 무게를 순회
		for (int idx = 0; idx < weights.length; idx++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 추의 무게를 배열 weights에 저장
			weights[idx] = Integer.parseInt(st.nextToken());
			
			// 추의 무게 합을 갱신
			totalSum += weights[idx];
		}
		
		// 각 무게의 측정 가능 여부를 저장할 배열 measurable 초기화
		measurable = new boolean[totalSum + 1];
		
		// weightMeasurer() 메서드를 호출해 각 무게의 측정 가능 여부를 갱신
		weightMeasurer(0, 0);
		
		// for 반복문을 사용해 각 무게의 측정 가능 여부를 순회
		for (int idx = 1; idx < measurable.length; idx++) {
			
			// 해당 무게가 측정 불가능한 경우 측정이 불가능한 경우의 수를 갱신
			if (!measurable[idx])
				count++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 측정이 불가능한 경우의 수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// weightMeasurer() 메서드 정의
	public static void weightMeasurer(int curWeight, int sum) {
		
		// 모든 무게 추를 확인한 경우
		if (curWeight == weightNum) {
			
			// 무게가 0 이상인 경우 해당 무게의 측정 가능 여부를 갱신
			if (sum > 0)
				measurable[sum] = true;
			
			// 메서드 종료
			return;
		}
		
		// 해당 추를 사용하지 않은 경우, 양팔저울 왼쪽 및 오른쪽에 올린 경우를 상정해 weightMeasurer() 메서드 재귀 호출
		weightMeasurer(curWeight + 1, sum);
		weightMeasurer(curWeight + 1, sum + weights[curWeight]);
		weightMeasurer(curWeight + 1, sum - weights[curWeight]);
	}
}