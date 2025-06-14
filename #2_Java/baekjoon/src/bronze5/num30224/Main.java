package bronze5.num30224;

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
		
		// readLine() 메서드를 사용해 입력 받은 숫자를 변수 numberString에 할당
		String numberString = in.readLine();
		
		// 해당 숫자에 7이 포함되어 있는지, 7로 나누어지는지 여부를 저장할 각 변수 초기화
		boolean isContained = false;
		boolean isDivisible = Integer.parseInt(numberString) % 7 == 0;
		
		// for 반복문을 사용해 해당 숫자의 각 자릿수를 순회
		for (int idx = 0; idx < numberString.length(); idx++) {
			
			// 이미 7이 포함되어 있는 경우 반복문 탈출
			if (isContained)
				break;
			
			// 해당 자릿수가 7인 경우 해당 숫자에 7이 포함되어 있는지 여부를 갱신
			if (numberString.charAt(idx) == '7')
				isContained = true;
		}
		
		// 숫자에 7이 포함되지 않고 7로 나눌 수 없는 경우 '0'을 출력
		if (!isContained && !isDivisible) {
			out.write("0");
			
		// 숫자에 7이 포함되지 않고 7로 나눌 수 있는 경우 '1'을 출력
		} else if (!isContained && isDivisible) {
			out.write("1");
			
		// 숫자에 7이 포함되어 있고 7로 나눌 수 없는 경우 '2'를 출력
		} else if (isContained && !isDivisible) {
			out.write("2");
			
		// 숫자에 7이 포함되어 있고 7로 나눌 수 있는 경우 '3'을 출력
		} else {
			out.write("3");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}