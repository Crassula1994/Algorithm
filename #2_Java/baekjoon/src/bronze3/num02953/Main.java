package bronze3.num02953;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 우승자의 번호와 그의 점수를 저장할 각 변수 초기화
		int winnerNum = 0;
		int winnerPoint = 0;
		
		// for 반복문을 사용해 각 다섯 명의 참가자를 차례로 순회
		for (int number = 1; number <= 5; number++) {
			
			// 해당 참가자의 점수를 저장할 변수 point 초기화
			int point = 0;
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 네 개의 평가 점수를 참가자의 점수에 갱신
			for (int p = 0; p < 4; p++)
				point += Integer.parseInt(st.nextToken());
			
			// 해당 점수가 저장된 우승자의 점수보다 많은 경우 우승자의 번호와 그의 점수를 갱신
			if (point > winnerPoint) {
				winnerNum = number;
				winnerPoint = point;
			}
		}
		
		// write() 메서드를 사용해 우승자의 번호와 그가 얻은 점수를 출력
		out.write(winnerNum + " " + winnerPoint);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}