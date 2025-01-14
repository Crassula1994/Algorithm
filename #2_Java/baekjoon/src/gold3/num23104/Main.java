package gold3.num23104;

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
	
	// 종이에 적힌 숫자로 만들 수 있는 비내림차순인 수열의 개수를 나눌 상수 DIVISOR 초기화
	static final int DIVISOR = 1000000007;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 종이의 개수와 해당 종이에 적힌 숫자의 개수를 각 변수에 할당
		int paperNum = Integer.parseInt(st.nextToken());
		int numberCnt = Integer.parseInt(st.nextToken());
		
		// 종이에 적힌 숫자로 만들 수 있는 비내림차순인 수열의 개수를 저장할 변수 totalCount 초기화
		long totalCount = 0;
		
		// 이전 종이의 각 숫자를 선택했을 때 비내림차순인 경우의 수의 누적 합을 저장할 배열 prevCountSum 초기화
		long[] prevCountSum = new long[numberCnt];
		
		// 각 종이에 적힌 숫자, 해당 종이에서 해당 숫자를 선택했을 때 비내림차순인 경우의 수를 저장할 각 2차원 배열 초기화
		int[][] papers = new int[paperNum][numberCnt];
		long[][] counts = new long[paperNum][numberCnt];
		
		// for 반복문을 사용해 각 종이를 순회
		for (int paper = 0; paper < paperNum; paper++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 각 종이에 적힌 숫자를 2차원 배열 papers에 저장
			for (int idx = 0; idx < numberCnt; idx++)
				papers[paper][idx] = Integer.parseInt(st.nextToken());
		}
		
		// fill() 메서드를 사용해 첫 번째 종이의 각 숫자를 선택했을 때 만들 수 있는 비내림차순인 수열의 개수를 초기화
		Arrays.fill(counts[0], 1);
		
		// for 반복문을 사용해 첫 번째 종이의 각 숫자를 선택했을 때 만들 수 있는 비내림차순인 수열의 개수의 누적 합을 배열 prevCountSum에 저장
		for (int idx = 0; idx < prevCountSum.length; idx++)
			prevCountSum[idx] = (idx == 0) ? counts[0][idx] : counts[0][idx] + prevCountSum[idx - 1];
		
		// for 반복문을 사용해 각 종이를 순회
		for (int paper = 1; paper < paperNum; paper++) {
			
			// 해당 종이의 각 숫자를 선택했을 때 만들 수 있는 비내림차순인 수열의 개수의 누적 합을 저장할 배열 curCountSum 초기화
			long[] curCountSum = new long[numberCnt];
			
			// for 반복문을 사용해 각 숫자를 순회
			for (int idx = 0; idx < numberCnt; idx++) {
				
				// 현재 숫자보다 작거나 같은 이전 종이의 숫자의 범위를 나타낼 각 변수 초기화
				int start = 0;
				int end = numberCnt - 1;
				
				// while 반복문을 사용해 현재 숫자보다 작거나 같은 이전 종이의 숫자를 찾을 때까지 순회
				while (start <= end) {
					
					// 범위의 중간을 계산해 변수 mid에 할당
					int mid = (start + end) / 2;
					
					// 해당 위치의 숫자가 현재 숫자보다 작거나 같은 경우 범위의 시작 위치를 갱신
					if (papers[paper - 1][mid] <= papers[paper][idx]) {
						start = mid + 1;
						
					// 해당 위치의 숫자가 현재 숫자보다 큰 경우 범위의 끝 위치를 갱신
					} else {
						end = mid - 1;
					}
				}
				
				// 현재 숫자보다 작은 숫자가 존재하는 경우 현재 숫자를 선택했을 때 비내림차순인 경우의 수를 갱신
				if (end >= 0)
					counts[paper][idx] = prevCountSum[end];
				
				// 해당 종이에서 해당 숫자를 선택했을 때 비내림차순인 경우의 수의 누적 합을 갱신
				curCountSum[idx] = (idx == 0) ? counts[paper][idx] : (counts[paper][idx] + curCountSum[idx - 1]) % DIVISOR;
			}
			
			// 이전 종이의 각 숫자를 선택했을 때 비내림차순인 경우의 수의 누적 합을 갱신
			prevCountSum = curCountSum;
		}
		
		// for 반복문을 사용해 종이에 적힌 숫자로 만들 수 있는 비내림차순인 수열의 개수를 갱신
		for (int idx = 0; idx < numberCnt; idx++)
			totalCount = (totalCount + counts[paperNum - 1][idx]) % DIVISOR;
		
		// valueOf() 및 write() 메서드를 사용해 종이에 적힌 숫자로 만들 수 있는 비내림차순인 수열의 개수를 출력
		out.write(String.valueOf(totalCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}