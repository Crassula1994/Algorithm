package bronze3.num10599;

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
		
		// StringBuilder 객체를 불러와 변수 sb에 할당
		StringBuilder sb = new StringBuilder();
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 출생일의 범위 및 사망일의 범위를 각 변수에 할당
			int birthYearFrom = Integer.parseInt(st.nextToken());
			int birthYearTo = Integer.parseInt(st.nextToken());
			int deathYearFrom = Integer.parseInt(st.nextToken());
			int deathYearTo = Integer.parseInt(st.nextToken());
			
			// 모든 테스트 케이스를 확인한 경우 반복문 탈출
			if (birthYearFrom == 0 && birthYearTo == 0 && deathYearFrom == 0 && deathYearTo == 0)
				break;
			
			// append() 메서드를 사용해 해당 페르시아 왕의 최소 나이와 최대 나이를 sb에 저장
			sb.append(deathYearFrom - birthYearTo).append(" ");
			sb.append(deathYearTo - birthYearFrom).append("\n");
		}
		
		// toString() 및 write() 메서드를 사용해 각 테스트 케이스에서 페르시아 왕의 최소 나이와 최대 나이를 출력 
		out.write(sb.toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}