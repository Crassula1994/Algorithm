package silver5.num11650;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 좌표의 개수를 변수 rowNum에 저장
		int rowNum = Integer.parseInt(in.readLine());
		
		// 각 좌표를 저장할 2차원 배열 coordinates 초기화
		int[][] coordinates = new int[rowNum][2];
		
		// for 반복문을 사용해 각 좌표를 순회
		for (int r = 0; r < rowNum; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 좌표를 배열 coordinates에 저장
			coordinates[r][0] = Integer.parseInt(st.nextToken());
			coordinates[r][1] = Integer.parseInt(st.nextToken());
		}
		
		// sort() 메서드를 사용해 2차원 배열을 정렬
		Arrays.sort(coordinates, (cd1, cd2) -> {
			return cd1[0] != cd2[0] ? cd1[0] - cd2[0] : cd1[1] - cd2[1];
		});
		
		// for 반복문을 사용해 정렬된 각 좌표를 출력
		for (int r = 0; r < rowNum; r++)
			out.write(coordinates[r][0] + " " + coordinates[r][1] + "\n");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}