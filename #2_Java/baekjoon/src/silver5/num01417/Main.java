package silver5.num01417;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 후보의 수 및 다솜이를 찍으려는 사람의 수를 각 변수에 할당
		int candiNum = Integer.parseInt(in.readLine());
		int voterSecured = Integer.parseInt(in.readLine());
		
		// 매수해야 하는 사람 수를 저장할 변수 voterCnt 초기화
		int voterCnt = 0;
		
		// 후보자가 1명이 아닌 경우
		if (candiNum > 1) {
			
			// 다른 유권자의 수를 저장할 PriorityQueue 객체 voters 초기화
			PriorityQueue<Integer> voters = new PriorityQueue<>(Collections.reverseOrder());
			
			// for 반복문을 사용해 각 유권자의 수를 순회하며 voters에 저장
			for (int v = 0; v < candiNum - 1; v++)
				voters.add(Integer.parseInt(in.readLine()));
			
			// while 반복문을 사용해 다솜이를 찍으려는 사람의 수가 가장 많을 때까지 순회
			while (voterSecured <= voters.peek()) {
				
				// poll() 및 add() 메서드를 사용해 가장 많은 유권자를 확보한 후보자의 유권자를 매수 처리
				voters.add(voters.poll() - 1);
				
				// 다솜이를 찍으려는 사람의 수 및 매수한 사람의 수 갱신
				voterSecured++;
				voterCnt++;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 매수해야 하는 사람 수를 출력
		out.write(String.valueOf(voterCnt));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}