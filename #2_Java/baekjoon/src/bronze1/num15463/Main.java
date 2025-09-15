package bronze1.num15463;

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
		
		// 각 광고판과 트럭의 모서리 좌표를 저장할 2차원 배열 coordinates 초기화
		int[][] coordinates = new int[3][4];
		
		// for 반복문을 사용해 각 광고판 및 트럭의 모서리 좌표를 순회
		for (int idx = 0; idx < 3; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 각 광고판과 트럭의 모서리 좌표를 2차원 배열 coordinates에 저장
			for (int coordinate = 0; coordinate < 4; coordinate++)
				coordinates[idx][coordinate] = Integer.parseInt(st.nextToken());
		}
		
		// areaCalculator() 메서드를 호출해 광고판의 보이는 면적을 변수 visibleArea에 할당
		int visibleArea = areaCalculator(coordinates[0], coordinates[2])
				+ areaCalculator(coordinates[1], coordinates[2]);
		
		// valueOf() 및 write() 메서드를 사용해 광고판의 보이는 면적을 출력
		out.write(String.valueOf(visibleArea));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// areaCalculator() 메서드 정의
	public static int areaCalculator(int[] billboard, int[] truck) {
		
		// 해당 광고판의 면적을 계산한 결과를 변수 billboardArea에 할당
		int billboardArea = (billboard[2] - billboard[0]) * (billboard[3] - billboard[1]);
		
		// max() 및 min() 메서드를 사용해 겹치는 면적의 각 좌표를 각 변수에 할당
		int blockedX1 = Math.max(billboard[0], truck[0]);
		int blockedY1 = Math.max(billboard[1], truck[1]);
		int blockedX2 = Math.min(billboard[2], truck[2]);
		int blockedY2 = Math.min(billboard[3], truck[3]);
		
		// 겹치는 면적이 있는 경우 보이는 면적을 계산해 반환
		if (blockedX1 < blockedX2 && blockedY1 < blockedY2)
			return billboardArea - (blockedX2 - blockedX1) * (blockedY2 - blockedY1);
		
		// 겹치는 면적이 없는 경우 해당 광고판의 면적을 반환
		return billboardArea;
	}
}