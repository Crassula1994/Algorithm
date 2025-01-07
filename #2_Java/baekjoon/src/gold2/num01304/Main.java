package gold2.num01304;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 도시의 개수 및 일반 도로의 개수를 각 변수에 할당
		int cityNum = Integer.parseInt(st.nextToken());
		int roadNum = Integer.parseInt(st.nextToken());
		
		// 해당 도시가 뒤쪽에 위치한 다음 도시와 같은 도시가 되어야 하는지 여부를 저장할 배열 isConnected 초기화
		boolean[] isConnected = new boolean[cityNum + 1];

		// while 반복문을 사용해 각 일반 도로의 연결 정보를 순회
		while (roadNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 도로가 연결된 도시를 각 변수에 할당
			int startCity = Integer.parseInt(st.nextToken());
			int endCity = Integer.parseInt(st.nextToken());
			
			// 도로가 뒤쪽 도시로 연결되는 경우 다음 도로를 순회
			if (startCity < endCity)
				continue;
			
			// for 반복문을 사용해 다음 도시와 같은 도시가 되어야 하는지 여부를 갱신
			for (int city = endCity; city < startCity; city++)
				isConnected[city] = true;
		}
		
		// for 반복문을 사용해 가능한 지역 내 도시의 수를 순회
		for (int count = 1; count <= cityNum; count++) {
			
			// 모든 지역의 도시 숫자가 같지 않은 경우 다음 도시 숫자를 순회
			if (cityNum % count != 0)
				continue;
			
			// 해당 도시 개수로 지역을 만들 수 있는지 여부를 나타낼 변수 canDivide 초기화
			boolean canDivide = true;
			
			// for 반복문을 사용해 해당 도시 개수로 만든 각 지역의 마지막 도시를 순회
			for (int endCity = count; endCity <= cityNum; endCity += count) {
				
				// 한 지역에 모든 도시가 속해 있는 경우 반복문 탈출
				if (count == cityNum)
					break;
				
				/* 해당 지역의 마지막 도시가 다음 도시와 반드시 연결되어야 하는 경우 지역을 만들 수 없으므로
				해당 도시 개수로 지역을 만들 수 있는지 여부를 갱신 후 반복문 탈출 */
				if (isConnected[endCity]) {
					canDivide = false;
					break;
				}
			}
			
			// 해당 도시 개수로 지역을 만들 수 있는 경우 나눌 수 있는 지역의 최댓값을 출력 후 반복문 탈출
			if (canDivide) {
				out.write(String.valueOf(cityNum / count));
				break;
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}