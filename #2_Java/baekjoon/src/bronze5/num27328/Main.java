package bronze5.num27328;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 두 정수를 각 변수에 할당
		int numberA = Integer.parseInt(in.readLine());
		int numberB = Integer.parseInt(in.readLine());
		
		// 첫 번째 정수가 더 작은 경우 -1을 출력
		if (numberA < numberB) {
			out.write("-1");
			
		// 첫 번째 정수가 더 큰 경우 1을 출력
		} else if (numberA > numberB) {
			out.write("1");
			
		// 첫 번째 정수와 두 번째 정수가 같은 경우 0을 출력
		} else {
			out.write("0");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}