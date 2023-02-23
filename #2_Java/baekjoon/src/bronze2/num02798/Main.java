package bronze2.num02798;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 필요한 멤버 변수 및 배열 선언
	static int cardNum;
	static int targetNum;
	static int[] cards;
	static boolean[] selected;
	static int answer = Integer.MIN_VALUE;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 카드의 수, 카드합의 목표를 각각의 변수에 할당
		cardNum = Integer.parseInt(st.nextToken());
		targetNum = Integer.parseInt(st.nextToken());

		// 각 카드의 값을 저장할 배열 cards 초기화
		cards = new int[cardNum];
		
		// 카드의 선택 여부를 나타내는 배열 selected 초기화
		selected = new boolean[cardNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 카드값을 배열 cards에 저장
		for (int idx = 0; idx < cards.length; idx++)
			cards[idx] = Integer.parseInt(st.nextToken());
		
		// cardComb() 메서드 호출
		cardComb(0, 3);

		// valueOf() 및 write() 메서드를 사용해 정답을 출력
		out.write(String.valueOf(answer));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// cardComb() 메서드 정의
	public static void cardComb(int startIdx, int selectedNum) {

		// 카드 조합에서 뽑고자 하는 카드가 0개인 경우
		if (selectedNum == 0) {
			
			// 각 카드의 총합을 저장할 변수 sum 초기화
			int sum = 0;
			
			// for 반복문을 사용해 selected 배열의 각 원소 순회
	        for (int idx = 0; idx < cardNum; idx++) {
	        	
	        	// 해당 카드를 선택한 경우 카드의 총합을 갱신
	            if (selected[idx])
	                sum += cards[idx];
	        }
			
			// 카드의 총합이 현재 저장된 정답보다 크고 목표 합보다 적은 경우 정답 갱신
			if (sum <= targetNum && sum > answer)
				answer = sum;

	        // return문을 사용해 메서드 종료
	        return;
	    }
	    
	    // for 반복문을 사용해 selected 배열의 각 원소 순회
	    for (int idx = startIdx; idx < cardNum; idx++) {
	        
	    	// 해당 카드를 선택 처리
	    	selected[idx] = true;
	        
	        // cardComb() 메서드 재귀 호출
	        cardComb(idx + 1, selectedNum - 1);
	        
	        // 선택 처리한 카드를 원래대로 복구
	        selected[idx] = false;
	    }
	}
}