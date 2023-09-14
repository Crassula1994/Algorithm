package silver4.num11656;

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
		
		// readLine() 메서드를 사용해 입력 받은 문자열을 변수 string에 할당
		String string = in.readLine();
		
		// 접미사를 사전 순으로 정렬할 PriorityQueue 객체 suffixSorter 초기화
		PriorityQueue<String> suffixSorter = new PriorityQueue<>();
		
		// for 반복문을 사용해 각 접미사를 순회
		for (int s = 0; s < string.length(); s++) {
			
			// substring() 메서드를 사용해 해당 접미사를 변수 suffix에 할당
			String suffix = string.substring(s);
			
			// offer() 메서드를 사용해 해당 접미사를 suffixSorter에 저장
			suffixSorter.offer(suffix);
		}
		
		// while 반복문을 사용해 접미사를 사전 순으로 출력
		while (!suffixSorter.isEmpty())
			out.write(suffixSorter.poll() + "\n");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}