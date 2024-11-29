package silver4.num13015;

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
		
		// 별을 출력할 크기를 계산해 각 변수에 할당
		int height = 2 * number - 1;
		int width = 4 * number - 3;
		
		// for 반복문을 사용해 각 줄을 순회
		for (int r = 0; r < height; r++) {
			
			// 해당 줄에서 값을 출력할 칸의 개수를 계산해 변수 lineWidth에 할당
			int lineWidth = (r < number) ? width - r : width - height + r + 1;
			
			// for 반복문을 사용해 각 칸을 순회
			for (int c = 0; c < lineWidth; c++) {
				
				// 첫 번째 줄 또는 마지막 줄인 경우
				if (r == 0 || r == height - 1) {
					
					// 별을 출력해야 하는 곳인 경우 별을 출력
					if (c < number || c >= lineWidth - number) {
						out.write("*");
						
					// 빈 칸을 출력해야 하는 곳인 경우 빈 칸을 출력
					} else {
						out.write(" ");
					}
					
				// 중간 위쪽에 위치한 줄인 경우
				} else if (r < number) {
					
					// 별을 출력해야 하는 곳인 경우 별을 출력
					if (c == r || c == r + number - 1
							|| c == lineWidth - number || c == lineWidth - 1) {
						out.write("*");
						
					// 빈 칸을 출력해야 하는 곳인 경우 빈 칸을 출력
					} else {
						out.write(" ");
					}
					
				// 중간 아래쪽에 위치한 줄인 경우
				} else {
					
					// 별을 출력해야 하는 곳인 경우 별을 출력
					if (c == height - r - 1 || c == height - r + number - 2
							|| c == lineWidth - number || c == lineWidth - 1) {
						out.write("*");
						
					// 빈 칸을 출력해야 하는 곳인 경우 빈 칸을 출력
					} else {
						out.write(" ");
					}
				}
			}
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}