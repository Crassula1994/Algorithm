package silver5.num01543;

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
		
		// readLine() 메서드를 사용해 입력 받은 문서와 검색하려는 단어를 각 변수에 할당
		String document = in.readLine();
		String targetWord = in.readLine();
		
		// 단어의 최대 등장 횟수, 탐색 중인 문서의 위치를 저장할 각 변수 초기화
		int count = 0;
		int index = 0;
		
		// while 반복문을 사용해 각 단어를 순회
		while (index <= document.length() - targetWord.length()) {
			
			// length() 및 substring() 메서드를 사용해 잘라낸 단어를 변수 word에 할당
			String word = document.substring(index, index + targetWord.length());
			
			// 해당 단어가 검색하려는 단어인 경우
			if (word.equals(targetWord)) {
				
				// 단어의 최대 등장 횟수 갱신
				count++;
				
				// length() 메서드를 사용해 탐색 중인 문서의 위치를 갱신
				index += targetWord.length();
				
			// 해당 단어가 검색하려는 단어가 아닌 경우 탐색 중인 문서의 위치 갱신
			} else {
				index++;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 단어의 최대 등장 횟수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}