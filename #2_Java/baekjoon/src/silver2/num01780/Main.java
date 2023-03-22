package silver2.num01780;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
 
	// 종이를 저장할 2차원 배열 paper 초기화
	static int[][] paper;
	
	// -1, 0, 1으로만 채워진 각 종이의 개수를 저장할 각 변수 초기화
	static int paperMinusCnt = 0;
	static int paperZeroCnt = 0;
	static int paperPlusCnt = 0;
	
	// ----------------------------------------------------------------------------------------------------
	
    // main() 메서드 정의
    public static void main(String[] args) throws IOException {
     
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 종이의 크기를 변수 size에 할당
		int size = Integer.parseInt(in.readLine());
		
		// 종이를 저장할 2차원 배열 paper 초기화
		paper = new int[size][size];
		
		// for 반복문을 사용해 배열 paper의 각 행을 순회
		for (int r = 0; r < size; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 배열 paper의 각 열을 순회하며 입력 받은 값을 저장
			for (int c = 0; c < size; c++)
				paper[r][c] = Integer.parseInt(st.nextToken());
		}
		
		// paperCutter() 메서드를 호출해 각 종이의 개수를 갱신
		paperCutter(0, 0, size);
		
		// write() 메서드를 사용해 -1, 0, 1으로만 채워진 각 종이의 개수를 출력
		out.write(paperMinusCnt + "\n" + paperZeroCnt + "\n" + paperPlusCnt);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
    }
    
    // ----------------------------------------------------------------------------------------------------

    // paperCutter() 메서드 정의
	public static void paperCutter(int startRow, int startCol, int size) {

		// 왼쪽 상단의 값을 변수 base에 할당
		int base = paper[startRow][startCol];
		
		// 모두 값이 일치하는지 여부를 저장할 변수 isSame 초기화
		boolean isSame = true;
		
		// 종이의 크기가 1이 아닌 경우
		if (size > 1) {
			
			// for 반복문을 사용해 배열 paper의 각 행과 열을 순회
			outer: for (int r = startRow; r < startRow + size; r++) {
				for (int c = startCol; c < startCol + size; c++) {

					// 해당 값이 왼쪽 상단의 값과 다른 경우
					if (paper[r][c] != base) {
						
						// 모두 값이 일치하는지 여부를 갱신
						isSame = false;
						
						// 종이를 자를 크기를 변수 newSize에 할당
						int newSize = size / 3;
						
						// for 반복문을 사용해 9등분한 종이에 대해 paperCutter() 메서드 재귀 호출
						for (int nr = 0; nr < 3; nr++) {
							for (int nc = 0; nc < 3; nc++)
								paperCutter(startRow + (newSize * nr), startCol + (newSize * nc), newSize);
						}
						
						// 반복문 탈출
						break outer;
					}
				}
			}
		}
		
		// 종이의 크기가 1이거나 모두 값이 일치하는 경우
		if (isSame) {
			
			// switch 조건문을 사용해 각 종이의 개수를 갱신
			switch (base) {
				case -1:
					paperMinusCnt++;
					break;
				case 0:
					paperZeroCnt++;
					break;
				default:
					paperPlusCnt++;
			}
		}
	}
}