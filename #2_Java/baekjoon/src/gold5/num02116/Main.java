package gold5.num02116;

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

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 주사위의 개수를 변수 diceNum에 할당
		int diceNum = Integer.parseInt(in.readLine());

		// 각 주사위의 눈의 수를 차례로 저장할 2차원 배열 dice 초기화
		int[][] dice = new int[diceNum][6];
		
		// 각 주사위의 눈의 쌍 위치를 저장할 배열 planarFigure 초기화
		int[] planarFigure = {5, 3, 4, 1, 2, 0}; 
		
		// 눈의 최대 합을 저장할 변수 maxSum 초기화
		int maxSum = 0;
		
		// for 반복문을 사용해 각 주사위를 순회
		for (int die = 0; die < diceNum; die++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 각 주사위의 눈을 배열 dice에 저장
			for (int i = 0; i < 6; i++)
				dice[die][i] = Integer.parseInt(st.nextToken());
		}
				
		// for 반복문을 사용해 첫 주사위의 6개 눈을 순회
		for (int plot = 0; plot < 6; plot++) {
			
			// 주사위 눈의 합을 저장할 변수 sum 초기화
			int sum = 0;
			
			// dice 배열을 복사할 배열 tempDice 초기화
			int[][] tempDice = new int[diceNum][6];
			
			// for 반복문을 사용해 dice 배열을 복사해 배열 tempDice에 저장
			for (int r = 0; r < dice.length; r++)
				tempDice[r] = dice[r].clone();
			
			// 현재 주사위의 바닥에 위치한 눈의 위치를 나타내는 변수 bottomPlot 초기화
			int bottomPlot = plot;
			
			// 천장에 위치한 눈의 위치를 변수 upPlot에 저장
			int upPlot = planarFigure[plot];
			
			// 해당 주사위의 줄 수를 나타내는 변수 row 초기화
			int row = 0;
			
			// while 반복문을 사용해 마지막 주사위까지 순회
			while (row < diceNum) {
				
				// 다음 주사위의 바닥 눈을 저장할 변수 key 초기화
				int key = tempDice[row][upPlot];
				
				// 바닥에 위치한 눈 및 천장에 위치한 눈을 제거
				tempDice[row][bottomPlot] = 0;
				tempDice[row][upPlot] = 0;
				
				// sort() 메서드를 사용해 해당 주사위의 남은 눈을 오름차순 정렬
				Arrays.sort(tempDice[row]);
				
				// 가장 큰 눈을 주사위 눈의 합에 합산
				sum += tempDice[row][5];
				
				// 마지막 줄인 아닌 경우
				if (row < diceNum - 1) {
					
					// for 반복문을 사용해 다음 줄의 주사위 눈을 순회
					for (int idx = 0; idx < 6; idx++) {
						
						// 바닥 눈의 위치를 갱신 후 반복문 탈출
						if (tempDice[row + 1][idx] == key) {
							bottomPlot = idx;
							break;
						}
					}
					
					// 다음에 올 눈을 변수 upPlot에 갱신
					upPlot = planarFigure[bottomPlot];
				}
				
				// 줄의 수를 갱신
				row++;
			}
			
			// max() 메서드를 사용해 주사위 눈의 합이 저장된 최대 합보다 큰 경우 갱신
			maxSum = Math.max(sum, maxSum);
		}
		
		// valueOf() 및 write() 메서드를 사용해 주사위 눈의 최대 합을 출력
		out.write(String.valueOf(maxSum));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}