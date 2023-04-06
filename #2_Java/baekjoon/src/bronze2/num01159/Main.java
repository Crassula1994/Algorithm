package bronze2.num01159;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 선수의 수를 변수 playerNum에 할당
		int playerNum = Integer.parseInt(in.readLine());
		
		// 성의 첫 글자가 같은 선수의 수를 저장할 배열 playerNames 초기화
		int[] playerNames = new int[26];
		
		// for 반복문을 사용해 각 선수의 이름을 순회
		for (int player = 0; player < playerNum; player++) {
			
			// readLine() 메서드를 사용해 입력 받은 선수의 이름을 변수 name에 할당
			String name = in.readLine();
			
			// charAt() 메서드를 사용해 입력 받은 선수 이름의 첫 글자 개수를 갱신
			playerNames[name.charAt(0) - 'a']++;
		}
		
		// 선발할 수 있는 선수가 존재하는지 여부를 나타내는 변수 isPossible 초기화
		boolean isPossible = false;

		// for 반복문을 사용해 배열 playerNames의 각 원소를 순회
		for (int idx = 0; idx < playerNames.length; idx++) {
			
			// 해당 알파벳이 5명 이상인 경우
			if (playerNames[idx] >= 5) {
				
				// write() 메서드를 사용해 해당 알파벳 출력
				out.write((char) (idx + 97));
				
				// 선발할 수 있는 선수가 존재하는지 여부를 갱신
				isPossible = true;
			}
		}
		
		// 선발할 수가 없는 경우 'PREDAJA' 출력
		if (!isPossible)
			out.write("PREDAJA");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}