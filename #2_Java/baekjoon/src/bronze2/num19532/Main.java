package bronze2.num19532;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 연립방정식의 정수를 각 변수에 할당
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 가능한 x값을 차례로 순회
		for (int x = -999; x < 1000; x++) {
			
			// for 반복문을 사용해 가능한 y값을 차례로 순회
			for (int y = -999; y < 1000; y++) {
				
				// 해당 연립방정식을 만족시키는 경우 해를 출력 후 반복문 탈출
				if (a * x + b * y == c && d * x + e * y == f) {
					out.write(x + " " + y);
					break;
				}
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
    }
}