package silver3.num01515;

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
		
		// readLine() 및 toCharArray() 메서드를 사용해 다솜이가 지우고 남은 숫자를 배열 totalNumber에 저장
		char[] totalNumber = in.readLine().toCharArray();
		
		// 현재 숫자와 다솜이가 지우고 남은 숫자의 현재 인덱스를 저장할 각 변수 초기화
		int number = 0;
		int index = 0;
		
		// while 반복문을 사용해 다솜이가 지우고 남은 숫자의 모든 자릿수를 순회
		outer: while (index < totalNumber.length) {
			
			// valueOf() 및 toCharArray() 메서드를 사용해 현재 숫자의 각 자릿수를 배열 digits에 저장
			char[] digits = String.valueOf(++number).toCharArray();
			
			// for 반복문을 사용해 각 숫자의 자릿수를 순회
			for (char digit : digits) {
				
				// 현재 자릿수와 다솜이가 지우고 남은 숫자의 현재 인덱스에 위치한 자릿수가 일치하는 경우 인덱스를 갱신
				if (digit == totalNumber[index])
					index++;
				
				// 모든 자릿수를 순회한 경우 반복문 탈출
				if (index == totalNumber.length)
					break outer;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 세준이가 적은 마지막 숫자를 출력
		out.write(String.valueOf(number));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}