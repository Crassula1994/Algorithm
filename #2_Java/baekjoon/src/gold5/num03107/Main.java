package gold5.num03107;

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
		
		// 축약되지 않은 IPv6 주소를 저장할 StringBuilder 객체를 불러와 변수 sb에 할당
		StringBuilder sb = new StringBuilder();
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine().replace("::", ":zeroes:"), ":");
		
		// countTokens() 메서드를 사용해 그룹의 개수를 변수 groupNum에 할당
		int groupNum = st.countTokens();
		
		// for 반복문을 사용해 각 그룹을 순회
		for (int g = 0; g < groupNum; g++) {

			// nextToken() 메서드를 사용해 해당 그룹을 변수 group에 할당
			String group = st.nextToken();
			
			// 해당 그룹이 0으로만 이루어져 있는 생략된 그룹인 경우
			if (group.equals("zeroes")) {
				
				// for 반복문을 사용해 0으로만 이루어져 있는 그룹을 sb에 추가
				for (int count = 0; count <= 8 - groupNum; count++)
					sb.append("0000:");
				
				// 다음 그룹을 순회
				continue;
			}
			
			// format(), replace(), append() 메서드를 사용해 해당 그룹을 축약되지 않은 형태로 sb에 저장
			sb.append(String.format("%4s", group).replace(" ", "0")).append(":");
		}
		
		// length() 및 setLength() 메서드를 사용해 마지막 ':'을 제거
		sb.setLength(sb.length() - 1);
		
		// toString() 및 write() 메서드를 사용해 축약되지 않은 IPv6 주소를 출력
		out.write(sb.toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}