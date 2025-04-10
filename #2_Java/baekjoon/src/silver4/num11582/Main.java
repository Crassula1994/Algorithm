package silver4.num11582;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 치킨집의 개수를 변수 restaurantNum에 할당
		int restaurantNum = Integer.parseInt(in.readLine());
		
		// 치킨집의 맛의 수치를 저장할 배열 restaurants 초기화
		int[] restaurants = new int[restaurantNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 치킨집의 맛의 수치를 배열 restaurants에 저장
		for (int idx = 0; idx < restaurants.length; idx++)
			restaurants[idx] = Integer.parseInt(st.nextToken());
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 현재 정렬을 진행 중인 회원들의 수를 변수 memberNum에 할당
		int memberNum = Integer.parseInt(in.readLine());
		
		// 한 사람이 정렬해야 하는 치킨집의 수를 저장할 변수 sortCount 초기화
		int sortCount = restaurantNum / memberNum;
		
		// for 반복문을 사용해 각 정렬 구간을 순회
		for (int startIdx = 0; startIdx < restaurants.length; startIdx += sortCount) {
			
			// 현재 정렬 구간의 끝 인덱스를 변수 endIdx에 할당
			int endIdx = startIdx + sortCount;
			
			// sort() 메서드를 사용해 해당 구간을 정렬
			Arrays.sort(restaurants, startIdx, endIdx);
			
			// for 반복문을 사용해 해당 구간의 정렬된 상태를 출력
			for (int idx = startIdx; idx < endIdx; idx++)
				out.write(restaurants[idx] + " ");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}