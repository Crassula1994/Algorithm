package gold5.num26524;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 간선들에 방향을 정해주는 방법의 수를 나눌 제수를 저장할 상수 DIVISOR 초기화
	static final int DIVISOR = 1000000007;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 점의 개수를 변수 pointNum에 할당
		int pointNum = Integer.parseInt(in.readLine());
		
		// 조건을 만족하는 방법의 수를 저장할 변수 count 초기화
		long count = 1;
		
		// for 반복문을 사용해 조건을 만족하는 방법의 개수를 갱신
		for (int n = 2; n <= pointNum; n++)
			count = (count * n) % DIVISOR;
		
		// valueOf() 및 write() 메서드를 사용해 조건을 만족하는 방법의 수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}