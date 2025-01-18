package bronze5.num28691;

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
		
		// readLine() 및 charAt() 메서드를 사용해 민재가 이야기한 동아리의 첫 번째 글자를 변수 acronym에 할당
		char acronym = in.readLine().charAt(0);
		
		// switch 조건문을 사용해 민재가 생각하는 동아리의 이름을 출력
		switch (acronym) {
			case 'M':
				out.write("MatKor");
				break;
			case 'W':
				out.write("WiCys");
				break;
			case 'C':
				out.write("CyKor");
				break;
			case 'A':
				out.write("AlKor");
				break;
			default:
				out.write("$clear");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}