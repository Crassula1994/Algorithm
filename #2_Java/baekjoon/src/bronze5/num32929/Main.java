package bronze5.num32929;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 UOS 문자열의 순서를 변수 targetOrder에 할당
		int targetOrder = Integer.parseInt(in.readLine());
		
		// UOS 문자열의 순서를 3으로 나눈 나머지에 따른 문자를 저장할 배열 stringUOS 초기화
		char[] stringUOS = {'S', 'U', 'O'};
		
		// write() 메서드를 사용해 찾고자 하는 순서에 위치한 UOS 문자열의 문자를 출력
		out.write(stringUOS[targetOrder % 3]);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}