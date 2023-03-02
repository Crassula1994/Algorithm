package d2.num12712;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Solution 클래스 정의
public class Solution {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// 노즐이 '+' 모양인 경우의 델타 배열을 각각 정의
		int[] dr1 = {-1, 1, 0, 0};
		int[] dc1 = {0, 0, -1, 1};
		
		// 노즐이 '×' 모양인 경우의 델타 배열을 각각 정의
		int[] dr2 = {-1, -1, 1, 1};
		int[] dc2 = {-1, 1, -1, 1};
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 배열의 크기 및 스프레이의 세기를 각 변수에 할당
			int size = Integer.parseInt(st.nextToken());
			int sprayStrength = Integer.parseInt(st.nextToken());
			
			// 파리의 개체 수를 저장할 2차원 배열 flies 초기화
			int[][] flies = new int[size][size];
			
			// 최대로 박멸할 수 있는 파리의 수를 저장할 변수 maxCount 초기화
			int maxCount = -1;
			
			// for 반복문을 사용해 배열 flies의 각 행을 순회
			for (int r = 0; r < size;  r++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 재할당
				st = new StringTokenizer(in.readLine());
				
				// for 반복문을 사용해 배열 flies의 각 열을 순회하며 입력 받은 파리의 수를 저장
				for (int c = 0; c < size; c++)
					flies[r][c] = Integer.parseInt(st.nextToken());
			}
			
			// for 반복문을 사용해 배열 flies의 각 행과 열을 순회
			for (int r = 0; r < size;  r++) {
				for (int c = 0; c < size; c++) {
					
					// 해당 위치에서 박멸할 수 있는 파리의 수를 저장할 각 변수 초기화
					int sum1 = flies[r][c];
					int sum2 = flies[r][c];
					
					// for 반복문을 사용해 해당 위치에서 각 델타 배열을 순회
					for (int d = 0; d < 4; d++) {
						
						// for 반복문을 사용해 스프레이 범위까지의 모든 위치를 순회
						for (int m = 1; m < sprayStrength; m++) {
							
							// '+' 노즐인 경우 스프레이의 범위인 위치를 각 변수에 할당
							int nr1 = r + dr1[d] * m;
							int nc1 = c + dc1[d] * m;
							
							// 해당 위치가 배열을 벗어나지 않은 경우 파리의 수 갱신
							if (nr1 >= 0 && nr1 < size && nc1 >= 0 && nc1 < size)
								sum1 += flies[nr1][nc1];
							
							// '×' 노즐인 경우 스프레이의 범위인 위치를 각 변수에 할당
							int nr2 = r + dr2[d] * m;
							int nc2 = c + dc2[d] * m;
							
							// 해당 위치가 배열을 벗어나지 않은 경우 파리의 수 갱신
							if (nr2 >= 0 && nr2 < size && nc2 >= 0 && nc2 < size)
								sum2 += flies[nr2][nc2];
						}
					}
					
					// 최대로 박멸할 수 있는 파리의 수를 갱신
					maxCount = (Math.max(sum1, sum2) > maxCount) ? Math.max(sum1, sum2) : maxCount;
				}
			}
			
			// write() 메서드를 사용해 최대로 박멸할 수 있는 파리의 수를 출력
			out.write("#" + (tc + 1) + " " + maxCount + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}