package gold1.num01300;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 배열의 크기 및 찾고자 하는 배열의 인덱스를 저장할 각 변수 초기화
	static int size;
	static int targetIdx;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 배열의 크기 및 찾고자 하는 배열의 인덱스를 각 변수에 할당
		size = Integer.parseInt(in.readLine());
		targetIdx = Integer.parseInt(in.readLine());
		
		// indexFinder() 메서드를 호출해 찾고자 하는 인덱스에 위치한 수를 변수 targetNumber에 할당
		long targetNumber = indexFinder();
		
		// valueOf() 및 write() 메서드를 사용해 찾고자 하는 인덱스에 위치한 수를 출력
		out.write(String.valueOf(targetNumber));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// indexFinder() 메서드 정의
	public static long indexFinder() {
		
		// 이분탐색을 위해 필요한 구간의 양끝 값을 저장할 각 변수 초기화
		long start = 1;
		long end = targetIdx + 1;
		
		// while 반복문을 사용해 값을 찾을 때까지 순회
		while (start < end) {
			
			// 이분탐색을 위해 필요한 중간값인 mid 변수 초기화
			long mid = (start + end) / 2;
			
			// 중간값보다 작은 원소의 개수가 찾고자 하는 배열의 인덱스보다 작은 경우 구간의 왼쪽 끝을 갱신
			if (numberCounter(mid) < targetIdx) {
				start = mid + 1;
				
			// 중간값보다 작은 원소의 개수가 찾고자 하는 배열의 인덱스보다 크거나 같은 경우 구간의 오른쪽 끝을 갱신
			} else {
				end = mid;
			}
		}
		
		// 찾고자 하는 인덱스에 위치한 수를 반환
		return start;
	}

	// ----------------------------------------------------------------------------------------------------
	
	// numberCounter() 메서드 정의
	public static long numberCounter(long number) {
		
		// 주어진 숫자보다 작은 원소의 개수를 저장할 변수 count 초기화
		long count = 0;
		
		// for 반복문을 사용해 주어진 숫자보다 작은 원소의 개수를 갱신
		for (int n = 1; n <= size; n++)
			count += Math.min(number / n, size);
		
		// 주어진 숫자보다 작은 원소의 개수를 반환
		return count;
	}
}