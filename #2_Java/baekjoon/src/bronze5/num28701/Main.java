package bronze5.num28701;

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
		
		// 1부터 해당 정수까지의 합과 그 제곱을 계산해 각 변수에 할당
		int sum = (number + 1) * number / 2;
		int square = sum * sum;
		
		// write() 메서드를 사용해 1부터 해당 정수까지의 합과 그 제곱, 세제곱의 합을 출력
		out.write(sum + "\n" + square + "\n" + square);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}