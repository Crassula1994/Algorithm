package silver3.num10025;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 얼음 양동이의 개수 및 앨버트의 양동이 범위를 각 변수에 할당
		int bucketNum = Integer.parseInt(st.nextToken());
		int range = Integer.parseInt(st.nextToken());
		
		// 우리의 위치별 얼음의 개수를 저장할 배열 cage 초기화
		int[] cage = new int[1000001];
		
		// 앨버트의 총 양동이 범위, 해당 범위 내의 총 얼음의 양, 최대 얼음의 양을 저장할 각 변수 초기화
		int totalRange = range * 2;
		int totalAmount = 0;
		int maxAmount = 0;
		
		// for 반복문을 사용해 각 얼음 양동이를 순회
		for (int bucket = 0; bucket < bucketNum; bucket++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 양동이의 얼음의 양 및 양동이의 좌표를 각 변수에 할당
			int amount = Integer.parseInt(st.nextToken());
			int location = Integer.parseInt(st.nextToken());
			
			// 해당 얼음의 양을 해당 좌표에 갱신
			cage[location] = amount;
			
			// 앨버트의 총 양동이 범위 내에 있는 경우 총 얼음의 양을 갱신
			if (location <= totalRange)
				totalAmount += amount;
		}
		
		// 앨버트의 총 양동이 범위가 우리보다 큰 경우 해당 범위 내의 총 얼음의 양을 최대 얼음의 양으로 갱신
		if (totalRange >= 1000000) {
			maxAmount = totalAmount;
		
		// 앨버트의 총 양동이 범위가 우리보다 작은 경우
		} else {
			
			// for 반복문을 사용해 각 범위를 차례로 순회
			for (int idx = 0; idx < 1000000 - totalRange; idx++) {
				
				// 각 범위의 얼음의 양을 갱신
				totalAmount -= cage[idx];
				totalAmount += cage[idx + totalRange + 1];
				
				// max() 메서드를 사용해 최대 얼음의 양을 갱신
				maxAmount = Math.max(totalAmount, maxAmount);
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 앨버트가 택한 최적 위치에서 얼음의 최댓값을 출력
		out.write(String.valueOf(maxAmount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}