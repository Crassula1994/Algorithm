package silver5.num10815;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자 카드의 개수를 변수 inLength에 할당
		int inLength = Integer.parseInt(in.readLine());
		
		// 숫자 카드를 저장할 Set 객체 cardSet 초기화
		Set<Integer> cardSet = new HashSet<>();
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 숫자 카드를 순회
		for (int i = 0; i < inLength; i++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 숫자 카드를 변수 card에 할당
			int card = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 해당 카드를 추가
			cardSet.add(card);
		}
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 조회해야 할 숫자 카드의 개수를 변수 outLength에 할당
		int outLength = Integer.parseInt(in.readLine());
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 숫자 카드를 조회
		for (int j = 0; j < outLength; j++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 숫자 카드를 변수 card에 할당
			int card = Integer.parseInt(st.nextToken());
			
			// cardSet에 해당 카드가 존재하는 경우 1을 출력
			if (cardSet.contains(card)) {
				out.write(1 + " ");
			
			// cardSet에 해당 카드가 존재하지 않는 경우 0을 출력
			} else {
				out.write(0 + " ");
			}
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}