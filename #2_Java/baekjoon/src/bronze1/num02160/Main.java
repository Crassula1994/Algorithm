package bronze1.num02160;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 그림의 개수를 변수 pictureNum에 할당
		int pictureNum = Integer.parseInt(in.readLine());
		
		// 각 그림을 저장할 3차원 배열 pictures 초기화
		char[][][] pictures = new char[pictureNum + 1][5][7];
		
		// 가장 작은 서로 다른 칸의 개수 및 가장 비슷한 두 그림의 번호를 저장할 각 변수 초기화
		int minCount = 36;
		int picture1 = 0;
		int picture2 = 0;
		
		// for 반복문을 사용해 각 그림을 순회
		for (int pic = 1; pic <= pictureNum; pic++) {
			
			// for 반복문을 사용해 각 그림의 행을 순회
			for (int r = 0; r < 5; r++) {
				
				// readLine() 메서드를 사용해 입력 받은 그림의 행을 변수 line에 할당
				String line = in.readLine();
				
				// for 반복문을 사용해 각 그림의 색을 3차원 배열 pictures에 저장
				for (int c = 0; c < 7; c++)
					pictures[pic][r][c] = line.charAt(c);
			}
		}
		
		// for 반복문을 사용해 각 그림 쌍을 순회
		for (int pic1 = 1; pic1 < pictureNum; pic1++) {
			for (int pic2 = pic1 + 1; pic2 <= pictureNum; pic2++) {
				
				// 서로 다른 칸의 개수를 저장할 변수 count 초기화
				int count = 0;
				
				// for 반복문을 사용해 각 그림의 행과 열을 순회
				for (int r = 0; r < 5; r++) {
					for (int c = 0; c < 7; c++) {
						
						// 해당 그림의 칸의 색이 다른 경우 서로 다른 칸의 개수 갱신
						if (pictures[pic1][r][c] != pictures[pic2][r][c])
							count++;
					}
				}
				
				// 서로 다른 칸의 개수가 저장된 서로 다른 칸의 개수보다 작은 경우 
				if (count < minCount) {
					
					// 가장 작은 서로 다른 칸의 개수 및 그림의 번호 갱신
					minCount = count;
					picture1 = pic1;
					picture2 = pic2;
				}
			}
		}
		
		// write() 메서드를 사용해 가장 비슷한 두 그림의 번호를 출력
		out.write(picture1 + " " + picture2);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}