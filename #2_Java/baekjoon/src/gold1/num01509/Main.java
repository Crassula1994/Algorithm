package gold1.num01509;

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
		
		// readLine() 메서드를 사용해 입력 받은 문자열을 변수 string에 할당
		String string = in.readLine();
		
		// length() 메서드를 사용해 문자열의 길이를 변수 length에 할당
		int length = string.length();
		
		// 해당 위치까지 팰린드롬 분할의 최소 개수를 저장할 배열 minCounts 초기화
		int[] minCounts = new int[length + 1];
		
		// 각 문자열의 부분 문자열이 팰린드롬인지 여부를 저장할 2차원 배열 isPalindrome 초기화
		boolean[][] isPalindrome = new boolean[length + 1][length + 1];
		
		// for 반복문을 사용해 각 부분 문자열의 길이를 순회
		for (int len = 1; len <= length; len++) {
			
			// for 반복문을 사용해 부분 문자열의 시작 위치를 순회
			for (int start = 1; start <= length - len + 1; start++) {
				
				// 부분 문자열의 끝 위치를 계산해 변수 end에 할당
				int end = start + len - 1;
				
				// 부분 문자열의 길이가 1인 경우 팰린드롬 여부를 갱신
				if (len == 1) {
					isPalindrome[start][end] = true;
					
				// 부분 문자열의 길이가 2이고, 양 끝 문자가 동일한 경우 팰린드롬 여부를 갱신
				} else if (len == 2 && string.charAt(start - 1) == string.charAt(end - 1)) {
					isPalindrome[start][end] = true;
					
				// 양 끝 문자가 동일하고, 내부 문자열이 팰린드롬인 경우 팰린드롬 여부를 갱신
				} else if (string.charAt(start - 1) == string.charAt(end - 1) && isPalindrome[start + 1][end - 1]) {
					isPalindrome[start][end] = true;
				}
			}
		}
		
		// for 반복문을 사용해 각 위치를 순회
		for (int cur = 1; cur <= length; cur++) {
			
			// 해당 위치까지 팰린드롬 분할의 최소 개수를 초기화
			minCounts[cur] = Integer.MAX_VALUE;
			
			// for 반복문을 사용해 이전의 각 위치를 순회
			for (int prev = 1; prev <= cur; prev++) {
				
				// 이전 위치부터 현재 위치까지의 부분 문자열이 팰린드롬인 경우 해당 위치까지 팰린드롬 분할의 최소 개수를 갱신
				if (isPalindrome[prev][cur])
					minCounts[cur] = Math.min(minCounts[prev - 1] + 1, minCounts[cur]);
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 팰린드롬 분할의 개수 최솟값을 출력
		out.write(String.valueOf(minCounts[length]));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}