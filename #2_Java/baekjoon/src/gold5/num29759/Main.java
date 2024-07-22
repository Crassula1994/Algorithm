package gold5.num29759;

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
		
		// readLine(), parseInt(), pow() 메서드를 사용해 입력 받은 스도쿠의 크기를 변수 size에 할당
		int size = (int) Math.pow(Integer.parseInt(in.readLine()), 2);
		
		// 서로소 스도쿠에 사용할 수 없는 숫자를 저장할 배열 isNotCoprime 초기화
		boolean[] isNotCoprime = new boolean[1000001];
		
		// 입력 받은 서로소 스도쿠를 저장할 2차원 배열 sudokuBoard 초기화
		int[][] sudokuBoard = new int[size][size];
		
		// 0과 1은 사용할 수 없으므로 사용할 수 없는지 여부를 갱신
		isNotCoprime[0] = isNotCoprime[1] = true;
		
		// for 반복문을 사용해 각 숫자를 순회
		for (int divisor = 2; divisor * divisor <= 1000000; divisor++) {
			
			// 해당 숫자를 사용할 수 없는 경우 다음 숫자를 순회
			if (isNotCoprime[divisor])
				continue;
			
			// for 반복문을 사용해 해당 숫자의 배수에 대하여 사용할 수 없는지 여부를 갱신
			for (int multiple = divisor * 2; multiple <= 1000000; multiple += divisor)
				isNotCoprime[multiple] = true;
		}
		
		// for 반복문을 사용해 서로소 스도쿠의 각 행을 순회
		for (int r = 0; r < size; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 서로소 스도쿠의 각 열을 순회
			for (int c = 0; c < size; c++) {
			
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 2차원 배열 sudokuBoard에 저장
				sudokuBoard[r][c] = Integer.parseInt(st.nextToken());
				
				// 숫자가 존재하는 경우 이미 사용된 숫자는 사용할 수 없으므로 사용할 수 없는지 여부를 갱신 
				if (sudokuBoard[r][c] > 0)
					isNotCoprime[sudokuBoard[r][c]] = true;
			}
		}
		
		// for 반복문을 사용해 서로소 스도쿠의 각 행과 열을 순회
		for (int r = 0, number = 500001; r < size; r++) {
			for (int c = 0; c < size; c++) {
				
				// 해당 칸에 숫자가 이미 존재하는 경우 해당 숫자를 출력
				if (sudokuBoard[r][c] > 0) {
					out.write(sudokuBoard[r][c] + " ");
					
				// 해당 칸에 숫자가 존재하지 않는 경우
				} else {
					
					// while 반복문을 사용해 사용할 수 있는 숫자를 찾을 때까지 순회
					while (isNotCoprime[number])
						number++;
					
					// write() 메서드를 사용해 해당 숫자를 출력
					out.write(number++ + " ");
				}
			}
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}