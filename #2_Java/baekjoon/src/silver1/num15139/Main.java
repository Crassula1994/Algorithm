package silver1.num15139;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 다각형의 꼭짓점 개수를 변수 vertexNum에 할당
		int vertexNum = Integer.parseInt(in.readLine());
		
		// 첩보 시설 좌표의 극한 값 및 첩보 시설의 총 둘레의 길이를 저장할 각 변수 초기화
		int leftLimit = Integer.MAX_VALUE;
		int rightLimit = Integer.MIN_VALUE;
		int upLimit = Integer.MIN_VALUE;
		int downLimit = Integer.MAX_VALUE;
		int totalPerimeter = 0;
		
		// 각 꼭짓점의 좌표를 저장할 2차원 배열 vertices 초기화
		int[][] vertices = new int[vertexNum][2];
		
		// for 반복문을 사용해 입력 받은 각 꼭짓점을 순회
		for (int idx = 0; idx < vertices.length; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 꼭짓점을 2차원 배열 vertice에 저장
			vertices[idx][0] = Integer.parseInt(st.nextToken());
			vertices[idx][1] = Integer.parseInt(st.nextToken());
			
			// min() 및 max() 메서드를 사용해 첩보 시설 좌표의 극한 값을 갱신
			leftLimit = Math.min(vertices[idx][0], leftLimit);
			rightLimit = Math.max(vertices[idx][0], rightLimit);
			upLimit = Math.max(vertices[idx][1], upLimit);
			downLimit = Math.min(vertices[idx][1], downLimit);
			
			// 두 번째 꼭짓점 이상인 경우 첩보 시설의 둘레의 길이를 갱신
			if (idx > 0)
				totalPerimeter += Math.abs(vertices[idx][0] - vertices[idx - 1][0])
						+ Math.abs(vertices[idx][1] - vertices[idx - 1][1]);
		}
		
		// 첫 번째 꼭짓점과 마지막 꼭짓점 사이의 둘레의 길이를 첩보 시설의 둘레의 길이에 갱신
		totalPerimeter += Math.abs(vertices[0][0] - vertices[vertexNum - 1][0])
				+ Math.abs(vertices[0][1] - vertices[vertexNum - 1][1]);
		
		// 첩보 시설의 안전한 둘레의 길이를 계산해 변수 securedPerimeter에 할당
		int securedPerimeter = totalPerimeter - 2 * ((rightLimit - leftLimit) + (upLimit - downLimit));
		
		// valueOf() 및 write() 메서드를 사용해 첩보 시설의 안전한 둘레의 길이를 출력
		out.write(String.valueOf(securedPerimeter));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}