package bronze3.num02445;

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

		// 행의 길이 및 열의 길이를 계산해 각 변수에 저장
		int length = number * 2 - 1;
		int width = number * 2;
		
		// 왼쪽 끝과 오른쪽 끝 인덱스를 나타내는 각 변수 초기화
		int left = 1;
		int right = width - 2;
		
		// for 반복문을 사용해 각 행과 열을 차례로 순회
		for (int r = 0; r < length; r++) {
			for (int c = 0; c < width; c++) {
				
				// 왼쪽 끝 인덱스와 오른쪽 끝 인덱스 사이에 빈 칸을 출력
				if (c >= left && c <= right) {
					out.write(" ");
					
				// 나머지 공간에는 별을 출력
				} else {
					out.write("*");
				}
			}

			// 줄 바꿈을 출력
			out.write("\n");
			
			// 왼쪽 끝과 오른쪽 끝 인덱스를 조정
			left = (r < number - 1) ? left + 1 : left - 1;
			right = (r < number - 1) ? right - 1 : right + 1;
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}