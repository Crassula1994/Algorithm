package bronze4.num33046;

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
		
		// 진동인 플레이어를 저장할 변수 targetPlayer 초기화
		int targetPlayer = 1;
		
		// for 반복문을 사용해 주사위를 굴린 각 횟수를 순회
		for (int count = 0; count < 2; count++) {
			
			// 주사위의 합을 저장할 변수 sum 초기화
			int sum = 0;
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 굴린 주사위의 합을 주사위의 합에 갱신
			for (int dice = 0; dice < 2; dice++)
				sum += Integer.parseInt(st.nextToken());
			
			// 진동인 플레이어를 갱신
			targetPlayer = ((targetPlayer + sum - 1) % 4 == 0) ? 4 : (targetPlayer + sum - 1) % 4;
		}
		
		// valueOf() 및 write() 메서드를 사용해 진동인 플레이어의 번호를 출력
		out.write(String.valueOf(targetPlayer));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}