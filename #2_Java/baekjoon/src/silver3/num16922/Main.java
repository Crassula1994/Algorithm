package silver3.num16922;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 사용할 수 있는 문자의 개수를 변수 letterNum에 할당
		int letterNum = Integer.parseInt(in.readLine());
		
		// 로마 숫자를 사용해 만들 수 있는 서로 다른 수의 개수를 저장할 변수 count 초기화
		int count = 0;
		
		// 각 숫자를 만들 수 있는지 여부를 저장할 배열 made 초기화
		boolean[] made = new boolean[50 * letterNum + 1];
		
		// for 반복문을 사용해 만들 수 있는 각 문자의 조합을 순회
		for (int i = 0; i <= letterNum; i++) {
			for (int v = 0; v <= letterNum - i; v++) {
				for (int x = 0; x <= letterNum - i - v; x++) {
						
					// 만들 수 있는 숫자를 계산해 변수 number에 할당
					int number = i * 1 + v * 5 + x * 10 + (letterNum - i - v - x) * 50;
					
					// 해당 숫자를 이미 만들 수 있는 숫자로 센 경우 다음 숫자를 순회
					if (made[number])
						continue;
					
					// 해당 숫자를 만들 수 있는지 여부 및 만들 수 있는 서로 다른 수의 개수를 갱신
					made[number] = true;
					count++;
				}
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 로마 숫자를 사용해 만들 수 있는 서로 다른 수의 개수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}