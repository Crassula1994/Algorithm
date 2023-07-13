package silver4.num01969;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
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

		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 DNA의 수 및 문자열의 길이를 각 변수에 할당
		int dnaNum = Integer.parseInt(st.nextToken());
		int stringLen = Integer.parseInt(st.nextToken());

		// 성의 상태를 저장할 2차원 배열 castle 초기화
		castle = new int[height][width];
		
		// for 반복문을 사용해 배열 castle의 각 행을 순회
		for (int r = 0; r < height; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 성의 상태를 2차원 배열 castle에 저장
			for (int c = 0; c < width; c++)
				castle[r][c] = Integer.parseInt(st.nextToken());
		}
		
		// timeCalculator() 메서드를 호출해 공주에게 도달할 수 있는 최단 시간을 계산하고 변수 minTime에 할당
		int minTime = timeCalculator(0, 0);

		// 용사가 공주를 시간 내에 구출할 수 없는 경우 'Fail' 출력
		if (minTime > limit || minTime == -1) {
			out.write("Fail");

		// 용사가 공주를 시간 내에 도달할 수 있는 경우 도달할 수 있는 최단 시간을 출력
		} else {
			out.write(String.valueOf(minTime));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}