package bronze2.num10093;

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
		
		// nextToken() 및 parseLong() 메서드를 사용해 입력 받은 두 정수를 각 변수에 할당
		long numberA = Long.parseLong(st.nextToken());
		long numberB = Long.parseLong(st.nextToken());
		
		// abs() 및 max() 메서드를 사용해 두 수 사이에 있는 수의 개수를 계산해 변수 count에 할당
		long count = Math.max(Math.abs(numberA - numberB) - 1, 0);
		
		// write() 메서드를 사용해 두 수 사이에 있는 수의 개수를 출력
		out.write(count + "\n");
		
		// for 반복문을 사용해 두 수 사이에 있는 수를 오름차순으로 출력
		for (long n = Math.min(numberA, numberB) + 1; n < Math.max(numberA, numberB); n++)
			out.write(n + " ");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}