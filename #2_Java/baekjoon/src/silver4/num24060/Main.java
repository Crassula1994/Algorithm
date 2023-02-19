package silver4.num24060;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {

	// 정렬된 배열을 저장할 배열, 저장 횟수 및 상한, 저장 결과를 초기화
	static int saveLimit;
	static int[] sorted;
	static int count = 0;
	static int result = -1;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 배열의 크기 및 저장 상한을 각 변수에 할당
		int length = Integer.parseInt(st.nextToken());
		saveLimit = Integer.parseInt(st.nextToken());
		
		// 입력 받은 원소를 저장할 배열 array 초기화
		int[] array = new int[length];
		sorted = new int[length];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 원소를 배열 array에 저장
		for (int idx = 0; idx < length; idx++)
			array[idx] = Integer.parseInt(st.nextToken());

		// mergeSort() 메서드를 호출해 병합 정렬 시행
		mergeSort(array, 0, length - 1);

		// valueOf() 및 write() 메서드를 사용해 결과를 출력
		out.write(String.valueOf(result));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// mergeSort() 메서드 정의
	public static void mergeSort(int[] array, int start, int end) {
		
		// 배열의 시작점과 끝점 사이에 원소가 존재하는 경우
		if (start < end) {
			
			// 시작점과 끝점의 중간점을 변수 mid에 할당
			int mid = (start + end) / 2;
			
			// mergeSort() 메서드 재귀 호출해 전반부 및 후반부 정렬 수행
			mergeSort(array, start, mid);
			mergeSort(array, mid + 1, end);
			
			// merge() 메서드를 호출해 정렬된 두 부분을 병합해 정렬된 상태로 변환
			merge(array, start, mid, end);
		}
	}

	// ----------------------------------------------------------------------------------------------------
	
	// merge() 메서드 정의
	public static void merge(int[] array, int start, int mid, int end) {
		
		// 전반부의 인덱스, 후반부의 인덱스, 새로운 배열의 인덱스를 초기화
		int i = start;
		int j = mid + 1;
		int idx = 0;
		
		// while 반복문을 사용해 각 인덱스를 순회
		while (i <= mid && j <= end) {
			
			// 전반부 원소가 후반부 원소보다 작거나 같은 경우 전반부 원소를 저장
			if (array[i] <= array[j]) {
				sorted[idx++] = array[i++];
				
			// 전반부 원소가 후반부 원소보다 큰 경우 후반부 원소를 저장
			} else {
				sorted[idx++] = array[j++];
			}
		}
		
		// while 반복문을 사용해 남은 전반부 배열을 저장
		while (i <= mid)
			sorted[idx++] = array[i++];
		
		// while 반복문을 사용해 남은 후반부 배열을 저장
		while (j <= end)
			sorted[idx++] = array[j++];
		
		// 전반부의 인덱스 및 새로운 배열의 인덱스 초기화
		i = start;
		idx = 0;
		
		// while 반복문을 사용해 저장 횟수에 도달할 때까지 순회
		while (i <= end) {
			
			// 현재의 저장 횟수가 저장 상한에 도달한 경우
			if (++count == saveLimit) {
				
				// 해당 저장 횟수에서 저장되는 값을 변수 result에 저장 후 반복문 탈출
				result = sorted[idx];
				break;
			}
			
			// 정렬된 결과를 기존 배열에 저장
			array[i++] = sorted[idx++];
		}
	}
}