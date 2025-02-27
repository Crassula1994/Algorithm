package gold5.num30855;

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
	
	// Fraction 클래스 정의
	static class Fraction {
		
		// 해당 분수의 분자와 분모를 저장할 각 변수 초기화
		long numerator;
		long denominator;
		
		// 매개변수를 입력 받는 생성자 정의
		public Fraction(long numerator, long denominator) {
			this.numerator = numerator;
			this.denominator = denominator;
			reduce();
		}

		// reduce() 메서드 정의
		public void reduce() {
			
			// calculateGCD() 메서드를 호출해 분모와 분자의 최대공약수를 변수 gcd에 할당
			long gcd = calculateGCD(numerator, denominator);
			
			// 분모와 분자를 기약분수 형태로 저장
			numerator /= gcd;
			denominator /= gcd;
		}

		// calculateGCD() 메서드 정의
		public long calculateGCD(long numberA, long numberB) {
			
			// 한 숫자가 다른 숫자로 나누어 떠러지는 경우 나눈 숫자가 최대공약수이므로 이를 반환
			if (numberA % numberB == 0)
				return numberB;
			
			// calculateGCD() 메서드를 재귀호출해 두 숫자의 최대공약수를 반환
			return calculateGCD(numberB, numberA % numberB);
		}
		
		// add() 메서드 정의
		public Fraction add(Fraction anotherFraction) {
			
			// 두 분수를 더한 결과의 분모와 분자를 계산해 각 변수에 저장
			long newNumerator = this.numerator * anotherFraction.denominator
					+ anotherFraction.numerator * this.denominator;
			long newDenominator = this.denominator * anotherFraction.denominator;
			
			// 두 분수를 더한 결과를 반환
			return new Fraction(newNumerator, newDenominator);
		}
		
		// divide() 메서드 정의
		public Fraction divide(Fraction anotherFraction) {
			
			// 두 분수를 나눈 결과의 분모와 분자를 계산해 각 변수에 저장
			long newNumerator = this.numerator * anotherFraction.denominator;
			long newDenominator = this.denominator * anotherFraction.numerator;
			
			// 두 분수를 나눈 결과를 반환
			return new Fraction(newNumerator, newDenominator);
		}
		
		// toString() 메서드 정의
		@Override
		public String toString() {
			
			// 분자와 분모를 빈 칸으로 구분된 문자열로 변환해 반환
			return numerator + " " + denominator;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 기호의 개수를 변수 symbolNum에 할당
		int symbolNum = Integer.parseInt(in.readLine());
		
		// 입력 받은 기호가 5개 미만인 경우 -1을 출력
		if (symbolNum < 5) {
			out.write(String.valueOf(-1));
			
		// 입력 받은 기호가 5개 이상인 경우
		} else {
			
			// 분수의 계산 결과를 저장할 Stack 객체 fractionCalculator 초기화
			Stack<Fraction> fractionCalculator = new Stack<>();
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// while 반복문을 사용해 각 기호를 순회
			while (symbolNum-- > 0) {
				
				// nextToken() 및 charAt() 메서드를 사용해 입력 받은 기호를 변수 symbol에 할당
				char symbol = st.nextToken().charAt(0);
				
				// 해당 기호가 '('인 경우 분자가 0인 분수를 fractionCalculator에 추가
				if (symbol == '(') {
					fractionCalculator.add(new Fraction(0, 1));
					
				// 해당 기호가 ')'인 경우
				} else if (symbol == ')') {
					
					// 네 개 이상의 원소가 존재하지 않는 경우 유효하지 않은 입력이므로 반복문 탈출
					if (fractionCalculator.size() < 4)
						break;
					
					// pop() 메서드를 사용해 각 분수와 괄호를 각 변수에 할당
					Fraction fractionC = fractionCalculator.pop();
					Fraction fractionB = fractionCalculator.pop();
					Fraction fractionA = fractionCalculator.pop();
					Fraction parenthesis = fractionCalculator.pop();
					
					// 각 값이 분수가 아니거나 괄호가 아닌 경우 유효하지 않은 입력이므로 반복문 탈출
					if (fractionA.numerator == 0 || fractionB.numerator == 0
							|| fractionC.numerator == 0 || parenthesis.numerator != 0)
						break;
					
					// divide(), add(), push() 메서드를 사용해 분수식을 계산한 결과를 fractionCalculator에 저장
					fractionCalculator.push(fractionA.add(fractionB.divide(fractionC)));
					
				// 해당 기호가 한 자리 숫자인 경우 해당 숫자를 분수로 변환해 fractionCalculator에 추가
				} else {
					fractionCalculator.add(new Fraction(symbol - '0', 1));
				}
			}
			
			// 입력이 유효하지 않은 경우 -1을 출력
			if (symbolNum > -1 || fractionCalculator.size() != 1) {
				out.write(String.valueOf(-1));
				
			// 입력이 유효한 경우 계산 결과의 분자와 분모를 출력
			} else {
				out.write(fractionCalculator.peek().toString());
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}