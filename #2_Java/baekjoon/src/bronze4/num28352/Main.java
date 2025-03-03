package bronze4.num28352;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 정수를 변수 number에 할당
		int number = Integer.parseInt(in.readLine());
		
		// 팩토리얼을 계산한 결과를 저장할 변수 result 초기화
		long result = 1;
		
		// while 반복문을 사용해 팩토리얼을 계산한 결과를 갱신
		while (number > 1)
			result *= number--;
		
		// write() 및 valueOf() 메서드를 사용해 해당 초와 동일한 주를 출력
		out.write(String.valueOf(result / 604800));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}