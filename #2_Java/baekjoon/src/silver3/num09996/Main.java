package silver3.num09996;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 파일의 개수를 변수 fileNum에 할당
		int fileNum = Integer.parseInt(in.readLine());
		
		// readLine() 및 split() 메서드를 사용해 입력 받은 파일의 패턴을 앞과 뒤로 나누어 배열 pattern에 저장
		String[] pattern = in.readLine().split("\\*");
		
		// for 반복문을 사용해 각 파일의 이름을 순회
		for (int file = 0; file < fileNum; file++) {
		
			// readLine() 메서드를 사용해 입력 받은 파일의 이름을 변수 fileName에 할당
			String fileName = in.readLine();
			
			// 파일 이름이 패턴의 길이보다 짧은 경우 'NE' 출력 후 다음 파일 이름을 순회
			if (fileName.length() < pattern[0].length() + pattern[1].length()) {
				out.write("NE\n");
				continue;
			}
			
			// 파일의 이름이 패턴과 일치하는 경우 'DA' 출력
			if (fileName.startsWith(pattern[0]) && fileName.endsWith(pattern[1])) {
				out.write("DA\n");
				
			// 파일의 이름이 패턴과 일치하지 않는 경우 'NE' 출력
			} else {
				out.write("NE\n");
			}
		}
			
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}