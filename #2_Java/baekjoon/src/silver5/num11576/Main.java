package silver5.num11576;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 진법을 각 변수에 할당
		int baseA = Integer.parseInt(st.nextToken());
		int baseB = Integer.parseInt(st.nextToken());
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 A진법 숫자의 자릿수를 변수 cipherA에 할당
		int cipherA = Integer.parseInt(in.readLine());
		
		// 10진법으로 나타낸 숫자를 저장할 변수 number 초기화
		int number = 0;
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 A진법으로 나타내는 10진법으로 나타낸 숫자를 저장
		for (int exponent = cipherA - 1; exponent >= 0; exponent--)
			number += Integer.parseInt(st.nextToken()) * Math.pow(baseA, exponent);
		
		// B진법으로 나타냈을 때 각 자릿수를 저장할 Stack 객체 cipherB 초기화
		Stack<Integer> cipherB = new Stack<>();
		
		// while 반복문을 사용해 숫자가 0이 될 때까지 순회
		while (number > 0) {
			
			// push() 메서드를 사용해 자릿수를 cipherB에 저장
			cipherB.push(number % baseB);
			
			// 10진법으로 나타낸 숫자를 갱신
			number /= baseB;
		}
		
		// while 반복문을 사용해 B진법으로 나타낸 각 자릿수를 출력
		while (!cipherB.isEmpty())
			out.write(cipherB.pop() + " ");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}