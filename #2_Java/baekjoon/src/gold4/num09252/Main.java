package gold4.num09252;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 toCharArray() 메서드를 사용해 입력 받은 문자열을 각 배열에 저장
		char[] string1 = in.readLine().toCharArray();
		char[] string2 = in.readLine().toCharArray();
		
		// 해당 문자열까지 가장 긴 공통 부분 수열의 길이를 저장할 배열 lcsLength 초기화
		int[][] lcsLength = new int[string1.length + 1][string2.length + 1];
		
		// for 반복문을 사용해 배열 lcsLength의 행과 열을 차례로 순회
		for (int r = 1; r <= string1.length; r++) {
			for (int c = 1; c <= string2.length; c++) {
				
				// 해당 행과 열의 문자가 같은 경우 왼쪽 위 대각선 값에서 1을 더한 값을 저장
				if (string1[r - 1] == string2[c - 1]) {
					lcsLength[r][c] = lcsLength[r - 1][c - 1] + 1;
				
				// 해당 행과 열의 문자가 다른 경우 위와 왼쪽의 값 중에서 더 큰 값을 저장
				} else {
					lcsLength[r][c] = Math.max(lcsLength[r - 1][c], lcsLength[r][c - 1]);
				}
			}
		}
		
		// 가장 긴 공통 부분 수열의 길이를 변수 length에 할당
		int length = lcsLength[string1.length][string2.length];
		
		// valueOf() 및 write() 메서드를 사용해 가장 긴 공통 부분 수열의 길이를 출력
		out.write(String.valueOf(length));
		
		// 가장 긴 공통 부분 수열이 0이 아닌 경우
		if (length != 0) {
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
			
			// 가장 긴 공통 부분 수열을 저장할 StringBuilder 객체 sb 초기화
			StringBuilder sb = new StringBuilder();
			
			// 현재 확인 중인 위치를 저장할 각 변수 초기화
			int r = string1.length;
			int c = string2.length;
			
			// while 반복문을 사용해 가장 긴 공통 부분 수열을 찾을 때까지 순회
			while (true) {
				
				// 가장 긴 공통 부분 수열을 모두 찾은 경우 반복문 탈출
				if (lcsLength[r][c] == 0)
					break;
				
				// 위쪽에 인접한 칸의 값이 현재 칸의 값과 동일한 경우 위쪽 칸으로 이동
				if (lcsLength[r][c] == lcsLength[r - 1][c]) {
					r = r - 1;
					continue;
				}
				
				// 왼쪽에 인접한 칸의 값이 현재 칸의 값과 동일한 경우 왼쪽 칸으로 이동
				if (lcsLength[r][c] == lcsLength[r][c - 1]) {
					c = c - 1;
					continue;
				}
				
				// append() 메서드를 사용해 가장 긴 공통 부분 수열에 속하는 문자를 sb에 추가
				sb.append(string1[r - 1]);
				
				// 왼쪽 위 대각선 칸으로 이동
				r = r - 1;
				c = c - 1;
			}
			
			// reverse(), toString(), write() 메서드를 사용해 가장 긴 공통 부분 수열을 출력
			out.write(sb.reverse().toString());
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}