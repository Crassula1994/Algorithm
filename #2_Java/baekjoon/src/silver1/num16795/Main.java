package silver1.num16795;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

// Main 클래스 정의
public class Main {
	
	// 각 게시물에 달린 게시물과 그 내용을 저장할 각 배열 초기화
	static List<Integer>[] replies;
	static String[] contents;
	
	// 게시물의 스레드를 출력할 StringBuilder 객체 sb 초기화
	static StringBuilder sb = new StringBuilder();
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 게시물의 수를 변수 postNum에 할당
		int postNum = Integer.parseInt(in.readLine());
		
		// 각 게시물에 달린 게시물과 그 내용을 저장할 각 배열 초기화
		replies = new ArrayList[postNum + 1];
		contents = new String[postNum + 1];
		
		// for 반복문을 사용해 각 게시물에 달린 게시물을 저장할 List 객체 초기화
		for (int idx = 0; idx < replies.length; idx++)
			replies[idx] = new ArrayList<>();
		
		// for 반복문을 사용해 각 게시물을 순회
		for (int post = 1; post <= postNum; post++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 게시물의 이전 게시물을 변수 parentPost에 저장
			int parentPost = Integer.parseInt(in.readLine());
			
			// add() 메서드를 사용해 해당 게시물의 위치를 배열 replies에 저장
			replies[parentPost].add(post);
			
			// readLine() 메서드를 사용해 해당 게시물의 내용을 배열 contents에 저장
			contents[post] = in.readLine();
		}
		
		// postFinder() 메서드를 호출해 게시물의 스레드를 sb에 저장
		postFinder(1, 0);
		
		// toString() 및 write() 메서드를 사용해 게시물의 스레드를 출력
		out.write(sb.toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// postFinder() 메서드 정의
	private static void postFinder(int curPost, int depth) {
		
		// for 반복문을 사용해 해당 게시물의 깊이만큼 '.'을 sb에 저장
		for (int d = 0; d < depth; d++)
			sb.append(".");
		
		// append() 메서드를 사용해 해당 게시물의 내용을 sb에 저장
		sb.append(contents[curPost]).append("\n");
		
		// for 반복문을 사용해 해당 게시물의 댓글에 대하여 postFinder() 메서드 재귀 호출
		for (int nextPost : replies[curPost])
			postFinder(nextPost, depth + 1);
	}
}