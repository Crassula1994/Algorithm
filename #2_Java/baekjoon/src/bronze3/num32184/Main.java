package bronze3.num32184;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 시작 페이지와 끝 페이지를 각 변수에 할당
		int startPage = Integer.parseInt(st.nextToken());
		int endPage = Integer.parseInt(st.nextToken());
		
		// 시작 페이지가 홀수 페이지가 아니거나 끝 페이지가 짝수 페이지가 아닌 경우 각 페이지를 갱신
		startPage = (startPage % 2 == 0) ? startPage - 1 : startPage;
		endPage = (endPage % 2 == 0) ? endPage : endPage + 1;
		
		// valueOf() 및 write() 메서드를 사용해 사진을 찍어야 할 최소 횟수를 출력
		out.write(String.valueOf((endPage - startPage + 1) / 2));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}