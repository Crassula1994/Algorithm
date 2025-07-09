package bronze1.num13322;

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
		
		// readLine() 및 length() 메서드를 사용해 입력 받은 문자열의 길이를 변수 stringLength에 할당
		int stringLength = in.readLine().length();
		
		// for 반복문을 사용해 해당 문자열의 접두사 배열에 속한 각 접두사가 끝나는 인덱스를 출력
		for (int idx = 0; idx < stringLength; idx++)
			out.write(idx + "\n");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}