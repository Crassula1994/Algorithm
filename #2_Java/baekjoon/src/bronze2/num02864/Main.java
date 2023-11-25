package bronze2.num02864;

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
		
		// nextToken() 메서드를 사용해 입력 받은 두 숫자를 각 변수에 할당
		String numberA = st.nextToken();
		String numberB = st.nextToken();
		
		// 두 숫자의 최솟값과 최댓값을 저장할 각 변수 초기화
		int minA = 0;
		int minB = 0;
		int maxA = 0;
		int maxB = 0;
		
		// for 반복문을 사용해 정수 A의 각 자릿수를 순회
		for (int idx = 0; idx < numberA.length(); idx++) {
			
			// charAt() 메서드를 사용해 각 자릿수를 변수 cipher에 할당
			int cipher = numberA.charAt(idx) - '0';
			
			// 해당 숫자가 5나 6인 경우 정수 A의 최솟값과 최댓값을 갱신
			if (cipher == 5 || cipher == 6) {
				minA = minA * 10 + 5;
				maxA = maxA * 10 + 6;
				
			// 해당 숫자가 5나 6이 아닌 숫자인 경우 정수 A의 최솟값과 최댓값을 갱신
			} else {
				minA = minA * 10 + cipher;
				maxA = maxA * 10 + cipher;
			}
		}
		
		// for 반복문을 사용해 정수 B의 각 자릿수를 순회
		for (int idx = 0; idx < numberB.length(); idx++) {
			
			// charAt() 메서드를 사용해 각 자릿수를 변수 cipher에 할당
			int cipher = numberB.charAt(idx) - '0';
			
			// 해당 숫자가 5나 6인 경우 정수 B의 최솟값과 최댓값을 갱신
			if (cipher == 5 || cipher == 6) {
				minB = minB * 10 + 5;
				maxB = maxB * 10 + 6;
				
			// 해당 숫자가 5나 6이 아닌 숫자인 경우 정수 B의 최솟값과 최댓값을 갱신
			} else {
				minB = minB * 10 + cipher;
				maxB = maxB * 10 + cipher;
			}
		}
		
		int minSum = minA + minB;
		int maxSum = maxA + maxB;
		
		out.write(minSum + " " + maxSum);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}