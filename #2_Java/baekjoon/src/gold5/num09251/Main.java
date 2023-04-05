package gold5.num09251;

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
		
		// for 반복문을 사용해 배열 lcsLength의 행을 차례로 순회
		for (int r = 1; r <= string1.length; r++) {
			
			// for 반복문을 사용해 배열 lcsLength의 열을 차례로 순회
			for (int c = 1; c <= string2.length; c++) {
				
				// 해당 행과 열의 문자가 같은 경우 대각선 값에서 1을 더한 값을 저장
				if (string1[r - 1] == string2[c - 1]) {
					lcsLength[r][c] = lcsLength[r - 1][c - 1] + 1;
				
				// 해당 행과 열의 문자가 다른 경우 위와 아래의 값 중에서 더 큰 값을 저장
				} else {
					lcsLength[r][c] = Math.max(lcsLength[r - 1][c], lcsLength[r][c - 1]);
				}
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 가장 긴 공통 부분 수열의 길이를 출력
		out.write(String.valueOf(lcsLength[string1.length][string2.length])); 

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}