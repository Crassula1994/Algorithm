package bronze5.num27219;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 무인도에서 로빈슨 크루소가 보낸 일수를 변수 dayNum에 할당
		int dayNum = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 5일마다 표시한 'V'를 출력
		for (int count = 0; count < dayNum / 5; count++)
			out.write("V");
		
		// for 반복문을 사용해 1일마다 표시한 'I'를 출력
		for (int count = 0; count < dayNum % 5; count++)
			out.write("I");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}