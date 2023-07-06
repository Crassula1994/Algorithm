package bronze3.num10810;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 바구니의 수 및 공을 넣을 횟수를 각 변수에 할당
		int basketNum = Integer.parseInt(st.nextToken());
		int inputCnt = Integer.parseInt(st.nextToken());
		
		// 바구니에 들어 있는 공의 번호를 저장할 배열 baskets 초기화
		int[] baskets = new int[basketNum];
		
		// for 반복문을 사용해 각 공을 넣는 횟수를 순회
		for (int cnt = 0; cnt < inputCnt; cnt++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 공을 넣는 바구니 및 공의 번호를 각 변수에 할당
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int ballNum = Integer.parseInt(st.nextToken());
			
			// for 반복문을 사용해 배열 baskets의 각 원소를 갱신
			for (int idx = start - 1; idx < end; idx++)
				baskets[idx] = ballNum;
		}

		// for 반복문을 사용해 바구니에 들어 있는 공의 번호를 차례로 출력
		for (int basket : baskets)
			out.write(basket + " ");

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}