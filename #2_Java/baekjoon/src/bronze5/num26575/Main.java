package bronze5.num26575;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken(), parseDouble() 메서드를 사용해 입력 받은 개의 수, 개마다 먹는 먹이의 무게, 무게당 먹이의 가격을 각 변수에 할당
			double dogNum = Double.parseDouble(st.nextToken());
			double foodQuantity = Double.parseDouble(st.nextToken());
			double foodPrice = Double.parseDouble(st.nextToken());
			
			// format() 및 write() 메서드를 사용해 음식을 사기 위해 필요한 금액을 출력
			out.write(String.format("$%.2f", dogNum * foodQuantity * foodPrice));
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}