package platinum5.num06549;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 히스토그램의 각 직사각형의 높이를 저장할 배열 histogram 초기화
	static int[] histogram;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 직사각형의 수를 변수 squareNum에 할당
			int squareNum = Integer.parseInt(st.nextToken());
			
			// 0이 입력된 경우 반복문 탈출
			if (squareNum == 0)
				break;
			
			// 히스토그램의 각 직사각형의 높이를 저장할 배열 histogram 초기화
			histogram = new int[squareNum];
			
			// for 반복문을 사용해 각 직사각형의 넓이를 배열 histogram에 저장
			for (int idx = 0; idx < histogram.length; idx++)
				histogram[idx] = Integer.parseInt(st.nextToken());
				
			// areaMeasurer() 메서드를 호출해 히스토그램에서 가장 넓이가 큰 직사각형의 넓이를 변수 maxArea에 할당
			long maxArea = areaMeasurer(0, squareNum - 1);
			
			// write() 메서드를 사용해 히스토그램에서 가장 넓이가 큰 직사각형의 넓이를 출력
			out.write(maxArea + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// areaMeasurer() 메서드 정의
	public static long areaMeasurer(int start, int end) {
		
		// 길이가 1인 직사각형인 경우 해당 넓이를 반환
		if (start == end)
			return histogram[start];
		
		// 히스토그램의 중간을 계산해 변수 mid에 할당
		int mid = (start + end) / 2;
		
		/* areaMeasurer() 메서드를 재귀 호출해 왼쪽과 오른쪽의 넓이를 분할하고,
		max() 메서드를 사용해 이중 더 넓은 넓이을 변수 maxArea에 할당 */
		long maxArea = Math.max(areaMeasurer(start, mid), areaMeasurer(mid + 1, end));
		
		/* areaCombiner() 메서드를 호출해 구간의 중간에서 가장 넓은 넓이를 지닌 넓이를 계산하고,
		max() 메서드를 사용해 이를 비교하여 더 넓은 넓이를 변수 maxArea에 할당 */
		maxArea = Math.max(areaCombiner(start, mid, end), maxArea);
		
		// 히스토그램에서 가장 넓이가 큰 직사각형의 넓이를 반환
		return maxArea;
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// areaCombiner() 메서드 정의
	public static long areaCombiner(int start, int mid, int end) {
		
		// 넓이를 탐색하기 위해 필요한 각 인덱스를 저장할 각 변수 초기화
		int left = mid;
		int right = mid;
		
		// 면적의 높이와 가장 넓은 넓이를 저장할 각 변수 초기화
		long minHeight = histogram[mid];
		long maxArea = histogram[mid];
		
		// while 반복문을 사용해 왼쪽과 오른쪽 인덱스가 끝에 도달할 때까지 순회
		while (left > start && right < end) {
			
			// 양쪽의 높이 중 왼쪽이 더 높은 경우 높이를 갱신
			if (histogram[left - 1] > histogram[right + 1]) {
				minHeight = Math.min(histogram[--left], minHeight);
			
			// 양쪽의 높이 중 오른쪽이 더 높거나 높이가 같은 경우 높이를 갱신
			} else {
				minHeight = Math.min(histogram[++right], minHeight);
			}
			
			// max() 메서드를 사용해 가장 넓은 넓이를 갱신
			maxArea = Math.max((right - left + 1) * minHeight, maxArea);
		}
		
		// 왼쪽 인데스가 끝에 도달할 때까지 순회
		while (left > start) {
			
			// min() 메서드를 사용해 직사각형의 넓이를 갱신
			minHeight = Math.min(histogram[--left], minHeight);
			
			// max() 메서드를 사용해 가장 넓은 넓이를 갱신
			maxArea = Math.max((right - left + 1) * minHeight, maxArea);
		}
		
		// 오른쪽 인데스가 끝에 도달할 때까지 순회
		while (right < end) {
			
			// min() 메서드를 사용해 직사각형의 넓이를 갱신
			minHeight = Math.min(histogram[++right], minHeight);
			
			// max() 메서드를 사용해 가장 넓은 넓이를 갱신
			maxArea = Math.max((right - left + 1) * minHeight, maxArea);
		}
		
		// 히스토그램에서 가장 넓이가 큰 직사각형의 넓이를 반환
		return maxArea;
	}
}