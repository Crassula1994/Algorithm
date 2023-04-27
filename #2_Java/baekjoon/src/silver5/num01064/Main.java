package silver5.num01064;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 점의 좌표를 각 변수에 할당
		int xA = Integer.parseInt(st.nextToken());
		int yA = Integer.parseInt(st.nextToken());
		int xB = Integer.parseInt(st.nextToken());
		int yB = Integer.parseInt(st.nextToken());
		int xC = Integer.parseInt(st.nextToken());
		int yC = Integer.parseInt(st.nextToken());
		
		// 세 점이 일직선에 위치한 경우 -1 출력
		if ((yB - yA) * (xC - xB) == (yC - yB) * (xB - xA)) {
			out.write(String.valueOf(-1.0));
			
		// 세 점이 일직선에 위치하지 않은 경우
		} else {
			
			// pow() 및 sqrt() 메서드를 사용해 각 점을 연결하는 변의 길이를 각 변수에 할당
			double sideAB = Math.sqrt(Math.pow(xA - xB, 2) + Math.pow(yA - yB, 2));
			double sideAC = Math.sqrt(Math.pow(xA - xC, 2) + Math.pow(yA - yC, 2));
			double sideBC = Math.sqrt(Math.pow(xB - xC, 2) + Math.pow(yB - yC, 2));
			
			// max() 또는 min() 메서드를 사용해 세 변 중 가장 긴 변의 길이와 가장 짧은 변의 길이를 각 변수에 할당
			double maxSide = Math.max(sideAB, Math.max(sideAC, sideBC));
			double minSide = Math.min(sideAB, Math.min(sideAC, sideBC));
			
			/*
			가장 큰 둘레의 길이와 가장 작은 둘레의 길이의 차이는
			가장 긴 변의 길이와 가장 짧은 변의 길이의 차이를 두 배한 것과 같으므로
			valueOf() 및 write() 메서드를 사용해 가장 큰 둘레의 길이와 가장 작은 둘레의 길이의 차이를 출력
			*/
			out.write(String.valueOf((maxSide - minSide) * 2));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}