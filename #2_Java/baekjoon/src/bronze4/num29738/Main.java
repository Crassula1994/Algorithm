package bronze4.num29738;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// StringBuilder 객체를 불러와 변수 sb에 할당
		StringBuilder sb = new StringBuilder();
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 1; tc <= testCase; tc++) {
			
			// append() 메서드를 사용해 해당 테스트 케이스의 번호를 sb에 추가
			sb.append("Case #").append(tc).append(": ");
			
			// readLine() 및 parseInt() 메서드를 사용해 마지막으로 참가한 라운드의 등수를 변수 rank에 할당
			int rank = Integer.parseInt(in.readLine());
			
			// Round 1에 진출한 경우 'Round 1'을 sb에 저장
			if (rank > 4500) {
				sb.append("Round 1");
				
			// Round 2에 진출한 경우 'Round 2'를 sb에 저장
			} else if (rank > 1000) {
				sb.append("Round 2");
				
			// Round 3에 진출한 경우 'Round 3'를 sb에 저장
			} else if (rank > 25) {
				sb.append("Round 3");
				
			// Wordld Finals에 진출한 경우 'World Finals'를 sb에 저장
			} else {
				sb.append("World Finals");
			}
			
			// append() 메서드를 사용해 줄바꿈 기호를 sb에 추가
			sb.append("\n");
		}
		
		// toString() 및 write() 메서드를 사용해 각 참가자가 마지막으로 참가한 라운드를 출력
		out.write(sb.toString());

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}