package bronze3.num16431;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 베시의 좌표를 각 변수에 할당
		int coordinateBR = Integer.parseInt(st.nextToken());
		int coordinateBC = Integer.parseInt(st.nextToken());
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 데이지의 좌표를 각 변수에 할당
		int coordinateDR = Integer.parseInt(st.nextToken());
		int coordinateDC = Integer.parseInt(st.nextToken());
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 농부 존의 좌표를 각 변수에 할당
		int coordinateJR = Integer.parseInt(st.nextToken());
		int coordinateJC = Integer.parseInt(st.nextToken());
		
		// abs() 및 max() 메서드를 사용해 베시와 데이지가 존에게 이동하는 데 걸리는 시간을 계산해 각 변수에 할당
		int timeB = Math.max(Math.abs(coordinateBR - coordinateJR), Math.abs(coordinateBC - coordinateJC));
		int timeD = Math.abs(coordinateDR - coordinateJR) + Math.abs(coordinateDC - coordinateJC);
		
		// 베시가 더 빨리 도착하는 경우 'bessie'를 출력
		if (timeB < timeD) {
			out.write("bessie");
			
		// 데이지가 더 빨리 도착하는 경우 'daisy'를 출력
		} else if (timeB > timeD) {
			out.write("daisy");
			
		// 동시에 도착하는 경우 'tie'를 출력
		} else {
			out.write("tie");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}