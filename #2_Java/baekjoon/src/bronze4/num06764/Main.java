package bronze4.num06764;

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
		
		// 어군 탐지기가 측정한 깊이를 저장할 배열 depths 초기화
		int[] depths = new int[4];
		
		// for 반복문을 사용해 입력 받은 어군 탐지기가 측정한 깊이를 배열 depths에 저장
		for (int idx = 0; idx < depths.length; idx++)
			depths[idx] = Integer.parseInt(in.readLine());
		
		// 물고기가 상승하고 있는 경우 'Fish Rising' 출력
		if (depths[0] < depths[1] && depths[1] < depths[2] && depths[2] < depths[3]) {
			out.write("Fish Rising");
			
		// 물고기가 하강하고 있는 경우 'Fish Diving' 출력	
		} else if (depths[0] > depths[1] && depths[1] > depths[2] && depths[2] > depths[3]) {
			out.write("Fish Diving");
			
		// 물고기가 동일한 깊이에 있는 경우 'Fish At Constant Depth' 출력
		} else if (depths[0] == depths[1] && depths[1] == depths[2] && depths[2] == depths[3]) {
			out.write("Fish At Constant Depth");
			
		// 물고기가 존재하지 않는 경우 'No Fish' 출력
		} else {
			out.write("No Fish");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}