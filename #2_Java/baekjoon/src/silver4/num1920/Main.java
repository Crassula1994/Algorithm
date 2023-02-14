package silver4.num1920;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자의 개수를 변수 inLength에 할당
		int inLength = Integer.parseInt(in.readLine());
		
		// 입력 받은 정수들을 저장할 배열 numbers 초기화
		int[] numbers = new int[inLength];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 배열 numbers의 각 원소를 순회
		for (int idx = 0; idx < numbers.length; idx++)
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 배열 numbers에 저장
			numbers[idx] = Integer.parseInt(st.nextToken());
		
		// sort() 메서드를 사용해 배열 numbers를 오름차순으로 정렬
		Arrays.sort(numbers);
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자의 개수를 변수 outLength에 할당
		int outLength = Integer.parseInt(in.readLine());
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 숫자를 순회
		outer: for (int i = 0; i < outLength; i++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 targetNum에 할당
			int targetNum = Integer.parseInt(st.nextToken());
			
			// 이분탐색 시 시작 인덱스, 끝 인덱스를 나타내는 각 변수 초기화
			int start = 0;
			int end = inLength - 1;
			
			// while 반복문을 사용해 주어진 값을 탐색
			while (start <= end) {
				
				// 중간 인덱스를 갱신
				int mid = (start + end) / 2;
				
				// 중간 인덱스의 값이 주어진 값과 같은 경우 1 출력 후 반복문 다음으로 넘기기
				if (numbers[mid] == targetNum) {
					out.write(1 + "\n");
					continue outer;
				
				// 중간 인덱스의 값이 주어진 값보다 큰 경우 끝 인덱스를 갱신
				} else if (numbers[mid] > targetNum) {
					end = mid - 1;
					
				// 중간 인덱스의 값이 주어진 값보다 작은 경우 시작 인덱스를 갱신
				} else {
					start = mid + 1;
				}
			}
			
			// write() 메서드를 사용해 아무런 값을 찾지 못한 경우 0 출력
			out.write(0 + "\n");
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}