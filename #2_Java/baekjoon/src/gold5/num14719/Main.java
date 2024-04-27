package gold5.num14719;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 2차원 세계의 세로 길이와 가로 길이를 각 변수에 할당
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		
		// 빗물이 고이는 총량을 저장할 totalAmount 초기화
		int totalAmount = 0;
		
		// 2차원 세계에 쌓인 블록의 상태를 저장할 2차원 배열 blocks 초기화
		boolean[][] blocks = new boolean[height][width];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 2차원 세계의 가로 길이를 차례로 순회
		for (int c = 0; c < width; c++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 블록의 높이를 변수 count에 할당
			int count = Integer.parseInt(st.nextToken());
			
			// for 반복문을 사용해 블록이 쌓인 상태를 갱신
			for (int r = height - 1; r >= height - count; r--)
				blocks[r][c] = true;
		}
		
		// for 반복문을 사용해 2차원 세계의 세로 길이를 차례로 순회
		for (int r = 0; r < height; r++) {
			
			// 블록이 존재하는 마지막 위치를 저장할 변수 lastIdx 초기화
			int lastIdx = -1;
			
			// for 반복문을 사용해 2차원 세계의 가로 길이를 차례로 순회
			for (int c = 0; c < width; c++) {
				
				// 해당 칸에 블록이 존재하는 경우
				if (blocks[r][c]) {
					
					// 이전에 블록이 존재한 경우 빗물이 고이는 총량을 갱신
					if (lastIdx != -1)
						totalAmount += c - lastIdx - 1;
					
					// 블록이 존재하는 마지막 위치를 갱신
					lastIdx = c;
				}
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 빗물이 고이는 총량을 출력
		out.write(String.valueOf(totalAmount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}