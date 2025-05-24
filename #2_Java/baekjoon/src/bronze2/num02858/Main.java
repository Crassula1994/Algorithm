package bronze2.num02858;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 빨간색 타일의 수와 갈색 타일의 수를 각 변수에 할당
		int redCount = Integer.parseInt(st.nextToken());
		int brownCount = Integer.parseInt(st.nextToken());
		
		// 상근이의 방에 채운 타일의 수를 변수 totalCount에 할당
		int totalCount = redCount + brownCount;
		
		// for 반복문을 사용해 가능한 방의 너비를 순회
		for (int width = 3; width * width <= totalCount; width++) {
			
			// 해당 방의 너비가 가능하지 않은 경우 다음 너비를 순회
			if (totalCount % width != 0)
				continue;
			
			// 해당 방의 길이를 변수 length에 할당
			int length = totalCount / width;
			
			// 상근이네 방의 크기를 찾은 경우 상근이네 방의 크기를 출력 후 반복문 탈출
			if ((width - 2) * (length - 2) == brownCount) {
				out.write(length + " " + width);
				break;
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}