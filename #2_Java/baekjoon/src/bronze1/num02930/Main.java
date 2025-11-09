package bronze1.num02930;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 상근이와 친구가 낸 가위바위보 모양에 따른 점수를 저장할 2차원 배열 scoreTable 초기화
	static int[][] scoreTable = {{1, 0, 2}, {2, 1, 0}, {0, 2, 1}};
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 상근이가 얻은 점수, 상근이가 얻을 수 있는 최대 점수를 저장할 각 변수 초기화
		int totalScore = 0;
		int maxScore = 0;
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 라운드의 수를 변수 roundNum에 할당
		int roundNum = Integer.parseInt(in.readLine());
		
		// readLine() 메서드를 사용해 상근이가 낸 가위바위보 모양을 변수 result에 저장
		String result = in.readLine();
		
		// 각 라운드별 가위, 바위, 보를 냈을 때의 점수를 저장할 2차원 배열 scores 초기화
		int[][] scores = new int[roundNum][3];
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 친구의 수를 변수 friendNum에 할당
		int friendNum = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 친구를 순회
		for (int friend = 0; friend < friendNum; friend++) {
			
			// readLine() 메서드를 사용해 친구가 낸 가위바위보 모양을 변수 friendResult에 할당
			String friendResult = in.readLine();
			
			// for 반복문을 사용해 각 라운드를 순회
			for (int round = 0; round < roundNum; round++) {
				
				/* charAt() 및 indexFinder() 메서드를 사용해
				해당 라운드에서 친구의 결과를 인덱스로 변환하고 변수 friendIndex에 할당 */
				int friendIndex = indexFinder(friendResult.charAt(round));
				
				// for 반복문을 사용해 상근이가 낸 가위바위보 모양에 따른 점수를 갱신
				for (int index = 0; index < 3; index++)
					scores[round][index] += scoreTable[index][friendIndex];
			}
		}
		
		// for 반복문을 사용해 각 라운드를 순회
		for (int round = 0; round < roundNum; round++) {
			
			/* charAt() 및 indexFinder() 메서드를 사용해
			해당 라운드에서 상근이의 결과를 인덱스로 변환하고 변수 index에 할당 */
			int index = indexFinder(result.charAt(round));
			
			// max() 메서드를 사용해 상근이의 점수 및 상근이가 얻을 수 있는 최대 점수를 갱신
			totalScore += scores[round][index];
			maxScore += Math.max(scores[round][0], Math.max(scores[round][1], scores[round][2]));
		}
		
		// write() 메서드를 사용해 상근이의 점수 및 상근이가 얻을 수 있는 최대 점수를 출력
		out.write(totalScore + "\n" + maxScore);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// indexFinder() 메서드 정의
	public static int indexFinder(char result) {
		
		// 가위인 경우 0을 반환
		if (result == 'S')
			return 0;
		
		// 바위인 경우 1을 반환
		if (result == 'R')
			return 1;
		
		// 보인 경우 2를 반환
		return 2;
	}
}