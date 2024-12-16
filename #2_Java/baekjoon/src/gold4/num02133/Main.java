package gold4.num02133;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 벽의 가로 길이를 변수 width에 할당
		int width = Integer.parseInt(in.readLine());
		
		// 각 크기의 벽을 타일로 채우는 경우의 수를 저장할 배열 counts 초기화
		int[] counts = new int[width + 1];
		
		// 벽의 가로 길이가 짝수인 경우
		if ((width & 1) != 1) {
			
			// 벽의 가로 길이가 0일 때 경우의 수를 초기화
			counts[0] = 1;
			
			// for 반복문을 사용해 각 짝수 길이를 순회
			for (int idx = 2; idx <= width; idx += 2) {
				
				// 해당 크기의 벽을 타일로 채우는 경우의 수를 초기화
				counts[idx] = counts[idx - 2] * 3;
				
				// for 반복문을 사용해 해당 크기의 벽을 타일로 채우는 경우의 수를 갱신
				for (int len = idx - 4; len >= 0; len -= 2)
					counts[idx] += counts[len] * 2;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 벽을 타일로 채우는 경우의 수를 출력
		out.write(String.valueOf(counts[width]));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}