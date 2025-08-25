package bronze4.num05358;

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

		// 선수들의 이름을 저장할 변수 playerName 초기화
		String playerName;
		
		// while 반복문을 사용해 각 선수들의 이름을 순회
		while ((playerName = in.readLine()) != null) {
			
			// for 반복문을 사용해 해당 선수 이름의 각 알파벳을 순회
			for (int idx = 0; idx < playerName.length(); idx++) {
				
				// charAt() 메서드를 사용해 해당 알파벳을 변수 alphabet에 할당
				char alphabet = playerName.charAt(idx);
				
				// switch 조건문을 사용해 올바른 선수 이름을 출력
				switch (alphabet) {
					case 'e':
						out.write("i");
						break;
					case 'i':
						out.write("e");
						break;
					case 'E':
						out.write("I");
						break;
					case 'I':
						out.write("E");
						break;
					default:
						out.write(alphabet);
				}
			}
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}