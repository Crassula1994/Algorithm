package silver3.num07419;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 전체 케이블의 수 및 필요한 케이블의 수를 각 변수에 할당
		int cableNum = Integer.parseInt(st.nextToken());
		int targetCount = Integer.parseInt(st.nextToken());
		
		// 필요한 케이블의 가능한 최대 길이와 그 범위, 전체 케이블의 길이를 나타낼 각 변수 초기화
		int start = 1;
		int end = 0;
		int maxLength = 0;
		
		// 각 케이블의 길이를 cm 단위로 저장할 배열 cables 초기화
		int[] cables = new int[cableNum];
		
		// for 반복문을 사용해 각 케이블을 순회
		for (int idx = 0; idx < cables.length; idx++) {
			
			// readLine() 및 parseDouble() 메서드를 사용해 입력 받은 케이블의 길이를 배열 cables에 저장
			cables[idx] = (int) (Double.parseDouble(in.readLine()) * 100);
			
			// max() 메서드를 사용해 가장 긴 케이블의 길이를 갱신
			end = Math.max(cables[idx], end);
		}
		
		// while 반복문을 사용해 가능한 최대 길이를 찾을 때까지 순회
		while (start <= end) {
			
			// 가능한 최대 길이 범위의 중간 값을 찾아 변수 mid에 할당
			int mid = (start + end) / 2;
			
			// 해당 길이로 케이블을 잘랐을 때 생기는 케이블의 총 개수를 저장할 변수 count 초기화
			long count = 0;
			
			// for 반복문을 사용해 해당 길이로 케이블을 잘랐을 때 생기는 케이블의 총 개수를 갱신
			for (int idx = 0; idx < cables.length; idx++)
				count += cables[idx] / mid;
			
			// 만들어진 케이블의 총 개수가 필요한 케이블의 수보다 많거나 같은 경우 최대 길이 및 범위의 시작 부분을 갱신
			if (count >= targetCount) {
				maxLength = Math.max(mid, maxLength);
				start = mid + 1;
				
			// 만들어진 케이블의 총 개수가 필요한 케이블의 수보다 적은 경우 범위의 끝 부분을 갱신
			} else {
				end = mid - 1;
			}
		}
		
		// format() 및 write() 메서드를 사용해 필요한 케이블의 가능한 최대 길이를 출력
		out.write(String.format("%.2f", maxLength / 100.0));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}