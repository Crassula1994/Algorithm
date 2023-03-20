package bronze3.num09063;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 점의 개수를 변수 dotNum에 할당
		int dotNum = Integer.parseInt(in.readLine());
		
		// 옥구슬이 발견된 각 점의 최솟값과 최댓값을 저장할 각 변수 초기화
		int minWidth = Integer.MAX_VALUE;
		int maxWidth = Integer.MIN_VALUE;
		int minHeight = Integer.MAX_VALUE;
		int maxHeight = Integer.MIN_VALUE;
		
		// for 반복문을 사용해 각 점을 순회
		for (int d = 0; d < dotNum; d++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 점의 좌표를 각 변수에 할당
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			// 옥구슬이 발견된 각 점의 최솟값과 최댓값을 갱신
			minWidth = Math.min(x, minWidth);
			maxWidth = Math.max(x, maxWidth);
			minHeight = Math.min(y, minHeight);
			maxHeight = Math.max(y, maxHeight);
		}

		// valueOf() 및 write() 메서드를 사용해 최소 크기의 직사각형의 넓이를 출력
		out.write(String.valueOf((maxWidth - minWidth) * (maxHeight - minHeight)));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
    }
}