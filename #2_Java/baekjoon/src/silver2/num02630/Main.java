package silver2.num02630;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 전체 종이의 색상을 저장할 2차원 배열 paper 초기화
	static int[][] paper;
	
	// 하얀색 색종이 및 푸른색 색종이의 값을 저장할 각 변수 초기화
	static int whitePaper = 0; 
	static int bluePaper = 0;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 한 변의 길이를 변수 length에 할당
		int length = Integer.parseInt(in.readLine());
		
		// 전체 종이의 색상을 저장할 2차원 배열 paper 초기화
		paper = new int[length][length];
		
		// for 반복문을 사용해 배열 paper의 각 행을 순회
		for (int r = 0; r < length; r++) {
			
			// StringTokernizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 배열 paper의 각 열을 순회하며 색상을 저장
			for (int c = 0; c < length; c++)
				paper[r][c] = Integer.parseInt(st.nextToken());
		}
		
		// paperCounter() 메서드를 호출해 하얀색 색종이 및 푸른색 색종이의 개수를 갱신
		paperCounter(0, 0, length);
			
		// write() 메서드를 사용해 하얀색 색종이 및 푸른색 색종이의 개수를 출력
		out.write(whitePaper + "\n" + bluePaper);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// paperCounter() 메서드 정의
	public static void paperCounter(int startRow, int startCol, int length) {
		
		// 왼쪽 끝의 색상을 변수 check에 할당
		int check = paper[startRow][startCol];
		
		// for 반복문을 사용해 전체의 행과 열을 순회
		outer: for (int r = startRow; r < startRow + length; r++) {
			for (int c = startCol; c < startCol + length; c++) {
				
				// 색상이 다른 경우 반복문 탈출
				if (paper[r][c] != check)
					break outer;
				
				// 색상이 모두 같은 경우
				if (r == startRow + length - 1 && c == startCol + length - 1) {
					
					// 하얀색인지 파란색인지에 따라 색종이의 개수 갱신
					if (check == 0) whitePaper++;
					else bluePaper++;
					
					// 함수 종료
					return;
				}
			}
		}
		
		// 자른 색종이의 크기를 변수 newLength에 할당
		int newLength = length / 2;
		
		// 사분면으로 나누어 각각 paperCounter() 메서드 재귀 호출
		paperCounter(startRow, startCol, newLength);
		paperCounter(startRow + newLength, startCol, newLength);
		paperCounter(startRow, startCol + newLength, newLength);
		paperCounter(startRow + newLength, startCol + newLength, newLength);
	}
}