package gold5.num02313;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 보석의 줄 수를 변수 lineNum에 할당
		int lineNum = Integer.parseInt(in.readLine());
		
		// 보석 가치 총합의 최댓값을 저장할 변수 maxSum 초기화
		long maxSum = 0;
		
		// 각 줄에서 구매한 보석을 저장할 StringBuilder 객체를 불러와 변수 sb에 할당
		StringBuilder sb = new StringBuilder();
		
		// while 반복문을 사용해 각 줄을 순회
		while (lineNum-- > 0) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 줄에 놓인 보석의 개수를 변수 jewelNum에 할당
			int jewelNum = Integer.parseInt(in.readLine());
			
			// 해당 줄에서 최대 보석 가치와 그때 보석의 개수, 끝 보석을 저장할 각 변수 초기화
			int maxValue = Integer.MIN_VALUE;
			int minCount = 0;
			int endJewel = 0;
			
			// 각 위치에서 보석의 가치를 저장할 배열 jewels 초기화
			int[] jewels = new int[jewelNum + 1];
			
			// 각 위치에서 최대 보석 가치의 합과 그때 보석의 개수를 저장할 2차원 배열 maxValues 초기화
			int[][] maxValues = new int[jewelNum + 1][2];
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 각 보석의 가치를 배열 jewels에 저장
			for (int idx = 1; idx < jewels.length; idx++)
				jewels[idx] = Integer.parseInt(st.nextToken());
			
			// 첫 번째 보석에서 최대 보석 가치의 합과 그때 보석의 개수를 갱신
			maxValues[1][0] = jewels[1];
			maxValues[1][1] = 1;
			
			// for 반복문을 사용해 각 보석을 순회
			for (int idx = 2; idx < jewels.length; idx++) {
				
				/* 이전 보석까지 최대 보석 가치의 합이 0 이하인 경우
				해당 보석에서 최대 보석 가치의 합과 그때 보석의 개수를 갱신 */
				if (maxValues[idx - 1][0] <= 0) {
					maxValues[idx][0] = jewels[idx];
					maxValues[idx][1] = 1;
				
				// 이전 보석까지 최대 보석 가치의 합이 1 이상인 경우
				} else {
					maxValues[idx][0] = maxValues[idx - 1][0] + jewels[idx];
					maxValues[idx][1] = maxValues[idx - 1][1] + 1;
				}
			}
			
			// for 반복문을 사용해 각 보석을 순회
			for (int idx = 1; idx < jewels.length; idx++) {
				
				// 해당 위치에서 최대 보석 가치의 합이 저장된 최대 보석 가치의 합보다 큰 경우
				if (maxValues[idx][0] > maxValue) {
					
					// 최대 보석 가치의 합, 그때 보석의 개수, 끝 보석을 갱신
					maxValue = maxValues[idx][0];
					minCount = maxValues[idx][1];
					endJewel = idx;
					
				// 해당 위치에서 최대 보석 가치의 합이 저장된 최대 보석 가치의 합과 같고 보석의 개수가 더 적은 경우
				} else if (maxValues[idx][0] == maxValue && maxValues[idx][1] < minCount) {
					
					// 최대 보석 가치의 합일 때 보석의 개수와 끝 보석을 갱신
					minCount = maxValues[idx][1];
					endJewel = idx;
				}
			}
			
			// 보석 가치 총합의 최댓값을 갱신
			maxSum += maxValue;
			
			// append() 메서드를 사용해 구입한 보석의 정보를 sb에 저장
			sb.append(endJewel - minCount + 1).append(" ").append(endJewel).append("\n");
		}
		
		// toString() 및 write() 메서드를 사용해 보석 가치 총합의 최댓값과 각 줄에서 구입한 보석을 출력
		out.write(maxSum + "\n" + sb.toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}