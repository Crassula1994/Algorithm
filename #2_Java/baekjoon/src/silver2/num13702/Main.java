package silver2.num13702;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 막걸리 주전자에 담긴 막걸리의 용량을 저장할 배열 kettles 초기화
	static int[] kettles;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 막걸리 주전자의 개수 및 은상이를 포함한 친구들의 수를 각 변수에 할당
		int kettleNum = Integer.parseInt(st.nextToken());
		int friendNum = Integer.parseInt(st.nextToken());
		
		// 친구들에게 분배할 수 있는 최대한의 막걸리 용량과 해당 값을 찾기 위한 각 범위를 저장할 각 변수 초기화
		long maxAmount = 0;
		long start = 1;
		long end = 0;
		
		// 각 막걸리 주전자에 담긴 막걸리의 용량을 저장할 배열 kettles 초기화
		kettles = new int[kettleNum];
		
		// for 반복문을 사용해 입력 받은 각 주전자의 용량을 순회
		for (int idx = 0; idx < kettles.length; idx++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 각 막걸리 주전자에 담긴 막걸리의 용량을 배열 kettles에 저장
			kettles[idx] = Integer.parseInt(in.readLine());
			
			// max() 메서드를 사용해 친구들에게 분배할 수 있는 최대한의 막걸리 용량을 찾기 위한 범위의 끝을 갱신
			end = Math.max(kettles[idx], end);
		}
		
		// 최대한의 막걸리 용량을 찾기 위한 범위의 끝을 갱신
		end++;
		
		// while 반복문을 사용해 친구들에게 분배할 수 있는 최대한의 막걸리 용량을 찾을 때까지 순회
		while (start < end) {
			
			// 최대한의 막걸리 용량을 찾기 위한 중간 값을 계산해 변수 mid에 할당
			long mid = (start + end) / 2;
			
			// 해당 용량으로 친구들에게 막걸리를 분배할 수 있는 경우 범위의 시작과 친구들에게 분배할 수 있는 최대한의 막걸리 용량을 갱신
			if (riceWineDistributer(mid) >= friendNum) {
				start = mid + 1;
				maxAmount = mid;
				
			// 해당 용량으로 친구들에게 막걸리를 분배할 수 없는 경우 범위의 끝을 갱신
			} else {
				end = mid;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 친구들에게 분배할 수 있는 최대한의 막걸리 용량을 출력
		out.write(String.valueOf(maxAmount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// riceWineDistributer() 메서드 정의
	public static long riceWineDistributer(long amount) {
		
		// 막걸리를 분배 받을 수 있는 사람의 수를 저장할 변수 count 초기화
		long count = 0;
		
		// for 반복문을 사용해 막걸리를 분배 받을 수 있는 사람의 수를 갱신
		for (long kettle : kettles)
			count += kettle / amount;
		
		// 막걸리를 분배 받을 수 있는 사람의 수를 반환
		return count;
	}
}