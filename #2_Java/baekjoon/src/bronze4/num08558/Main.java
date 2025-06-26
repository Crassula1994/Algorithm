package bronze4.num08558;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 팩토리얼의 순서를 변수 targetOrder에 할당
		int targetOrder = Integer.parseInt(in.readLine());
		
		// 4 이하 팩토리얼의 일의 자리를 저장할 배열 units 초기화
		int[] units = {1, 1, 2, 6, 4};
		
		// valueOf() 및 write() 메서드를 사용해 입력 받은 순서에 해당하는 팩토리얼의 일의 자리 숫자를 출력
		out.write((targetOrder > 4) ? "0" : String.valueOf(units[targetOrder]));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}