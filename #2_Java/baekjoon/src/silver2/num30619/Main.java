package silver2.num30619;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수열의 길이를 변수 length에 할당
		int length = Integer.parseInt(in.readLine());
		
		// 입력 받은 수열과 각 사람이 위치한 집의 번호를 저장할 각 배열 초기화
		int[] sequence = new int[length + 1];
		int[] houses = new int[length + 1];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 수열을 배열 sequence에 저장
		for (int idx = 1; idx < sequence.length; idx++)
			sequence[idx] = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 각 사람이 위치한 집의 번호를 배열 houses에 저장
		for (int idx = 1; idx < sequence.length; idx++)
			houses[sequence[idx]] = idx;
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 쿼리의 개수를 변수 queryNum에 할당
		int queryNum = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 쿼리를 순회
		for (int query = 0; query < queryNum; query++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 사람의 번호를 각 변수에 할당
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			
			// 범위에 존재하는 사람의 집의 번호를 저장할 배열 newHouses 초기화
			int[] newHouses = new int[right - left + 1];
			
			// for 반복문을 사용해 범위에 존재하는 사람의 집의 번호를 배열 newHouses에 저장
			for (int idx = left; idx <= right; idx++)
				newHouses[idx - left] = houses[idx];
			
			// sort() 메서드를 사용해 범위에 존재하는 사람의 집의 번호를 오름차순으로 정렬
			Arrays.sort(newHouses);
			
			// clone() 메서드를 사용해 새로운 수열을 저장할 배열 newSequence 초기화
			int[] newSequence = sequence.clone();
			
			// for 반복문을 사용해 범위에 존재하는 사람의 집의 번호를 갱신
			for (int idx = 0; idx < newHouses.length; idx++)
				newSequence[newHouses[idx]] = idx + left;
			
			// for 반복문을 사용해 새롭게 배정된 수열을 출력
			for (int idx = 1; idx < newSequence.length; idx++)
				out.write(newSequence[idx] + " ");
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}