package silver5.num01343;

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
		
		// StringBuilder 객체를 불러와 변수 sb에 할당
		StringBuilder sb = new StringBuilder();
		
		// readLine() 메서드를 사용해 입력 받은 보드판을 변수 board에 할당
		String board = in.readLine();
		
		// 연속된 'X'의 개수, 해당 보드판을 덮을 수 있는지 여부를 나타낼 각 변수 초기화
		int count = 0;
		boolean isCovered = true;
		
		// for 반복문을 사용해 각 보드판의 글자를 순회
		for (int idx = 0; idx < board.length(); idx++) {
			
			// charAt() 메서드를 사용해 해당 글자를 변수 character에 할당
			char character = board.charAt(idx);
			
			// 해당 글자가 'X'인 경우 'X'의 개수 갱신
			if (character == 'X') {
				count++;
				
				// 'X'가 4개인 경우 'AAAA'로 덮고 'X'의 개수 초기화
				if (count == 4) {
					sb.append("AAAA");
					count = 0;
				}
				
				// 마지막 문자인 경우
				if (idx == board.length() - 1) {
					
					// 폴리오미노로 덮지 못하는 경우인 경우 해당 보드판을 덮을 수 있는지 여부를 갱신
					if (count == 1 || count == 3) {
						isCovered = false;
					
					// 'X'가 2개인 경우 'BB'로 덮고 'X'의 개수 초기화
					} else if (count == 2) {
						sb.append("BB");
						count = 0;
					}
				}
				
			// 해당 글자가 '.'인 경우 
			} else {
				
				// 폴리오미노로 덮지 못하는 경우인 경우 해당 보드판을 덮을 수 있는지 여부를 갱신 후 반복문 탈출
				if (count == 1 || count == 3) {
					isCovered = false;
					break;
				
				// 'X'가 2개인 경우 'BB'로 덮고 'X'의 개수 초기화
				} else if (count == 2) {
					sb.append("BB");
					count = 0;
				}
				
				// append() 메서드를 사용해 '.' 추가
				sb.append(".");
			}
		}
		
		// 해당 보드판을 덮을 수 없는 경우 '-1' 출력
		if (!isCovered) {
			out.write(String.valueOf(-1));
		
		// 해당 보드판을 덮을 수 있는 경우 사전순으로 가장 앞서는 답을 출력
		} else {
			out.write(sb.toString());
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}