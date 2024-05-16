package silver4.num24061;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 실제 수행한 변경 횟수와 정렬 결과를 알고자 하는 변경 횟수를 저장할 각 변수 초기화
	static int count = 0;
	static int targetCnt;
	
	// 배열의 원소와 병합 정렬 결과를 임시로 저장할 각 배열 초기화
	static int[] array;
	static int[] temp;
	
	// 병합 정렬을 수행한 결과를 저장할 StringBuilder 객체 sb 초기화
	static StringBuilder sb = new StringBuilder();
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 배열의 크기와 정렬 결과를 알고자 하는 변경 횟수를 각 변수에 할당
		int size = Integer.parseInt(st.nextToken());
		targetCnt = Integer.parseInt(st.nextToken());
		
		// 배열의 원소와 병합 정렬 결과를 임시로 저장할 각 배열 초기화
		array = new int[size];
		temp = new int[size];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 배열의 원소를 배열 array에 저장
		for (int idx = 0; idx < array.length; idx++)
			array[idx] = Integer.parseInt(st.nextToken());
		
		// mergeSort() 메서드를 호출해 병합 정렬을 수행
		mergeSort(0, size - 1);
		
		// 실제 수행한 변경 횟수가 정렬 결과를 알고자 하는 변경 횟수보다 작은 경우 -1 출력
		if (count < targetCnt) {
			out.write(String.valueOf(-1));
			
		// 실제 수행한 변경 횟수가 정렬 결과를 알고자 하는 변경 횟수보다 크거나 같은 경우 정렬 결과를 출력
		} else {
			out.write(sb.toString());
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// mergeSort() 메서드 정의
	public static void mergeSort(int start, int end) {
		
		// 이미 정렬 결과를 알고자 하는 변경 횟수를 찾은 경우 메서드 종료
		if (count >= targetCnt)
			return;
		
		// 해당 부분 배열을 반으로 나눌 수 있는 경우
		if (start < end) {
		
			// 부분 배열의 중간 값을 계산해 변수 mid에 할당
			int mid = (start + end) / 2;
			
			// mergeSort() 메서드를 재귀 호출해 배열을 둘로 나누어 정렬
			mergeSort(start, mid);
			mergeSort(mid + 1, end);
			
			// merge() 메서드를 호출해 정렬한 결과를 병합
			merge(start, mid, end);
		}
	}
	
	// ----------------------------------------------------------------------------------------------------

	// merge() 메서드 정의
	public static void merge(int start, int mid, int end) {
		
		// 정렬한 원소와 정렬한 결과를 저장할 인덱스를 나타낼 각 변수 초기화
		int left = start;
		int right = mid + 1;
		int index = 0;
		
		// while 반복문을 사용해 왼쪽과 오른쪽 중 더 정렬할 원소가 없을 때까지 순회
		while (left <= mid && right <= end) {
			
			// 왼쪽 부분의 원소가 오른쪽 부분의 원소보다 작거나 같은 경우 왼쪽 원소를 배열 temp에 저장
			if (array[left] <= array[right]) {
				temp[index++] = array[left++];
			
			// 왼쪽 부분의 원소가 오른쪽 부분의 원소보다 큰 경우 오른쪽 원소를 배열 temp에 저장
			} else {
				temp[index++] = array[right++];
			}
		}
		
		// while 반복문을 사용해 왼쪽에 더 정렬할 원소가 때까지 배열 temp에 저장
		while (left <= mid)
			temp[index++] = array[left++];
		
		// while 반복문을 사용해 오른쪽에 더 정렬할 원소가 때까지 배열 temp에 저장
		while (right <= end)
			temp[index++] = array[right++];
		
		// 정렬한 결과를 저장한 인덱스를 초기화
		index = 0;
		
		// for 반복문을 사용해 병합 정렬을 수행한 결과를 순회
		for (int idx = start; idx <= end; idx++) {
			
			// 병합 정렬을 수행한 결과를 반영
			array[idx] = temp[index++];
			
			// 해당 변경 횟수가 결과를 알고자 하는 병합 정렬 횟수인 경우
			if (++count == targetCnt) {
				
				// for 반복문을 사용해 병합 정렬을 수행한 결과를 sb에 저장
				for (int element : array)
					sb.append(element + " ");
				
				// 반복문 탈출
				break;
			}
		}
	}
}