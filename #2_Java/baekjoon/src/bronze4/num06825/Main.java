package bronze4.num06825;

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

		// readLine() 및 parseDouble() 메서드를 사용해 입력 받은 환자의 몸무게와 키를 각 변수에 할당
		double weight = Double.parseDouble(in.readLine());
		double height = Double.parseDouble(in.readLine());
		
		// 계산한 체질량 지수를 변수 index에 할당
		double index = weight / (height * height);
		
		// 체질량 지수가 25 초과인 경우 'Overweight'을 출력
		if (index > 25) {
			out.write("Overweight");
			
		// 체질량 지수가 18.5 미만인 경우 'Underweight'을 출력
		} else if (index < 18.5) {
			out.write("Underweight");
			
		// 체질량 지수가 18.5 이상 25 이하인 경우 'Normal weight'를 출력
		} else {
			out.write("Normal weight");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}