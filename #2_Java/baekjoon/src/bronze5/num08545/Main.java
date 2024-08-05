package bronze5.num08545;

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
		
		// 입력 받은 세 글자 단어를 저장할 StringBuilder 객체를 불러와 변수 sb에 할당
		StringBuilder sb = new StringBuilder(in.readLine());
		
		// reverse(), toString(), write() 메서드를 사용해 입력 받은 세 글자 단어를 뒤집은 결과를 출력
		out.write(sb.reverse().toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}