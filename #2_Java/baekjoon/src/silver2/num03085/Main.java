package silver2.num03085;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;55

// Main 클래스 정의
public class Main {
	
	// 보드 위치별 사탕의 색을 저장할 2차원 배열 candies 초기화
	static char[][] candies;
	
	// 보드의 크기, 상근이가 먹을 수 있는 사탕의 최대 개수를 저장할 각 변수 초기화
	static int size;
	static int maxIntake = 0;
	
	// 가능한 최댓값에 도달했는지를 저장할 변수 isMax 초기화
	static boolean isMax = false;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 보드의 크기를 변수 size에 할당
		size = Integer.parseInt(in.readLine());
		
		// 보드 위치별 사탕의 색을 저장할 2차원 배열 candies 초기화
		candies = new char[size][size];
		
		// for 반복문을 사용해 배열 candies의 각 행을 순회
		for (int r = 0; r < size; r++) {
			
			// readLine() 메서드를 사용해 입력 받은 해당 줄의 사탕 배열을 변수 line에 할당
			String line = in.readLine();
			
			// for 반복문을 사용해 배열 candies의 각 열에 값을 저장
			for (int c = 0; c < size ; c++)
				candies[r][c] = line.charAt(c);
		}
		
		// rowChecker() 및 colChecker() 메서드를 호출해 상근이가 먹을 수 있는 사탕의 최대 개수 갱신
		rowChecker();
		colChecker();
		
		System.out.println(maxIntake);
		
		// 상근이가 먹을 수 있는 사탕의 최대 개수가 보드의 크기와 같은 경우 해당 값 출력
		if (isMax) {
			out.write(String.valueOf(maxIntake));
		
		// 상근이가 먹을 수 있는 사탕의 최대 개수가 보드의 크기보다 작은 경우
		} else {
			
			
			
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// rowChecker() 메서드 정의
	public static void rowChecker() {
		
		// for 반복문을 사용해 각 행을 순회
		for (int r = 0; r < size; r++) {
			
			// 비교하는 기준 색상을 변수 color에 할당
			char color = candies[r][0];
			
			// 먹을 수 있는 사탕의 개수를 저장할 변수 count 초기화
			int count = 1;
			
			// for 반복문을 사용해 각 행의 각 칸을 순회
			for (int c = 1; c < size; c++) {
				
				System.out.println(count);
				
				// 기준 색상과 같은 경우 먹을 수 있는 사탕의 개수 갱신
				if (candies[r][c] == color) {
					count++;
					
				//	기준 색상과 다른 경우
				} else {
					
					// max() 메서드를 사용해 최댓값 비교 후 갱신
					maxIntake = Math.max(count, maxIntake);
					
					// 상근이가 먹을 수 있는 사탕의 최대 개수가 보드의 크기와 같은 경우
					if (maxIntake == size) {
						
						// 가능한 최댓값에 도달했는지를 저장할 변수 isMax 갱신 및 반복문 탈출
						isMax = true;
						break;
					}
						
					// 기준 색상 및 먹을 수 있는 사탕의 개수 변경
					color = candies[r][c];
					count = 1;
				}
			}
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// colChecker() 메서드 정의
	public static void colChecker() {
		
		// 가능한 최댓값에 도달하지 않은 경우
		if (!isMax) {
			
			// for 반복문을 사용해 각 열을 순회
			for (int c = 0; c < size; c++) {
				
				// 비교하는 기준 색상을 변수 color에 할당
				char color = candies[0][c];
				
				// 먹을 수 있는 사탕의 개수를 저장할 변수 count 초기화
				int count = 1;
				
				// for 반복문을 사용해 각 열의 각 칸을 순회
				for (int r = 1; r < size; r++) {
					
					// 기준 색상과 같은 경우 먹을 수 있는 사탕의 개수 갱신
					if (candies[r][c] == color) {
						count++;
						
					//	기준 색상과 다른 경우
					} else {
						
						// max() 메서드를 사용해 최댓값 비교 후 갱신
						maxIntake = Math.max(count, maxIntake);
						
						// 상근이가 먹을 수 있는 사탕의 최대 개수가 보드의 크기와 같은 경우
						if (maxIntake == size) {
							
							// 가능한 최댓값에 도달했는지를 저장할 변수 isMax 갱신 및 반복문 탈출
							isMax = true;
							break;
						}
						
						// 기준 색상 및 먹을 수 있는 사탕의 개수 변경
						color = candies[r][c];
						count = 1;
					}
				}
			}
		}
	}
}