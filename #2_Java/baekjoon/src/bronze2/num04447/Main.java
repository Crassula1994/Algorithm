package bronze2.num04447;

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

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// StringBuilder 객체를 불러와 변수 sb에 할당
		StringBuilder sb = new StringBuilder();
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// 해당 히어로가 착한 정도를 나타낼 변수 goodIndex 초기화
			int goodIndex = 0;
			
			// readLine() 메서드를 사용해 입력 받은 히어로의 이름을 변수 heroName에 할당
			String heroName = in.readLine();
			
			// for 반복문을 사용해 각 글자를 순회
			for (int idx = 0; idx < heroName.length(); idx++) {
				
				// charAt() 메서드를 사용해 해당 글자를 변수 letter에 할당
				char letter = heroName.charAt(idx);
				
				// switch 조건문을 사용해 히어로가 착한 정도를 갱신
				switch (letter) {
					case 'g':
					case 'G':
						goodIndex++;
						break;
					case 'b':
					case 'B':
						goodIndex--;
				}
			}
			
			// append() 메서드를 사용해 해당 히어로의 이름을 정해진 형식으로 sb에 추가
			sb.append(heroName).append(" is ");
			
			// 해당 히어로가 착한 경우 'GOOD'을 sb에 추가 
			if (goodIndex > 0) {
				sb.append("GOOD");
				
			// 해당 히어로가 나쁜 경우 'A BADDY'를 sb에 추가
			} else if (goodIndex < 0) {
				sb.append("A BADDY");
				
			// 해당 히어로가 중립인 경우 'NEUTRAL'을 sb에 추가
			} else {
				sb.append("NEUTRAL");
			}
			
			// append() 메서드를 사용해 sb에 줄바꿈을 추가
			sb.append("\n");
		}
		
		// toString() 및 write() 메서드를 사용해 각 히어로가 착한지 나쁜지를 출력
		out.write(sb.toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}