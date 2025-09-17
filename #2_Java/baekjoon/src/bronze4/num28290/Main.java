package bronze4.num28290;

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
		
		// readLine() 멧서드를 사용해 입력 받은 친구의 문자열을 변수 string에 할당
		String string = in.readLine();
		
		// switch 조건문을 사용해 친구의 타법을 출력
		switch (string) {
			case "fdsajkl;":
			case "jkl;fdsa":
				out.write("in-out");
				break;
			case "asdf;lkj":
			case ";lkjasdf":
				out.write("out-in");
				break;
			case "asdfjkl;":
				out.write("stairs");
				break;
			case ";lkjfdsa":
				out.write("reverse");
				break;
			default:
				out.write("molu");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}