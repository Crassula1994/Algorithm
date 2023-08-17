package silver5.num11004;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 숫자의 개수 및 찾고자 하는 수의 순서를 각 변수에 할당
		int numbers = Integer.parseInt(st.nextToken());
		int order = Integer.parseInt(st.nextToken());
		
		// 주어진 숫자를 저장할 PriorityQueue 객체 sorter 초기화
		PriorityQueue<Integer> sorter = new PriorityQueue<>();
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 숫자를 sorter에 저장
		for (int n = 0; n < numbers; n++)
			sorter.offer(Integer.parseInt(st.nextToken()));
		
		// for 반복문을 사용해 찾고자 하는 수의 앞 순서까지의 수를 제거
		for (int n = 0; n < order - 1; n++)
			sorter.poll();
		
		// poll(), valueOf(), write() 메서드를 사용해 찾고자 하는 수를 출력
		out.write(String.valueOf(sorter.poll()));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}