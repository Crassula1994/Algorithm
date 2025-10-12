package bronze2.num16561;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 3의 배수를 3으로 나누어 변수 multiplier에 할당
		int multiplier = Integer.parseInt(in.readLine()) / 3;
		
		// 3의 배수를 분해하는 방법의 개수를 저장할 변수 totalCount 초기화
		int totalCount = 0;
		
		// for 반복문을 사용해 3의 배수를 분해하는 방법의 개수를 갱신
		for (int count = 3; count <= multiplier; count++)
			totalCount += count - 2;
		
		// valueOf() 및 write() 메서드를 사용해 3의 배수를 분해하는 방법의 개수를 출력
		out.write(String.valueOf(totalCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}