package silver2.num16652;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 추정 이메일의 수 및 남은 이메일의 수를 각 변수에 할당
		int estimateCount = Integer.parseInt(st.nextToken());
		int remainCount = Integer.parseInt(st.nextToken());
		
		// 전체 이메일 수의 최솟값을 저장할 변수 totalCount 초기화
		int totalCount = 0;
		
		// 각 이메일의 제목별 최소 존재해야 하는 이메일의 수를 저장할 Map 객체 minCounts 초기화
		Map<String, Integer> minCounts = new HashMap<>();
		
		// while 반복문을 사용해 남은 이메일의 제목을 순회
		while (remainCount-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// countTokens() 메서드를 사용해 해당 이메일의 제목 및 해당 이메일까지 존재해야 하는 이메일의 수를 각 변수에 할당
			String subject = "";
			int minCount = st.countTokens();
			
			// while 반복문을 사용해 해당 이메일의 제목을 갱신
			while (st.hasMoreTokens())
				subject = st.nextToken();
			
			// 해당 이메일 제목으로 된 최소 이메일 수가 현재 존재해야 하는 이메일 수보다 적은 경우 이를 갱신
			if (minCounts.getOrDefault(subject, 0) < minCount)
				minCounts.put(subject, minCount);
		}
		
		// for 반복문을 사용해 전체 이메일 수의 최솟값을 갱신
		for (String subject : minCounts.keySet())
			totalCount += minCounts.get(subject);
		
		// 추정 이메일의 수가 전체 이메일 수의 최솟값 이상인지 여부를 출력
		out.write((estimateCount >= totalCount) ? "YES" : "NO");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}