package bronze1.num23841;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 그림의 세로 길이와 가로 길이를 각 변수에 할당
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		
		// 데칼코마니 한 그림을 저장할 2차원 배열 painting 초기화
		char[][] painting = new char[height][width];
		
		// for 반복문을 사용해 입력 받은 그림을 2차원 배열 painting에 저장
		for (int r = 0; r < height; r++)
			painting[r] = in.readLine().toCharArray();
		
		// for 반복문을 사용해 각 그림의 칸을 순회
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++) {
				
				// 해당 위치가 빈 곳인 경우 다음 칸을 순회
				if (painting[r][c] == '.')
					continue;
				
				// 해당 물감의 데칼코마니 결과를 갱신
				painting[r][width - c - 1] = painting[r][c];
			}
		}
		
		// for 반복문을 사용해 데칼코마니한 그림을 출력
		for (int r = 0; r < height; r++) {
			out.write(painting[r]);
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}