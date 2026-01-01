package bronze3.num28214;

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
		
		/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 빵 묶음의 개수, 빵 묶음에 속한 빵의 개수,
		팔 수 없는 빵 묶음의 크림이 들어 있지 않은 최소 빵의 개수를 각 변수에 할당 */
		int bundleNum = Integer.parseInt(st.nextToken());
		int pieceNum = Integer.parseInt(st.nextToken());
		int pieceLimit = Integer.parseInt(st.nextToken());
		
		// 팔 수 있는 빵 묶음의 수를 저장할 변수 count 초기화
		int count = 0;
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// while 반복문을 사용해 각 빵 묶음을 순회
		while (bundleNum-- > 0) {
			
			// 크림이 없는 빵의 개수를 저장할 변수 pieceCount 초기화
			int pieceCount = 0;
			
			// for 반복문을 사용해 각 빵을 순회
			for (int piece = 0; piece < pieceNum; piece++) {
				
				// 해당 빵에 크림이 없는 경우 크림이 없는 빵의 개수를 갱신
				if (st.nextToken().equals("0"))
					pieceCount++;
			}
			
			// 해당 빵 묶음을 팔 수 있는 경우 팔 수 있는 빵 묶음의 수를 갱신
			if (pieceCount < pieceLimit)
				count++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 팔 수 있는 빵 묶음의 수를 출력
		out.write(String.valueOf(count));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}