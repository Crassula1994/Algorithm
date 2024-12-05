package bronze4.num14038;

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
		
		// 선수의 승리 횟수를 저장할 변수 winCount 초기화
		int winCount = 0;
		
		// 선수의 승리 횟수에 따라 속하게 되는 그룹을 저장할 배열 groups 초기화
		int[] groups = {-1, 3, 3, 2, 2, 1, 1};
		
		// for 반복문을 사용해 입력 받은 경기 결과를 순회
		for (int game = 0; game < 6; game++) {
			
			// 해당 경기를 이긴 경우 선수의 승리 횟수를 갱신
			if (in.readLine().charAt(0) == 'W')
				winCount++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 해당 선수가 속하게 될 그룹을 출력
		out.write(String.valueOf(groups[winCount]));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}