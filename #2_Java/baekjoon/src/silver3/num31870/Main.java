package silver3.num31870;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 주어진 배열의 원소를 저장할 배열 array 초기화
	static int[] array;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 원소의 개수를 변수 elementNum에 할당
		int elementNum = Integer.parseInt(in.readLine());
		
		// 주어진 배열의 원소를 저장할 배열 array 초기화
		array = new int[elementNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 주어진 배열의 원소를 배열 array에 저장
		for (int idx = 0; idx < array.length; idx++)
			array[idx] = Integer.parseInt(st.nextToken());

		// arraySorter() 메서드를 호출해 배열을 뒤집거나 뒤집지 않고 버블 정렬했을 때의 횟수를 계산하고 각 변수에 할당
		int count = arraySorter(false);
		int reversedCount = 1 + arraySorter(true);
		
		// min(), valueOf(), write() 메서드를 사용해 배열 A를 오름차순으로 만드는데 필요한 최소 횟수를 출력
		out.write(String.valueOf(Math.min(count, reversedCount)));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// arraySorter() 메서드 정의
	public static int arraySorter(boolean reversed) {
		
		// 원소를 교환한 횟수를 저장할 변수 count 초기화
		int count = 0;
		
		// clone() 메서드를 사용해 정렬할 배열을 배열 sortedArray에 할당
		int[] sortedArray = array.clone();
		
		// 해당 원소를 뒤집은 경우
		if (reversed) {
			
			// for 반복문을 사용해 해당 배열을 뒤집기
			for (int idx = 0; idx < sortedArray.length / 2; idx++) {
				int temp = sortedArray[idx];
				sortedArray[idx] = sortedArray[sortedArray.length - idx - 1];
				sortedArray[sortedArray.length - idx - 1] = temp;
			}
		}
		
		// for 반복문을 사용해 배열의 원소를 순회
		for (int i = 0; i < sortedArray.length - 1; i++) {
			
			// for 반복문을 사용해 해당 원소의 이전에 위치한 정렬된 원소를 순회
			for (int j = 0; j < sortedArray.length - i - 1; j++) {
			
				// 해당 원소가 앞의 원소보다 큰 경우
				if (sortedArray[j] > sortedArray[j + 1]) {
					
					// 두 원소의 자리를 교환
					int temp = sortedArray[j];
					sortedArray[j] = sortedArray[j + 1];
					sortedArray[j + 1] = temp;
					
					// 원소를 교환한 횟수를 갱신
					count++;
				}
			}
		}
		
		// 원소를 교환한 횟수를 반환
		return count;
	}
}