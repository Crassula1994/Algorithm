package gold4.num02448;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// Main 클래스 정의
public class Main {
	
	// 별과 빈 칸을 저장할 2차원 배열 paper 초기화
	static char[][] paper;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
		int number = Integer.parseInt(in.readLine());
		
		// 별과 빈 칸을 저장할 2차원 배열 paper 초기화
		paper = new char[number][2 * number - 1];
		
		// for 반복문을 사용해 2차원 배열 paper에 빈 칸을 저장
		for (int r = 0; r < number; r++)
			Arrays.fill(paper[r], ' ');
		
		// starDrawer() 메서드를 호출해 별을 paper에 저장
		starDrawer(number, 0, number - 1);
		
		// for 반복문을 사용해 paper에 저장된 별과 빈 칸을 출력
		for (int r = 0; r < number; r++) {
			for (int c = 0; c < 2 * number - 1; c++)
				out.write(paper[r][c]);
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// starDrawer() 메서드 정의
	public static void starDrawer(int size, int row, int column) {
		
		// 가장 작은 삼각형인 경우
		if (size == 3) {
			
			// 별을 저장해야 할 곳에 별을 저장
			paper[row][column] = '*';
			paper[row + 1][column - 1] = '*';
			paper[row + 1][column + 1] = '*';
			paper[row + 2][column - 2] = '*';
			paper[row + 2][column - 1] = '*';
			paper[row + 2][column] = '*';
			paper[row + 2][column + 1] = '*';
			paper[row + 2][column + 2] = '*';
			
			// 메서드 종료
			return;
		}
		
		// 더 작은 삼각형의 크기를 변수 newSize에 할당
		int newSize = size / 2;
		
		// starDrawer() 메서드 재귀 호출
        starDrawer(newSize, row, column);
        starDrawer(newSize, row + newSize, column - newSize);
        starDrawer(newSize, row + newSize, column + newSize);
	}
}