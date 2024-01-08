package bronze2.num10804;

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
		
		// 각 카드의 배치를 저장할 배열 cards 초기화
		int[] cards = new int[21];
		
		// for 반복문을 사용해 각 카드의 위치를 초기화
		for (int idx = 1; idx < cards.length; idx++)
			cards[idx] = idx;
		
		// for 반복문을 사용해 입력 받은 각 구간을 순회
		for (int section = 0; section < 10; section++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 시작 위치와 끝 위치를 각 변수에 할당
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			// for 반복문을 사용해 값을 교체할 각 위치의 값을 순회
			for (int idx = start; idx <= start + (end - start) / 2; idx++) {
				
				// 변수 temp를 활용해 두 위치의 값을 교체
				int temp = cards[idx];
				cards[idx] = cards[end + start - idx];
				cards[end + start - idx] = temp;
			}
		}
		
		// for 반복문을 사용해 각 카드들의 배치를 출력
		for (int idx = 1; idx < cards.length; idx++)
			out.write(cards[idx] + " ");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}