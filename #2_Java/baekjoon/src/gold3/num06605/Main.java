package gold3.num06605;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Main 클래스 정의
public class Main {
	
	// 소박한 숫자(Humble Number)를 저장할 List 객체 humbleNumbers 초기화
	static List<Integer> humbleNumbers = new ArrayList<>();
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// humbleNumberGenerator() 메서드를 호출해 소박한 숫자를 humbleNumbers에 저장
		humbleNumberGenerator(1, 2);
		
		// sort() 메서드를 사용해 소박한 숫자를 
		Collections.sort(humbleNumbers);
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// readLine() 및 parseInt() 메서드를 사용해 찾고자 하는 소박한 숫자의 순서를 변수 targetOrder에 할당
			int targetOrder = Integer.parseInt(in.readLine());
			
			// 모든 테스트 케이스를 순회한 경우 반복문 탈출
			if (targetOrder == 0)
				break;
			
			// suffixFinder(), get(), format(), write() 메서드를 사용해 해당 순서의 소박한 숫자를 정해진 형식으로 출력
			out.write(String.format("The %d%s humble number is %d.\n",
					targetOrder, suffixFinder(targetOrder % 100), humbleNumbers.get(targetOrder - 1)));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// humbleNumberGenerator() 메서드 정의
	public static void humbleNumberGenerator(long curNumber, int multiplier) {
		
		// 현재 소박한 숫자가 5842번째 소박한 숫자보다 큰 경우 메서드 종료
		if (curNumber > 2000000000)
			return;
		
		// add() 메서드를 사용해 현재 소박한 숫자를 humbleNumbers에 추가
		humbleNumbers.add((int) curNumber);
		
		// switch 조건문을 사용해 humbleNumberGenerator() 메서드 재귀 호출
		switch (multiplier) {
			case 2:
				humbleNumberGenerator(curNumber * 2, 2);
			case 3:
				humbleNumberGenerator(curNumber * 3, 3);
			case 5:
				humbleNumberGenerator(curNumber * 5, 5);
			default:
				humbleNumberGenerator(curNumber * 7, 7);
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// suffixFinder() 메서드 정의
	public static String suffixFinder(int targetOrder) {
		
		// 'st'를 붙여야 하는 경우 'st'를 반환
		if (targetOrder % 10 == 1 && targetOrder != 11)
			return "st";
		
		// 'nd'를 붙여야 하는 경우 'nd'를 반환
		if (targetOrder % 10 == 2 && targetOrder != 12)
			return "nd";
		
		// 'rd'를 붙여야 하는 경우 'rd'를 반환
		if (targetOrder % 10 == 3 && targetOrder != 13)
			return "rd";
		
		// 'th'를 붙여야 하는 경우 'th'를 반환
		return "th";
	}
}