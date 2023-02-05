package bronze5.num9086;

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
		
		// readLine() 및 parseInt 메서드를 사용해 입력된 테스트 케이스의 수를 변수 testCase에 저장
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int i = 0; i < testCase; i++) {
			
			// readLine() 및 toCharArray() 메서드를 사용해 입력된 문자열을 배열 line에 저장
			char[] line = in.readLine().toCharArray();
			
			// write() 메서드를 사용해 배열의 첫 문자와 마지막 문자를 각각 출력
			out.write(line[0]);
			out.write(line[line.length - 1] + "\n");
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}