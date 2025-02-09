package bronze4.num18404;

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
		
		// 1과 2의 개수를 저장할 각 변수 초기화
		int count1 = 0;
		int count2 = 0;
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// while 반복문을 사용해 각 정수를 순회
		while (st.hasMoreTokens()) {
			
			// 해당 정수가 1인 경우 1의 개수를 갱신
			if (st.nextToken().equals("1")) {
				count1++;
				
			// 해당 정수가 2인 경우 2의 개수를 갱신
			} else {
				count2++;
			}
		}
		
		// write() 메서드를 사용해 1과 2 중에서 더 많은 쪽을 출력
		out.write((count1 > count2) ? "1" : "2");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}