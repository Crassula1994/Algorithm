package silver3.num25370;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

// Main 클래스 정의
public class Main {
	
	// 선택할 카드 개수를 저장할 변수 cardNum 초기화
	static int cardNum;
	
	// 카드 숫자 곱을 저장할 Set 객체 results 초기화
	static Set<Integer> results = new HashSet<>();
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 선택할 카드 개수를 변수 cardNum에 할당
		cardNum = Integer.parseInt(in.readLine());
		
		// cardMultiplier() 메서드를 호출해 카드 숫자 곱이 될 수 있는 숫자를 갱신
		cardMultiplier(0, 1);
		
		// size(), valueOf(), write() 메서드를 사용해 카드 숫자 곱이 될 수 있는 수의 개수를 출력
		out.write(String.valueOf(results.size()));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// cardMultiplier() 메서드 정의
	public static void cardMultiplier(int selected, int result) {
		
		// 모든 카드를 선택한 경우 카드 숫자 곱을 results에 저장 후 메서드 종료
		if (selected == cardNum) {
			results.add(result);
			return;
		}
		
		// for 반복문을 사용해 각 숫자 카드를 선택한 결과를 상정해 cardMultiplier() 메서드 재귀 호출
		for (int card = 1; card < 10; card++)
			cardMultiplier(selected + 1, result * card);
	}
}