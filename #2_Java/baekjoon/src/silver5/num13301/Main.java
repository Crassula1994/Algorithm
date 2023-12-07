package silver5.num13301;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 타일의 개수를 변수 tileNum에 할당
		int tileNum = Integer.parseInt(in.readLine());

		// 타일이 1개인 경우 직사각형의 둘레를 출력
		if (tileNum == 1) {
			out.write(String.valueOf(4));
			
		// 타일이 2개 이상인 경우
		} else {
			
			// 각 타일의 크기를 저장할 배열 tiles 초기화
			long[] tiles = new long[tileNum + 1];
			
			// 첫 번째 타일과 두 번째 타일의 크기를 초기화
			tiles[1] = 1;
			tiles[2] = 1;
			
			// for 반복문을 사용해 각 타일의 크기를 갱신
			for (int idx = 3; idx < tiles.length; idx++)
				tiles[idx] = tiles[idx - 1] + tiles[idx - 2];
			
			// 직사각형의 둘레를 계산해 변수 circumference에 할당
			long circumference = tiles[tileNum] * 4 + tiles[tileNum - 1] * 2;
			
			// valueOf() 및 write() 메서드를 사용해 직사각형의 둘레를 출력
			out.write(String.valueOf(circumference));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}