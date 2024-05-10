package bronze4.num17009;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 각 팀의 점수를 각 변수에 할당
		int scoreA = 3 * Integer.parseInt(in.readLine()) + 2 * Integer.parseInt(in.readLine()) + Integer.parseInt(in.readLine());
		int scoreB = 3 * Integer.parseInt(in.readLine()) + 2 * Integer.parseInt(in.readLine()) + Integer.parseInt(in.readLine());
		
		// 애플스 팀의 점수가 바나나스 팀의 점수보다 높은 경우 'A'를 출력
		if (scoreA > scoreB) {
			out.write("A");
			
		// 바나나스 팀의 점수가 애플스 팀의 점수보다 높은 경우 'B'를 출력
		} else if (scoreA < scoreB) {
			out.write("B");
		
		// 두 팀이 동점을 이룬 경우 'T'를 출력
		} else {
			out.write("T");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}