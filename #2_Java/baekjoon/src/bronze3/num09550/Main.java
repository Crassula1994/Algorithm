package bronze3.num09550;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// 생일 파티에 참석할 수 있는 최대 아이들의 수를 저장할 변수 maxCount 초기화
			int maxCount = 0;
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 승택이가 갖고 있는 사탕의 종류의 수와
			행복해 하기 위해 필요한 사탕의 수를 각 변수에 할당 */
			int typeNum = Integer.parseInt(st.nextToken());
			int happyLimit = Integer.parseInt(st.nextToken());
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// while 반복문을 사용해 생일 파티에 참석할 수 있는 최대 아이들의 수를 갱신
			while (typeNum-- > 0)
				maxCount += Integer.parseInt(st.nextToken()) / happyLimit;
			
			// write() 메서드를 사용해 생일 파티에 참석할 수 있는 최대 아이들의 수를 출력
			out.write(maxCount + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}