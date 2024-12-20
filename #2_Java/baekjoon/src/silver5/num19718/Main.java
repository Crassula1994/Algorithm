package silver5.num19718;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 상자에 있는 동전의 개수를 같게 만들기 위해 필요한 최소 시간을 저장할 변수 minTime 초기화
		int minTime = 0;
		
		// 각 상자에 들어 있는 동전의 개수를 저장할 배열 chests 초기화
		int[] chests = new int[3];
		
		// for 반복문을 사용해 입력 받은 각 상자에 들어 있는 동전의 개수를 배열 chests에 저장
		for (int idx = 0; idx < chests.length; idx++)
			chests[idx] = Integer.parseInt(in.readLine());
		
		// sort() 메서드를 사용해 각 상자를 들어 있는 동전의 개수를 기준으로 오름차순 정렬
		Arrays.sort(chests);
		
		/* 가장 적은 수의 동전이 들어 있는 상자와 두 번째로 적은 수의 동전이 들어 있는 상자의 동전의 개수가 같아지도록
		가장 적은 수의 동전 및 가장 많은 수의 동전이 들어 있는 상자에 동전을 추가 */
		minTime += chests[1] - chests[0];
		chests[2] += minTime;
		chests[0] += minTime;
		
		/* 가장 많은 수의 동전이 들어 있는 상자의 동전의 개수가 같아지도록
		가장 적은 수의 동전이 들어 있는 상자와 두 번째로 적은 수의 동전이 들어 있는 상자에 동전을 추가 */
		minTime += chests[2] - chests[0];
		
		// valueOf() 및 write() 메서드를 사용해 상자에 있는 동전의 개수를 같게 만들기 위해 필요한 최소 시간을 출력
		out.write(String.valueOf(minTime));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}