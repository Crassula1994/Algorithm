package silver3.num25706;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 도로의 길이를 변수 length에 할당
		int length = Integer.parseInt(in.readLine());
		
		// 각 칸의 높이 및 각 칸에서 총 몇 개의 칸을 밟게 되는지를 저장할 각 배열 초기화
		int[] heights = new int[length];
		int[] counts = new int[length];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 칸의 높이를 배열 heights에 저장
		for (int idx = 0; idx < heights.length; idx++)
			heights[idx] = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 각 칸을 거꾸로 순회
		for (int idx = length - 1; idx >= 0; idx--) {
			
			// 해당 칸이 마지막 칸이거나 점프했을 때 도로 밖으로 나가는 경우 밟게 되는 칸의 개수를 갱신
			if (idx == length - 1 || idx + heights[idx] + 1 >= length) {
				counts[idx] = 1;
			
			// 해당 칸에 점프대가 존재하지 않는 경우 밟게 되는 칸의 개수를 갱신
			} else if (heights[idx] == 0) {
				counts[idx] = counts[idx + 1] + 1;
				
			// 해당 칸에 점프대가 존재하는 경우 밟게 되는 칸의 개수를 갱신
			} else {
				counts[idx] = counts[idx + heights[idx] + 1] + 1;
			}
		}
		
		// for 반복문을 사용해 각 칸에서 총 몇 개의 칸을 밟게 되는지를 출력
		for (int count : counts)
			out.write(count + " ");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}