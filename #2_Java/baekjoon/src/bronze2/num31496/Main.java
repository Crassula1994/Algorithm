package bronze2.num31496;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 아이템의 종류 수와 자작나무를 뜻하는 단어를 각 변수에 할당
		int categoryNum = Integer.parseInt(st.nextToken());
		String targetWord = st.nextToken();
		
		// 게임에서 삭제된 아이템의 총 수량을 저장할 변수 totalCount 초기화
		int totalCount = 0;
		
		// while 반복문을 사용해 각 아이템의 종류를 순회
		while (categoryNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 아이템의 이름과 수량을 각 변수에 할당
			String itemName = st.nextToken();
			int itemCount = Integer.parseInt(st.nextToken());
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(itemName, "_");
			
			// while 반복문을 사용해 각 단어를 순회
			while (st.hasMoreTokens()) {
				
				// 해당 단어가 자작나무를 뜻하는 단어인 경우 게임에서 삭제된 아이템의 총 수량을 갱신 후 반복문 탈출
				if (st.nextToken().equals(targetWord)) {
					totalCount += itemCount;
					break;
				}
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 게임에서 삭제된 아이템의 총 수량을 출력
		out.write(String.valueOf(totalCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}