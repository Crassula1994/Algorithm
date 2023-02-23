package silver2.num02477;

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

		// readLine() 및 parseInt() 메서드를 사용해 단위 면적에 자라는 참외의 개수를 변수 unitQuantity에 할당
		int unitQuantity = Integer.parseInt(in.readLine());
		
		// 육각형의 방향과 길이를 저장할 2차원 배열 farmland 초기화
		int[][] farmland = new int[6][2];
		
		// 농장의 큰 직사각형의 가로와 세로의 길이 및 인덱스를 나타내는 각 변수 초기화
		int longWidth = 0;
		int longHeight = 0;
		int longWidthIdx = 0;
		int longHeightIdx = 0;
		
		// for 반복문을 사용해 배열 farmland의 각 원소를 순회
		for (int idx = 0; idx < farmland.length; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 farmland 배열에 각각 저장
			farmland[idx][0] = Integer.parseInt(st.nextToken()); 
			farmland[idx][1] = Integer.parseInt(st.nextToken());
			
			// 서쪽 또는 동쪽으로 이동하는 경우 최대 가로 길이 갱신
			if (farmland[idx][0] < 3) {
				if (farmland[idx][1] > longWidth) {
					longWidth = farmland[idx][1];
					longWidthIdx = idx;
				}
				
			// 남쪽 또는 북쪽으로 이동하는 경우 최대 세로 길이 갱신
			} else {
				if (farmland[idx][1] > longHeight) {
					longHeight = farmland[idx][1];
					longHeightIdx = idx;
				}
			}
		}
		
		// 농장의 작은 직사각형의 넓이를 도출
		int	shortBox = farmland[(longWidthIdx + 3) % 6][1] * farmland[(longHeightIdx + 3) % 6][1];
		
		// 참외밭의 참외 수를 나타내는 변수 totalQuantity 도출
		int totalQuantity = unitQuantity * (longWidth * longHeight - shortBox);

		// valueOf() 및 write() 메서드를 사용해 참외밭의 참외 수 출력
		out.write(String.valueOf(totalQuantity));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}