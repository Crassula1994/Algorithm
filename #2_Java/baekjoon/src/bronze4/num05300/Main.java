package bronze4.num05300;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 보트에 보낼 해적의 수를 변수 pirateNum에 할당
		int pirateNum = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 해적의 번호를 순회
		for (int number = 1; number <= pirateNum; number++) {
			
			// write() 메서드를 사용해 해적의 번호를 출력
			out.write(number + " ");
			
			// 6번째 해적이거나 마지막 해적인 경우 'Go!'를 출력
			if (number % 6 == 0 || number == pirateNum)
				out.write("Go! ");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}