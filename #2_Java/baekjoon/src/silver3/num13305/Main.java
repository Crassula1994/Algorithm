package silver3.num13305;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 도시의 개수를 변수 cityNum에 할당
		int cityNum = Integer.parseInt(in.readLine());
		
		// 두 도시 사이의 도로의 길이 및 각 도시 주유소의 기름 가격을 저장할 각 배열 초기화
		long[] roadLength = new long[cityNum - 1];
		long[] oilPrice = new long[cityNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 도로의 길이를 배열 roadLength에 저장
		for (int idx = 0; idx < roadLength.length; idx++)
			roadLength[idx] = Long.parseLong(st.nextToken());
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 도시 주유소의 기름 가격을 배열 oilPrice에 저장
		for (int idx = 0; idx < oilPrice.length; idx++)
			oilPrice[idx] = Long.parseLong(st.nextToken());
		
		// 제일 왼쪽 도시에서 제일 오른쪽 도시로 가는 최소 비용 및 현재까지의 최소 기름 가격을 저장할 각 변수 초기화
		long minCost = oilPrice[0] * roadLength[0];
		long minPrice = oilPrice[0];
		
		// for 반복문을 사용해 각 도시를 차례로 순회
		for (int idx = 1; idx < roadLength.length; idx++) {
			
			// min() 메서드를 사용해 최소 가격을 갱신
			minPrice = Math.min(minPrice, oilPrice[idx]);
			
			// 해당 도로를 지나는 데 필요한 비용을 갱신
			minCost += minPrice * roadLength[idx];
		}
		
		// valueOf() 및 write() 메서드를 사용해 제일 왼쪽 도시에서 제일 오른쪽 도시로 가는 최소 비용을 출력
		out.write(String.valueOf(minCost));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}