package gold5.num02668;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

// Main 클래스 정의
public class Main {
	
	// 각 정수를 저장할 표, 각 정수의 선택 여부를 나타낼 각 배열 초기화
	static int[] table;
	static boolean[] selected;
	
	// 최대로 뽑힌 각 정수를 저장할 List 객체 numberList 초기화
	static List<Integer> numberList = new ArrayList<>();
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 정수를 변수 number에 할당
		int number = Integer.parseInt(in.readLine());
		
		// 각 정수를 저장할 표, 각 정수의 선택 여부를 나타낼 각 배열 초기화
		table = new int[number + 1];
		selected = new boolean[number + 1];
		
		// for 반복문을 사용해 입력 받은 정수를 배열 table에 저장
		for (int idx = 1; idx < table.length; idx++)
			table[idx] = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 숫자를 순회
		for (int idx = 1; idx <= number; idx++) {
			
			// 해당 숫자를 선택한 것으로 처리
			selected[idx] = true;
			
			// numberSelector() 메서드를 호출해 최대로 뽑을 수 있는 정수들의 개수를 갱신
			numberSelector(idx, idx);
			
			// 해당 숫자를 선택하지 않은 것으로 처리
			selected[idx] = false;
		}
		
		// size() 및 write() 메서드를 사용해 최대로 뽑을 수 있는 정수들의 개수를 출력
		out.write(numberList.size() + "\n");
		
		// for 반복문을 사용해 뽑힌 정수들을 차례로 출력
		for (int idx = 0; idx < numberList.size(); idx++)
			out.write(numberList.get(idx) + "\n");
			
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// numberSelector() 메서드 정의
	public static void numberSelector(int currentNum, int targetNum) {

		// 현재 숫자에 담긴 값이 목표로 하는 숫자와 동일한 경우
		if (table[currentNum] == targetNum) {
			
			// add() 메서드를 사용해 목표로 하는 숫자를 numberList에 추가 후 메서드 종료
			numberList.add(targetNum);
			return;
		}
		
		// 목표로 하는 숫자에 도달할 수 없는 경우 메서드 종료
		if (selected[table[currentNum]])
			return;
		
		// 현재 숫자에 담긴 정수를 선택한 것으로 처리
		selected[table[currentNum]] = true;
		
		// numberSelector() 메서드 재귀 호출
		numberSelector(table[currentNum], targetNum);

		// 현재 숫자에 담긴 정수를 선택하지 않은 것으로 처리
		selected[table[currentNum]] = false;
	}
}