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
		
		// extremeValueMaker() 메서드를 호출해 두 숫자의 최솟값과 최댓값을 각 배열에 할당
		int[] extremeA = extremeValueMaker(numberA);
		int[] extremeB = extremeValueMaker(numberB);
		
		// 두 수의 합 중 최솟값과 최댓값을 계산해 각 변수에 할당
		int minSum = extremeA[0] + extremeB[0];
		int maxSum = extremeA[1] + extremeB[1];
		
		// write() 메서드를 사용해 두 수의 합 중 최솟값과 최댓값을 출력
		out.write(minSum + " " + maxSum);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// extremeValueMaker() 메서드 정의
	private static int[] extremeValueMaker(String numberStr) {
		
		// 최솟값과 최댓값을 저장할 배열 extremeVal 초기화
		int[] extremeVal = new int[2];
		
		// for 반복문을 사용해 정수의 각 자릿수를 순회
		for (int idx = 0; idx < numberStr.length(); idx++) {
			
			// charAt() 메서드를 사용해 각 자릿수를 변수 cipher에 할당
			int cipher = numberStr.charAt(idx) - '0';
			
			// 해당 숫자가 5나 6인 경우 정수의 최솟값과 최댓값을 갱신
			if (cipher == 5 || cipher == 6) {
				extremeVal[0] = extremeVal[0] * 10 + 5;
				extremeVal[1] = extremeVal[1] * 10 + 6;
				
			// 해당 숫자가 5나 6이 아닌 숫자인 경우 정수 A의 최솟값과 최댓값을 갱신
			} else {
				extremeVal[0] = extremeVal[0] * 10 + cipher;
				extremeVal[1] = extremeVal[1] * 10 + cipher;
			}
		}
		
		// 최솟값과 최댓값을 저장한 배열 반환
		return extremeVal;
	}
}