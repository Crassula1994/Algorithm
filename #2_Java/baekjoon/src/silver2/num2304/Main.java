package silver2.num2304;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {

	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 기둥의 개수를 변수 pillarNum에 할당
		int pillarNum = Integer.parseInt(in.readLine());

		// 기둥의 위치와 높이를 저장할 2차원 배열 pillars 초기화
		int[][] pillars = new int[pillarNum][2];
		
		// 가장 높은 기둥의 길이를 저장할 변수 maxHeight 초기화
		int maxHeight = 0;
		
		// 창고 다각형의 면적을 저장할 변수 totalArea 초기화
		int totalArea = 0;
		
		// for 반복문을 사용해 배열 pillars의 각 원소를 순회
		for (int idx = 0; idx < pillars.length; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 기둥과 개수를 배열 pillars에 저장
			pillars[idx][0] = Integer.parseInt(st.nextToken());
			pillars[idx][1] = Integer.parseInt(st.nextToken());
			
			// 저장된 가장 높은 기둥의 길이보다 입력 받은 기둥이 높으면 가장 높은 기둥의 길이 갱신
			maxHeight = (pillars[idx][1] > maxHeight) ? pillars[idx][1] : maxHeight;
		}
		
		// sort() 메서드를 사용해 기둥을 위치를 기준으로 오름차순으로 정렬
		Arrays.sort(pillars, (p1, p2) -> {return p1[0] - p2[0];});
		
		// 현재의 높이와 높이를 계산할 기준이 되는 인덱스를 저장할 각 변수 초기화
		int height = pillars[0][1];
		int startIdx = pillars[0][0];
		
		// for 반복문을 사용해 가장 높은 기둥의 왼쪽 부분을 순회
		for (int idx = 0; idx < pillars.length; idx++) {
			
			// 해당 기둥이 이전 높이보다 높은 경우
			if (pillars[idx][1] > height) {
				
				// 지금까지의 면적을 계산
				totalArea += (pillars[idx][0] - startIdx) * height;
				
				// 현재의 높이 및 높이를 계산할 기준이 되는 인덱스 초기화
				height = pillars[idx][1];
				startIdx = pillars[idx][0];
			}
			
			// 해당 기둥이 가장 높은 기둥인 경우 반복문 탈출
			if (height == maxHeight)
				break;
		}
		
		// 현재의 높이와 높이를 계산할 기준이 되는 인덱스를 저장할 각 변수 초기화
		height = pillars[pillarNum - 1][1];
		int endIdx = pillars[pillarNum - 1][0];
		
		// for 반복문을 사용해 가장 높은 기둥의 오른쪽 부분을 순회
		for (int idx = pillarNum - 1; idx >= 0; idx--) {
			
			// 해당 기둥이 이전 높이보다 높은 경우
			if (pillars[idx][1] > height) {
				
				// 지금까지의 면적을 계산
				totalArea += (endIdx - pillars[idx][0]) * height;
				
				// 현재의 높이 및 높이를 계산할 기준이 되는 인덱스 초기화
				height = pillars[idx][1];
				endIdx = pillars[idx][0];
			}
			
			// 해당 기둥이 가장 높은 기둥인 경우 반복문 탈출
			if (height == maxHeight)
				break;
		}
		
		// 가장 높은 기둥 사이의 면적을 계산
		totalArea += (endIdx - startIdx + 1) * maxHeight;
		
		// valueOf() 및 write() 메서드를 사용해 창고 다각형의 면적을 출력
		out.write(String.valueOf(totalArea));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}