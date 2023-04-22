package bronze4.num04299;

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

		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 점수의 합과 차를 각 변수에 할당
		int sum = Integer.parseInt(st.nextToken());
		int diff = Integer.parseInt(st.nextToken());
		
		// 각 점수의 합과 차를 이루는 두 점수를 각 변수에 할당
		int winScore = (sum + diff) / 2;
		int loseScore = (sum - diff) / 2;
		
		// 두 점수 중 하나가 음수인 경우 -1을 출력
		if (winScore < 0 || loseScore < 0) {
			out.write(String.valueOf(-1));
		
		// 두 점수의 합과 차가 주어진 값과 일치하는 경우 해당 점수를 출력
		} else if (winScore + loseScore == sum && winScore - loseScore == diff) {
			out.write(winScore + " " + loseScore);
		
		// 두 점수의 합과 차가 주어진 값과 일치하지 않는 경우 -1을 출력
		} else {
			out.write(String.valueOf(-1));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}