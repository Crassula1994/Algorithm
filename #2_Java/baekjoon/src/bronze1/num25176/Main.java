package bronze1.num25176;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 청정수열에 속한 정수의 상한을 변수 numberLimit에 할당
		int numberLimit = Integer.parseInt(in.readLine());
		
		// 점수가 최소인 청정수열의 개수를 저장할 변수 count 초기화
		int count = 1;
		
		// for 반복문을 사용해 점수가 최소인 청정수열의 개수를 갱신
		for (int number = 2; number <= numberLimit; number++)
			count *= number;
		
		// valueOf() 및 write() 메서드를 사용해 점수가 최소인 청정수열의 개수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}