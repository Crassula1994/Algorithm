package bronze2.num21918;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 전구의 개수와 명령어의 개수를 각 변수에 할당
		int bulbNum = Integer.parseInt(st.nextToken());
		int commandNum = Integer.parseInt(st.nextToken());
		
		// 전구의 상태를 저장할 배열 bulbs 초기화
		boolean[] bulbs = new boolean[bulbNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 전구의 상태를 배열 bulbs에 저장
		for (int idx = 0; idx < bulbs.length; idx++)
			bulbs[idx] = st.nextToken().equals("1");
		
		// while 반복문을 사용해 각 명령어를 순회
		while (commandNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 해당 명령어의 정보를 각 변수에 할당
			int category = Integer.parseInt(st.nextToken());
			int parameter1 = Integer.parseInt(st.nextToken());
			int parameter2 = Integer.parseInt(st.nextToken());
			
			// switch 조건문을 사용해 해당 명령어를 수행 처리
			switch (category) {
				case 1:
					bulbs[parameter1 - 1] = (parameter2 == 1);
					break;
				case 2:
					for (int idx = parameter1 - 1; idx < parameter2; idx++)
						bulbs[idx] = !bulbs[idx];
					break;
				case 3:
					for (int idx = parameter1 - 1; idx < parameter2; idx++)
						bulbs[idx] = false;
					break;
				default:
					for (int idx = parameter1 - 1; idx < parameter2; idx++)
						bulbs[idx] = true;
			}
		}
		
		// StringBuilder 객체를 불러와 변수 sb에 할당
		StringBuilder sb = new StringBuilder();
		
		// for 반복문을 사용해 모든 명령어를 수행한 후 전구의 상태를 sb에 저장
		for (boolean bulb : bulbs)
			sb.append((bulb) ? "1 " : "0 ");
		
		// toString() 및 write() 메서드를 사용해 모든 명령어를 수행한 후 전구의 상태를 출력
		out.write(sb.toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}