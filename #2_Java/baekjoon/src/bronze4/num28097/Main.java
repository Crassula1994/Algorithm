package bronze4.num28097;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 공부 계획의 수를 변수 planNum에 할당
		int planNum = Integer.parseInt(in.readLine());
		
		// 포닉스가 공부를 마칠 때까지 걸린 총 시간을 저장할 변수 totalTime 초기화
		int totalTime = 8 * (planNum - 1);
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// while 반복문을 사용해 포닉스가 공부를 마칠 때까지 걸린 총 시간을 갱신
		while (planNum-- > 0)
			totalTime += Integer.parseInt(st.nextToken());
		
		// write() 메서드를 사용해 포닉스가 공부를 마칠 때까지 걸린 총 시간을 일과 시간 단위로 출력
		out.write((totalTime / 24) + " " + (totalTime % 24));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}