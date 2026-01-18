package bronze4.num31775;

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
		
		// 각 문자열이 l, k, p로 시작하는지 여부를 저장할 각 변수 초기화
		boolean isStartedL = false;
		boolean isStartedK = false;
		boolean isStartedP = false;
		
		// for 반복문을 사용해 각 문자열을 순회
		outer: for (int s = 0; s < 3; s++) {
			
			// readLine() 및 charAt() 메서드를 사용해 입력 받은 문자열의 첫 글자를 변수 firstLetter에 할당
			char firstLetter = in.readLine().charAt(0);
			
			// switch 조건문을 사용해 각 문자열이 l, k, p로 시작하는지 여부를 갱신
			switch (firstLetter) {
				case 'l':
					isStartedL = true;
					break;
				case 'k':
					isStartedK = true;
					break;
				case 'p':
					isStartedP = true;
					break;
				default:
					break outer;
			}
		}
		
		// write() 메서드를 사용해 세 문자열로 만든 응원 문구가 GLOBAL한지 여부를 출력
		out.write((isStartedL && isStartedK && isStartedP) ? "GLOBAL" : "PONIX");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}