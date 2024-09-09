package silver1.num09009;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 데이터의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// 10억 이하의 각 피보나치 수열의 원소를 저장할 배열 fibonacci 초기화
		int[] fibonacci = new int[45];
		
		// 첫 번째 피보나치 수열의 원소를 초기화
		fibonacci[1] = 1;
		
		// for 반복문을 사용해 각 피보나치 수열의 원소를 배열 fibonacci에 저장
		for (int idx = 2; idx < fibonacci.length; idx++)
			fibonacci[idx] = fibonacci[idx - 1] + fibonacci[idx - 2];
		
		// for 반복문을 사용해 각 테스트 데이터를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// 해당 숫자를 구성하는 피보나치 수를 저장할 Stack 객체 elements 초기화
			Stack<Integer> elements = new Stack<>();
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
			int number = Integer.parseInt(in.readLine());
			
			// for 반복문을 사용해 각 피보나치 수를 거꾸로 순회
			for (int idx = fibonacci.length - 1; idx > 1; idx--) {
				
				// 입력 받은 숫자를 구성하는 피보나치 수를 모두 구한 경우 반복문 탈출
				if (number == 0)
					break;
				
				// 남은 숫자가 해당 피보나치 수보다 크거나 같은 경우 elements에 해당 피보나치 수를 추가 후 남은 숫자를 갱신
				if (number >= fibonacci[idx]) {
					elements.push(fibonacci[idx]);
					number -= fibonacci[idx];
				}
			}
			
			// while 반복문을 사용해 각 숫자를 구성하는 피보나치 수를 출력
			while (!elements.isEmpty())
				out.write(elements.pop() + " ");
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}