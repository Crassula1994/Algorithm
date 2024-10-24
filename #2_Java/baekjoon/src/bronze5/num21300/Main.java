package bronze5.num21300;

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
		
		// 빈 용기의 총 개수를 저장할 변수 containerNum 초기화
		int containerNum = 0;
		
		// for 반복문을 사용해 빈 용기의 총 개수를 갱신
		for (int c = 0; c < 6; c++)
			containerNum += Integer.parseInt(st.nextToken());
		
		// valueOf() 및 write() 메서드를 사용해 소비자가 받을 수 있는 총 환금 보증금의 값을 출력
		out.write(String.valueOf(containerNum * 5));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}