package silver5.num11637;

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
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 후보자의 수를 변수 candidateNum에 할당
			int candidateNum = Integer.parseInt(in.readLine());
			
			// 최다 득표 수, 전체 득표 수를 저장할 각 변수 초기화
			int maxCount = 0;
			int totalCount = 0;
			
			// 최다 득표한 후보자의 번호를 저장할 List 객체 winners 초기화
			List<Integer> winners = new ArrayList<>();
			
			// for 반복문을 사용해 각 후보자를 순회
			for (int candidate = 1; candidate <= candidateNum; candidate++) {
				
				// readLine() 및 parseInt() 메서드를 사용해 입력 받은 해당 후보자의 득표 수를 변수 count에 할당
				int count = Integer.parseInt(in.readLine());
				
				// 전체 득표 수를 갱신
				totalCount += count;
				
				// 해당 후보자의 득표 수가 저장된 최다 득표 수보다 많은 경우
				if (count > maxCount) {
					
					// 최다 득표 수를 갱신
					maxCount = count;
					
					// clear() 및 add() 메서드를 사용해 winners를 초기화 후 해당 후보자를 추가
					winners.clear();
					winners.add(candidate);
					
				// 해당 후보자의 득표 수가 저장된 최다 득표 수와 같은 경우 해당 후보자를 winners에 추가
				} else if (count == maxCount) {
					winners.add(candidate);
				}
			}
			
			// 최다 득표자가 없는 경우 'no winner' 출력
			if (winners.size() > 1) {
				out.write("no winner");
				
			// 최다 득표자가 과반 수 득표를 한 경우 정해진 문구를 출력
			} else if (maxCount * 2 > totalCount) {
				out.write("majority winner " + winners.get(0));
				
			// 최다 득표자가 과반 수 득표를 하지 못한 경우 정해진 문구를 출력
			} else {
				out.write("minority winner " + winners.get(0));
			}
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}