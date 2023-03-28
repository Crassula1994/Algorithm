package silver1.num09465;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해서 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 스티커의 길이를 변수 length에 할당
			int length = Integer.parseInt(in.readLine());
			
			// 스티커의 점수 및 각 스티커를 선택했을 때의 최대 점수를 저장할 각 2차원 배열 초기화
			int[][] stickers = new int[2][length];
			int[][] maxScores = new int[2][length];
			
			// for 반복문을 사용해 배열 stickers의 각 행을 순회
			for (int r = 0; r < 2; r++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 할당
				StringTokenizer st = new StringTokenizer(in.readLine());
				
				// for 반복문을 사용해 배열 stickers의 각 열을 순회하며 스티커의 점수를 배열 stickers에 저장
				for (int c = 0; c < length; c++)
					stickers[r][c] = Integer.parseInt(st.nextToken());
			}
			
			// 스티커의 길이가 1인 경우 더 큰 점수를 지닌 스티커의 점수를 출력
			if (length == 1) {
				out.write(Math.max(stickers[0][0], stickers[1][0]) + "\n");
				
			// 스티커의 길이가 2 이상인 경우
			} else {
				
				// 처음 네 스티커를 각각 선택했을 경우 스티커 점수의 최댓값을 초기화
				maxScores[0][0] = stickers[0][0];
				maxScores[1][0] = stickers[1][0];
				maxScores[0][1] = stickers[1][0] + stickers[0][1];
				maxScores[1][1] = stickers[0][0] + stickers[1][1];
				
				// for 반복문을 사용해 각 스티커 점수의 최댓값을 갱신
				for (int idx = 2; idx < length; idx++) {
					maxScores[0][idx] = Math.max(maxScores[1][idx - 1], maxScores[1][idx - 2]) + stickers[0][idx];				
					maxScores[1][idx] = Math.max(maxScores[0][idx - 1], maxScores[0][idx - 2]) + stickers[1][idx];
				}
				
				// max() 및 write() 메서드를 사용해 스티커 점수의 최댓값을 출력
				out.write(Math.max(maxScores[0][length - 1], maxScores[1][length - 1]) + "\n");
			}
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}