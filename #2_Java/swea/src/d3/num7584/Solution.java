package d3.num7584;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Solution 클래스 정의
public class Solution {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// readLine() 및 parseLong() 메서드를 사용해 입력 받은 문자의 위치를 변수 loc에 할당
			long loc = Long.parseLong(in.readLine());
			
			// 문자 위치의 인덱스를 변수 iloc에 할당
			long iloc = loc - 1;
			
			// while 반복문을 사용해 주어진 인덱스의 값을 찾을 때까지 순회
			while (iloc >= 0) {
				
				// 주어진 인덱스가 홀수인 경우 짝수가 될 때까지 인덱스 조정
				if (iloc % 2 != 0) {
					iloc = (iloc - 1) / 2;
					
				// 주어진 인덱스가 4의 배수인 경우 0을 출력 후 반복문 탈출
				} else if (iloc % 4 == 0) {
					out.write("#" + (tc + 1) + " " + 0 + "\n");
					break;
				
				// 주어진 인덱스가 2의 배수인 경우 1을 출력 후 반복문 탈출
				} else {
					out.write("#" + (tc + 1) + " " + 1 + "\n");
					break;
				}
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}