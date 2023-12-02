package bronze2.num17608;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 막대기의 개수를 변수 stickNum에 할당
		int stickNum = Integer.parseInt(in.readLine());
		
		// 막대기의 높이를 저장할 배열 heights 초기화
		int[] heights = new int[stickNum];
		
		// for 반복문을 사용해 입력 받은 막대기의 높이를 배열 heights에 저장
		for (int idx = 0; idx < heights.length; idx++)
			heights[idx] = Integer.parseInt(in.readLine());
		
		// 지금까지 나온 가장 높은 막대기의 높이 및 보이는 막대기의 수를 저장할 각 변수를 초기화
		int maxHeight = 0;
		int count = 0;
		
		// for 반복문을 사용해 각 막대기를 거꾸로 순회
		for (int idx = heights.length - 1; idx >= 0; idx--) {
			
			// 해당 막대기의 높이를 변수 height에 할당
			int height = heights[idx];
			
			// 해당 막대기의 높이가 지금까지 나온 가장 높은 막대기의 높이보다 높은 경우
			if (height > maxHeight) {
				
				// 지금까지 나온 가장 높은 막대기의 높이 및 보이는 막대기의 수를 갱신
				maxHeight = height;
				count++;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 보이는 막대기의 수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}