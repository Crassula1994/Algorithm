package bronze3.num01598;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {

	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 두 자연수를 각 변수에 할당
		int number1 = Integer.parseInt(st.nextToken());
		int number2 = Integer.parseInt(st.nextToken());
		
		// 각 자연수의 위치를 계산해 각 변수에 할당
		int r1 = (number1 % 4 == 0) ? 4 : number1 % 4;
		int c1 = (number1 % 4 == 0) ? number1 / 4 : number1 / 4 + 1;
		int r2 = (number2 % 4 == 0) ? 4 : number2 % 4;
		int c2 = (number2 % 4 == 0) ? number2 / 4 : number2 / 4 + 1;
		
		// abs() 메서드를 사용해 두 자연수 사이의 직각 거리를 계산하고, 변수 distance에 할당
		int distance = Math.abs(r1 - r2) + Math.abs(c1 - c2);

		// valueOf() 및 write() 메서드를 사용해 두 자연수 사이의 직각 거리를 출력
		out.write(String.valueOf(distance));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}