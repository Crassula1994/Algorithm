package silver2.num2004;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 정수를 각 변수에 할당
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		// 2의 개수 및 5의 개수를 셀 각 변수 초기화
		int countTwo = 0;
		int countFive = 0;
		
		// 검사할 숫자를 담은 배열 checkArr 초기화
		int[] checkArr = {n, m, n - m};
		
		// for 반복문을 사용해 배열 checkArr의 각 원소를 순회
		for (int idx = 0; idx < checkArr.length; idx++) {
		
			// 검사할 숫자를 변수 number에 할당
			int number = checkArr[idx];
			
			// while 반복문을 사용해 n이 5로 나누어 떨어지는 횟수를 계산해 countFive 갱신
			while (number >= 5) {
				countFive = (idx == 0) ? countFive + number / 5 : countFive - number / 5;
				number /= 5;
			}
		}
		
		// for 반복문을 사용해 배열 checkArr의 각 원소를 순회
		for (int idx = 0; idx < checkArr.length; idx++) {
		
			// 검사할 숫자를 변수 number에 할당
			int number = checkArr[idx];
			
			// while 반복문을 사용해 n이 2로 나누어 떨어지는 횟수를 계산해 countTwo 갱신
			while (number >= 2) {
				countTwo = (idx == 0) ? countTwo + number / 2 : countTwo - number / 2;
				number /= 2;
			}
		}
		
		// min(), valueOf(), write() 메서드를 사용해 0의 개수를 출력
		out.write(String.valueOf(Math.min(countTwo, countFive)));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}