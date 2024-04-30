package silver4.num10994;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
		int number = Integer.parseInt(in.readLine());
		
		// 각 줄에 따른 행과 열의 크기를 계산해 변수 size에 할당
		int size = (number - 1) * 4 + 1;
		
		// 별과 빈 칸을 저장할 2차원 배열 stars 초기화
		boolean[][] stars = new boolean[size][size];
		
		// for 반복문을 사용해 각 사각형을 순회
		for (int n = 1; n <= number; n++) {
			
			// 가장 안쪽의 별인 경우 해당 칸을 별로 갱신
			if (n == 1) {
				stars[size / 2][size / 2] = true;
			
			// 바깥쪽의 사각형인 경우
			} else {
				
				// 사각형의 상한과 하한을 계산해 각 변수에 할당
				int lowerBound = size / 2 - 2 * (n - 1);
				int upperBound = size / 2 + 2 * (n - 1);
				
				// for 반복문을 사용해 사각형의 위쪽 칸을 별로 갱신
				for (int c = lowerBound; c < upperBound; c++)
					stars[lowerBound][c] = true;
				
				// for 반복문을 사용해 사각형의 오른쪽 칸을 별로 갱신
				for (int r = lowerBound; r < upperBound; r++)
					stars[r][upperBound] = true;
				
				// for 반복문을 사용해 사각형의 아래쪽 칸을 별로 갱신
				for (int c = upperBound; c > lowerBound; c--)
					stars[upperBound][c] = true;
				
				// for 반복문을 사용해 사각형의 왼쪽 칸을 별로 갱신
				for (int r = upperBound; r > lowerBound; r--)
					stars[r][lowerBound] = true;
			}
		}
		
		// for 반복문을 사용해 각 칸을 순회
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				
				// 해당 칸이 별인 경우 별을 출력
				if (stars[r][c]) {
					out.write("*");
					
				// 해당 칸이 빈 칸인 경우 빈 칸을 출력
				} else {
					out.write(" ");
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