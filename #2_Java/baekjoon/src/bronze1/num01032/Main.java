package bronze1.num01032;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 파일 이름의 개수를 변수 fileNum에 할당
		int fileNum = Integer.parseInt(in.readLine());
		
		// readLine() 및 toCharArray() 메서드를 사용해 입력 받은 첫 파일 이름을 배열 fileNamePattern에 저장
		char[] fileNamePattern = in.readLine().toCharArray();
		
		// for 반복문을 사용해 각 파일 이름을 순회
		for (int file = 1; file < fileNum; file++) {
			
			// readLine() 및 toCharArray() 메서드를 사용해 입력 받은 파일 이름을 배열 fileNum에 저장
			char[] fileName = in.readLine().toCharArray();
			
			// for 반복문을 사용해 파일 이름의 각 글자를 순회
			for (int idx = 0; idx < fileNamePattern.length; idx++) {
				
				// 해당 글자가 서로 다를 경우 '?'로 글자 변경
				if (fileNamePattern[idx] != fileName[idx])
					fileNamePattern[idx] = '?';
			}
		}

		// for 반복문을 사용해 패턴을 출력
		for (int idx = 0; idx < fileNamePattern.length; idx++)
			out.write(fileNamePattern[idx]);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}