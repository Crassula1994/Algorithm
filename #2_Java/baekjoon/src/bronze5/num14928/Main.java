package bronze5.num14928;

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
		
		// readLine() 메서드를 사용해 입력 받은 가장 좋아하는 수를 변수 number에 할당
		String number = in.readLine();
		
		// 가장 좋아하는 수를 20000303으로 나눈 나머지를 저장할 변수 remainder 초기화
		int remainder = 0;
		
		// for 반복문을 사용해 가장 좋아하는 수를 20000303으로 나눈 나머지를 갱신
		for (int idx = 0; idx < number.length(); idx++)
			remainder = (remainder * 10 + (number.charAt(idx) - '0')) % 20000303;
		
		// valueOf() 및 write() 메서드를 사용해 가장 좋아하는 수를 20000303으로 나눈 나머지를 출력
		out.write(String.valueOf(remainder));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}