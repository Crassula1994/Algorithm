package silver3.num28356;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 고사실의 크기를 각 변수에 할당
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		
		// 고사실이 한 칸인 경우 시험지는 1종류만 사용하므로 1을 두 번 출력
		if (height == 1 && width == 1) {
			out.write(1 + "\n" + 1);
		
		// 고사실의 행이나 열이 한 줄인 경우
		} else if (height == 1 || width == 1) {
			
			// write() 메서드를 사용해 시험지는 2종류만 사용하므로 2를 출력
			out.write(2 + "\n");
			
			// for 반복문을 사용해 각 칸의 시험지를 출력
			for (int cell = 0; cell < height * width; cell++) {
				out.write((cell % 2 == 0) ? 1 + " " : 2 + " ");
				
				// 열이 한 칸인 경우 줄바꿈을 출력
				if (width == 1)
					out.newLine();
			}
			
		// 고사실의 행과 열이 모두 두 줄 이상인 경우
		} else {
			
			// write() 메서드를 사용해 시험지는 4종류만 사용하므로 4를 출력
			out.write(4 + "\n");
			
			// for 반복문을 사용해 고사실의 각 칸을 순회
			for (int r = 0; r < height; r++) {
				for (int c = 0, paperNum = 0; c < width; c++) {
					
					// 해당 칸에서 배부될 시험지의 번호를 갱신
					paperNum = (r % 2 == 0) ? 1 : 3;
					paperNum = (c % 2 == 0) ? paperNum : paperNum + 1;
					
					// write() 메서드를 사용해 해당 칸에서 배부될 시험지의 번호를 출력
					out.write(paperNum + " ");
				}
				
				// newLine() 메서드를 사용해 줄바꿈 출력
				out.newLine();
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}