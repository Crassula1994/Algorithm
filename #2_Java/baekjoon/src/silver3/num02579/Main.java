package silver3.num02579;

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
	
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 계단의 개수를 변수 stairNum에 할당
		int stairNum = Integer.parseInt(in.readLine());
		
		// 각 계단의 점수를 저장할 배열 stairs 초기화
		int[] stairs = new int[301];
		
		// 해당 계단을 밟을 때까지의 최대 점수를 저장할 배열 scores 초기화
		int[] scores = new int[301];
		
		// for 반복문을 사용해 입력 받은 각 계단의 점수를 배열 score에 저장
		for (int idx = 0; idx < stairNum; idx++)
			stairs[idx] = Integer.parseInt(in.readLine());
		
		// 첫 번째 계단부터 세 번째 계단의 점수를 초기화
		scores[0] = stairs[0];
		scores[1] = stairs[0] + stairs[1];
		scores[2] = Math.max(stairs[0], stairs[1]) + stairs[2];
		
		// for 반복문을 사용해 각 계단별 최대 점수를 계산해 배열 scores에 저장
		for (int idx = 3; idx < stairNum; idx++)
			scores[idx] = Math.max(scores[idx - 3] + stairs[idx - 1], scores[idx - 2]) + stairs[idx];

		// valueOf() 및 write() 메서드를 사용해 가장 높은 점수를 출력
		out.write(String.valueOf(scores[stairNum - 1]));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}