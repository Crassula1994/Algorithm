package bronze1.num15819;

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
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 핸들의 개수 및 찾고자 하는 핸들의 순서를 각 변수에 할당
		int handleNum = Integer.parseInt(st.nextToken());
		int targetOrder = Integer.parseInt(st.nextToken()) - 1;
		
		// 입력 받은 핸들을 저장할 배열 handles 초기화
		String[] handles = new String[handleNum];
		
		// for 반복문을 사용해 입력 받은 핸들을 배열 handles에 저장
		for (int idx = 0; idx < handles.length; idx++)
			handles[idx] = in.readLine();
		
		// sort() 메서드를 사용해 핸들을 사전 순으로 정렬
		Arrays.sort(handles);
		
		// write() 메서드를 사용해 찾고자 하는 순서의 핸들을 출력
		out.write(handles[targetOrder]);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}