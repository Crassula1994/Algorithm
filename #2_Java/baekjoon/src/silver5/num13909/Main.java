package silver5.num13909;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 창문의 개수 및 사람의 수를 변수 number에 할당
		int number = Integer.parseInt(in.readLine());
		
		// 열려 있는 창문의 개수를 저장할 변수 windowOpened 초기화
		int windowOpened = 0;
		
		// for 반복문을 사용해 열려 있는 창문의 개수를 순회
		for (int n = 1; n * n <= number; n++)
			windowOpened++;
		
		// valueOf() 및 write() 메서드를 사용해 열려 있는 창문의 개수를 출력
		out.write(String.valueOf(windowOpened));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}