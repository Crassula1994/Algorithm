package bronze3.num15781;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 헬멧의 개수와 조끼의 개수를 각 변수에 할당
		int helmetNum = Integer.parseInt(st.nextToken());
		int vestNum = Integer.parseInt(st.nextToken());
		
		// 경수가 얻을 수 있는 헬멧과 조끼의 가장 높은 방어력을 저장할 각 변수 초기화
		int maxHelmet = 0;
		int maxVest = 0;
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// while 반복문을 사용해 경수가 얻을 수 있는 헬멧 중 가장 높은 방어력을 갱신
		while (helmetNum-- > 0)
			maxHelmet = Math.max(Integer.parseInt(st.nextToken()), maxHelmet);
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// while 반복문을 사용해 경수가 얻을 수 있는 조끼 중 가장 높은 방어력을 갱신
		while (vestNum-- > 0)
			maxVest = Math.max(Integer.parseInt(st.nextToken()), maxVest);
		
		// valueOf() 및 write() 메서드를 사용해 경수가 얻을 수 있는 방어력의 최댓값을 출력
		out.write(String.valueOf(maxHelmet + maxVest));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}