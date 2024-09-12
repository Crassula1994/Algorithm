package bronze2.num10539;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수열 B의 길이를 변수 length에 할당
		int length = Integer.parseInt(in.readLine());
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 수열 B의 각 원소를 순회
		for (int idx = 1, sum = 0; idx <= length; idx++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 수열 B의 원소를 변수 elementB에 할당
			int elementB = Integer.parseInt(st.nextToken());
			
			// 원래 수열 A의 원소를 역산해 변수 elementA에 할당
			int elementA = elementB * idx - sum;
			
			// 지금까지 구한 수열 A 원소들의 합을 갱신
			sum += elementA;
			
			// write() 메서드를 사용해 수열 A의 원래 원소를 출력
			out.write(elementA + " ");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}