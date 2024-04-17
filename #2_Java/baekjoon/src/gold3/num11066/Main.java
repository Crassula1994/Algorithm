package gold3.num11066;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 소설을 구성하는 장의 수를 변수 chapterNum에 할당
			int chapterNum = Integer.parseInt(in.readLine());
			
			// 각 파일의 크기와 그 누적 합을 저장할 각 배열 초기화
			int[] fileSize = new int[chapterNum + 1];
			int[] accumSum = new int[chapterNum + 1];
			
			// 각 파일까지의 최소 비용을 저장할 2차원 배열 minCosts 초기화
			int[][] minCosts = new int[chapterNum + 1][chapterNum + 1];
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 파일의 크기와 그 누적 합을 각 배열에 저장
			for (int idx = 1; idx < fileSize.length; idx++) {
				fileSize[idx] = Integer.parseInt(st.nextToken());
				accumSum[idx] = accumSum[idx - 1] + fileSize[idx];
			}
			
			// for 반복문을 사용해 파일을 합친 구간의 크기를 순회
			for (int length = 1; length < chapterNum; length++) {
				
				// for 반복문을 사용해 구간의 시작 파일을 순회
				for (int idx = 1; idx < minCosts.length - length; idx++) {
					
					// 해당 구간을 합치는 데 필요한 최소 비용을 초기화
					minCosts[idx][idx + length] = Integer.MAX_VALUE;
					
					// 해당 구간을 마지막으로 합하는데 필요한 비용을 변수 sumCost에 할당
					int sumCost = accumSum[idx + length] - accumSum[idx - 1];
					
					// for 반복문을 사용해 해당 구간을 두 부분으로 나누어 순회
					for (int mid = idx; mid < idx + length; mid++) {
						
						// 해당 구간을 두 부분으로 나누어 각 부분을 저장했을 때의 비용을 변수 cost에 할당
						int cost = minCosts[idx][mid] + minCosts[mid + 1][idx + length] + sumCost;
						
						// min() 메서드를 사용해 해당 구간을 합치는 데 필요한 최소 비용을 갱신
						minCosts[idx][idx + length] = Math.min(cost, minCosts[idx][idx + length]);
					}
				}
			}
			
			// write() 메서드를 사용해 모든 장을 합치는 데 필요한 최소 비용을 출력
			out.write(minCosts[1][chapterNum] + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}