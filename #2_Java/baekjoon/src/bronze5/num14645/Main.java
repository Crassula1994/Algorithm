package bronze5.num14645;

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
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 정거장의 수 및 출발역에서 탑승하는 사람의 수를 각 변수에 할당
		int stopNum = Integer.parseInt(st.nextToken());
		int passengerNum = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 각 정거장을 순회
		for (int stop = 0; stop < stopNum; stop++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 탑승하는 사람의 수를 갱신
			passengerNum += Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken());
		}
		
		// write() 메서드를 사용해 버스 운전수의 이름을 출력
		out.write("비와이");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}