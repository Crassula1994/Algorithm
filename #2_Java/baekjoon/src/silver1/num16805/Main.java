package silver1.num16805;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 지역의 수 및 특징의 수를 각 변수에 할당
		int prefectureNum = Integer.parseInt(st.nextToken());
		int featureNum = Integer.parseInt(st.nextToken());
		
		// 경계선의 위치 및 최소 오차를 저장할 각 변수 초기화
		int boundary = 0;
		int minError = Integer.MAX_VALUE;
		
		// 각 지역의 특징을 저장할 2차원 배열 prefectures 초기화
		int[][] prefactures = new int[prefectureNum + 1][2];
		
		// while 반복문을 사용해 각 특징을 순회
		while (featureNum-- > 0) {
			
			// readLine() 메서드를 사용해 입력 받은 특징을 변수 feature에 할당
			String feature = in.readLine();
			
			// for 반복문을 사용해 각 지역을 순회
			for (int idx = 0; idx < feature.length(); idx++) {
				
				// 해당 지역의 특징이 서부인 경우 서부인 특징의 수를 갱신
				if (feature.charAt(idx) == 'W') {
					prefactures[idx + 1][0]++;
				
				// 해당 지역의 특징이 동부인 경우 동부인 특징의 수를 갱신
				} else {
					prefactures[idx + 1][1]++;
				}
			}
		}
		
		// for 반복문을 사용해 각 지역의 특징의 누적 합을 갱신
		for (int idx = 1; idx <= prefectureNum; idx++) {
			prefactures[idx][0] += prefactures[idx - 1][0];
			prefactures[idx][1] += prefactures[idx - 1][1];
		}
		
		// for 반복문을 사용해 각 지역을 순회
		for (int idx = 0; idx <= prefectureNum; idx++) {
			
			// 해당 위치에서 경계를 지었을 때 오차의 수를 계산해 변수 errorCount에 할당
			int errorCount = prefactures[prefectureNum][0] - prefactures[idx][0] + prefactures[idx][1];
			
			// 해당 오차의 수가 저장된 최소 오차보다 적은 경우 최소 오차 및 경계선의 위치를 갱신
			if (errorCount < minError) {
				minError = errorCount;
				boundary = idx;
			}
		}
		
		// write() 메서드를 사용해 경계선의 위치를 출력
		out.write(boundary + " " + (boundary + 1));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}