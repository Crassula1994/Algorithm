package silver4.num02485;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 가로수의 수를 변수 treeNum에 할당
		int treeNum = Integer.parseInt(in.readLine());
		
		// 각 가로수의 위치 및 간격을 저장할 각 배열 초기화
		int[] treeLoc = new int[treeNum];
		int[] treeInterval = new int[treeNum];
		
		// for 반복문을 사용해 입력 받은 가로수의 위치를 배열 treeLoc에 저장
		for (int idx = 0; idx < treeLoc.length; idx++)
			treeLoc[idx] = Integer.parseInt(in.readLine());
		
		// sort() 메서드를 사용해 가로수의 위치를 오름차순으로 정렬
		Arrays.sort(treeLoc);
		
		// for 반복문을 사용해 각 나무의 간격을 계산해 배열 treeInterval에 저장
		for (int idx = 1; idx < treeInterval.length; idx++)
			treeInterval[idx] = treeLoc[idx] - treeLoc[idx - 1];
		
		// 나무 사이의 최대 간격을 저장할 변수 maxInterval 초기화
		int maxInterval = treeInterval[1];
		
		// for 반복문을 사용해 나무 사이의 최대 간격을 갱신
		for (int idx = 2; idx < treeInterval.length; idx++)
			maxInterval = gcdCalculator(maxInterval, treeInterval[idx]);
		
		// 새로 심어야 하는 가로수의 수를 계산해 변수 count에 할당
		int count = (treeLoc[treeNum - 1] - treeLoc[0]) / maxInterval + 1 - treeNum;
		
		// valueOf() 및 write() 메서드를 사용해 새로 심어야 하는 가로수의 수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// gcdCalculator() 메서드 정의
	public static int gcdCalculator(int numA, int numB) {
		
		// 두 숫자가 같은 경우 해당 숫자를 최대공약수로 반환
		if (numA == numB) {
			return numA;
			
		// 두 숫자가 같지 않은 경우
		} else {
			
			// max() 및 min() 메서드를 사용해 두 수 중 큰 수와 작은 수를 각 변수에 할당
			int bigNum = Math.max(numA, numB);
			int smallNum = Math.min(numA, numB);
			
			// 큰 수가 작은 수로 나누어 떨어지는 경우 작은 수를 최대공약수로 반환
			if (bigNum % smallNum == 0) {
				return smallNum;
			
			// 큰 수가 작은 수로 나누어 떨어지지 않는 경우 gcdCalculator() 메서드 재귀 호출
			} else {
				return gcdCalculator(smallNum, bigNum % smallNum);
			}
		}
	}
}