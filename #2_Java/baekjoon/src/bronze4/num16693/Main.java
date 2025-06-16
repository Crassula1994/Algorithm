package bronze4.num16693;

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
		
		// nextToken() 및 parseDouble() 메서드를 사용해 입력 받은 조각 피자의 가격 당 넓이를 변수 valueS에 할당
		double valueS = Double.parseDouble(st.nextToken()) / Double.parseDouble(st.nextToken());
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseDouble() 메서드를 사용해 입력 받은 원형 피자의 넓이와 가격을 각 변수에 할당
		double radiusC = Double.parseDouble(st.nextToken());
		double priceC = Double.parseDouble(st.nextToken());
		
		// write() 메서드를 사용해 조각 피자와 원형 피자 중 어느 것을 사는 것이 나은지 출력
		out.write(((valueS > (radiusC * radiusC * Math.PI) / priceC)) ? "Slice of pizza" : "Whole pizza");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}