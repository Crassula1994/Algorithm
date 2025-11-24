package bronze2.num06376;

// 필요한 패키지 불러오기
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedWriter 객체를 불러와 변수 out에 할당
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// write() 메서드를 사용해 e의 근삿값을 n이 0부터 2인 경우까지 출력
		out.write("n e\n- -----------\n0 1\n1 2\n2 2.5\n");
		
		// e의 근삿값, 해당 n에서 더해지는 값의 분모 값을 저장할 각 변수 초기화
		double numberE = 2.5;
		double denominator = 2;
		
		// for 반복문을 사용해 n이 3부터 9인 경우까지 순회
		for (int numberN = 3; numberN < 10; numberN++) {
			
			// 해당 n에서 더해지는 값의 분모 값 및 e의 근삿값을 갱신
			denominator *= numberN;
			numberE += 1.0 / denominator;
			
			// format() 및 write() 메서드를 사용해 해당 n에서의 e의 근삿값을 정해진 형식으로 출력
			out.write(String.format("%d %.9f\n", numberN, numberE));
		}
		
		// close() 메서드를 사용해 BufferedWriter 객체 종료
		out.close();
	}
}