package silver4.num01755;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Number 클래스 정의
	public static class Number implements Comparable<Number> {
		
		// 해당 숫자와 문자 형태를 저장할 각 변수 초기화
		int number;
		String string;
		
		// 매개변수를 입력 받는 생성자 정의
		public Number(int number, String string) {
			this.number = number;
			this.string = string;
		}

		// compareTo() 메서드 정의
		@Override
		public int compareTo(Number anotherNumber) {
			return this.string.compareTo(anotherNumber.string);
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 시작 정수와 끝 정수를 각 변수에 할당
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		// 각 숫자의 읽는 방법을 저장할 배열 numStrings 초기화
		String[] numStrings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		
		// 각 숫자를 문자열 기준으로 정렬할 List 객체 numbers 초기화
		List<Number> numbers = new ArrayList<>();
		
		// for 반복문을 사용해 시작 정수와 끝 정수 사이의 각 숫자를 순회
		for (int number = start; number <= end; number++) {
			
			// 해당 숫자를 숫자 하나씩 읽은 결과를 변수 numString에 할당
			String numString = (number < 10)
					? numStrings[number] : numStrings[number / 10] + " " + numStrings[number % 10];
			
			// add() 메서드를 사용해 해당 정수를 numbers에 저장
			numbers.add(new Number(number, numString));
		}
		
		// sort() 메서드를 사용해 해당 숫자를 문자열 기준으로 사전순 정렬
		Collections.sort(numbers);
		
		// for 반복문을 사용해 정렬된 숫자를 순회
		for (int idx = 0; idx < numbers.size(); idx++) {
			
			// get() 및 write() 메서드를 사용해 해당 숫자를 출력
			out.write(numbers.get(idx).number + " ");
			
			// 10번째 숫자에 해당하는 경우 줄바꿈 출력
			if (idx % 10 == 9)
				out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}