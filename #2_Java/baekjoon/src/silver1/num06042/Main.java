package silver1.num06042;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 수열 S1, S2의 길이를 각 변수에 할당
		int length1 = Integer.parseInt(st.nextToken());
		int length2 = Integer.parseInt(st.nextToken());
		
		// 가장 긴 공통 부분 수열의 길이를 저장할 변수 maxLength 초기화
		int maxLength = 0;
		
		// 각 수열의 원소를 저장할 각 배열 초기화
		int[] sequence1 = new int[length1];
		int[] sequence2 = new int[length2];
		
		// for 반복문을 사용해 수열 S1의 원소를 배열 sequence1에 저장
		for (int idx = 0; idx < sequence1.length; idx++)
			sequence1[idx] = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 수열 S2의 원소를 배열 sequence2에 저장
		for (int idx = 0; idx < sequence2.length; idx++)
			sequence2[idx] = Integer.parseInt(in.readLine());
		
		// 해당 원소까지 가장 긴 공통 부분 수열의 길이를 저장할 2차원 배열 lcsLength 초기화
		int[][] lcsLength = new int[length1 + 1][length2 + 1];
		
		// for 반복문을 사용해 2차원 배열 lcsLength의 행과 열을 순회
		for (int r = 1; r <= length1; r++) {
			for (int c = 1; c <= length2; c++) {
				
				// 두 수열의 원소가 같은 경우 
				if (sequence1[r - 1] == sequence2[c - 1]) {
					
					// 가장 긴 공통 부분 수열의 길이를 두 수열의 이전 공통 부분 수열의 길이에서 1을 더한 값을 저장
					lcsLength[r][c] = lcsLength[r - 1][c - 1] + 1;
					
					// max() 메서드를 사용해 가장 긴 공통 부분 수열의 길이를 갱신
					maxLength = Math.max(lcsLength[r][c], maxLength);
					
				// 두 수열의 원소가 다른 경우 가장 긴 공통 부분 수열의 길이를 0으로 초기화
				} else {
					lcsLength[r][c] = 0;
				}
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 가장 긴 공통 부분 수열의 길이를 출력
		out.write(String.valueOf(maxLength));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}