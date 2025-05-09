package bronze1.num11070;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 데이터의 수를 변수 testData에 할당
		int testData = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 데이터를 순회
		while (testData-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 팀 개수와 전체 경기 수를 각 변수에 할당
			int teamNum = Integer.parseInt(st.nextToken());
			int gameNum = Integer.parseInt(st.nextToken());
			
			// 각 팀의 피타고라스 기댓값을 저장할 배열 expectations 초기화
			double[] expectations = new double[teamNum];
			
			// 각 팀의 득점과 실점을 저장할 2차원 배열 scoreBoard 초기화
			int[][] scoreBoard = new int[teamNum][2];
			
			// while 반복문을 사용해 각 경기의 정보를 순회
			while (gameNum-- > 0) {
				
				// StringTokenizer 객체를 불러와 변수 st에 재할당
				st = new StringTokenizer(in.readLine());
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 팀의 번호 및 득점을 각 변수에 할당
				int teamA = Integer.parseInt(st.nextToken()) - 1;
				int teamB = Integer.parseInt(st.nextToken()) - 1;
				int scoreA = Integer.parseInt(st.nextToken());
				int scoreB = Integer.parseInt(st.nextToken());
				
				// 각 팀의 득점과 실점을 2차원 배열 scoreBoard에 저장
				scoreBoard[teamA][0] += scoreA;
				scoreBoard[teamA][1] += scoreB;
				scoreBoard[teamB][0] += scoreB;
				scoreBoard[teamB][1] += scoreA;
			}
			
			// for 반복문을 사용해 각 팀을 순회
			for (int idx = 0; idx < expectations.length; idx++) {
				
				// 해당 팀의 피타고라스 기댓값을 구하기 위해 기댓값의 분자와 분모를 계산한 결과를 각 변수에 할당
				double numerator = scoreBoard[idx][0] * scoreBoard[idx][0];
				double denominator = numerator + scoreBoard[idx][1] * scoreBoard[idx][1];
				
				// 해당 팀의 피타고라스 기댓값을 배열 expectations에 저장
				expectations[idx] = (denominator == 0) ? 0 : numerator / denominator;
			}
			
			// sort() 메서드를 사용해 피타고라스 기댓값을 오름차순 정렬
			Arrays.sort(expectations);
			
			// write() 메서드를 사용해 최대 및 최소 피타고라스 기댓값에 1000을 곱한 값의 정수 부분을 출력
			out.write((int) (expectations[teamNum - 1] * 1000) + "\n");
			out.write((int) (expectations[0] * 1000) + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}