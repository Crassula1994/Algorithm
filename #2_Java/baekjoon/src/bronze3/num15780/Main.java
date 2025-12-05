package bronze3.num15780;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 학생의 수와 멀티탭의 수를 각 변수에 할당
		int studentNum = Integer.parseInt(st.nextToken());
		int stripNum = Integer.parseInt(st.nextToken());
		
		// 멀티탭에 꽂을 수 있는 코드의 수를 저장할 변수 totalCount 초기화
		int totalCount = 0;
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// while 반복문을 사용해 각 멀티탭을 순회
		while (stripNum-- > 0) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 멀티탭 구의 수를 변수 count에 할당
			int count = Integer.parseInt(st.nextToken());
			
			// 멀티탭에 꽂을 수 있는 코드의 수를 갱신
			totalCount += count / 2;
			
			// 해당 멀티탭 구의 수가 홀수인 경우 멀티탭에 꽂을 수 있는 코드의 수를 갱신
			if ((count & 1) == 1)
				totalCount++;
		}
		
		// write() 메서드를 사용해 모든 사람이 멀티탭에 코드를 꽂을 수 있는지 여부를 출력
		out.write((totalCount >= studentNum) ? "YES" : "NO");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}