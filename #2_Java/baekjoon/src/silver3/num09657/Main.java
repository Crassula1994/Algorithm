package silver3.num09657;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 돌의 개수를 변수 stoneNum에 할당
		int stoneNum = Integer.parseInt(in.readLine());
		
		// 돌의 개수가 7로 나누었을 때 나누어 떨어지거나 2가 남는 경우 창영이가 이기게 되므로 'CY'를 출력
		if (stoneNum % 7 == 0 || stoneNum % 7 == 2) {
			out.write("CY");
			
		// 돌의 개수가 7로 나누었을 때 1, 3, 4, 5, 6이 나오는 경우 상근이가 이기게 되므로 'SK'를 출력
		} else {
			out.write("SK");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}