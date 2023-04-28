package bronze4.num05596;

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

		// 민국이와 만세의 총점을 저장할 각 변수를 초기화
		int scoreMK = 0;
		int scoreMS = 0;
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 민국이의 총점을 갱신
		for (int s = 0; s < 4; s++)
			scoreMK += Integer.parseInt(st.nextToken());
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 만세의 총점을 갱신
		for (int s = 0; s < 4; s++)
			scoreMS += Integer.parseInt(st.nextToken());
			
		// max(), valueOf(), write() 메서드를 사용해 더 큰 총점을 출력
		out.write(String.valueOf(Math.max(scoreMK, scoreMS)));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}