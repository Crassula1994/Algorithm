package bronze4.num30501;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 용의자의 수를 변수 suspectNum에 할당
		int suspectNum = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 용의자의 이름을 순회
		outer: while (suspectNum-- > 0) {
			
			// readLine() 메서드를 사용해 입력 받은 이름을 변수 suspectName에 할당
			String suspectName = in.readLine();
			
			// for 반복문을 사용해 이름의 각 알파벳을 순회
			for (char alphabet : suspectName.toCharArray()) {
				
				// 이름에 'S'가 포함되는 경우 관우를 죽인 범인의 이름을 출력 후 반복문 탈출
				if (alphabet == 'S') {
					out.write(suspectName);
					break outer;
				}
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}