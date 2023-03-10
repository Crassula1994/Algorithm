package silver3.num01735;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 분수의 분자와 분모를 각 변수에 할당
		int numeratorA = Integer.parseInt(st.nextToken());
		int denominatorA = Integer.parseInt(st.nextToken());
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		 st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 분수의 분자와 분모를 각 변수에 할당
		int numeratorB = Integer.parseInt(st.nextToken());
		int denominatorB = Integer.parseInt(st.nextToken());
		
		// 분수의 합을 계산해 각 변수에 할당
		int numerator = numeratorA * denominatorB + numeratorB * denominatorA;
		int denominator = denominatorA * denominatorB;
		
		// gcdCalculator() 메서드를 호출해 분자와 분모의 최대공약수를 변수 gcd에 할당
		int gcd = gcdCalculator(numerator, denominator);
		
		// write() 메서드를 사용해 기약분수의 분자와 분모를 출력
		out.write((numerator / gcd) + " " + (denominator / gcd));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// gcdCalculator() 메서드 정의
	public static int gcdCalculator(int numA, int numB) {
		
		// 두 숫자가 같은 경우 해당 숫자를 최대공약수로 반환
		if (numA == numB) {
			return numA;
			
		// 두 숫자가 같지 않은 경우
		} else {
			
			// max() 및 min() 메서드를 사용해 두 수 중 큰 수와 작은 수를 각 변수에 할당
			int bigNum = Math.max(numA, numB);
			int smallNum = Math.min(numA, numB);
			
			// 큰 수가 작은 수로 나누어 떨어지는 경우 작은 수를 최대공약수로 반환
			if (bigNum % smallNum == 0) {
				return smallNum;
			
			// 큰 수가 작은 수로 나누어 떨어지지 않는 경우 gcdCalculator() 메서드 재귀 호출
			} else {
				return gcdCalculator(smallNum, bigNum % smallNum);
			}
		}
	}
}