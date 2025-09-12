package bronze4.num31495;

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
		
		// readLine() 메서드를 사용해 입력 받은 토카의 문자열을 변수 string에 할당
		String string = in.readLine();
		
		// 해당 문자열이 정확한 문자열이 아니거나, 큰따옴표 내부가 빈 문자열인 경우 'CE'를 출력
		if (string.charAt(0) != '\"' || string.charAt(string.length() - 1) != '\"' || string.length() < 3) {
			out.write("CE");
			
		// 해당 문자열이 정확한 문자열인 경우 내부 문자열을 출력
		} else {
			out.write(string.substring(1, string.length() - 1));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}