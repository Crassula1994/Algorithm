package bronze2.num01434;

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
		
		// 전체 박스의 낭비된 용량의 합을 저장할 변수 remains 초기화
		int remains = 0;

		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 박스의 개수와 책의 개수를 각 변수에 할당
		int boxNum = Integer.parseInt(st.nextToken());
		int bookNum = Integer.parseInt(st.nextToken());
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// while 반복문을 사용해 전체 박스 용량의 합을 갱신
		while (boxNum-- > 0)
			remains += Integer.parseInt(st.nextToken());
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// while 반복문을 사용해 전체 박스의 낭비된 용량의 합을 갱신
		while (bookNum-- > 0)
			remains -= Integer.parseInt(st.nextToken());
		
		// valueOf() 및 write() 메서드를 사용해 전체 박스의 낭비된 용량의 합을 출력
		out.write(String.valueOf(remains));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}