package silver1.num01992;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
 
	// 흑백 영상을 저장할 2차원 배열 screen 초기화
	static int[][] screen;
	
	// ----------------------------------------------------------------------------------------------------
	
    // main() 메서드 정의
    public static void main(String[] args) throws IOException {
     
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 영상의 크기를 변수 size에 할당
		int size = Integer.parseInt(in.readLine());
		
		// 흑백 영상을 저장할 2차원 배열 screen 초기화
		screen = new int[size][size];
		
		// for 반복문을 사용해 배열 screen의 각 행을 순회
		for (int r = 0; r < size; r++) {
			
			// readLine() 메서드를 사용해 입력 받은 각 줄의 영상 정보를 변수 line에 할당
			String line = in.readLine();
			
			// for 반복문을 사용해 배열 paper의 각 열을 순회하며 입력 받은 값을 저장
			for (int c = 0; c < size; c++)
				screen[r][c] = line.charAt(c) - '0';
		}
		
		// screenCompressor() 메서드를 호출해 영상을 압축한 결과를 출력
		screenCompressor(0, 0, size, out);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
    }
    
    // ----------------------------------------------------------------------------------------------------

    // screenCompressor() 메서드 정의
	public static void screenCompressor(int startRow, int startCol, int size, BufferedWriter out) throws IOException {

		// 왼쪽 상단의 값을 변수 base에 할당
		int base = screen[startRow][startCol];
		
		// 모두 값이 일치하는지 여부를 저장할 변수 isSame 초기화
		boolean isSame = true;
		
		// 영상의 크기가 1이 아닌 경우
		if (size > 1) {
			
			// for 반복문을 사용해 배열 paper의 각 행과 열을 순회
			outer: for (int r = startRow; r < startRow + size; r++) {
				for (int c = startCol; c < startCol + size; c++) {

					// 해당 값이 왼쪽 상단의 값과 다른 경우
					if (screen[r][c] != base) {
						
						// 모두 값이 일치하는지 여부를 갱신
						isSame = false;
						
						// 영상을 나눌 크기를 변수 newSize에 할당
						int newSize = size / 2;
						
						// write() 메서드를 사용해 여는 괄호를 출력
						out.write("(");
						
						// for 반복문을 사용해 4등분한 영상에 대해 screenCompressor() 메서드 재귀 호출
						for (int nr = 0; nr < 2; nr++) {
							for (int nc = 0; nc < 2; nc++)
								screenCompressor(startRow + (newSize * nr), startCol + (newSize * nc), newSize, out);
						}
						
						// write() 메서드를 사용해 닫는 괄호를 출력
						out.write(")");
						
						// 반복문 탈출
						break outer;
					}
				}
			}
		}
		
		// 영상의 크기가 1이거나 모두 값이 일치하는 경우
		if (isSame) {
			
			// 왼쪽 상단의 값이 1인 경우 1을 출력
			if (base == 1) {
				out.write(String.valueOf(1));
			
			// 왼쪽 상단의 값이 0인 경우 0을 출력
			} else {
				out.write(String.valueOf(0));
			}
		}
	}
}