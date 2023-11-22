package silver5.num11931;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 숫자를 내림차순으로 정렬할 PriorityQueue 객체 sorter 초기화
		PriorityQueue<Integer> sorter = new PriorityQueue<>((n1, n2) -> {
			return n2 - n1;
		});
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수의 개수를 변수 numCnt에 할당
		int numCnt = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 입력 받은 숫자를 sorter에 저장
		for (int n = 0; n < numCnt; n++)
			sorter.offer(Integer.parseInt(in.readLine()));

		// while 반복문을 사용해 내림차순으로 정렬한 결과를 출력
		while (!sorter.isEmpty())
			out.write(sorter.poll() + "\n");

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}