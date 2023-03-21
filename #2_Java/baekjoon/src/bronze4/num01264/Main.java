package bronze4.num01264;

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
		
		// while 반복문을 사용해 각 줄을 순회
		while (true) {
			
			// readLine() 및 toLowerCase() 메서드를 사용해 각 줄의 문장에서 대문자를 소문자로 변환해 변수 sentence에 할당
			String sentence = in.readLine().toLowerCase();
			
			// '#'이 입력된 경우 반복문 탈출
			if (sentence.equals("#"))
				break;
			
			// 모음의 개수를 저장할 변수 count 초기화
			int count = 0;
			
			// for 반복문을 사용해 문장의 각 글자를 순회
			for (int idx = 0; idx < sentence.length(); idx++) {
				
				// charAt() 메서드를 사용해 각 글자를 변수 character에 할당
				char character = sentence.charAt(idx);
				
				// 해당 글자가 모음인 경우 모음의 개수를 갱신
				if (character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u')
					count++;
			}
			
			// write() 메서드를 사용해 모음의 개수를 출력
			out.write(count + "\n");
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}