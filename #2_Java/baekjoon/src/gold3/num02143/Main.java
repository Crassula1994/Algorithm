package gold3.num02143;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 목표 값을 변수 targetValue에 할당 두 부 배열의 길이를 각 변수에 할당
		int targetValue = Integer.parseInt(in.readLine());
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 부 배열 A의 길이를 변수 lengthA에 할당
		int lengthA = Integer.parseInt(in.readLine());
		
		// StringTokenizer 객체를 불러와 변수 subArrayStrA에 할당
		StringTokenizer subArrayStrA = new StringTokenizer(in.readLine());
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 부 배열 B의 길이를 변수 lengthB에 할당
		int lengthB = Integer.parseInt(in.readLine());
		
		// StringTokenizer 객체를 불러와 변수 subArrayStrB에 할당
		StringTokenizer subArrayStrB = new StringTokenizer(in.readLine());
		
		// 목표 값을 만들 수 있는 모든 부 배열 쌍의 개수를 저장할 변수 count 초기화
		long count = 0;
		
		// 두 배열의 원소 및 부 배열의 합을 저장할 각 배열 초기화
		int[] arrayA = new int[lengthA];
		int[] arrayB = new int[lengthB];
		int[] subArrayA = new int[lengthA * (lengthA + 1) / 2];
		int[] subArrayB = new int[lengthB * (lengthB + 1) / 2];
		
		// for 반복문을 사용해 입력 받은 배열 A의 원소를 배열 arrayA에 저장
		for (int idx = 0; idx < arrayA.length; idx++)
			arrayA[idx] = Integer.parseInt(subArrayStrA.nextToken());
		
		// for 반복문을 사용해 입력 받은 배열 B의 원소를 배열 arrayB에 저장
		for (int idx = 0; idx < arrayB.length; idx++)
			arrayB[idx] = Integer.parseInt(subArrayStrB.nextToken());
		
		// subArrayMaker() 메서드를 호출해 부 배열의 합을 갱신
		subArrayMaker(arrayA, subArrayA);
		subArrayMaker(arrayB, subArrayB);
		
		// sort() 메서드를 사용해 배열 B의 부 배열의 합을 오름차순으로 정렬
		Arrays.sort(subArrayB);
		
		// for 반복문을 사용해 배열 A의 부 배열의 합을 순회
		for (int sumA : subArrayA) {
			
			// 해당 부 배열의 값과 더해 목표 값이 되는 배열 B의 부 배열의 합을 변수 sumB에 할당
			int sumB = targetValue - sumA;
			
			/* lowerBoundFinder(), upperBoundFinder() 메서드를 호출해 배열 B의 부 배열의 합과 일치하는 값의
			시작 위치와 끝 위치를 각 변수에 할당 */
			int startIdx = lowerBoundFinder(sumB, subArrayB);
			int endIdx = upperBoundFinder(sumB, subArrayB);
			
			// 목표 값을 만들 수 있는 모든 부 배열 쌍의 개수를 갱신
			count += endIdx - startIdx;
		}
		
		// valueOf() 및 write() 메서드를 사용해 입력 받은 목표 값을 만들 수 있는 모든 부 배열 쌍의 개수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// subArrayMaker() 메서드 정의
	public static void subArrayMaker(int[] array, int[] subArray) {
		
		// for 반복문을 사용해 부 배열의 시작 원소를 순회
		for (int start = 0, idx = 0; start < array.length; start++) {
			
			// 부 배열의 합을 저장할 변수 sum 초기화
			int sum = 0;
			
			// for 반복문을 사용해 부 배열의 끝 원소를 순회 
			for (int end = start; end < array.length; end++) {
				sum += array[end];
				subArray[idx++] = sum;
			}
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// lowerBoundFinder() 메서드 정의
	public static int lowerBoundFinder(int targetValue, int[] subArray) {
		
		// 찾고자 하는 값의 위치를 찾기 위한 값의 범위를 나타낼 각 변수 초기화
		int start = 0;
		int end = subArray.length;
		
		// while 반복문을 사용해 찾고자 하는 값을 찾을 때까지 순회
		while (start < end) {
			
			// 범위의 중간에 해당하는 위치를 계산해 변수 mid에 할당
			int mid = (start + end) / 2;
			
			// 해당 값이 찾고자 하는 값보다 작은 경우 범위의 시작 위치를 갱신
			if (subArray[mid] < targetValue) {
				start = mid + 1;
				
			// 해당 값이 찾고자 하는 값보다 크거나 같은 경우 범위의 끝 위치를 갱신
			} else {
				end = mid;
			}
		}
		
		// 찾는 값의 시작 위치를 반환
		return end;
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// upperBoundFinder() 메서드 정의
	public static int upperBoundFinder(int targetValue, int[] subArray) {
		
		// 찾고자 하는 값의 위치를 찾기 위한 값의 범위를 나타낼 각 변수 초기화
		int start = 0;
		int end = subArray.length;
		
		// while 반복문을 사용해 찾고자 하는 값을 찾을 때까지 순회
		while (start < end) {
			
			// 범위의 중간에 해당하는 위치를 계산해 변수 mid에 할당
			int mid = (start + end) / 2;
			
			// 해당 값이 찾고자 하는 값보다 작거나 같은 경우 범위의 시작 위치를 갱신
			if (subArray[mid] <= targetValue) {
				start = mid + 1;
				
			// 해당 값이 찾고자 하는 값보다 큰 경우 범위의 끝 위치를 갱신
			} else {
				end = mid;
			}
		}
		
		// 찾는 값의 시작 위치를 반환
		return end;
	}
}