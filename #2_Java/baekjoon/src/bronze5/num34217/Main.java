package bronze5.num34217;

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
		
		// 한양대역과 용답역에서 하차했을 때 한양대학교 ITBT관까지 걸리는 시간을 저장할 각 변수 초기화
		int timeH = 0;
		int timeY = 0;
		
		// for 반복문을 사용해 각 역까지의 시간 및 역에서 ITBT관까지의 시간을 순회
		for (int t = 0; t < 2; t++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 한양대역과 용답역에서 하차했을 때 걸리는 시간을 갱신
			timeH += Integer.parseInt(st.nextToken());
			timeY += Integer.parseInt(st.nextToken());
		}
		
		// 한양대역에서 하차하는 게 더 빠른 경우 'Hanyang Univ.'를 출력
		if (timeH < timeY) {
			out.write("Hanyang Univ.");
			
		// 용답역에서 하차하는 게 더 빠른 경우 'Yongdap'을 출력
		} else if (timeH > timeY) {
			out.write("Yongdap");
			
		// 두 역에서 걸리는 시간이 같은 경우 'Either'를 출력
		} else {
			out.write("Either");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}