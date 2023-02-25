package silver2.num01406;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {

	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// readLine() 메서드를 사용해 입력 받은 문자열을 변수 word에 할당
		String word = in.readLine();
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 명령어의 개수를 변수 commands에 할당
		int commands = Integer.parseInt(in.readLine());

		// 문자열을 저장할 List 객체 stringList 초기화
		List<Character> stringList = new LinkedList<>();
		
		// for 반복문을 사용해 문자열의 각 문자를 stringList에 추가
		for (int idx = 0; idx < word.length(); idx++)
			stringList.add(word.charAt(idx));
		
		// listIterator() 메서드를 사용해 커서 역할로 사용할 ListIterator 객체 cursor 초기화
		ListIterator<Character> cursor = stringList.listIterator();
		
		// while 반복문을 사용해 커서의 위치를 가장 마지막으로 이동
		while (cursor.hasNext())
			cursor.next();
		
		// for 반복문을 사용해 각 명령어를 순회
		for (int i = 0; i < commands; i++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 charAt() 메서드를 사용해 입력 받은 명령어를 변수 command에 저장
			char command = st.nextToken().charAt(0);
			
			// switch 조건문을 사용해 명령어에 따라 정해진 명령을 수행
			switch (command) {
			
				// 명령어 'L'을 입력한 경우
				case 'L':
					
					// 커서가 문장의 맨 앞이 아닌 경우 previous() 메서드를 사용해 커서를 앞으로 이동
					if (cursor.hasPrevious())
						cursor.previous();
					
					// 조건문 탈출
					break;
				
				// 명령어 'D'를 입력한 경우
				case 'D':
					
					// 커서가 문장의 맨 뒤가 아닌 경우 next() 메서드를 사용해 커서를 뒤로 이동
					if (cursor.hasNext())
						cursor.next();
					
					// 조건문 탈출
					break;
					
				// 명령어 'B'를 입력한 경우
				case 'B':
					
					// 커서가 문장의 맨 앞이 아닌 경우
					if (cursor.hasPrevious()) {
						
						// previous() 및 remove() 메서드를 이용해 커서 왼쪽의 문자를 제거
						cursor.previous();
						cursor.remove();
					}
					
					// 조건문 탈출
					break;

				// 명령어 'P'를 입력한 경우
				default:
					
					// nextToken() 및 charAt() 메서드를 사용해 입력 받은 문자를 변수 character에 저장
					char character = st.nextToken().charAt(0);
					
					// add() 메서드를 사용해 문자를 추가
					cursor.add(character);
			}
		}
		
		// for 반복문을 사용해 명령어를 수행한 후 문자열을 출력
		for (char str : stringList)
			out.write(str);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}