package bronze3.num10102;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 심사위원의 수를 변수 judgeNum에 할당
		int judgeNum = Integer.parseInt(in.readLine());
		
		// readLine() 메서드를 사용해 입력 받은 투표 결과를 변수 results에 할당
		String results = in.readLine();
		
		// A와 B의 투표 수를 저장할 각 변수 초기화
		int countA = 0;
		int countB = 0;
		
		// for 반복문을 사용해 각 투표 결과를 순회
		for (int idx = 0; idx < judgeNum; idx++) {
			
			// charAt() 메서드를 사용해 각 투표 결과를 변수 result에 할당
			char result = results.charAt(idx);
			
			// A에게 투표한 경우 A의 투표 수 갱신
			if (result == 'A') {
				countA++;
				
			// B에게 투표한 경우 B의 투표 수 갱신
			} else {
				countB++;
			}
		}
		
		// A가 받은 표가 B보다 많은 경우 'A'를 출력
		if (countA > countB) {
			out.write("A");
			
		// B가 받은 표가 A보다 많은 경우 'B'를 출력
		} else if (countA < countB) {
			out.write("B");
			
		// A와 B의 투표 수가 같은 경우 'Tie'를 출력
		} else {
			out.write("Tie");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}