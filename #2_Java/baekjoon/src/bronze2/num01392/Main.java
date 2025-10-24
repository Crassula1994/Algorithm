package bronze2.num01392;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 악보의 수와 질문의 개수를 각 변수에 할당
		int musicNum = Integer.parseInt(st.nextToken());
		int questionNum = Integer.parseInt(st.nextToken());
		
		// 각 시간별 연주되는 악보를 저장할 List 객체 performances 초기화
		List<Integer> performances = new ArrayList<>();
		
		// for 반복문을 사용해 각 악보를 순회
		for (int music = 1; music <= musicNum; music++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 해당 악보가 차지하는 시간을 변수 time에 할당
			int time = Integer.parseInt(in.readLine());
			
			// while 반복문을 사용해 각 시간별 연주되는 악보를 갱신
			while (time-- > 0)
				performances.add(music);
		}
		
		// while 반복문을 사용해 각 질문에 대하여 해당 시간에 부르는 악보의 번호를 출력
		while (questionNum-- > 0)
			out.write(performances.get(Integer.parseInt(in.readLine())) + "\n");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}