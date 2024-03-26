package bronze5.num27959;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 동전의 수 및 초코바의 가격을 각 변수에 할당
		int coinNum = Integer.parseInt(st.nextToken());
		int price = Integer.parseInt(st.nextToken());
		
		// 밤고가 초코바를 살 수 있는 경우 'Yes'를 출력
		if (coinNum * 100 >= price) {
			out.write("Yes");
			
		// 밤고가 초코바를 살 수 없는 경우 'No'를 출력
		} else {
			out.write("No");
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}