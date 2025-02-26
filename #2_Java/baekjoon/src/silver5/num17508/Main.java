package silver5.num17508;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 카드 조합별 마법 행렬을 만들기 위한 카드의 최소 회전 횟수를 저장할 2차원 배열 counts 초기화
	static int[][] counts = {{1, -1, -1, 0}, {-1, 1, -1, -1}, {-1, -1, 0, -1}, {0, -1, -1, 1}};
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 카드 행렬의 크기를 각 변수에 할당
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		
		// 마법 행렬을 만들기 위해 필요한 카드의 최소 회전 횟수를 저장할 변수 minCount 초기화
		int minCount = 0;
		
		// 입력 받은 카드 행렬을 저장할 2차원 배열 matrix 초기화
		char[][] matrix = new char[height][width];
		
		// for 반복문을 사용해 입력 받은 카드 행렬을 2차원 배열 matrix에 저장
		for (int r = 0; r < height; r++)
			matrix[r] = in.readLine().toCharArray();
		
		// 행의 수가 홀수인 경우
		if ((height & 1) == 1) {
			
			// 열의 수가 홀수이고 가운데 칸이 8이 아닌 경우 마법 행렬을 만들 수 없으므로 필요한 카드의 최소 회전 횟수를 -1로 갱신
			if ((width & 1) == 1 && matrix[height / 2][width / 2] != '8')
				minCount = -1;
			
			// 열의 수가 짝수이거나 가운데 칸이 8인 경우
			if (minCount >= 0) {
				
				// for 반복문을 사용해 각 칸을 순회
				for (int c = 0; c < width / 2; c++) {
					
					// cardChecker() 메서드를 호출해 대칭인 카드쌍이 마법 행렬을 이루기 위해 필요한 회전 횟수를 변수 count에 할당
					int count = cardChecker(matrix[height / 2][c], matrix[height / 2][width - c - 1]);
					
					// 마법 행렬을 만들 수 없는 경우 필요한 카드의 최소 회전 횟수를 -1로 갱신 후 반복문 탈출
					if (count == -1) {
						minCount = -1;
						break;
					}
					
					// 마법 행렬을 만들기 위해 필요한 카드의 최소 회전 횟수를 갱신
					minCount += count;
				}
			}
		}
		
		// 행의 수가 짝수이거나 가운데 행이 마법 행렬을 이루는 경우
		if (minCount >= 0) {
			
			// for 반복문을 사용해 각 행을 순회
			outer: for (int r = 0; r < height / 2; r++) {
				
				// for 반복문을 사용해 각 칸을 순회
				for (int c = 0; c < width; c++) {
					
					// cardChecker() 메서드를 호출해 대칭인 카드쌍이 마법 행렬을 이루기 위해 필요한 회전 횟수를 변수 count에 할당
					int count = cardChecker(matrix[r][c], matrix[height - r - 1][width - c - 1]);
					
					// 마법 행렬을 만들 수 없는 경우 필요한 카드의 최소 회전 횟수를 -1로 갱신 후 반복문 탈출
					if (count == -1) {
						minCount = -1;
						break outer;
					}
					
					// 마법 행렬을 만들기 위해 필요한 카드의 최소 회전 횟수를 갱신
					minCount += count;
				}
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 마법 행렬을 만들기 위해 필요한 카드의 최소 회전 횟수를 출력
		out.write(String.valueOf(minCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// cardChecker() 메서드 정의
	public static int cardChecker(char curCard, char nextCard) {
		
		// 해당 카드쌍이 마법 행렬을 이루기 위해 필요한 회전 횟수를 반환
		return counts[curCard - '6'][nextCard - '6'];
	}
}