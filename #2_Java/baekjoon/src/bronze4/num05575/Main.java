package bronze4.num05575;

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

		// for 반복문을 사용해 세 사람의 출퇴근 시간을 순회
		for (int person = 0; person < 3; person++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 출퇴근 시간을 각 변수에 할당
			int startTime = Integer.parseInt(st.nextToken()) * 3600 + Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
			int endTime = Integer.parseInt(st.nextToken()) * 3600 + Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());

			// 근무 시간을 계산해 변수 workingTime에 할당 
			int workingTime = endTime - startTime;
			
			// write() 메서드를 사용해 근무 시간을 시, 분, 초의 순으로 출력
			out.write(workingTime / 3600 + " ");
			workingTime %= 3600;
			out.write(workingTime / 60 + " ");
			workingTime %= 60;
			out.write(workingTime + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}