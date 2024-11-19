package gold4.num02650;

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
		
		// 최소 교차점의 개수 및 가장 많은 교차점을 갖는 연결선의 교차점 개수를 저장할 각 변수 초기화
		int minCountSum = 0;
		int maxCount = 0;
		
		// 각 연결선의 교차점 개수를 저장할 배열 counts 초기화
		int[] counts = new int[pointNum / 2];
		
		// 연결된 각 점의 정보를 저장할 2차원 배열 lines 초기화
		int[][] lines = new int[pointNum / 2][2];
		
		// for 반복문을 사용해 각 연결선을 순회
		for (int idx = 0; idx < pointNum / 2; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 각 연결선의 두 점을 순회
			for (int point = 0; point < 2; point++) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 연결된 점의 정보를 각 변수에 할당
				int pointLocation = Integer.parseInt(st.nextToken());
				int pointDistance = Integer.parseInt(st.nextToken());
				
				// switch 조건문을 사용해 해당 점을 수직선 상의 한 좌표로 바꾼 결과를 2차원 배열 lines에 저장
				switch (pointLocation) {
					case 1:
						lines[idx][point] = pointDistance;
						break;
					case 2:
						lines[idx][point] = 150 - pointDistance;
						break;
					case 3:
						lines[idx][point] = 200 - pointDistance;
						break;
					default:
						lines[idx][point] = pointDistance + 50;
				}
			}
			
			// 두 연결선의 점 중 더 작은 좌표가 뒤쪽에 위치한 경우 두 점의 위치를 교환
			if (lines[idx][0] > lines[idx][1]) {
				int temp = lines[idx][0];
				lines[idx][0] = lines[idx][1];
				lines[idx][1] = temp;
			}
		}
		
		// for 반복문을 사용해 각 연결선의 쌍을 순회
		for (int line1 = 0; line1 < pointNum / 2; line1++) {
			for (int line2 = 0; line2 < pointNum / 2; line2++) {
				
				// 같은 연결선인 경우 다음 연결선의 쌍을 순회
				if (line1 == line2)
					continue;
				
				// 두 연결선이 교차하는 경우 각 연결선의 교차점 개수와 최소 교차점의 개수를 갱신
				if (lines[line1][0] < lines[line2][0] && lines[line2][0] < lines[line1][1]
						&& lines[line1][1] < lines[line2][1]) {
					counts[line1]++;
					counts[line2]++;
					minCountSum++;
				}
			}
		}
		
		// for 반복문을 사용해 가장 많은 교차점을 갖는 연결선의 교차점 개수를 갱신
		for (int idx = 0; idx < counts.length; idx++)
			maxCount = Math.max(counts[idx], maxCount);
		
		// write() 메서드를 사용해 최소 교차점의 개수 및 가장 많은 교차점을 갖는 연결선의 교차점 개수를 출력
		out.write(minCountSum + "\n" + maxCount);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}