package bronze1.num03035;

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
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 신문 기사의 크기 및 스캐너의 배율을 각 변수에 할당
		int row = Integer.parseInt(st.nextToken());
		int column = Integer.parseInt(st.nextToken());
		int zoomRow = Integer.parseInt(st.nextToken());
		int zoomColumn = Integer.parseInt(st.nextToken());
		
		// 신문 기사를 스캐너로 확대한 결과를 저장할 2차원 배열 result 초기화
		char[][] result = new char[row * zoomRow][column * zoomColumn];
		
		// for 반복문을 사용해 신문 기사의 각 행을 순회
		for (int r = 0; r < row; r++) {
			
			// readLine() 메서드를 사용해 입력 받은 신문 기사의 행을 변수 line에 할당
			String line = in.readLine();
			
			// for 반복문을 사용해 신문 기사의 각 글자를 순회
			for (int c = 0; c < column; c++) {
				
				// charAt() 메서드를 사용해 입력 받은 신문 기사의 글자를 변수 character에 할당
				char character = line.charAt(c);
				
				// for 반복문을 사용해 스캐너로 확대한 결과를 갱신
				for (int zr = r * zoomRow; zr < (r + 1) * zoomRow; zr++) {
					for (int zc = c * zoomColumn; zc < (c + 1) * zoomColumn; zc++)
						result[zr][zc] = character;
				}
			}
		}
		
		// for 반복문을 사용해 신문 기사를 확대한 결과의 각 행과 열을 출력
		for (int r = 0; r < row * zoomRow; r++) {
			for (int c = 0; c < column * zoomColumn; c++)
				out.write(result[r][c]);
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}