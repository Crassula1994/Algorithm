package bronze3.num05565;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 책의 총 가격을 변수 totalPrice에 할당
		int totalPrice = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 입력 받은 나머지 책 9권의 가격을 차례로 순회
		for (int book = 0; book < 9; book++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 책의 가격을 변수 price에 할당
			int price = Integer.parseInt(in.readLine());
			
			// 총 가격에서 책의 가격을 빼서 남은 가격을 갱신
			totalPrice -= price;
		}
		
		// valueOf() 및 write() 메서드를 사용해 가격을 읽을 수 없는 책의 가격을 출력
		out.write(String.valueOf(totalPrice));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}