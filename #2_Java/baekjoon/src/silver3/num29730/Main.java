package silver3.num29730;

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
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 임스가 공부한 기록의 개수를 변수 recordNum에 할당
		int recordNum = Integer.parseInt(in.readLine());
		
		// 임스가 푼 백준 문제와 백준 문제가 아닌 다른 공부 기록을 저장할 각 List 객체 초기화
		List<Integer> problems = new ArrayList<>();
		List<String> records = new ArrayList<>();
		
		// while 반복문을 사용해 각 기록을 순회
		while (recordNum-- > 0) {
			
			// readLine() 메서드를 사용해 입력 받은 공부 기록을 변수 record에 할당
			String record = in.readLine();
			
			// 공부 기록이 'boj.kr/'로 시작하는 경우
			if (record.startsWith("boj.kr/")) {
				
				// substring() 메서드를 사용해 공부 기록의 숫자 부분을 변수 numberStr에 할당
				String numberStr = record.substring(7);
				
				// 해당 부분이 백준 문제 번호에 해당하는 경우 problems에 추가 후 다음 기록을 순회
				if (isProblemNumber(numberStr)) {
					problems.add(Integer.parseInt(numberStr));
					continue;
				}
			}
			
			// add() 메서드를 사용해 백준 문제가 아닌 다른 공부 기록을 records에 저장
			records.add(record);
		}
		
		// sort() 메서드를 사용해 백준 문제 번호와 백준 문제가 아닌 다른 공부 기록을 정렬
		Collections.sort(problems);
		Collections.sort(records, (r1, r2) -> {
			if (r1.length() == r2.length())
				return r1.compareTo(r2);
			return r1.length() - r2.length();
		});
		
		// for 반복문을 사용해 백준 문제가 아닌 다른 공부 기록을 출력
		for (String record : records)
			out.write(record + "\n");
		
		// for 반복문을 사용해 백준 문제 공부 기록을 출력
		for (int number : problems)
			out.write("boj.kr/" + number + "\n");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// isProblemNumber() 메서드 정의
	public static boolean isProblemNumber(String numberStr) {
		
		// 숫자 부분이 존재하지 않거나 길이가 5글자를 초과하는 경우 false 반환
		if (numberStr.isEmpty() || numberStr.length() > 5)
			return false;
		
		// 숫자 부분이 숫자로만 구성되지 않은 경우 false 반환
		if (!numberStr.matches("\\d+"))
			return false;
		
		// parseInt() 메서드를 사용해 숫자 부분을 숫자로 변환한 결과를 변수 number에 할당
		int number = Integer.parseInt(numberStr);
		
		// 숫자 부분을 변환한 결과가 1 미만 30000 초과인 경우 false 반환
		if (number < 1 || number > 30000)
			return false;
		
		// 숫자 부분이 백준 문제 번호의 조건에 부합하는 경우 true 반환
		return true;
	}
}