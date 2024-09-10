package gold2.num02437;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 저울추의 개수를 변수 weightNum에 할당
		int weightNum = Integer.parseInt(in.readLine());
		
		// 저울추로 연속하여 잴 수 있는 최대 무게를 저장할 변수 maxWeight 초기화
		int maxWeight = 0;
		
		// 각 저울추의 무게를 저장할 배열 weights 초기화
		int[] weights = new int[weightNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 저울추의 무게를 배열 weights에 저장
		for (int idx = 0; idx < weights.length; idx++)
			weights[idx] = Integer.parseInt(st.nextToken());
		
		// sort() 메서드를 사용해 저울추의 무게를 오름차순으로 정렬
		Arrays.sort(weights);
		
		// for 반복문을 사용해 각 저울추의 무게를 순회
		for (int weight : weights) {
			
			// 주어진 추들로 측정할 수 없는 무게 최솟값을 찾은 경우 반복문 탈출
			if (weight > maxWeight + 1)
				break;
			
			// 저울추로 연속하여 잴 수 있는 최대 무게를 갱신
			maxWeight += weight;
		}
		
		// valueOf() 및 write() 메서드를 사용해 주어진 추들로 측정할 수 없는 무게 최솟값을 출력
		out.write(String.valueOf(maxWeight + 1));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}