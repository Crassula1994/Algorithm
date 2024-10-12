package gold3.num32179;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 가능한 배열의 개수를 나눌 제수를 저장할 상수 DIVISOR 초기화
	static final int DIVISOR = 1000000007;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 배열의 크기 및 이분탐색의 흔적의 크기를 각 변수에 할당
		int arraySize = Integer.parseInt(st.nextToken());
		int traceSize = Integer.parseInt(st.nextToken()) - 1;
		
		// 이분탐색의 흔적을 저장하기 위해 필요한 탐색의 범위와 흔적을 저장할 위치, 가능한 배열의 개수를 나타낼 각 변수 초기화
		int start = 0;
		int end = arraySize - 1;
		int mid = (start + end) / 2;
		long totalCount = 1;
		
		// 이분탐색의 흔적을 저장할 배열 traces 초기화
		int[] traces = new int[arraySize + 1];
		
		// 주어진 배열의 크기에 넣어야 하는 숫자의 개수에 따른 방법의 수를 저장할 2차원 배열 counts 초기화
		long[][] counts = new long[101][101];
		
		// for 반복문을 사용해 각 배열의 크기를 순회
		for (int size = 0; size <= 100; size++) {
			
			// 0개의 숫자를 넣어야 하는 경우 그 방법의 수를 초기화
			counts[size][0] = 1;
			
			// for 반복문을 사용해 넣어야 하는 각 숫자의 개수에 따른 방법의 수 갱신
			for (int numCnt = 1; numCnt <= size; numCnt++)
				counts[size][numCnt] = (counts[size - 1][numCnt - 1] + counts[size - 1][numCnt]) % DIVISOR;
		}
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 이분탐색 흔적의 첫 원소를 배열 traces에 저장
		traces[mid] = Integer.parseInt(st.nextToken());
		
		// while 반복문을 사용해 각 이분탐색의 흔적을 순회
		while (traceSize-- > 0) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 이분탐색의 흔적의 숫자를 변수 traceNumber에 할당
			int traceNumber = Integer.parseInt(st.nextToken());
			
			// 입력 받은 이분탐색의 흔적의 숫자가 이전 숫자보다 큰 경우 범위의 시작 부분을 갱신
			if (traceNumber > traces[mid]) {
				start = mid + 1;
				
			// 입력 받은 이분탐색의 흔적의 숫자가 이전 숫자보다 작은 경우 범위의 끝 부분을 갱신
			} else {
				end = mid - 1;
			}
			
			// 현재 이분탐색의 흔적의 숫자를 저장할 위치를 다시 계산해 변수 mid에 재할당
			mid = (start + end) / 2;
			
			// 현재 이분탐색의 흔적의 숫자를 배열 traces에 저장
			traces[mid] = traceNumber;
		}
		
		// 이분탐색의 흔적을 저장할 배열의 마지막 값을 101로 초기화
		traces[arraySize] = 101;
		
		// for 반복문을 사용해 이분탐색 흔적이 저장된 배열을 순회
		for (int idx = 0, count = 0, minValue = 1; idx < traces.length; idx++) {
			
			// 해당 위치에 배열이 비어 있는 경우 빈 칸의 개수를 갱신
			if (traces[idx] == 0) {
				count++;
				
			// 해당 위치에 배열이 비어 있지 않은 경우
			} else {

				// 가능한 배열의 개수를 갱신
				totalCount *= counts[traces[idx] - minValue][count];
				totalCount %= DIVISOR;
				
				// 빈 칸에 넣을 수 있는 최소의 값 갱신 및 빈 칸의 개수 초기화
				minValue = traces[idx] + 1;
				count = 0;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 가능한 배열의 개수를 출력
		out.write(String.valueOf(totalCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}