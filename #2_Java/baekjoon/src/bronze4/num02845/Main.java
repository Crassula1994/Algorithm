package bronze4.num02845;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 1㎡당 사람의 수, 파티가 열렸던 곳의 넓이를 각 변수에 할당
		int density = Integer.parseInt(st.nextToken());
		int area = Integer.parseInt(st.nextToken());
		
		// 파티에 참가한 참가자 수를 계산해 변수 pariticipant에 할당
		int participant = density * area;
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 신문 기사에 적힌 참가자의 수를 순회
		for (int news = 0; news < 5; news++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 신문 기사에 적힌 참가자의 수를 변수 estimation에 할당
			int estimation = Integer.parseInt(st.nextToken());
			
			// write() 메서드를 사용해 실제 참가자 수와 신문 기사에 적힌 참가자 수 사이의 차이를 출력
			out.write((estimation - participant) + " ");
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}