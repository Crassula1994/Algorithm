package gold4.num01846;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 게임판의 크기를 변수 size에 할당
		int size = Integer.parseInt(in.readLine());
		
		// 게임판의 크기가 3인 경우 -1을 출력
		if (size == 3) {
			out.write(String.valueOf(-1));
			
		// 게임판의 크기가 짝수인 경우
		} else if (size % 2 == 0) {
			
			// for 반복문을 사용해 각 줄을 순회
			for (int line = 1; line <= size; line++) {
				
				// 각 줄의 위치에 따라 배치할 칸의 번호를 출력
				if (line == size / 2) {
					out.write(String.valueOf(1));
				} else if (line == size / 2 + 1) {
					out.write(String.valueOf(size));
				} else if (line < size / 2) {
					out.write(String.valueOf(line + 1));
				} else {
					out.write(String.valueOf(line - 1));
				}
				
				// newLine() 메서드를 사용해 줄바꿈을 출력
				out.newLine();
			}
			
		// 게임판의 크기가 홀수인 경우
		} else {
			
			// for 반복문을 사용해 각 줄을 순회
			for (int line = 1; line <= size; line++) {
				
				// 각 줄의 위치에 따라 배치할 칸의 번호를 출력
				if (line == size / 2 + 1) {
					out.write(String.valueOf(1));
				} else if (line == size / 2 + 2) {
					out.write(String.valueOf(size));
				} else if (line < size / 2 + 1) {
					out.write(String.valueOf(line + 1));
				} else {
					out.write(String.valueOf(line - 1));
				}
				
				// newLine() 메서드를 사용해 줄바꿈을 출력
				out.newLine();
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}