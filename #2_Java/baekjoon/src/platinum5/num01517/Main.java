package platinum5.num01517;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 수열의 길이, 버블 정렬 시 두 숫자의 위치를 바꾸는 횟수를 저장할 각 변수 초기화
	static int length;
	static long swapCnt = 0;
	
	// 입력 받은 수열, 정렬한 수열을 저장할 각 배열 초기화
	static int[] sequence;
	static int[] sorted;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수열의 길이를 변수 length에 할당
		length = Integer.parseInt(in.readLine());

		// 입력 받은 수열, 정렬한 수열을 저장할 각 배열 초기화
		sequence = new int[length];
		sorted = new int[length];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 수열을 배열 sequence에 저장
		for (int idx = 0; idx < length; idx++)
			sequence[idx] = Integer.parseInt(st.nextToken());
		
		// 병합 정렬을 수행할 mergeSort() 메서드를 호출해 버블 정렬 시 두 숫자의 위치를 바꾸는 횟수를 갱신
		mergeSort(0, length - 1);
		
		// valueOf() 및 write() 메서드를 사용해 버블 정렬 시 두 숫자의 위치를 바꾸는 횟수를 출력
		out.write(String.valueOf(swapCnt));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// mergeSort() 메서드 정의
	public static void mergeSort(int left, int right) {
		
		// 왼쪽 끝 인덱스가 오른쪽 끝 인덱스보다 작은 경우
		if (left < right) {
			
			// 배열의 중간 인덱스를 계산해 변수 mid에 할당
			int mid = (left + right) / 2;
			
			// mergeSort() 메서드를 재귀 호출해 배열을 반으로 나눠 각 부분에 대한 정렬을 수행
			mergeSort(left, mid);
			mergeSort(mid + 1, right);
			
			// merge() 메서드를 호출해 정렬된 두 배열을 합병
			merge(left, mid, right);
		}
	}

	// ----------------------------------------------------------------------------------------------------
	
	// merge() 메서드 정의
	public static void merge(int left, int mid, int right) {
		
		// 배열을 반으로 나눴을 때 각 부분의 인덱스를 나타낼 각 변수 초기화
		int leftIdx = left;
		int rightIdx = mid + 1;
		
		// 배열 sorted의 인덱스를 나타낼 변수 sortedIdx 초기화
		int sortedIdx = left;
		
		// while 반복문을 사용해 왼쪽과 오른쪽 배열 중 하나가 끝에 도달할 때까지 순회
		while (leftIdx <= mid && rightIdx <= right) {
			
			// 왼쪽 배열에 있는 값이 오른쪽 배열에 있는 값보다 작거나 같은 경우
			if (sequence[leftIdx] <= sequence[rightIdx]) {
				
				// 정렬된 배열에 왼쪽 배열의 값을 추가
				sorted[sortedIdx++] = sequence[leftIdx++];
			
			// 왼쪽 배열에 있는 값이 오른쪽 배열에 있는 값보다 큰 경우
			} else {
				
				// 정렬된 배열에 오른쪽 배열의 값을 추가
				sorted[sortedIdx++] = sequence[rightIdx++];
				
				// 버블 정렬 시 두 숫자의 위치를 바꾸는 횟수를 갱신
				swapCnt += mid + 1 - leftIdx;
			}
		}
		
		// 오른쪽 배열의 값이 남아 있는 경우
		if (leftIdx > mid) {
			
			// while 반복문을 사용해 남아 있는 오른쪽 배열의 값을 정렬된 배열에 추가
			while (rightIdx <= right)
				sorted[sortedIdx++] = sequence[rightIdx++];
			
		// 왼쪽 배열의 값이 남아 있는 경우
		} else {
			
			// while 반복문을 사용해 남아 있는 왼쪽 배열의 값을 정렬된 배열에 추가
			while (leftIdx <= mid)
				sorted[sortedIdx++] = sequence[leftIdx++];
		}
		
		// for 반복문을 사용해 정렬된 배열을 기존의 배열에 덮어 씌워 저장
		for (int idx = left; idx <= right; idx++)
			sequence[idx] = sorted[idx];
	}
}