package silver5.num11866;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// StringBuilder 객체를 불러와 변수 sb에 할당
		StringBuilder sb = new StringBuilder("<");
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 두 자연수를 각 변수에 할당
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		// 사람들로 구성된 원을 저장할 Queue 객체 circle 초기화
		Queue<Integer> circle = new LinkedList<>();
		
		// for 반복문을 사용해 Queue 객체에 사람을 추가
		for (int person = 1; person < n + 1; person++)
			circle.offer(person);
		
		// while 반복문을 사용해 모든 사람이 제거될 때까지 순회
		while (!circle.isEmpty()) {
			
			// for 반복문을 사용해 정해진 간격만큼의 인원을 넘기기
			for (int i = 0; i < k - 1; i++)				
				circle.offer(circle.poll());
			
			// poll() 및 append() 메서드를 사용해 뽑힌 인원을 변수 sb에 추가
			sb.append(circle.poll()).append(", ");
		}
		
		// delete() 및 append() 메서드를 사용해 마지막 반점 제거 및 괄호를 변수 sb에 추가
		sb.delete(sb.length() - 2, sb.length());
		sb.append(">");
		
		// toString() 및 write() 메서드를 사용해 요세푸스 순열을 출력
		out.write(sb.toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}