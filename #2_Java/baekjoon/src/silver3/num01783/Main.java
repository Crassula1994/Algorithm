package silver3.num01783;

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
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 체스판의 세로 길이와 가로 길이를 각 변수에 할당
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		
		// 병든 나이트가 방문할 수 있는 칸의 개수를 저장할 변수 maxCount 초기화
		int maxCount = 0;

		// 체스판의 세로 길이가 1인 경우 병든 나이트가 방문할 수 있는 칸의 개수는 1이므로 이를 갱신
		if (height == 1) {
			maxCount = 1;
		
		// 체스판의 세로 길이가 2인 경우
		} else if (height == 2) {
			
			// min() 메서드를 사용해 병든 나이트가 방문할 수 있는 칸의 개수를 갱신
			maxCount = Math.min((width + 1) / 2, 4);
		
		// 체스판의 세로 길이가 3 이상인 경우
		} else {
			
			// 체스판의 가로 길이가 7 미만인 경우
			if (width < 7) {
				
				// min() 메서드를 사용해 병든 나이트가 방문할 수 있는 칸의 개수를 갱신
				maxCount = Math.min(width, 4);
				
			// 체스판의 가로 길이가 7 이상인 경우 나이트가 방문할 수 있는 칸의 개수는 가로 길이 - 2이므로 이를 갱신
			} else {
				maxCount = width - 2;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 병든 나이트가 방문할 수 있는 칸의 개수를 출력
		out.write(String.valueOf(maxCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}