package bronze1.num17363;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 그림의 세로 및 가로 길이를 각 변수에 할당
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		
		// 입력 받은 그림 및 문자를 돌린 뒤의 결과를 저장할 각 2차원 배열 초기화
		char[][] drawing = new char[height][width];
		char[][] characters = {
				{'-', '|'}, {'|', '-'}, {'/', '\\'}, {'\\', '/'},
				{'^', '<'}, {'<', 'v'}, {'v', '>'}, {'>', '^'}
		};
		
		// 각 글자를 돌렸을 때의 모양을 저장할 Map 객체 results 초기화
		Map<Character, Character> results = new HashMap<>();
		
		// for 반복문을 사용해 각 글자를 돌렸을 때의 모양을 results에 저장
		for (int idx = 0; idx < characters.length; idx++)
			results.put(characters[idx][0], characters[idx][1]);
		
		// for 반복문을 사용해 입력 받은 그림을 2차원 배열 drawing에 저장
		for (int r = 0; r < height; r++)
			drawing[r] = in.readLine().toCharArray();
		
		// for 반복문을 사용해 입력 받은 그림을 넘어뜨렸을 때를 순회
		for (int c = width - 1; c >= 0; c--) {
			for (int r = 0; r < height; r++) {
				
				// 온점이거나 대문자 O인 경우 그대로 출력 후 다음 글자를 순회
				if (drawing[r][c] == '.' || drawing[r][c] == 'O') {
					out.write(drawing[r][c]);
					continue;
				}
				
				// get() 및 write() 메서드를 사용해 해당 글자를 돌린 결과를 출력
				out.write(results.get(drawing[r][c]));
			}
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}