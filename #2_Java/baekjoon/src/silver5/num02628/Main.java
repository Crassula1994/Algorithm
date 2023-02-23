package silver5.num02628;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 종이의 가로와 세로의 길이를 각 변수에 할당
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 자르는 횟수를 변수 cutCount에 할당
		int cutCount = Integer.parseInt(in.readLine());
		
		// 가장 큰 종이 조각의 넓이를 저장할 변수 maxArea 초기화
		int maxArea = 0;
		
		// 가로와 세로로 자른 점선 번호를 저장할 각 List 객체 초기화
		List<Integer> widthCut = new LinkedList<>();
		List<Integer> heightCut = new LinkedList<>();
		
		// 각 List 객체에 종이의 모서리 값을 추가
		widthCut.add(0);
		widthCut.add(height);
		heightCut.add(0);
		heightCut.add(width);
		
		// for 반복문을 사용해 자르는 점선을 차례로 순회
		for (int cut = 0; cut < cutCount; cut++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 자르는 방향 및 자르는 번호를 각 변수에 할당
			int cutDirection = Integer.parseInt(st.nextToken());
			int cutNum = Integer.parseInt(st.nextToken());
			
			// 자르는 방향이 가로인 경우 widthCut에 번호 추가
			if (cutDirection == 0) {
				widthCut.add(cutNum);
			
			// 자르는 방향이 세로인 경우 heightCut에 번호 추가
			} else {
				heightCut.add(cutNum);
			}
		}
		
		// sort() 메서드를 사용해 각 List 객체 정렬
		Collections.sort(widthCut);
		Collections.sort(heightCut);
		
		// 각 List 객체의 인덱스를 순회
		for (int i = 1; i < widthCut.size(); i++) {
			for (int j = 1; j < heightCut.size(); j++) {
				
				// 각 경우의 넓이를 계산해 변수 area에 할당
				int area = (widthCut.get(i) - widthCut.get(i - 1)) * (heightCut.get(j) - heightCut.get(j - 1));
				
				// 해당 넓이가 최대 넓이인 경우 최대 넓이 갱신
				maxArea = (area > maxArea) ? area : maxArea;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 최대 넓이 출력
		out.write(String.valueOf(maxArea));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}