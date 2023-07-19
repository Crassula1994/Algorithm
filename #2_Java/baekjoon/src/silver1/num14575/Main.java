package silver1.num14575;

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

		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 대회 참가자의 수 및 술의 총량을 각 변수에 할당
		int participants = Integer.parseInt(st.nextToken());
		int drinkAmt = Integer.parseInt(st.nextToken());
		
		// 각 참가자의 최소 주량과 최대 주량을 저장할 2차원 배열 limits 초기화
		int[][] limits = new int[participants][2];
		
		// 모든 참가자의 최소 주량의 합과 최대 주량의 합, 최소 주량 및 최대 주량을 저장할 각 변수 초기화
		int minSum = 0;
		int maxSum = 0;
		int lowerAmt = Integer.MIN_VALUE;
		int upperAmt = drinkAmt;
		
		// for 반복문을 사용해 각 참가자를 순회
		for (int idx = 0; idx < participants; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 참가자의 최소 주량 및 최대 주량을 배열 limits에 저장
			limits[idx][0] = Integer.parseInt(st.nextToken());
			limits[idx][1] = Integer.parseInt(st.nextToken());
			
			// max() 메서드를 사용해 최소 주량을 갱신
			lowerAmt = Math.max(limits[idx][0], lowerAmt);
			
			// 모든 참가자의 최소 주량의 합과 최대 주량의 합을 갱신
			minSum += limits[idx][0];
			maxSum += limits[idx][1];
		}
		
		// 최소 주량의 합보다 술의 총량이 적거나, 최대 주량의 합보다 술의 총량이 큰 경우 -1 출력
		if (minSum > drinkAmt || maxSum < drinkAmt) {
			out.write(String.valueOf(-1));
			
		// 술의 총량이 최소 주량의 합보다 크고, 최대 주량의 합보다 적은 경우
		} else {
			
			// while 반복문을 사용해 도현이가 정한 술의 상한을 찾을 때까지 순회
			while (lowerAmt <= upperAmt) {
				
				// 각 사람에게 분배한 술의 양의 총합을 저장할 변수 sum 초기화
				int sum = 0;
				
				// 최솟값과 최댓값의 중간값을 계산해 변수 mid에 할당
				int mid = (lowerAmt + upperAmt) / 2;
				
				// for 반복문을 사용해 해당 사람에게 분배한 술의 양의 총합을 갱신
				for (int idx = 0; idx < participants; idx++)
					sum += Math.min(limits[idx][1], mid);
				
				// 분배한 술의 양이 술의 총량보다 크거나 같은 경우 술의 상한을 감소
				if (sum >= drinkAmt) {
					upperAmt = mid - 1;
				
				// 분배한 술의 양이 술의 총량보다 작은 경우 술의 상한을 증가
				} else {
					lowerAmt = mid + 1;
				}
			}
			
			// valueOf() 및 write() 메서드를 사용해 도현이가 정한 술의 상한의 최솟값을 출력
			out.write(String.valueOf(lowerAmt));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}