package silver4.num02870;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 종이의 줄 개수를 변수 lineCount에 할당
		int lineCount = Integer.parseInt(in.readLine());
		
		// 각 줄에서 찾은 숫자를 저장할 List 객체 numbers 초기화
		List<BigInteger> numbers = new ArrayList<>();
		
		// for 반복문을 사용해 각 줄을 순회
		for (int line = 0; line < lineCount; line++) {
			
			// readLine() 메서드를 사용해 입력 받은 해당 줄을 배열 numStrings에 할당
			String[] numStrings = in.readLine().split("\\D+");
			
			// for 반복문을 사용해 배열 numStrings의 각 원소를 순회
			for (int idx = 0; idx < numStrings.length; idx++) {
				
				// 해당 원소가 빈 문자열인 경우 다음 원소를 순회
				if (numStrings[idx].isEmpty())
					continue;
				
				// add() 메서드를 사용해 해당 숫자를 numbers에 저장
				numbers.add(new BigInteger(numStrings[idx]));
			}
		}
		
		// sort() 메서드를 사용해 각 숫자를 오름차순으로 정렬
		Collections.sort(numbers);
		
		// for 반복문을 사용해 각 숫자를 오름차순으로 정렬한 결과를 출력
		for (BigInteger number : numbers)
			out.write(number.toString() + "\n");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}