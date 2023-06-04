package bronze4.num11948;

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
		
		// 물리, 화학, 생물, 지구과학 중 가장 낮은 점수, 선택한 과목의 총 점수를 저장할 각 변수 초기화
		int minScore = Integer.MAX_VALUE;
		int sumScore = 0;
		
		// for 반복문을 사용해 물리, 화학, 생물, 지구과학 점수를 순회
		for (int s = 0; s < 4; s++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 각 점수를 변수 score에 할당
			int score = Integer.parseInt(in.readLine());
			
			// min() 메서드를 사용해 가장 낮은 점수를 갱신
			minScore = Math.min(score, minScore);
			
			// 선택한 과목의 총 점수를 갱신
			sumScore += score;
		}
		
		// 가장 낮은 점수를 제거
		sumScore -= minScore;
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 역사, 지리 점수를 각 변수에 할당
		int history = Integer.parseInt(in.readLine());
		int geography = Integer.parseInt(in.readLine());
		
		// max() 메서드를 사용해 더 높은 점수를 더해 선택한 과목의 총 점수를 갱신
		sumScore += Math.max(history, geography);
		
		// valueOf() 및 write() 메서드를 사용해 선택한 과목의 총 점수를 출력
		out.write(String.valueOf(sumScore));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}