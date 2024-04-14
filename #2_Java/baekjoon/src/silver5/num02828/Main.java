package silver5.num02828;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 스크린과 바구니의 크기를 각 변수에 할당
		@SuppressWarnings("unused")
		int screenSize = Integer.parseInt(st.nextToken());
		int basketSize = Integer.parseInt(st.nextToken());
		
		// readLine() 및 parseInt() 메서드를 사용해 떨어지는 사과의 개수를 변수 appleNum에 할당
		int appleNum = Integer.parseInt(in.readLine());
		
		// 바구니가 이동해야 하는 최소 거리, 바구니의 왼쪽과 오른쪽 끝을 나타낼 각 변수 초기화
		int minDist = 0;
		int left = 1;
		int right = left + basketSize - 1;
		
		// for 반복문을 사용해 각 사과의 떨어지는 위치를 순회
		for (int apple = 0; apple < appleNum; apple++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 떨어지는 사과의 위치를 변수 location에 할당
			int location = Integer.parseInt(in.readLine());
			
			// 사과가 떨어지는 위치가 바구니 내인 경우 다음 사과를 순회
			if (location >= left && location <= right)
				continue;
				
			// 바구니가 이동해야 하는 거리를 변수 distance에 할당
			int distance = (location < left) ? location - left : location - right;
			
			// abs() 메서드를 사용해 바구니가 이동해야 하는 최소 거리 갱신
			minDist += Math.abs(distance);
			
			// 바구니의 왼쪽과 오른쪽 끝을 갱신
			left += distance;
			right += distance;
		}
		
		// valueOf() 및 write() 메서드를 사용해 바구니가 이동해야 하는 최소 거리를 출력
		out.write(String.valueOf(minDist));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}