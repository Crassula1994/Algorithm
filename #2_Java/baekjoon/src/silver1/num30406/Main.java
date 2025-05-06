package silver1.num30406;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 춘배가 가지고 있는 선물의 개수를 변수 giftNum에 할당
		int giftNum = Integer.parseInt(in.readLine());
		
		// 산타 춘배가 선물을 나눠줬을 때 얻을 수 있는 만족도의 최댓값을 저장할 변수 maxLevel 초기화
		int maxLevel = 0;
		
		// 각 가격에 해당하는 선물의 개수를 저장할 배열 counts 초기화
		int[] counts = new int[4];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// while 반복문을 사용해 각 가격에 해당하는 선물의 개수를 갱신
		while (giftNum-- > 0)
			counts[Integer.parseInt(st.nextToken())]++;
		
		// min() 메서드를 사용해 0과 3, 1과 2의 가격 조합으로 선물을 줄 수 있는 각 경우의 개수를 각 변수에 할당
		int comb03 = Math.min(counts[0], counts[3]);
		int comb12 = Math.min(counts[1], counts[2]);
		
		// 산타 춘배가 선물을 나눠줬을 때 얻을 수 있는 만족도의 최댓값을 갱신
		maxLevel += (comb03 + comb12) * 3;
		
		// 각 선물의 개수를 갱신
		counts[0] -= comb03;
		counts[1] -= comb12;
		counts[2] -= comb12;
		counts[3] -= comb03;
		
		// 남아 있는 선물의 가격을 저장할 각 변수 초기화
		int priceA = -1;
		int priceB = -1;
		
		// for 반복문을 사용해 각 가격을 순회
		for (int idx = 0; idx < 4; idx++) {
			
			// 해당 가격의 선물이 남아 있지 않은 경우 다음 가격을 순회
			if (counts[idx] == 0)
				continue;
			
			// 남아 있는 선물을 처음 찾은 경우 남아 있는 선물의 가격을 갱신 후 다음 가격을 순회
			if (priceA == -1) {
				priceA = idx;
				continue;
			}
			
			// 남아 있는 나머지 선물의 가격을 갱신
			priceB = idx;
		}
		 
		// 남아 있는 나머지 선물로 조합이 가능한 경우 산타 춘배가 선물을 나눠줬을 때 얻을 수 있는 만족도의 최댓값을 갱신
		if (priceB != -1)
			maxLevel += Math.min(counts[priceA], counts[priceB]) * (priceA ^ priceB);
		
		// valueOf() 및 write() 메서드를 사용해 산타 춘배가 선물을 나눠줬을 때 얻을 수 있는 만족도의 최댓값을 출력
		out.write(String.valueOf(maxLevel));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}