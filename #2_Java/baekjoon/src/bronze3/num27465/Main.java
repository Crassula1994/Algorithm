package bronze3.num27465;

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

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
		int number = Integer.parseInt(in.readLine());
		
		// 숫자가 1인 경우 2로 변경
		if (number == 1)
			number *= 2;

		// 숫자가 5억 초과인 경우 10억으로 값을 고정하고 5억 이하인 경우 2를 곱해 저장
		number = (number > 500000000) ? 1000000000 : number * 2;
   
		// valueOf() 및 write() 메서드를 사용해 소수가 아닌 수 출력
		out.write(String.valueOf(number));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}