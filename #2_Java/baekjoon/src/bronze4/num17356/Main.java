package bronze4.num17356;

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
		
		// nextToken() 및 parseDouble() 메서드를 사용해 입력 받은 욱과 제의 욱제력을 각 변수에 할당
		double forceA = Double.parseDouble(st.nextToken());
		double forceB = Double.parseDouble(st.nextToken());
		
		// pow() 메서드를 사용해 욱이 제를 이길 확률을 계산하고 변수 odds에 할당
		double odds = 1 / (1 + Math.pow(10, (forceB - forceA) / 400));
		
		// valueOf() 및 write() 메서드를 사용해 욱이 제를 이길 확률을 출력
		out.write(String.valueOf(odds));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}