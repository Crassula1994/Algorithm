package bronze2.num10864;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 학생의 수 및 친구 관계의 수를 각 변수에 할당
		int studentNum = Integer.parseInt(st.nextToken());
		int friendshipNum = Integer.parseInt(st.nextToken());
		
		// 각 학생의 친구 수를 저장할 배열 counts 초기화
		int[] counts = new int[studentNum + 1];
		
		// StringBuilder 객체를 불러와 변수 sb에 할당
		StringBuilder sb = new StringBuilder();
		
		// while 반복문을 사용해 각 친구 관계를 순회
		while (friendshipNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 각 학생의 친구 수를 갱신
			counts[Integer.parseInt(st.nextToken())]++;
			counts[Integer.parseInt(st.nextToken())]++;
		}
		
		// for 반복문을 사용해 각 학생의 친구의 수를 sb에 저장
		for (int student = 1; student <= studentNum; student++)
			sb.append(counts[student]).append("\n");
		
		// toString() 및 write() 메서드를 사용해 각 학생의 친구의 수를 출력
		out.write(sb.toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}