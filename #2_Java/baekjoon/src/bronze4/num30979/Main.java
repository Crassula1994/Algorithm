package bronze4.num30979;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 파댕이를 돌봐야 하는 시간 및 가지고 있는 사탕의 총 개수를 각 변수에 할당
		int totalTime = Integer.parseInt(in.readLine());
		int candyNum = Integer.parseInt(in.readLine());
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// while 반복문을 사용해 파댕이가 우는 시간을 갱신
		while (candyNum-- > 0 && totalTime > 0)
			totalTime -= Integer.parseInt(st.nextToken());
		
		// write() 메서드를 사용해 파댕이가 울지 않게 만들 수 있는지 여부를 출력
		out.write((totalTime > 0) ? "Padaeng_i Cry" : "Padaeng_i Happy");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}