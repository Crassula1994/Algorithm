package bronze3.num09610;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 점의 개수를 변수 pointNum에 할당
		int pointNum = Integer.parseInt(in.readLine());
		
		// 각 사분면과 축에 존재하는 점의 개수를 저장할 각 변수 초기화
		int countQ1 = 0;
		int countQ2 = 0;
		int countQ3 = 0;
		int countQ4 = 0;
		int countAxis = 0;
		
		// for 반복문을 사용해 각 점의 좌표를 순회
		for (int point = 0; point < pointNum; point++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 점의 좌표를 각 변수에 할당
			int coordinateX = Integer.parseInt(st.nextToken());
			int coordinateY = Integer.parseInt(st.nextToken());
			
			// 해당 점이 축에 위치한 경우 축에 존재하는 점의 개수를 갱신
			if (coordinateX == 0 || coordinateY == 0) {
				countAxis++;
			
			// 해당 점이 1사분면에 위치한 경우 1사분면에 위치한 점의 개수를 갱신
			} else if (coordinateX > 0 && coordinateY > 0) {
				countQ1++;
				
			// 해당 점이 2사분면에 위치한 경우 2사분면에 위치한 점의 개수를 갱신
			} else if (coordinateX < 0 && coordinateY > 0) {
				countQ2++;
			
			// 해당 점이 3사분면에 위치한 경우 3사분면에 위치한 점의 개수를 갱신
			} else if (coordinateX < 0 && coordinateY < 0) {
				countQ3++;
			
			// 해당 점이 4사분면에 위치한 경우 4사분면에 위치한 점의 개수를 갱신
			} else {
				countQ4++;
			}
		}
		
		// write() 메서드를 사용해 각 사분면과 축에 점이 몇 개 있는지를 출력
		out.write("Q1: " + countQ1 + "\nQ2: " + countQ2 + "\nQ3: " + countQ3 + "\nQ4: " + countQ4 + "\nAXIS: " + countAxis);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}