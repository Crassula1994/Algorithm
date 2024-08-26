package bronze5.num21598;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 절을 할 횟수를 변수 bowCount에 할당
		int bowCount = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 입력 받은 절을 할 횟수만큼 'SciComLove'를 출력
		for (int count = 0; count < bowCount; count++)
			out.write("SciComLove\n");
			
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}