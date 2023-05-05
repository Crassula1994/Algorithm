package bronze3.num01267;

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

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 통화의 개수를 변수 callNum에 할당
		int callNum = Integer.parseInt(in.readLine());
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// 영식 요금제 및 민식 요금제의 예상 요금을 저장할 각 변수 초기화
		int costY = 0;
		int costM = 0;
		
		// for 반복문을 사용해 각 통화를 순회
		for (int call = 0; call < callNum; call++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 통화 시간을 변수 time에 할당
			int time = Integer.parseInt(st.nextToken());
			
			// 영식 요금제 및 민식 요금제의 예상 요금을 갱신
			costY += 10 * (time / 30 + 1);
			costM += 15 * (time / 60 + 1);
		}
		
		// 영식 요금제가 더 저렴한 경우 영식 요금제의 예상 요금을 출력
		if (costY < costM) {
			out.write("Y " + costY);
			
		// 민식 요금제가 더 저렴한 경우 민식 요금제의 예상 요금을 출력
		} else if (costY > costM) {
			out.write("M " + costM);
		
		// 두 요금제의 요금이 같은 경우 두 요금제의 예상 요금을 출력
		} else {
			out.write("Y M " + costY);
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}