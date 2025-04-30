package bronze3.num11586;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 마법거울의 크기를 변수 size에 할당
		int size = Integer.parseInt(in.readLine());
		
		// 지영 공주님의 원래 모습을 저장할 2차원 배열 mirrorImage 초기화
		char[][] mirrorImage = new char[size][size];
		
		// for 반복문을 사용해 입력 받은 지영 공주님의 원래 모습을 2차원 배열 mirrorImage에 저장
		for (int r = 0; r < size; r++)
			mirrorImage[r] = in.readLine().toCharArray();
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 마법거울의 심리 상태를 변수 mentation에 할당
		int mentation = Integer.parseInt(in.readLine());
		
		// 마법거울의 심리 상태가 1인 경우
		if (mentation == 1) {
			
			// for 반복문을 사용해 지영 공주님의 모습을 그대로 출력
			for (int r = 0; r < size; r++) {
				out.write(mirrorImage[r]);
				out.newLine();
			}
			
		// 마법 거울의 심리 상태가 2인 경우
		} else if (mentation == 2) {
			
			// for 반복문을 사용해 좌우로 반전된 지영 공주님의 모습을 출력
			for (int r = 0; r < size; r++) {
				for (int c = size - 1; c >= 0; c--)
					out.write(mirrorImage[r][c]);
				out.newLine();
			}
			
		// 마법 거울의 심리 상태가 3인 경우
		} else {
			
			// for 반복문을 사용해 상하로 반전된 지영 공주님의 모습을 출력
			for (int r = size - 1; r >= 0; r--) {
				out.write(mirrorImage[r]);
				out.newLine();
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}