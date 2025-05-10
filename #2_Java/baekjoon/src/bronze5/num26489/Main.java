package bronze5.num26489;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 입력을 받은 문장과 파일의 줄 수를 저장할 각 변수 초기화
		String line;
		int lineNum = 0;
		
		// while 반복문을 사용해 파일의 줄 수를 갱신
		while ((line = in.readLine()) != null)
			lineNum++;
		
		// valueOf() 및 write() 메서드를 사용해 파일의 줄 수를 출력
		out.write(String.valueOf(lineNum));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}