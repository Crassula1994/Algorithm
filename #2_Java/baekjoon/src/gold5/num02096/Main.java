package gold5.num02096;

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

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 줄의 수를 변수 lineNum에 할당
		int lineNum = Integer.parseInt(in.readLine());
		
		// 입력 받은 숫자표를 저장할 2차원 배열 numTable 초기화
		int[][] numTable = new int[lineNum][3];
		
		// for 반복문을 사용해 numTable의 각 줄을 순회
		for (int idx = 0; idx < lineNum; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 줄의 숫자를 numTable에 저장
			numTable[idx][0] = Integer.parseInt(st.nextToken());
			numTable[idx][1] = Integer.parseInt(st.nextToken());
			numTable[idx][2] = Integer.parseInt(st.nextToken());
		}
		
		// 해당 위치까지의 최댓값과 최솟값을 각각 저장할 각 2차원 배열 초기화
		int[][] maxScores = new int[lineNum][3];
		int[][] minScores = new int[lineNum][3];
		
		// for 반복문을 사용해 첫 번째 위치의 최댓값과 최솟값을 초기화
		for (int idx = 0; idx < 3; idx++) {
			maxScores[0][idx] = numTable[0][idx];
			minScores[0][idx] = numTable[0][idx];
		}
		
		// for 반복문을 사용해 배열 maxScore 및 minScore의 각 행을 순회
		for (int idx = 1; idx < lineNum; idx++) {
		
			// max() 메서드를 사용해 각 위치에서의 최대 점수를 갱신
			maxScores[idx][0] = Math.max(maxScores[idx - 1][0], maxScores[idx - 1][1]) + numTable[idx][0];
			maxScores[idx][1] = Math.max(maxScores[idx - 1][0], Math.max(maxScores[idx - 1][1], maxScores[idx - 1][2])) + numTable[idx][1];
			maxScores[idx][2] = Math.max(maxScores[idx - 1][1], maxScores[idx - 1][2]) + numTable[idx][2];
			
			// min() 메서드를 사용해 각 위치에서의 최소 점수를 갱신
			minScores[idx][0] = Math.min(minScores[idx - 1][0], minScores[idx - 1][1]) + numTable[idx][0];
			minScores[idx][1] = Math.min(minScores[idx - 1][0], Math.min(minScores[idx - 1][1], minScores[idx - 1][2])) + numTable[idx][1];
			minScores[idx][2] = Math.min(minScores[idx - 1][1], minScores[idx - 1][2]) + numTable[idx][2];
		}
		
		// max() 및 min() 메서드를 사용해 얻을 수 있는 최대 점수와 최소 점수를 각 변수에 할당
		int maxScore = Math.max(maxScores[lineNum - 1][0], Math.max(maxScores[lineNum - 1][1], maxScores[lineNum - 1][2]));
		int minScore = Math.min(minScores[lineNum - 1][0], Math.min(minScores[lineNum - 1][1], minScores[lineNum - 1][2]));
		
		// write() 메서드를 사용해 얻을 수 있는 최대 점수와 최소 점수를 출력
		out.write(maxScore + " " + minScore);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}