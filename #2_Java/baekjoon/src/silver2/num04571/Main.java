package silver2.num04571;

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
		
		// 데이터 세트의 번호를 저장할 변수 dataSet 초기화
		int dataSet = 1;
		
		// while 반복문을 사용해 각 데이터 세트를 순회
		while (true) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseLong() 메서드를 사용해 입력 받은 두 양의 정수를 각 변수에 할당
			long numberA = Long.parseLong(st.nextToken());
			long numberB = Long.parseLong(st.nextToken());
			
			// 모든 데이터 세트를 확인한 경우 반복문 탈출
			if (numberA == 0 && numberB == 0)
				break;
			
			// valueOf() 및 length() 메서드를 사용해 두 양의 정수의 곱셈의 결과와 출력해야 할 길이를 각 변수에 할당 
			long result = numberA * numberB;
			int length = String.valueOf(result).length();
			
			// replace() 메서드를 사용해 곱셈의 결과 사이에 출력할 대시 줄을 변수 dashLine에 할당
			String dashLine = new String(new char[length]).replace('\u0000', '-') + "\n";
			
			// digitFinder() 메서드를 호출해 두 번째 양의 정수의 각 자릿수를 배열 digitsB에 저장
			int[] digitsB = digitFinder(numberB);
			
			// digitChecker() 메서드를 호출해 해당 자릿수에 존재하는 0이 아닌 자릿수의 개수를 변수 nonZeroCnt에 할당
			int nonZeroCnt = digitChecker(digitsB);
			
			// write() 메서드를 사용해 문제 번호를 출력
			out.write("Problem " + dataSet++ + "\n");
			
			// format() 및 write() 메서드를 사용해 두 양의 정수를 출력
			out.write(String.format("%" + length + "d\n", numberA));
			out.write(String.format("%" + length + "d\n", numberB));
			
			// write() 메서드를 사용해 대시 줄을 출력
			out.write(dashLine);
			
			// 0이 아닌 자릿수가 2개 이상인 경우
			if (nonZeroCnt > 1) {
				
				// for 반복문을 사용해 각 자릿수를 순회
				for (int idx = 0, zeroCnt = 0; idx < digitsB.length; idx++) {
					
					// 해당 자릿수가 0인 경우 0인 자릿수의 개수를 갱신 후 다음 자릿수를 순회
					if (digitsB[idx] == 0) {
						zeroCnt++;
						continue;
					}	
					
					// format() 및 write() 메서드를 사용해 해당 자릿수의 곱셈 결과를 출력
					out.write(String.format("%" + (length - idx) + "d", numberA * digitsB[idx]));
					
					// for 반복문을 사용해 0의 자릿수의 개수만큼 0을 출력
					for (int count = 0; count < zeroCnt; count++)
						out.write("0");
					
					// newLine() 메서드를 사용해 줄바꿈을 출력
					out.newLine();
					
					// 0인 자릿수의 개수를 초기화
					zeroCnt = 0;
				}
				
				// write() 메서드를 사용해 대시 줄을 출력
				out.write(dashLine);
			}
			
			// write() 메서드를 사용해 두 양의 정수의 곱셈의 결과를 출력
			out.write(result + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// digitFinder() 메서드 정의
	public static int[] digitFinder(long number) {
		
		// valueOf() 및 length() 메서드를 사용해 해당 숫자의 자릿수를 저장할 배열 digits 초기화
		int[] digits = new int[String.valueOf(number).length()];
		
		// for 반복문을 사용해 해당 숫자의 자릿수를 배열 digits에 저장
		for (int idx = 0; idx < digits.length; idx++) {
			digits[idx] = (int) (number % 10);
			number /= 10;
		}
		
		// 해당 숫자의 자릿수를 저장한 배열을 반환
		return digits;
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// digitChecker() 메서드 정의
	public static int digitChecker(int[] digits) {
		
		// 0이 아닌 자릿수의 개수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 각 자릿수를 순회
		for (int digit : digits) {
			
			// 해당 자릿수가 0이 아닌 경우 0이 아닌 자릿수의 개수를 갱신
			if (digit != 0)
				count++;
		}
		
		// 0이 아닌 자릿수의 개수를 반환
		return count;
	}
}