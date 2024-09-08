package gold4.num17236;

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
		
		// readLine() 및 parseDouble() 메서드를 사용해 입력 받은 각 삼각형의 높이를 각 변수에 할당
		double heightA = Double.parseDouble(in.readLine());
		double heightB = Double.parseDouble(in.readLine());
		double heightC = Double.parseDouble(in.readLine());
		
		// 삼각형의 반둘레의 길이를 삼각형의 면적으로 나눈 값을 계산해 변수 semiperimeter에 할당
		double semiperimeter = 1 / heightA + 1 / heightB + 1 / heightC;
		
		// sqrt() 메서드를 사용해 삼각형의 면적을 계산해 변수 area에 할당
		double area = 1 / Math.sqrt(semiperimeter * (semiperimeter - 2 * (1 / heightA))
				* (semiperimeter - 2 * (1 / heightB)) * (semiperimeter - 2 * (1 / heightC)));

        // format() 및 write() 메서드를 사용해 삼각형의 넓이를 출력
        out.write(String.format("%.7f", area));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}