package bronze4.num30031;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 지폐의 장수를 변수 banknoteNum에 할당
		int banknoteNum = Integer.parseInt(in.readLine());
		
		// 수민이가 가진 지폐의 총액을 저장할 변수 totalAmount 초기화
		int totalAmount = 0;
		
		// while 반복문을 사용해 각 지폐를 순회
		while (banknoteNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 지폐의 가로 길이를 변수 width에 할당
			int width = Integer.parseInt(st.nextToken());
			
			// switch 조건문을 사용해 수민이가 가진 지폐의 총액을 갱신
			switch (width) {
				case 136:
					totalAmount += 1000;
					break;
				case 142:
					totalAmount += 5000;
					break;
				case 148:
					totalAmount += 10000;
					break;
				default:
					totalAmount += 50000;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 수민이가 가진 지폐의 총액을 출력
		out.write(String.valueOf(totalAmount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}