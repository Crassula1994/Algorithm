package silver2.num14496;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 문자의 치환 가능한 문자 및 바꾸려 하는 문자로부터의 최소 치환 횟수를 저장할 각 배열 초기화
	static List<Integer>[] pairs;
	static Integer[] minCounts;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 대호가 바꾸려 하는 문자와 바꿀 문자를 각 변수에 할당
		int startChar = Integer.parseInt(st.nextToken());
		int endChar = Integer.parseInt(st.nextToken());
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 전체 문자의 수 및 치환 가능한 문자쌍의 수를 각 변수에 할당
		int charNum = Integer.parseInt(st.nextToken());
		int pairNum = Integer.parseInt(st.nextToken());
		
		// 각 문자의 치환 가능한 문자 및 바꾸려 하는 문자로부터의 최소 치환 횟수를 저장할 각 배열 초기화
		pairs = new ArrayList[charNum + 1];
		minCounts = new Integer[charNum + 1];
		
		// for 반복문을 사용해 각 문자의 치환 가능한 문자를 저장할 List 객체 초기화
		for (int idx = 0; idx < pairs.length; idx++)
			pairs[idx] = new ArrayList<>();
		
		// for 반복문을 사용해 각 치환 가능한 문자쌍을 순회
		for (int pair = 0; pair < pairNum; pair++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 치환할 수 있는 각 문자를 각 변수에 할당
			int firstChar = Integer.parseInt(st.nextToken());
			int secondChar = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 각 문자의 치환 가능한 문자를 배열 pairs에 저장
			pairs[firstChar].add(secondChar);
			pairs[secondChar].add(firstChar);
		}
		
		// charReplacer() 메서드를 호출해 대호가 바꾸려 하는 문자의 최소 치환 횟수를 변수 minCount에 할당
		int minCount = charReplacer(startChar, endChar);
		
		// valueOf() 및 write() 메서드를 사용해 대호가 바꾸려 하는 문자의 최소 치환 횟수를 출력
		out.write(String.valueOf(minCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// charReplacer() 메서드 정의
	public static int charReplacer(int startChar, int endChar) {
		
		// 다음에 바꿀 문자를 저장할 Queue 객체 replaceList 초기화
		Queue<Integer> replaceList = new LinkedList<>();
		
		// offer() 메서드를 사용해 바꾸려 하는 문자를 replaceList에 저장 후 최소 치환 횟수를 갱신
		replaceList.offer(startChar);
		minCounts[startChar] = 0;
		
		// while 반복문을 사용해 replaceList가 빌 때까지 순회
		while (!replaceList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 문자를 변수 curChar에 할당
			int curChar = replaceList.poll();
			
			// 현재 문자가 바꿀 문자인 경우 최소 치환 횟수를 반환
			if (curChar == endChar)
				return minCounts[curChar];
			
			// for 반복문을 사용해 다음에 바꿀 수 있는 문자를 순회
			for (int nextChar : pairs[curChar]) {
				
				// 해당 문자를 이전에 바꾼 적이 있는 경우 다음 문자를 순회
				if (minCounts[nextChar] != null)
					continue;
				
				// offer() 메서드를 사용해 다음에 바꿀 문자를 replaceList에 저장 후 최소 치환 횟수를 갱신
				replaceList.offer(nextChar);
				minCounts[nextChar] = minCounts[curChar] + 1;
			}
		}
		
		// 바꿀 문자로 바꿀 수 없는 경우 -1 반환
		return -1;
	}
}