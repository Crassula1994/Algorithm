package silver5.num12871;

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
		
		// readLine() 메서드를 사용해 입력 받은 각 문자열을 각 변수에 할당
		String stringS = in.readLine();
		String stringT = in.readLine();
		
		// length() 및 gcdCalculator() 메서드를 사용해 두 문자열의 길이의 최대공약수 및 최소공배수를 각 변수에 할당
		int gcd = gcdCalculator(stringS.length(), stringT.length());
		int lcm = (stringS.length() / gcd) * (stringT.length() / gcd) * gcd;
		
		// 각 문자열의 길이가 같아질 때까지 반복한 문자열을 저장할 각 StringBuilder 객체 초기화
		StringBuilder repeatedStringS = new StringBuilder();
		StringBuilder repeatedStringT = new StringBuilder();
		
		// for 반복문을 사용해 문자열 S의 반복 문자열을 갱신
		for (int count = 0; count < lcm / stringS.length(); count++)
			repeatedStringS.append(stringS);
		
		// for 반복문을 사용해 문자열 T의 반복 문자열을 갱신
		for (int count = 0; count < lcm / stringT.length(); count++)
			repeatedStringT.append(stringT);
		
		// toString(), equals(), write() 메서드를 사용해 두 반복 문자열이 같아질 수 있는지 여부를 출력
		out.write((repeatedStringS.toString().equals(repeatedStringT.toString())) ? "1" : "0");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// gcdCalculator() 메서드 정의
	public static int gcdCalculator(int numberA, int numberB) {
		
		// 주어진 숫자가 나누어 떨어지는 경우 나눈 숫자가 최대공약수이므로 이를 반환
		if (numberA % numberB == 0)
			return numberB;
		
		// gcdCalculator() 메서드를 재귀 호출해 최대공약수를 반환
		return gcdCalculator(numberB, numberA % numberB);
	}
}