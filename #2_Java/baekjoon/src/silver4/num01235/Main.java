package silver4.num01235;

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
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 학생의 수를 변수 studentNum에 할당
		int studentNum = Integer.parseInt(in.readLine());
		
		// 각 학생의 학생 번호를 저장할 배열 numbers 초기화
		String[] numbers = new String[studentNum];
		
		// for 반복문을 사용해 입력 받은 각 학생 번호를 배열 numbers에 추가
		for (int idx = 0; idx < numbers.length; idx++)
			numbers[idx] = in.readLine();
		
		// length() 메서드를 사용해 초기 자릿수 및 학생들의 학생 번호를 서로 다르게 만들 수 있는 자릿수를 저장할 각 변수 초기화
		int startLength = numbers[0].length();
		int minLength = startLength;
		
		// 줄인 학생 번호를 저장할 Set 객체 newNumbers 초기화
		Set<String> newNumbers = new HashSet<>();
		
		// for 반복문을 사용해 각 길이를 순회
		outer: for (int startIdx = 1; startIdx < startLength; startIdx++) {
			
			// for 반복문을 사용해 각 학생 번호를 순회
			for (String number : numbers) {
				
				// substring() 메서드를 사용해 새로운 번호를 newNumber에 할당
				String newNumber = number.substring(startIdx);
				
				// 이미 해당 번호가 존재하는 경우 반복문 탈출
				if (newNumbers.contains(newNumber))
					break outer;
				
				// add() 메서드를 사용해 해당 번호를 newNumbers에 저장
				newNumbers.add(newNumber);
			}
			
			// clear() 메서드를 사용해 newNumbers에 저장한 새로운 번호를 모두 제거
			newNumbers.clear();
			
			// 학생들의 학생 번호를 서로 다르게 만들 수 있는 자릿수를 갱신
			minLength--;
		}
		
		// valueOf() 및 write() 메서드를 사용해 학생 번호를 서로 다르게 만들 수 있는 자릿수를 출력
		out.write(String.valueOf(minLength));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}