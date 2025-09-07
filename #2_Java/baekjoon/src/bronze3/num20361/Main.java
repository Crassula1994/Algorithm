package bronze3.num20361;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 공을 숨긴 컵의 위치, 컵의 위치를 뒤바꾼 횟수를 각 변수에 할당
		st.nextToken();
		int targetCup = Integer.parseInt(st.nextToken());
		int swapCount = Integer.parseInt(st.nextToken());
		
		// while 반복문을 사용해 각 컵을 뒤바꾼 횟수를 순회
		while (swapCount-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 바꾼 컵의 위치를 각 변수에 할당
			int cupA = Integer.parseInt(st.nextToken());
			int cupB = Integer.parseInt(st.nextToken());
			
			// 바꾼 컵 중 첫 번째 컵에 공이 들어 있었던 경우 공이 위치한 컵의 위치를 갱신
			if (targetCup == cupA) {
				targetCup = cupB;
				
			// 바꾼 컵 중 두 번째 컵에 공이 들어 있었던 경우 공이 위치한 컵의 위치를 갱신
			} else if (targetCup == cupB) {
				targetCup = cupA;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 공이 위치한 컵의 위치를 출력
		out.write(String.valueOf(targetCup));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}