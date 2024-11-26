package bronze4.num32710;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
		int number = Integer.parseInt(in.readLine());
			
		// 해당 숫자가 구구단에서 등장하는지 여부를 나타내는 변수 hasNumber 초기화
		boolean hasNumber = false;
		
		// for 반복문을 사용해 각 구구단을 순회
		outer: for (int times = 2; times < 10; times++) {
			
			// for 반복문을 사용해 각 구구단의 숫자를 순회
			for (int multiplier = 1; multiplier < 10; multiplier++) {
				
				// 해당 숫자가 등장하는 경우 해당 숫자가 구구단에서 등장하는지 여부를 갱신 후 반복문 탈출
				if (number == times || number == multiplier || number == times * multiplier) {
					hasNumber = true;
					break outer;
				}
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 주어진 수가 구구단표에서 등장하는지 여부를 갱신
		out.write((hasNumber) ? String.valueOf(1) : String.valueOf(0));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}