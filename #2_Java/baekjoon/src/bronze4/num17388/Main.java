package bronze4.num17388;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 대학교의 참여도를 각 변수에 할당
		int soongsil = Integer.parseInt(st.nextToken());
		int korea = Integer.parseInt(st.nextToken());
		int hanyang = Integer.parseInt(st.nextToken());
		
		// 참여도의 합이 100 이상인 경우 'OK'를 출력
		if (soongsil + korea + hanyang >= 100) {
			out.write("OK");
		
		// 참여도의 합이 100 미만인 경우
		} else {
			
			// 숭실대학교가 가장 참여도가 적은 경우 'Soongsil'을 출력
			if (soongsil < korea && soongsil < hanyang) {
				out.write("Soongsil");
			
			// 고려대학교가 가장 참여도가 적은 경우 'Korea'를 출력
			} else if (korea < soongsil && korea < hanyang) {
				out.write("Korea");
				
			// 한양대학교가 가장 참여도가 적은 경우 'Hanyang'을 출력
			} else {
				out.write("Hanyang");
			}
		}
				
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}