package bronze2.num12813;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 이진수의 길이를 저장할 상수 LENGTH 초기화
	static final int LENGTH = 100_000;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 메서드를 사용해 입력 받은 두 이진수를 각 변수에 할당
		String binaryStringA = in.readLine();
		String binaryStringB = in.readLine();
		
		// for 반복문을 사용해 A & B의 연산 결과를 출력
		for (int idx = 0; idx < LENGTH; idx++)
			out.write((binaryStringA.charAt(idx) == '1' && binaryStringB.charAt(idx) == '1') ? "1" : "0");
		
		// newLine() 메서드를 사용해 줄바꿈을 출력
		out.newLine();
		
		// for 반복문을 사용해 A | B의 연산 결과를 출력
		for (int idx = 0; idx < LENGTH; idx++)
			out.write((binaryStringA.charAt(idx) == '1' || binaryStringB.charAt(idx) == '1') ? "1" : "0");
		
		// newLine() 메서드를 사용해 줄바꿈을 출력
		out.newLine();
		
		// for 반복문을 사용해 A ^ B의 연산 결과를 출력
		for (int idx = 0; idx < LENGTH; idx++)
			out.write((binaryStringA.charAt(idx) != binaryStringB.charAt(idx)) ? "1" : "0");
		
		// newLine() 메서드를 사용해 줄바꿈을 출력
		out.newLine();
		
		// for 반복문을 사용해 ~A의 연산 결과를 출력
		for (int idx = 0; idx < LENGTH; idx++)
			out.write((binaryStringA.charAt(idx) == '0') ? "1" : "0");
		
		// newLine() 메서드를 사용해 줄바꿈을 출력
		out.newLine();
		
		// for 반복문을 사용해 ~B의 연산 결과를 출력
		for (int idx = 0; idx < LENGTH; idx++)
			out.write((binaryStringB.charAt(idx) == '0') ? "1" : "0");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}