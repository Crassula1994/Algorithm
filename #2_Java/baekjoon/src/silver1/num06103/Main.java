package silver1.num06103;

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
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 멀론의 수 및 공예가가 청구할 각 비용을 각 변수에 할당
		int merlonNum = Integer.parseInt(st.nextToken());
		int addCharge = Integer.parseInt(st.nextToken());
		int reduceCharge = Integer.parseInt(st.nextToken());
		
		// 성을 다시 세우기 위해 필요한 최소 비용을 저장할 변수 minCost 초기화
		long minCost = 0;
		
		// 바뀌기 전 멀론의 높이와 바뀐 후 멀론의 높이를 저장할 각 배열 초기화
		int[] beforeHeights = new int[merlonNum];
		int[] afterHeights = new int[merlonNum];
		
		// for 반복문을 사용해 각 멀론을 순회
		for (int idx = 0; idx < merlonNum; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 각 멀론의 높이를 각 배열에 저장
			beforeHeights[idx] = Integer.parseInt(st.nextToken());
			afterHeights[idx] = Integer.parseInt(st.nextToken());
		}
		
		// sort() 메서드를 사용해 각 멀론의 높이를 오름차순으로 정렬
		Arrays.sort(beforeHeights);
		Arrays.sort(afterHeights);
		
		// for 반복문을 사용해 각 멀론의 높이를 순회
		for (int idx = 0; idx < merlonNum; idx++) {
			
			// 멀론을 높여야 하는 경우 성을 다시 세우기 위해 필요한 최소 비용을 갱신
			if (beforeHeights[idx] < afterHeights[idx]) {
				minCost += (afterHeights[idx] - beforeHeights[idx]) * addCharge;
			
			// 멀론을 낮춰야 하는 경우 성을 다시 세우기 위해 필요한 최소 비용을 갱신
			} else if (beforeHeights[idx] > afterHeights[idx]) {
				minCost += (beforeHeights[idx] - afterHeights[idx]) * reduceCharge;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 성을 다시 세우기 위해 필요한 최소 비용을 출력
		out.write(String.valueOf(minCost));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}